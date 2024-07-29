package com.sprintProject.data.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.dto.CustomerDto;
import com.sprintProject.data.dto.FilmDto;
import com.sprintProject.data.entity.Customer;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Rental;
import com.sprintProject.data.exception.InvalidException;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.repository.CustomerRepository;
import com.sprintProject.data.repository.RentalRepository;
import com.sprintProject.data.repository.StoreRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalServiceImpl implements RentalService{

	@Autowired
	RentalRepository rrepo;
	
	@Autowired
	CustomerRepository crepo;
	
	@Autowired
	StoreRepository srepo;
	
	@Override
	public Rental getAllRentalById(int id) throws NotFoundException{
		// TODO Auto-generated method stub
		if(rrepo.findById(id).isEmpty()==true) {
			throw new NotFoundException("The given rental id="+id+" does not exist");
		}
		return rrepo.getAllRentalById(id);
	}

	@Override
	public List<FilmDto> getAllFilmsRentedToCustomer(int id) {
		// TODO Auto-generated method stub
		if(crepo.findById(id).isEmpty()==true) {
			throw new NotFoundException("The given customer id="+id+" does not exist");
		}
		return rrepo.getAllFilmsRentedToCustomer(id);
	}

	@Override
	public List<FilmDto> getTopTenFilmsRentedToCustomer() {
		// TODO Auto-generated method stub
		
		return rrepo.getTopTenFilmsRentedToCustomer();
	}

	@Override
	public List<FilmDto> getTopTenFilmsRentedOfAStore(int id) {
		// TODO Auto-generated method stub
		if(srepo.findById(id).isEmpty()==true) {
			throw new NotFoundException("The given Store id="+id+" does not exist");
		}

		return rrepo.getTopTenFilmsRentedOfAStore(id);
	}

	@Override
	public List<CustomerDto> getCustomerWhoHaveNotReturnedTheFilm() {
		// TODO Auto-generated method stub
		return rrepo.getCustomerWhoHaveNotReturnedTheFilm();
	}
	
	public Rental createRental(Rental rental) {

		// TODO Auto-generated method stub

		return rrepo.save(rental);
	}

	@Override
	public Rental updateRentalReturnDate(Timestamp Return_Date, int id) {
		// TODO Auto-generated method stub
		Rental rent=rrepo.findById(id).orElseThrow(()->new NotFoundException("id" +"does not exist"));
		rent.setRental_Date(Return_Date);
		rrepo.save(rent);
		return rent;
		
	}

}
