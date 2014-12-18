package nl.tweeenveertig.cassandra.poc.repository;

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
        manager.insert(entity);
    }
}
