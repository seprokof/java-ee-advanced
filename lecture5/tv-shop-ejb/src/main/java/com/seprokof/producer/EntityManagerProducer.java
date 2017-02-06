package com.seprokof.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Provides database connectivity via JPA entity manager.
 * 
 * @author seprokof
 *
 */
public class EntityManagerProducer {

    // @PersistenceUnit(unitName = "tv-store")
    // private EntityManagerFactory emf;
    //
    // @Produces
    // public EntityManager getEntityManager() {
    // return emf.createEntityManager();
    // }
    //
    // public void close(@Disposes EntityManager em) {
    // if (em.isOpen()) {
    // em.close();
    // }
    // if (emf.isOpen()) {
    // emf.close();
    // }
    // }

    @Produces
    @PersistenceContext(unitName = "tv-store")
    private EntityManager em;

}
