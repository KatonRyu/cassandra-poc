package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by thom on 11/7/14.
 */
@Entity(table = "logs")
public class LogFile {


    @EmbeddedId
    private CompoundKey id;

    @Column
    private String line;


    public static class CompoundKey {
        @PartitionKey
        @Order(1)
        private String name;

        @PartitionKey
        @Order(2)
        private Date time;

        @PartitionKey
        @Order(3)
        private Date timestamp;

        public CompoundKey() {}

        public CompoundKey(String name, Date time, Date timestamp) {
            this.name = name;
            this.time = time;
            this.timestamp = timestamp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
    }

    public LogFile() {
    }

    public CompoundKey getId() {
        return id;
    }

    public void setId(CompoundKey id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
