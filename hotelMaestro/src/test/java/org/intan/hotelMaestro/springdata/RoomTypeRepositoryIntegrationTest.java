/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intan.hotelMaestro.springdata;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.intan.hotelMaestro.springdata.model.RoomType;
import org.intan.hotelMaestro.springdata.repository.RoomTypeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

/**
 * Integration tests for {@link ProductRepository}.
 * 
 * @author Oliver Gierke
 */
public class RoomTypeRepositoryIntegrationTest extends AbstractIntegrationTest {

	
	@Autowired
	RoomTypeRepository roomTypeRepository;

	@Test
	public void createRoomType() {

		RoomType roomType = new RoomType("Single Room Type", new BigDecimal(49.99), "Single");
		roomType = roomTypeRepository.save(roomType);
		assertThat(roomType.getId(), is(notNullValue()));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void lookupRoomTypesByDescription() {
	/*	RoomType roomType = new RoomType("Double Room Type", new BigDecimal(49.99), "Description");
		roomType = roomTypeRepository.save(roomType);
		Iterable<RoomType> t = roomTypeRepository.findAll();
		
		assertNotNull(t);
		assertTrue(t.iterator().hasNext());*/

		Pageable pageable = new PageRequest(0, 1, Direction.DESC, "name");
		Page<RoomType> page = roomTypeRepository.findByDescriptionContaining("Single", pageable);
		System.out.println("desc:" + page.getContent().get(0).getDescription());
		assertThat(page.getContent(), hasSize(1));
		assertThat(page.isFirstPage(), is(true));
		assertThat(page.isLastPage(), is(false));
		assertThat(page.hasNextPage(), is(true));
	}

/*	@Test
	@SuppressWarnings("unchecked")
	public void findsProductsByAttributes() {

		List<Product> products = repository.findByAttributes("attributes.connector", "plug");

		assertThat(products, Matchers.<Product> hasItems(named("Dock")));
	}*/
}
