package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;
import info.archinnov.achilles.type.Counter;

/**
 * Created by thom on 12/17/14.
 */
@Entity(table = "count_table")
public class InfoCounter {

    @Id
    private String name;

    @Column
    private Counter info;

    @Column
    private Counter debug;

    public InfoCounter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counter getInfo() {
        return info;
    }

    public void setInfo(Counter info) {
        this.info = info;
    }

    public Counter getDebug() {
        return debug;
    }

    public void setDebug(Counter debug) {
        this.debug = debug;
    }

}
