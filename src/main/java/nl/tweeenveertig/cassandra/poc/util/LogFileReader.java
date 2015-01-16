package nl.tweeenveertig.cassandra.poc.util;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by thom on 1/15/15.
 */
public class LogFileReader {

    private static final String BASE_DIR = "/var/log/";
    private static Set<String> defaultLogs = new HashSet<String>();
    private static BufferedReader reader;

    static {
        defaultLogs.add("auth.log");
        defaultLogs.add("syslog");
    }



}
