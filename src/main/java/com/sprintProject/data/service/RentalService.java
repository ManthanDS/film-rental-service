package com.sprintProject.data.service;

import java.sql.Timestamp;
import java.util.List;

import com.sprintProject.data.dto.CustomerDto;
import com.sprintProject.data.dto.FilmDto;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Rental;

public interface RentalService {

	public Rental getAllRentalById(int id);
	List<FilmDto> getAllFilmsRentedToCustomer(int id);
	List<FilmDto> getTopTenFilmsRentedToCustomer();
	List<FilmDto> getTopTenFilmsRentedOfAStore(int id);
	List<CustomerDto> getCustomerWhoHaveNotReturnedTheFilm();
	public Rental createRental(Rental rental);
	
	Rental updateRentalReturnDate(Timestamp Return_Date, int id);
}
