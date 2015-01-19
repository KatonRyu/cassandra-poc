package nl.tweeenveertig.cassandra.poc.util;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * Created by thom on 11/20/14.
 */
public class LogFileRegexDateWrapper {

    public enum LogFileType {
        SINGLE,
        BLOCK,
        TIMELESS
    }

    private LogFileType type;

    private Pattern pattern;

    private SimpleDateFormat dateFormat;

    public LogFileRegexDateWrapper() {

    }

    public LogFileRegexDateWrapper(LogFileType type, Pattern pattern, SimpleDateFormat dateFormat) {
        this.type = type;
        this.pattern = pattern;
        this.dateFormat = dateFormat;
    }

    public LogFileRegexDateWrapper(LogFileType type, String pattern, String dateFormat) {
        this.type = type;
        this.pattern = Pattern.compile(pattern);
        this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    public LogFileType getType() {
        return type;
    }

    public void setType(LogFileType type) {
        this.type = type;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

}
