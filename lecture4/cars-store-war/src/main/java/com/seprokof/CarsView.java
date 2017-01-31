package com.seprokof;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.dto.Passcar;
import com.seprokof.dto.Truck;

/**
 * Cars view.
 * 
 * @author seprokof
 *
 */
@Named
@RequestScoped
public class CarsView {

	@Inject
	private Set<Passcar> passcars;

	@Inject
	private Set<Truck> trucks;

	public Set<Passcar> getPasscars() {
		return passcars;
	}

	public Set<Truck> getTrucks() {
		return trucks;
	}

}
