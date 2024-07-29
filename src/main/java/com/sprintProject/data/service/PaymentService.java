package com.sprintProject.data.service;

import java.util.List;

import com.sprintProject.data.dto.FilmAmount;

public interface PaymentService {

	List<FilmAmount> getFilmsAmountRented();
	List<FilmAmount> getRevemueOfAFilmAmountRented(int id);
	List<FilmAmount> getRevenueOfAllFilmsByStore(int id);
}
