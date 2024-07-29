package com.sprintProject.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.dto.FilmAmount;
import com.sprintProject.data.exception.NotFoundException;
import com.sprintProject.data.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository prepo;
	
	@Override
	public List<FilmAmount> getFilmsAmountRented() throws NotFoundException{
		// TODO Auto-generated method stub
		if(prepo.getFilmsAmountRented().isEmpty()==true) {
			throw new NotFoundException("No Records Found.");
		}
		return prepo.getFilmsAmountRented();
	}

	@Override
	public List<FilmAmount> getRevemueOfAFilmAmountRented(int id) throws NotFoundException{
		// TODO Auto-generated method stub
		if(prepo.getRevemueOfAFilmAmountRented(id).isEmpty()==true) {
			throw new NotFoundException("The given film id="+ id+" does not exist.");
		}
		return prepo.getRevemueOfAFilmAmountRented(id);
	}

	@Override
	public List<FilmAmount> getRevenueOfAllFilmsByStore(int id) {
		// TODO Auto-generated method stub
		if(prepo.getRevenueOfAllFilmsByStore(id).isEmpty()==true) {
			throw new NotFoundException("The given store id="+ id+" does not exist.");
		}
		return prepo.getRevenueOfAllFilmsByStore(id);
	}

}
