package nl.tweeenveertig.cassandra.poc.models;

import info.archinnov.achilles.annotations.*;

import java.util.Date;

/**
 * Represents a block of information in a log file.
 * @author Thom Schanzleh
 */
@Entity(table = "block_based_logs")
public class LogFileBlock {

    @EmbeddedId
    private LogFileBlockKey id;

    @Column
    private String block;

    public LogFileBlock() {}

    public LogFileBlock(String serverName, String fileName, Date blockBeginTimestamp, Date blockEndTimestamp, Date timestamp, String block) {
        this.id = new LogFileBlockKey(serverName, fileName, blockBeginTimestamp, blockEndTimestamp, timestamp);
        this.block = block;
    }

    public static class LogFileBlockKey extends BaseKeyPart {

        @Order(4)
        private Date blockBeginTimestamp;

        @Order(5)
        private Date blockEndTimestamp;

        public LogFileBlockKey() {}

        public LogFileBlockKey(String serverName, String fileName, Date blockBeginTimestamp, Date blockEndTimestamp, Date timestamp) {
            super(serverName, fileName, timestamp);
            this.blockBeginTimestamp = blockBeginTimestamp;
            this.blockEndTimestamp = blockEndTimestamp;
        }

        public Date getBlockBeginTimestamp() {
            return blockBeginTimestamp;
        }

        public void setBlockBeginTimestamp(Date blockBeginTimestamp) {
            this.blockBeginTimestamp = blockBeginTimestamp;
        }

        public Date getBlockEndTimestamp() {
            return blockEndTimestamp;
        }

        public void setBlockEndTimestamp(Date blockEndTimeStamp) {
            this.blockEndTimestamp = blockEndTimeStamp;
        }
    }

    public LogFileBlockKey getId() {
        return id;
    }

    public void setId(LogFileBlockKey id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
