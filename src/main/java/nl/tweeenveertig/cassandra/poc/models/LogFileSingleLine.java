package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.EmbeddedId;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Order;

import java.util.Date;

/**
 * Represents a line in a log file.
 * @author Thom Schanzleh
 */
@Entity(table = "line_based_logs")
public class LogFileSingleLine {

    @EmbeddedId
    private LogFileLineKey id;

    @Column
    private String line;

    public LogFileSingleLine() {}

    public LogFileSingleLine(String serverName, String fileName, Date logEntryDate, Date timestamp, String line) {
        this.id = new LogFileLineKey(serverName, fileName, logEntryDate, timestamp);
        this.line = line;
    }

    public static class LogFileLineKey extends BaseKeyPart {

        @Order(4)
        private Date logEntryDate;


        public LogFileLineKey() {}

        public LogFileLineKey(String serverName, String fileName, Date logEntryDate, Date timestamp) {
            super(serverName, fileName, timestamp);
            this.logEntryDate = logEntryDate;
        }

        public Date getLogEntryDate() {
            return logEntryDate;
        }

        public void setLogEntryDate(Date logEntryDate) {
            this.logEntryDate = logEntryDate;
        }
    }

    public LogFileLineKey getId() {
        return id;
    }

    public void setId(LogFileLineKey id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
