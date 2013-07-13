package com.test.djackatron2.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalTime;
import org.junit.Test;

public class TestTimeService {
	@Test
	public void  DefaultTimeService(){
		//given
		LocalTime openService = new LocalTime(6,0);
		LocalTime closeService = new LocalTime(22,0);
		LocalTime testTime = new LocalTime(16,0);
		DefaultTimeService timeService = new DefaultTimeService(openService,closeService);
		
		//when
		boolean result = timeService.isServiceAvailiable(testTime);
		
		//then
		assertTrue(result);
	} 
	@Test
	public void  AfterService(){
		//given
		LocalTime openService = new LocalTime(6,0);
		LocalTime closeService = new LocalTime(22,0);
		LocalTime testTime = new LocalTime(22,0);
		DefaultTimeService timeService = new DefaultTimeService(openService,closeService);
		
		//when
		boolean result = timeService.isServiceAvailiable(testTime);
		
		//then
		assertFalse(result);
	}
	@Test
	public void  BeforService(){
		//given
		LocalTime openService = new LocalTime(6,0);
		LocalTime closeService = new LocalTime(22,0);
		LocalTime testTime = new LocalTime(5,0);
		DefaultTimeService timeService = new DefaultTimeService(openService,closeService);
		
		//when
		boolean result = timeService.isServiceAvailiable(testTime);
		
		//then
		assertFalse(result);
	}
}
