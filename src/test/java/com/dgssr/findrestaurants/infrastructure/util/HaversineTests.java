package com.dgssr.findrestaurants.infrastructure.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dgssr.findrestaurants.infrastructure.utilities.HaversineCalc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HaversineTests {

	
	@Test
	public void shouldBeHaversinIsCreated() {
		HaversineCalc haversine = new HaversineCalc();
		assertNotNull(haversine);
	}
	
	@Test
	public void shouldBeCalculateDistanceTwoPoints() {
		
		double latStart = -23.6880566;
		double longStart = -46.7968791;
		double latEnd = -23.6593497;
		double longEnd = -46.7702823;
		
		double distanceExpected = 4.186348591166014;
		
		double distanceBetween = HaversineCalc.distance(latStart, longStart, latEnd,longEnd);
		
		assertTrue(distanceBetween == distanceExpected);
	}
	
	@Test
	public void shouldBeCalculateHaversin() {
		double latitude = -23.6880566;	
		double haversinExpected = 0.43711115982239584;
		double haversinCalc = HaversineCalc.haversin(latitude);
		assertTrue(haversinCalc == haversinExpected);
	}
}
