package com.sprintProject.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.dto.FilmAmount;
import com.sprintProject.data.dto.StoreAmount;
import com.sprintProject.data.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	@Query("select new com.sprintProject.data.dto.FilmAmount(f.title,sum(p.amount)) from Film f join Inventory i on f.film_id=i.film.film_id join Rental r on r.inventory.inventory_id=i.inventory_id join Payment p on p.rental.Rental_Id=r.Rental_Id group by f.title order by sum(r.inventory.inventory_id)" )
	List<FilmAmount> getFilmsAmountRented();
	
	@Query("select new com.sprintProject.data.dto.FilmAmount(f.title,sum(p.amount)) from Film f join Inventory i on f.film_id=i.film.film_id join Rental r on r.inventory.inventory_id=i.inventory_id join Payment p on p.rental.Rental_Id=r.Rental_Id where f.film_id=?1 group by f.title order by f.film_id" )
	List<FilmAmount> getRevemueOfAFilmAmountRented(int id);
	
	@Query("select new com.sprintProject.data.dto.FilmAmount(f.title,sum(p.amount)) from Film f join Inventory i on f.film_id=i.film.film_id join Rental r on r.inventory.inventory_id=i.inventory_id join Payment p on p.rental.Rental_Id=r.Rental_Id where i.store.store_id=?1 group by f.title order by sum(p.amount)" )
	List<FilmAmount> getRevenueOfAllFilmsByStore(int id);
	
	
}
