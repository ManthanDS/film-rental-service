package com.sprintProject.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintProject.data.dto.CustomerDto;
import com.sprintProject.data.dto.FilmDto;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>{

	@Query("select r from Rental r where Rental_Id=?1")
	Rental getAllRentalById(int id);
	
	@Query("select new com.sprintProject.data.dto.FilmDto(f.film_id,f.title,f.description,f.releaseYear,f.rentalRate,f.rating,f.specialFeatures,f.language) from Film f where f.film_id in(select i.film.film_id from Inventory i where i.inventory_id in(select r.inventory.inventory_id from Rental r where r.customer.customer_id=?1)) ")
	List<FilmDto> getAllFilmsRentedToCustomer(int id);
	
	@Query("select new com.sprintProject.data.dto.FilmDto(f.film_id,f.title,f.description,f.releaseYear,f.rentalRate,f.rating,f.specialFeatures,f.language) from Film f join Inventory i on f.film_id=i.film.film_id  join Rental r on r.inventory.inventory_id=i.inventory_id group by f.title order by count(r.inventory.inventory_id)desc limit 10 " )
	List<FilmDto> getTopTenFilmsRentedToCustomer();
	
	@Query("select new com.sprintProject.data.dto.FilmDto(f.film_id,f.title,f.description,f.releaseYear,f.rentalRate,f.rating,f.specialFeatures,f.language) from Film f join Inventory i on f.film_id=i.film.film_id join Rental r on r.inventory.inventory_id=i.inventory_id where i.store.store_id=?1 group by f.title order by count(r.inventory.inventory_id)desc limit 10" )
	List<FilmDto> getTopTenFilmsRentedOfAStore(int id);
	
	@Query("select new com.sprintProject.data.dto.CustomerDto(c.customer_id,c.first_name,c.last_name,c.email,c.active,c.create_date,c.last_update) from Customer c where c.customer_id IN (select r.customer.customer_id from Rental r where Return_Date is null)")
	List<CustomerDto> getCustomerWhoHaveNotReturnedTheFilm();
}
