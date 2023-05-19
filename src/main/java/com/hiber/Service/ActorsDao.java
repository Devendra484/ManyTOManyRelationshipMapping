package com.hiber.Service;

import java.util.List;

import com.hiber.Entity.*;

public interface ActorsDao {
	
	void saveActor(Actors acts);
	void saveMovie(Movies movies);
	
	void updateMovie(Movies movies, Long Id);
	void updateActor(Actors acts, Long Id);
	
	void deleteMovie(Long Id);
	void deleteActor(Long Id);
	
	List<Movies> getMoviesList();
	List<Actors> getActorsList();
	Movies getMovieById(Long Id);
	Actors getActorsById(Long Id);
	List<Actors> getActorsByMoviesId(Long Id);
	
	
	
}
