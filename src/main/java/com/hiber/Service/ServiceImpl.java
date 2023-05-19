package com.hiber.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hiber.Entity.Actors;
import com.hiber.Entity.Movies;
import com.hiber.util.Hibernateutil;

public class ServiceImpl implements ActorsDao {

	public void saveActor(Actors acts) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(acts);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void saveMovie(Movies movies) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.persist(movies);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void updateMovie(Movies movies, Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Movies movie=session.get(Movies.class, Id);
			movie.setMovieName(movies.getMovieName());
			movie.setMovieStatus(movies.getMovieStatus());
			movie.setRelaseDate(movies.getRelaseDate());
			movie.setActors(movies.getActors());
			
			session.update(movie);
			
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void updateActor(Actors acts, Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Actors actors=session.get(Actors.class, Id);
			actors.setActorName(acts.getActorName());
			actors.setAge(acts.getAge());
			actors.setNoOfMovies(acts.getNoOfMovies());
			actors.setMovies(acts.getMovies());
			
			session.update(actors);
			
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void deleteMovie(Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Movies movies=session.get(Movies.class, Id);
			session.delete(movies);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void deleteActor(Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Actors acts=session.get(Actors.class, Id);
			session.delete(acts);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public void deleteMovieOfActor(Long Id) {
		Transaction tx = null;
		Session session = null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql="Delete * from Movies m where m.actors.id= :actorsId";
			Query<Movies> query=session.createQuery(hql);
			query.setParameter("actorsIs" , Id);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

	}

	public List<Movies> getMoviesList() {
		Transaction tx = null;
		Session session = null;
		List<Movies> moviesList=new ArrayList<Movies>();
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql=" Select * from Movies ";
			Query<Movies> movies=session.createSQLQuery(hql);
			tx.commit();
			moviesList=movies.list();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

		return moviesList;
	}

	public List<Actors> getActorsList() {
		Transaction tx = null;
		Session session = null;
		List<Actors> actorsList=new ArrayList<Actors>();

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql="from Actors ";
			Query<Actors> acts=session.createQuery(hql);
			tx.commit();
			actorsList=acts.list();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}

		return actorsList;
	}

	public Movies getMovieById(Long Id) {
		Transaction tx = null;
		Session session = null;
		Movies movies=null;

		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			movies=session.get(Movies.class, Id);
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return movies;
	}

	public Actors getActorsById(Long Id) {
		Transaction tx = null;
		Session session = null;
		Actors actors=null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			actors=session.get(Actors.class, Id);

			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return actors;
	}

	public List<Actors> getActorsByMoviesId(Long Id) {
		Transaction tx = null;
		Session session = null;
		List<Actors> listOfActors=null;
		try {
			session = Hibernateutil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String hql="SELECT a FROM Actors a JOIN a.movies m WHERE m.id = :movieId";
			Query<Actors> query=session.createQuery(hql);
			query.setParameter("movieId", Id);
			listOfActors=query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx == null) {
				tx.rollback();
			}
			e.getStackTrace();
		} finally {
			if (tx != null) {
				session.close();
			}
		}
		return listOfActors;
	}

}
