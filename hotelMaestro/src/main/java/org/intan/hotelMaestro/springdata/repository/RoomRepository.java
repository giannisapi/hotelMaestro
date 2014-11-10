package org.intan.hotelMaestro.springdata.repository;

import java.util.List;

import org.intan.hotelMaestro.springdata.model.Room;
import org.intan.hotelMaestro.springdata.model.RoomType;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long>, QueryDslPredicateExecutor<RoomType>,CustomRoomRepository  {

	//Page<Room> findByDescriptionContaining(String description, Pageable pageable);

	/**
	 * Returns all {@link RoomType}s having the given attribute.
	 * 
	 * @param attribute
	 * @return
	 */
	@Query("{ ?0 : ?1 }")
	List<Room> findByAttributes(String key, String value);
}
