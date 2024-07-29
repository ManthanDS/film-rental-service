package com.sprintProject.data.service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Category;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Language;
import com.sprintProject.data.repository.ActorRepository;
import com.sprintProject.data.repository.CategoryRepository;
import com.sprintProject.data.repository.FilmRepository;
import com.sprintProject.data.repository.LanguageRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepo;

	@Autowired
	ActorRepository actorRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	LanguageRepository languageRepo;

	@Override
	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		return filmRepo.findById(id).get();
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().toList();
	}

	@Override
	public String addFilm(Film film) {
		// TODO Auto-generated method stub
		if (filmRepo.save(film) != null) {
			return "Record Created Succcessfully";
		}
		return null;
	}

	@Override
	public List<Film> getFilmsByTitle(String title) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getTitle().equals(title)).toList();
	}

	@Override
	public List<Film> getFilmsByYear(int year) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getReleaseYear() == year).toList();
	}

	@Override
	public List<Film> getFilmsByDurationGreaterThan(int duration) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getRentalDuration() >= duration).toList();
	}

	@Override
	public List<Film> getFilmsByRateGreaterThan(int rate) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getRentalRate() >= rate).toList();
	}

	@Override
	public List<Film> getFilmsByLengthGreaterThan(int length) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getLength() >= length).toList();
	}

	@Override
	public List<Film> getFilmsByDurationLesserThan(int duration) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getRentalDuration() <= duration).toList();
	}

	@Override
	public List<Film> getFilmsByRateLesserThan(int rate) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getRentalRate() <= rate).toList();
	}

	@Override
	public List<Film> getFilmsByLengthLesserThan(int length) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getLength() <= length).toList();
	}

	@Override
	public List<Film> getFilmsBetweenYears(int fromYear, int toYear) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream()
				.filter(f -> (f.getReleaseYear() >= fromYear) && (f.getReleaseYear() <= toYear)).toList();
	}

	@Override
	public List<Film> getFilmsByRatingLesserThan(String rating) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getIntegerRating(f.getRating()) <= f.getIntegerRating(rating))
				.toList();

	}

	@Override
	public List<Film> getFilmsByRatingGreaterThan(String rating) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getIntegerRating(f.getRating()) >= f.getIntegerRating(rating))
				.toList();
	}

	@Override
	public List<Film> getFilmsByLanguage(String language) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getLanguage().getLanguageName().equals(language)).toList();
	}

	@Override
	public List<Actor> getActorsFromFilmByFilmId(int film_id) {
		// TODO Auto-generated method stub
		return filmRepo.findAll().stream().filter(f -> f.getFilm_id() == film_id).toList().get(0).getActors();
	}

	@Override
	public Map<Integer, Long> getCountOfFilmsByYear() {
		// TODO Auto-generated method stub
		// Map<Integer, Integer> resultMap = new HashMap<>();
		return filmRepo.findAll().stream().collect(Collectors.groupingBy(Film::getReleaseYear, Collectors.counting()));
	}

	@Override
	public List<Film> getFilmsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> assignActorToFilm(int film_id, String actor_first_name, String actor_last_name) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		Actor actor = actorRepo.findAll().stream()
				.filter(a -> a.getFirst_name().equals(actor_first_name) && a.getLast_name().equals(actor_last_name))
				.toList().get(0);
		film.getActors().add(actor);
		//Collections.sort(film.getActors(), actor);
		filmRepo.save(film);
		return filmRepo.findById(film_id).get().getActors();
	}

	@Override
	public Film updateTitleOfFilm(int film_id, String title) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		film.setTitle(title);
		return filmRepo.save(film);
	}

	@Override
	public Film updateReleaseYearOfFilm(int film_id, int release_year) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		film.setReleaseYear(release_year);
		return filmRepo.save(film);
	}

	@Override
	public Film updateRentalDurationOfFilm(int film_id, int rental_duration) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		film.setRentalDuration(rental_duration);
		return filmRepo.save(film);
	}

	@Override
	public Film updateRentalRateOfFilm(int film_id, int rental_rate) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		film.setRentalRate(rental_rate);
		return filmRepo.save(film);
	}

	@Override
	public Film updateRatingOfFilm(int film_id, String rating) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		film.setRating(rating);
		return filmRepo.save(film);
	}

	@Override
	public Film updateLanguageOfFilm(int film_id, String language) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		Language updateLanguage = languageRepo.findAll().stream()
				.filter(l->l.getLanguageName().equals(language))
				.toList().get(0);
		film.setLanguage(updateLanguage);
		return filmRepo.save(film);
	}

	@Override
	public Film updateCategoryOfFilm(int film_id, String category) {
		// TODO Auto-generated method stub
		Film film = filmRepo.findById(film_id).get();
		Category updateCategory = categoryRepo.findAll().stream()
				.filter(c->c.getName().equals(category))
				.toList().get(0);
		film.getCategories().add(updateCategory);
		//Collections.sort(film.getCategories(), updateCategory);
		return filmRepo.save(film);

	}

}
