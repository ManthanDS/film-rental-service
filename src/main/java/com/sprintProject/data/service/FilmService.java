package com.sprintProject.data.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.entity.Language;

public interface FilmService {
	
	Film getFilmById(int id);
	List<Film> getAllFilms();
    String addFilm(Film film);
    List<Film> getFilmsByTitle(String title);
    List<Film> getFilmsByYear(int year);
    List<Film> getFilmsByDurationGreaterThan(int duration);
    List<Film> getFilmsByRateGreaterThan(int rate);
    List<Film> getFilmsByLengthGreaterThan(int length);
    List<Film> getFilmsByDurationLesserThan(int duration);
    List<Film> getFilmsByRateLesserThan(int rate);
    List<Film> getFilmsByLengthLesserThan(int length);
    List<Film> getFilmsBetweenYears(int fromYear, int toYear);
    List<Film> getFilmsByRatingLesserThan(String rating);
    List<Film> getFilmsByRatingGreaterThan(String rating);
    List<Film> getFilmsByLanguage(String language);
    List<Actor> getActorsFromFilmByFilmId(int film_id);
    Map<Integer, Long> getCountOfFilmsByYear();
    List<Film> getFilmsByCategory(String category);
    List<Actor> assignActorToFilm(int film_id,String actor_first_name,String actor_last_name);
    Film updateTitleOfFilm(int film_id,String title);
    Film updateReleaseYearOfFilm(int film_id,int release_year);
    Film updateRentalDurationOfFilm(int film_id,int rental_duration);
    Film updateRentalRateOfFilm(int film_id,int rental_rate);
    Film updateRatingOfFilm(int film_id,String rating);
    Film updateLanguageOfFilm(int film_id,String language);
    Film updateCategoryOfFilm(int film_id,String category);
    
}
