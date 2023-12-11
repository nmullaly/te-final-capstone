package com.techelevator.controller;

import com.techelevator.dao.WatchlistItemDao;
import com.techelevator.model.WatchlistItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class WatchlistItemController {

    private WatchlistItemDao watchlistItemDao;

    public WatchlistItemController(WatchlistItemDao watchlistItemDao) {
        this.watchlistItemDao = watchlistItemDao;
    }

    @RequestMapping(path = "/profile/{id}/watchlist", method = RequestMethod.GET)
    public List<WatchlistItem> getWatchListByUserId(@PathVariable int id) {
        return watchlistItemDao.getWatchlistByUserId(id);
    }

    @RequestMapping(path = "profile/{id}/watchlist", method = RequestMethod.DELETE)
    public List<WatchlistItem> removeItemFromList(@RequestBody WatchlistItem item, @PathVariable int id) {
        if (item.getProfileId() == id) {
            return watchlistItemDao.removeItemFromList(item);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Entry not on this profile");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "profile/{id}/watchlist", method = RequestMethod.POST)
    public List<WatchlistItem> addItemToList(@RequestBody WatchlistItem item) {
        return watchlistItemDao.addItemToList(item);
    }

}
