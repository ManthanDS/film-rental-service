package com.sprintProject.data.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintProject.data.entity.Actor;
import com.sprintProject.data.entity.Film;
import com.sprintProject.data.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {

	@Autowired
	FilmService filmSvc;
	
//	@Autowired
//	ModelMapper modelMapper;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<FilmDTO> getFilmById(@PathVariable("id") int id) {
//		Film film = filmSvc.getFilmById(id);
//		FilmDTO filmDtoResponse = modelMapper.map(film, FilmDTO.class);
//		return ResponseEntity.ok().body(filmDtoResponse);
//	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addFilm(@RequestBody Film film){
		return new ResponseEntity<String>(filmSvc.addFilm(film),HttpStatus.CREATED);
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Film>> getFilmByTitle(@PathVariable("title") String title){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByTitle(title),HttpStatus.OK);
	}
	
	@GetMapping("/year/{year}")
	public ResponseEntity<List<Film>> getFilmsByYear(@PathVariable("year") int year){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByYear(year),HttpStatus.OK);
	}
	
	@GetMapping("/duration/gt/{rd}")
	public ResponseEntity<List<Film>> getFilmsByDurationGreaterThan(@PathVariable("rd") int rd){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByDurationGreaterThan(rd),HttpStatus.OK);
	}
	
	@GetMapping("/rate/gt/{rate}")
	public ResponseEntity<List<Film>> getFilmsByRateGreaterThan(@PathVariable("rate") int rate){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByRateGreaterThan(rate),HttpStatus.OK);
	}
	
	@GetMapping("/length/gt/{length}")
	public ResponseEntity<List<Film>> getFilmsByLengthGreaterThan(@PathVariable("length") int length){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByLengthGreaterThan(length),HttpStatus.OK);
	}
	
	@GetMapping("/duration/lt/{rd}")
	public ResponseEntity<List<Film>> getFilmsByDurationLesserThan(@PathVariable("rd") int rd){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByDurationLesserThan(rd),HttpStatus.OK);
	}
	
	@GetMapping("/rate/lt/{rate}")
	public ResponseEntity<List<Film>> getFilmsByRateLesserThan(@PathVariable("rate") int rate){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByRateLesserThan(rate),HttpStatus.OK);
	}
	
	@GetMapping("/length/lt/{length}")
	public ResponseEntity<List<Film>> getFilmsByLengthLesserThan(@PathVariable("length") int length){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByLengthLesserThan(length),HttpStatus.OK);
	}
	
	@GetMapping("/betweenyear/{from}/{to}")
	public ResponseEntity<List<Film>> getFilmsBetweenYears(@PathVariable("from") int fromYear,@PathVariable("to") int toYear){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsBetweenYears(fromYear,toYear),HttpStatus.OK);
	}
	
	@GetMapping("/rating/lt/{rating}")
	public ResponseEntity<List<Film>> getFilmsByRatingLowerThan(@PathVariable("rating") String rating){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByRatingLesserThan(rating),HttpStatus.OK);
	}
	
	@GetMapping("/rating/gt/{rating}")
	public ResponseEntity<List<Film>> getFilmsByRatingGreaterThan(@PathVariable("rating") String rating){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByRatingGreaterThan(rating),HttpStatus.OK);
	}
	
	@GetMapping("/language/{lang}")
	public ResponseEntity<List<Film>> getFilmsByLanguage(@PathVariable("lang") String lang){
		return new ResponseEntity<List<Film>>(filmSvc.getFilmsByLanguage(lang),HttpStatus.OK);
	}
	
	@GetMapping("/countbyyear")
	public ResponseEntity<Map<Integer,Long>> getCountOfFilmsByYear(){
		return new ResponseEntity<Map<Integer,Long>>(filmSvc.getCountOfFilmsByYear(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}/actors")
	public ResponseEntity<List<Actor>> getActorsOfFilmByFilmId(@PathVariable("id") int film_id){
		return new ResponseEntity<List<Actor>>(filmSvc.getActorsFromFilmByFilmId(film_id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/actor")
	public ResponseEntity<List<Actor>> assignActorToFilm(@PathVariable("id") int film_id,@RequestParam("first_name") String first_name,@RequestParam
			("last_name") String last_name){
		return new ResponseEntity<List<Actor>>(filmSvc.assignActorToFilm(film_id, first_name, last_name),HttpStatus.OK);
	}
	
	@PutMapping("/update/title/{id}")
	public ResponseEntity<Film> updateTitleOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody String title){
		return new ResponseEntity<Film>(filmSvc.updateTitleOfFilm(film_id,title),HttpStatus.OK);
	}
	
	@PutMapping("/update/releaseyear/{id}")
	public ResponseEntity<Film> updateReleaseYearOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody int release_year){
		return new ResponseEntity<Film>(filmSvc.updateReleaseYearOfFilm(film_id, release_year),HttpStatus.OK);
	}
	
	@PutMapping("/update/rentalduration/{id}")
	public ResponseEntity<Film> updateRentalDurationOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody int rental_duration){
		return new ResponseEntity<Film>(filmSvc.updateRentalDurationOfFilm(film_id, rental_duration),HttpStatus.OK);
	}
	
	@PutMapping("/update/rentalrate/{id}")
	public ResponseEntity<Film> updateRentalRateOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody int rental_rate){
		return new ResponseEntity<Film>(filmSvc.updateRentalRateOfFilm(film_id, rental_rate),HttpStatus.OK);
	}
	
	@PutMapping("/update/rating/{id}")
	public ResponseEntity<Film> updateRatingOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody String rating){
		return new ResponseEntity<Film>(filmSvc.updateRatingOfFilm(film_id, rating),HttpStatus.OK);
	}
	
	@PutMapping("/update/language/{id}")
	public ResponseEntity<Film> updateLanguageOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody String language){
		return new ResponseEntity<Film>(filmSvc.updateLanguageOfFilm(film_id, language),HttpStatus.OK);
	}
	
	@PutMapping("/update/category/{id}")
	public ResponseEntity<Film> updateCategoryOfFilmByFilmId(@PathVariable("id") int film_id,@RequestBody String category){
		return new ResponseEntity<Film>(filmSvc.updateCategoryOfFilm(film_id, category),HttpStatus.OK);
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {
		return new ResponseEntity<Film>(filmSvc.getFilmById(id),HttpStatus.OK);	
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Film>> getAllFilms() {
		return new ResponseEntity<List<Film>>(filmSvc.getAllFilms(),HttpStatus.OK);	
	} 	
}
