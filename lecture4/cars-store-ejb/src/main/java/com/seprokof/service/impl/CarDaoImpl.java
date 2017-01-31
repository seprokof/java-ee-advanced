package com.seprokof.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.seprokof.dto.Car;
import com.seprokof.service.CarDao;

/**
 * Database access object layer.
 * 
 * @author seprokof
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CarDaoImpl implements CarDao {

	@Inject
	private EntityManager em;

	@Override
	public Car getCarById(Long id) {
		return em.find(Car.class, id);
	}

	@Override
	public List<Car> getAllCars() {
		return em.createNamedQuery(Car.GET_ALL_CARS, Car.class).getResultList();
	}

}
