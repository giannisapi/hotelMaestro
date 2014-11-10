package org.intan.hotelMaestro.springdata.repository;

import java.util.List;

import org.intan.hotelMaestro.springdata.model.Hotel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long>, QueryDslPredicateExecutor<Hotel>  {
	@Query("{ ?0 : ?1 }")
	List<Hotel> findByAttributes(String key, String value);
}
