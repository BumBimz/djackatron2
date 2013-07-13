package com.test.djackatron2.service;

import org.joda.time.LocalTime;

public class DefaultTimeService {
	private LocalTime openService;
	private LocalTime closeService;
	
	public DefaultTimeService(LocalTime openService, LocalTime closeService) {
		this.openService = openService;
		this.closeService = closeService;
	}

	public boolean isServiceAvailiable(LocalTime testTime) {
		if(testTime.isBefore(closeService)&&testTime.isAfter(openService))
			return true;
		else
			return false;
	}

}
