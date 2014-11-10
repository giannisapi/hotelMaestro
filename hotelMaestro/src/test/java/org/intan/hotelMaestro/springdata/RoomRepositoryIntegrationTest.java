package org.intan.hotelMaestro.springdata;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.intan.hotelMaestro.springdata.model.Room;
import org.intan.hotelMaestro.springdata.model.RoomType;
import org.intan.hotelMaestro.springdata.repository.RoomRepository;
import org.intan.hotelMaestro.springdata.repository.RoomTypeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomRepositoryIntegrationTest extends AbstractIntegrationTest{

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	RoomTypeRepository roomTypeRepository;
	private long startMonth = 3;
	private long endMonth = 11;
	private long startDay = 1;
	private long endDay  = 30;
	
	private long getRandomTimeBetweenTwoDates () {
	    long diff = endMonth - startMonth + 1;
	    String randomMonth =  Long.toString(startMonth + (long) (Math.random() * diff)) ;
	    if (randomMonth.length() == 1) {
	    	randomMonth = "0" + randomMonth;
	    }
	    
	     diff = endDay - startDay + 1;
	    String randomDay =  Long.toString(startDay + (long) (Math.random() * diff)) ;
	    if (randomDay.length() == 1) {
	    	randomDay = "0" + randomDay;	
	    }
	    String time = "2013-" + randomMonth+ "-" + randomDay + " 00:00:00";
	    return Timestamp.valueOf(time).getTime();
	}

	


	@Test
	public void createRoom() throws ParseException {
		roomRepository.findByRangeDate();
	    SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "yyyy-MM-dd hh:mm:ss");
	    Date randomDate = null;
	    System.out.println(roomRepository.count());
	    Room room = null;
		RoomType roomType = new RoomType("Single Room Type", new BigDecimal(49.99), "Single");
		roomType = roomTypeRepository.save(roomType);
		assertThat(roomType.getId(), is(notNullValue()));
		int i = 0;
		while (i < 6000) {
			i = i + 1;
			room = new Room();
			room.setBedcount(1);
			room.setBedtype1(1);
			room.setRateid(1);
			room.setRoomno(888);
			room.setRoomTypeID(roomType.getId());
			room.setOccupiedDates(new ArrayList<Date>());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String dateInString = "10-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "11-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "12-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "13-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "16-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "17-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			dateInString = "18-08-2014 00:00:00";
			room.getOccupiedDates().add(sdf.parse(dateInString));
			room = roomRepository.save(room);
			assertThat(room.getId(), is(notNullValue()));
		}
	}
	
	@Test
	public void createRoomWithRoomType() {

		RoomType roomType = new RoomType("Single Room Type", new BigDecimal(49.99), "Single");
		roomType = roomTypeRepository.save(roomType);
		assertThat(roomType.getId(), is(notNullValue()));

		Room room = new Room();
		room.setBedcount(1);
		room.setBedtype1(1);
		room.setRateid(1);
		room.setRoomno(888);
		room.setRoomTypeID(roomType.getId());
		room = roomRepository.save(room);
		assertThat(room.getId(), is(notNullValue()));
	}
}
