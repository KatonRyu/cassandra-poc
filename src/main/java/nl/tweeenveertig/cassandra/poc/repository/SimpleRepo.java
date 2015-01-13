package nl.tweeenveertig.cassandra.poc.repository;

import info.archinnov.achilles.exception.AchillesException;
import info.archinnov.achilles.persistence.PersistenceManager;

/**
 * Created by thom on 12/18/14.
 */
public class SimpleRepo {

    private PersistenceManager manager;

    public SimpleRepo(PersistenceManager manager) {
        this.manager = manager;
    }

    public void insertData(Object entity) {
       try {
           manager.insert(entity);
       } catch(AchillesException ex) {
           System.out.println("Object " + entity.toString() + " is not managed by Achilles and was not inserted.");
       }
    }
}
