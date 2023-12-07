package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.WatchlistItem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWatchlistItemDao implements WatchlistItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWatchlistItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<WatchlistItem> getWatchlistByUserId(int id) {
        List<WatchlistItem> items = new ArrayList<>();
        String sql = "SELECT * FROM watchlist WHERE profile_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                items.add(mapRowToWatchlistItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return items;
    }

    @Override
    public List<WatchlistItem> removeItemFromList(WatchlistItem item) {
        List<WatchlistItem> items = new ArrayList<>();
        String sql = "DELETE FROM watchlist WHERE profile_id = ? AND movie_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, item.getProfileId(), item.getMovieId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected one");
            } else {
                items = getWatchlistByUserId(item.getProfileId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return items;
    }

    @Override
    public List<WatchlistItem> addItemToList(WatchlistItem item) {
        List<WatchlistItem> items = new ArrayList<>();
        String sql = "INSERT INTO watchlist (profile_id, movie_id) " +
                "VALUES (?, ?) RETURNING (profile_id);";
        try {
            int newItemProfId = jdbcTemplate.queryForObject(sql, int.class,
                    item.getProfileId(), item.getMovieId());
            items = getWatchlistByUserId(item.getProfileId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (NullPointerException e) {
            throw new DaoException("Transfer Unsuccessful", e);
        }
        return items;
    }

    private WatchlistItem mapRowToWatchlistItem(SqlRowSet rs) {
        WatchlistItem item = new WatchlistItem();
        item.setProfileId(rs.getInt("profile_id"));
        item.setMovieId(rs.getInt("movie_id"));
        return item;
    }

}
