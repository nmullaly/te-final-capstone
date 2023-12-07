package com.techelevator.controller;

import com.techelevator.dao.WatchlistItemDao;
import com.techelevator.model.WatchlistItem;
import org.springframework.web.bind.annotation.*;

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

}
