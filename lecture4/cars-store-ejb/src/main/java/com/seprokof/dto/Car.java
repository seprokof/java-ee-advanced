package com.seprokof.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Car entity representation in the database. Fields validation is not used,
 * since the service only read values.
 * 
 * @author seprokof
 *
 */
@Entity
@NamedQuery(name = Car.GET_ALL_CARS, query = "SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 2846988032545366397L;
	public static final String GET_ALL_CARS = "Car.getAllCars";

	@Id
	@GeneratedValue
	private Long id;
	private String model;
	private Integer carYear;
	@Enumerated(EnumType.STRING)
	private CarType carType;
	private Integer passengerCount;
	private Double carryingCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCarYear() {
		return carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	public Double getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(Double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + carYear + ", carType=" + carType + ", passengerCount="
				+ passengerCount + ", carryingCapacity=" + carryingCapacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((carryingCapacity == null) ? 0 : carryingCapacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((passengerCount == null) ? 0 : passengerCount.hashCode());
		result = prime * result + ((carYear == null) ? 0 : carYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carType != other.carType)
			return false;
		if (carryingCapacity == null) {
			if (other.carryingCapacity != null)
				return false;
		} else if (!carryingCapacity.equals(other.carryingCapacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (passengerCount == null) {
			if (other.passengerCount != null)
				return false;
		} else if (!passengerCount.equals(other.passengerCount))
			return false;
		if (carYear == null) {
			if (other.carYear != null)
				return false;
		} else if (!carYear.equals(other.carYear))
			return false;
		return true;
	}

	/**
	 * Supported car types.
	 * 
	 * @author seprokof
	 *
	 */
	public enum CarType {
		PASSCAR, TRUCK
	}
}
