package nl.tweeenveertig.cassandra.poc.util;

import static nl.tweeenveertig.cassandra.poc.util.LogFileRegexDateWrapper.LogFileType;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by thom on 1/15/15.
 */
public class LogFileReader {

    private static final String BASE_DIR = "/var/log/";
    private static Map<String, LogFileType> defaultLogs = new HashMap<String, LogFileType>();
    private static BufferedReader reader;

    static {
        defaultLogs.put("auth.log", LogFileType.SINGLE);
        defaultLogs.put("syslog", LogFileType.SINGLE);
    }


    public static void readDefault() {
        for(Map.Entry<String, LogFileType> entry : defaultLogs.entrySet()) {
            try {
                reader = Files.newBufferedReader(Paths.get(BASE_DIR + entry.getKey()), StandardCharsets.UTF_8);
                String cur;
                Matcher matcher;

                while((cur = reader.readLine()) != null) {
                    
                }
            } catch(IOException ex) {
                System.err.println("Error reading file");
            }
        }
    }

}
