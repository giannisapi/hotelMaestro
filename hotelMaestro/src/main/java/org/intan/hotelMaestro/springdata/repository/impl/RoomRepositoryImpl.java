package org.intan.hotelMaestro.springdata.repository.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.intan.hotelMaestro.springdata.model.Room;
import org.intan.hotelMaestro.springdata.repository.CustomRoomRepository;
import org.intan.hotelMaestro.springdata.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class RoomRepositoryImpl implements CustomRoomRepository {
	
	  @Autowired
	private MongoOperations operations;
   @Autowired
   private MongoTemplate mongoTemplate;
   @Autowired
	RoomRepository roomRepository;
	  
	public List<Room>  findByRangeDate() {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	    
		Date to = null;
		Date from = null;
		try {
			to = dateFormat.parse("15-08-2014 00:00:00");
			 from = dateFormat.parse("14-08-2014 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBObject c1 = new BasicDBObject("occupiedDates", null);
		DBObject c2 = BasicDBObjectBuilder.start().push("occupiedDates").push("$not").
		                        push("$elemMatch").add("$gte", from).add("$lte", to).get();
		Criteria c = Criteria.where("$or").is(Arrays.asList(c1, c2));
		Query query = new Query().addCriteria(c);
		List<Room> rooms = mongoTemplate.find(query, Room.class);
		

		return rooms;
	}
	

}
