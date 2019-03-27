package co.com.star.tennisreferee.repository.configuration;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ConfiguracionCDI {

    @Produces
    @PersistenceContext
    public EntityManager entityManager;
    
}
