package com.sprintProject.data.service;

import java.util.List;
import java.util.Map;

import com.sprintProject.data.dto.InventoryFilmCount;
import com.sprintProject.data.dto.InventoryStoreCount;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Inventory;

public interface InventoryService {

	 public List<InventoryFilmCount> getInventoryCountOfAllFilmsInAllStores();
	 public List<InventoryFilmCount> getInventoryOfAllFilmsByStore(int id);
	 public List<InventoryStoreCount> getInventoryOfAllStoresByFilm(int id);
	 public List<InventoryStoreCount> getInventoryOfAStoreByFilm(int filmid,int storeid);
	 public Inventory createInventory(Inventory inventory);
}
