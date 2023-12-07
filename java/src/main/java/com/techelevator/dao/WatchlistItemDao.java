package com.techelevator.dao;

import com.techelevator.model.WatchlistItem;

import java.util.List;

public interface WatchlistItemDao {

    List<WatchlistItem> getWatchlistByUserId(int id);
    List<WatchlistItem> removeItemFromList(WatchlistItem item);
    List<WatchlistItem> addItemToList(WatchlistItem item);

}
