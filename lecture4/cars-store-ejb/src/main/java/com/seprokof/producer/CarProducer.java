package com.seprokof.producer;

import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;

import com.seprokof.dto.Car.CarType;
import com.seprokof.dto.Passcar;
import com.seprokof.dto.Truck;
import com.seprokof.service.CarDao;

/**
 * Produces injectable collections of passcars and trucks.
 * 
 * @author seprokof
 *
 */
public class CarProducer {

	@EJB
	private CarDao carDao;

	@Produces
	public Set<Passcar> getPasscars() {
		return carDao.getAllCars().stream().filter(c -> CarType.PASSCAR.equals(c.getCarType())).map(Passcar::new)
				.collect(Collectors.toSet());
	}

	@Produces
	public Set<Truck> getTrucks() {
		return carDao.getAllCars().stream().filter(c -> CarType.TRUCK.equals(c.getCarType())).map(Truck::new)
				.collect(Collectors.toSet());
	}

}
