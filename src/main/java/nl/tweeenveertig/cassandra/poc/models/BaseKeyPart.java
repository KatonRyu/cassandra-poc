package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.Order;
import info.archinnov.achilles.annotations.PartitionKey;

import java.util.Date;

/**
 * Created by thom on 11/28/14.
 */
public abstract class BaseKeyPart {

    @PartitionKey
    @Order(1)
    private String serverName;

    @PartitionKey
    @Order(2)
    private String fileName;

    @Order(3)
    private Date timestamp;

    public BaseKeyPart() {}

    public BaseKeyPart(String serverName, String fileName, Date timestamp) {
        this.serverName = serverName;
        this.fileName = fileName;
        this.timestamp = timestamp;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
