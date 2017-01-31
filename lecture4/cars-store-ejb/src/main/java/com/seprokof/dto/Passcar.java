package com.seprokof.dto;

/**
 * Passenger car representation.
 * 
 * @author seprokof
 *
 */
public class Passcar extends CarBase {
	private Integer passengerCount;

	public Passcar(Car car) {
		super(car);
		this.passengerCount = car.getPassengerCount();
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((passengerCount == null) ? 0 : passengerCount.hashCode());
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
		Passcar other = (Passcar) obj;
		if (passengerCount == null) {
			if (other.passengerCount != null)
				return false;
		} else if (!passengerCount.equals(other.passengerCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passcar [passengerCount=" + passengerCount + ", model()=" + getModel() + ", year()=" + getYear() + "]";
	}

}
