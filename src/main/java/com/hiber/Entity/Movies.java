package com.hiber.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String movieName;
	
	private LocalDate relaseDate;
	
	private String movieStatus;
	
	@ManyToMany(mappedBy="movies",cascade ={CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.EAGER)
	/*
	 * @JoinTable(name="Actors_Movies", joinColumns=@JoinColumn(name="movies_Id"),
	 * inverseJoinColumns=@JoinColumn(name="actors_Id") )
	 */
	private Set<Actors> actors= new HashSet<Actors>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getRelaseDate() {
		return relaseDate;
	}

	public void setRelaseDate(LocalDate relaseDate) {
		this.relaseDate = relaseDate;
	}

	public String getMovieStatus() {
		return movieStatus;
	}

	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}

	public Set<Actors> getActors() {
		return actors;
	}

	public void setActors(Set<Actors> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", movieName=" + movieName + ", relaseDate=" + relaseDate + ", movieStatus="
				+ movieStatus + ", actors=" + actors + "]";
	}
	
	
}
