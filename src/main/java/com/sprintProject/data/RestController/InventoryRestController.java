package com.sprintProject.data.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.dto.InventoryFilmCount;
import com.sprintProject.data.dto.InventoryStoreCount;
import com.sprintProject.data.entity.Inventory;
import com.sprintProject.data.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryRestController {

	@Autowired
	InventoryService iservice;
	
	@RequestMapping("/films")
	private ResponseEntity<List<InventoryFilmCount>> getInventoryCountOfAllFilmsInAllStores(){
		return new ResponseEntity<>(iservice.getInventoryCountOfAllFilmsInAllStores(),HttpStatus.OK);
	}
	
	@RequestMapping("/store/{id}")
	private ResponseEntity<List<InventoryFilmCount>> getInventoryOfAllFilmsByStore(@PathVariable("id") int id){
		return new ResponseEntity<>(iservice.getInventoryOfAllFilmsByStore(id),HttpStatus.OK);
	}
	
	@RequestMapping("/film/{id}")
	private ResponseEntity<List<InventoryStoreCount>> getInventoryOfAllStoresByFilm(@PathVariable("id") int id){
		return new ResponseEntity<>(iservice.getInventoryOfAllStoresByFilm(id),HttpStatus.OK);
	}
	
	@RequestMapping("/film/{fid}/store/{sid}")
	private ResponseEntity<List<InventoryStoreCount>> getInventoryOfAStoreByFilm(@PathVariable("fid") int fid,@PathVariable("sid") int sid){
		return new ResponseEntity<>(iservice.getInventoryOfAStoreByFilm(fid,sid),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String>createInventory(@RequestBody Inventory inventory){
		iservice.createInventory(inventory);
		return new ResponseEntity<String>("Inventory added successfully",HttpStatus.OK);
	}
}
