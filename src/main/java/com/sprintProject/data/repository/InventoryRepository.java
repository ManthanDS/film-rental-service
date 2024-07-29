package com.sprintProject.data.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.dto.InventoryFilmCount;
import com.sprintProject.data.dto.InventoryStoreCount;
import com.sprintProject.data.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	@Query("select new com.sprintProject.data.dto.InventoryFilmCount(f.title,count(i.film.film_id)) from Film f join Inventory i on i.film.film_id=f.film_id group by i.film.film_id")
	List<InventoryFilmCount> getInventoryCountOfAllFilmsInAllStores();
	
	@Query("select new com.sprintProject.data.dto.InventoryFilmCount(f.title,count(i.film.film_id)) from Film f join Inventory i on i.film.film_id=f.film_id  where i.store.store_id=?1 group by i.film.film_id")
	List<InventoryFilmCount> getInventoryOfAllFilmsByStore(int id);
	
	@Query("select new com.sprintProject.data.dto.InventoryStoreCount(s.store_id,s.staff.staff_id,s.address.address_Id,count(i.store.store_id)) from Store s join Inventory i on i.store.store_id=s.store_id  where i.film.film_id=?1 group by i.store.store_id")
	List<InventoryStoreCount> getInventoryOfAllStoresByFilm(int id);
	
	@Query("select new com.sprintProject.data.dto.InventoryStoreCount(s.store_id,s.staff.staff_id,s.address.address_Id,count(i.store.store_id)) from Store s join Inventory i on i.store.store_id=s.store_id  where i.film.film_id=?1 and i.store.store_id=?2 group by i.store.store_id")
	List<InventoryStoreCount> getInventoryOfAStoreByFilm(int filmid,int storeid);
	
	
}
