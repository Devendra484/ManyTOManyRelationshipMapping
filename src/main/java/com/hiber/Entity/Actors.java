package com.hiber.Entity;

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
@Table(name="Actors")
public class Actors {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String actorName;
	
	private Integer age;
	
	private Integer noOfMovies;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="Actors_Movies",
			joinColumns=@JoinColumn(name="actors_Id"),
			inverseJoinColumns=@JoinColumn(name="movies_Id")
			)
	private Set<Movies> movies= new HashSet<Movies>();
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getActorName() {
		return actorName;
	}



	public void setActorName(String actorName) {
		this.actorName = actorName;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Integer getNoOfMovies() {
		return noOfMovies;
	}



	public void setNoOfMovies(Integer noOfMovies) {
		this.noOfMovies = noOfMovies;
	}



	public Set<Movies> getMovies() {
		return movies;
	}



	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}



	@Override
	public String toString() {
		return "Actors [id=" + id + ", actorName=" + actorName + ", age=" + age + ", noOfMovies=" + noOfMovies
				+ "]";
	}
	
	
	
}
