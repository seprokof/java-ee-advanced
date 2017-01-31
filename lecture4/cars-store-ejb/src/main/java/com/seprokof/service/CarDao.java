package com.seprokof.service;

import java.util.List;

import com.seprokof.dto.Car;

/**
 * Service manipulating car object.
 * 
 * @author seprokof
 *
 */
public interface CarDao {

	/**
	 * Retrieves {@link Car} for the database based on unique identifier.
	 * 
	 * @param id
	 *            unique identifier of the car. Should not be <code>null</code>
	 *            or empty.
	 * @return founded object. <code>null</code> will be returned if car will
	 *         not found.
	 */
	Car getCarById(Long id);

	/**
	 * Retrieves all existing cars from the database.
	 * 
	 * @return the list of stored cars. Empty collection returned if no cars
	 *         found in the database.
	 */
	List<Car> getAllCars();

}
