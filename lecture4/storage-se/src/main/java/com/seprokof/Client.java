package com.seprokof;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * Application entry point.
 * 
 * @author seprokof
 *
 */
public class Client {

	@Inject
	@Any
	private Instance<IStorage> storage;

	public void main(@Observes ContainerInitialized event) {
		storage.forEach(s -> s.storeData());
	}

}
