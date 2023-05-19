package com.hiber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hiber.Entity.Actors;
import com.hiber.Entity.Movies;
import com.hiber.Service.ActorsDao;
import com.hiber.Service.ServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ActorsDao operations=new ServiceImpl();
        
        //save Actors with Movies
        Actors actor1=new Actors();
        
        Movies movie1 =new Movies();
        movie1.setMovieName("Akhanda");
        movie1.setMovieStatus("BlockBluster");
        movie1.setRelaseDate(LocalDate.of(2021, 11, 11));
        
        Movies movie2=new Movies();
        movie2.setMovieName("Veera Simha Reddy");
        movie2.setMovieStatus("SuperHit");
        movie2.setRelaseDate(LocalDate.of(2022,9, 15));
        
        actor1.setActorName("Balayya");
        actor1.setAge(65);

        actor1.setNoOfMovies(108);
        actor1.getMovies().add(movie2);
        actor1.getMovies().add(movie1);
        
        operations.saveActor(actor1);
        
        //Save Movie with Actor

        Actors actor2=new Actors();
        actor2.setActorName("NTR");
        actor2.setAge(38);
        actor2.setNoOfMovies(29);
        
        Actors actor3=new Actors();
        actor3.setActorName("Ram Charan");
        actor3.setAge(36);
        actor3.setNoOfMovies(20);
        
        Movies movie3=new Movies();
        movie3.setMovieName("RRR");
        movie3.setMovieStatus("ALl TIME Block Buster");
        movie3.setRelaseDate(LocalDate.of(2022, 4, 23));
        movie3.getActors().add(actor2);
        movie3.getActors().add(actor3);
        
        
        operations.saveMovie(movie3);
        
        
        //get Actors List
        System.out.println("Actor  List:  ============>"+operations.getActorsList());
        
        //getMoviesList
        System.out.println("Movies List : ============>"+operations.getMoviesList());
        
        //getMoviesById
        System.out.println("Movies  By ID :1 ============>"+operations.getMovieById(1L));
        
        //getActorsById
        System.out.println("Actor By ID :3 ============>"+operations.getActorsById(3L));
        
        //getActorsByMoviesId
        System.out.println("ActorsByMoviesId ===========>"+operations.getActorsByMoviesId(1L));
        
        //Update Movie
        movie3.setMovieStatus("ALL TIME BIGGEST BLOCK BLUSTER");
        actor2.setAge(20);  //not Changed
        movie3.getActors().add(actor2); //not Changed
        operations.updateMovie(movie3, 3L);
        
        //UpdateActor
        actor3.setAge(35);
        operations.updateActor(actor3, 3L);
        
        
        //Delete Movie
        operations.deleteMovie(2L);
        
        //Delete Actor
        operations.deleteActor(4L);
    }
}
