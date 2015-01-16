package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.EmbeddedId;
import info.archinnov.achilles.annotations.Entity;

import java.util.Date;

/**
 * Represents an entry in a logfile without a timestamp.
 * @author Thom Schanzleh
 */
@Entity(table = "timeless_logs")
public class LogFileTimeless {

    @EmbeddedId
    private LogFileTimelessKey id;

    @Column
    private String entry;

    public LogFileTimeless() {}

    public LogFileTimeless(String serverName, String fileName, Date timestamp, String entry) {
        this.id = new LogFileTimelessKey(serverName, fileName, timestamp);
        this.entry = entry;
    }

    public static class LogFileTimelessKey extends BaseKeyPart {

        public LogFileTimelessKey() {}

        public LogFileTimelessKey(String serverName, String fileName, Date timestamp) {
            super(serverName, fileName, timestamp);
        }
    }

    public LogFileTimelessKey getId() {
        return id;
    }

    public void setId(LogFileTimelessKey id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
