package com.sprintProject.data.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.dto.InventoryFilmCount;
import com.sprintProject.data.dto.InventoryStoreCount;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Inventory;
import com.sprintProject.data.repository.FilmRepository;
import com.sprintProject.data.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryRepository irepo;
	
	@Autowired
	FilmRepository frepo;
	
	@Override
	public List<InventoryFilmCount> getInventoryCountOfAllFilmsInAllStores() {
		return irepo.getInventoryCountOfAllFilmsInAllStores();
	}

	@Override
	public List<InventoryFilmCount> getInventoryOfAllFilmsByStore(int id) {
		// TODO Auto-generated method stub
		return irepo.getInventoryOfAllFilmsByStore(id);
	}

	@Override
	public List<InventoryStoreCount> getInventoryOfAllStoresByFilm(int id) {
		// TODO Auto-generated method stub
		return irepo.getInventoryOfAllStoresByFilm(id);
	}

	@Override
	public List<InventoryStoreCount> getInventoryOfAStoreByFilm(int filmid, int storeid) {
		// TODO Auto-generated method stub
		return irepo.getInventoryOfAStoreByFilm(filmid, storeid);
	}
	
	public Inventory createInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return irepo.save(inventory);
	}

}
