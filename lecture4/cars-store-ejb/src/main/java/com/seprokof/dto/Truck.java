package com.seprokof.dto;

/**
 * Truck car representation.
 * 
 * @author seprokof
 *
 */
public class Truck extends CarBase {
	private Double carryingCapacity;

	public Truck(Car car) {
		super(car);
		this.carryingCapacity = car.getCarryingCapacity();
	}

	public Double getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(Double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carryingCapacity == null) ? 0 : carryingCapacity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (carryingCapacity == null) {
			if (other.carryingCapacity != null)
				return false;
		} else if (!carryingCapacity.equals(other.carryingCapacity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Truck [carryingCapacity=" + carryingCapacity + ", model=" + getModel() + ", year=" + getYear() + "]";
	}

}
