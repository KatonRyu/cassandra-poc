package nl.tweeenveertig.cassandra.poc.app;

import com.datastax.driver.core.Cluster;
import info.archinnov.achilles.persistence.PersistenceManager;
import info.archinnov.achilles.persistence.PersistenceManagerFactory;
import info.archinnov.achilles.type.Counter;
import info.archinnov.achilles.type.CounterBuilder;
import nl.tweeenveertig.cassandra.poc.models.InfoCounter;
import nl.tweeenveertig.cassandra.poc.models.LogFile;
import nl.tweeenveertig.cassandra.poc.util.LogFileRegexDateWrapper;
import nl.tweeenveertig.cassandra.poc.util.LogFileRegexDateWrapper.LogFileType;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;

/**
 * Created by thom on 11/7/14.
 */
public class Main {

    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
        PersistenceManagerFactory pmf = PersistenceManagerFactory.PersistenceManagerFactoryBuilder
                .builder(cluster)
                .withEntityPackages("nl.tweeenveertig.cassandra.poc.models")
                .withKeyspaceName("poc")
                .forceTableCreation(true).build();

        PersistenceManager manager = pmf.createPersistenceManager();

        LogFileRegexDateWrapper wrapper = new LogFileRegexDateWrapper(LogFileType.WEB, "(\\d{4}[-][0|1][0-2][-][0-3]\\d [0-2]\\d[:][0-5]\\d[:][0-5]\\d[,]\\d{3})", "yyyy-MM-dd HH:mm:ss,SSS");

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("/home/thom/Documents/workspace/Cassandra-POC/cassandra-poc/src/main/resources/log.txt-20.log"), StandardCharsets.UTF_8);
            String cur;
            Matcher matcher;
            while((cur = br.readLine()) != null) {
                LogFile log = new LogFile();
                InfoCounter count = new InfoCounter();
                System.out.println("Counter made");
                count.setName("log.txt-20.log");
                Counter infoCount = count.getInfo() != null ? count.getInfo() : CounterBuilder.incr(0L);
                System.out.println("Countinfo retrieved");
                if(cur.contains("INFO")) {
                    System.out.println("Attempting to update count");
                    infoCount.incr();
                    System.out.println("Count incremented");
                }
                count.setInfo(CounterBuilder.incr(infoCount.get() != null ? infoCount.get() : 0L));
                matcher = wrapper.getPattern().matcher(cur);
                //System.out.println(wrapper.getPattern().toString());
                System.out.println(cur);
                System.out.println("File made.");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
                String dateString = cur.substring(0, 24);
                System.out.println("DateString: " + dateString);
                Date date = df.parse(dateString);
                String line = cur.substring(24);
                log.setId(new LogFile.CompoundKey("log.txt-20.log", date, new Date()));
                System.out.println("Id set.");
                log.setLine(line);
                System.out.println("Line set.");
                manager.insert(log);
                manager.insert(count);
                System.out.println("Row inserted.");
            }
        } catch(Exception ex) {
            System.out.println("Message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
