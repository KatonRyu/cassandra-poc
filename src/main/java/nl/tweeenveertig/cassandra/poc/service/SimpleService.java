package nl.tweeenveertig.cassandra.poc.service;

import info.archinnov.achilles.persistence.PersistenceManager;
import nl.tweeenveertig.cassandra.poc.repository.SimpleRepo;

/**
 * Created by thom on 12/18/14.
 */
public class SimpleService {

    private SimpleRepo repo;

    public SimpleService(PersistenceManager manager) {
        this.repo = new SimpleRepo(manager);
    }

    public void insert(Object entity) {
        repo.insertData(entity);
    }
}
