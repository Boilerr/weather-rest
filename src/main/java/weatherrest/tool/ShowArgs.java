package weatherrest.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.*;

import java.util.Arrays;

/**
 * This ApplicationRunner show java start arguments
 * Example: java -jar target/weather-rest-0.0.1-SNAPSHOT.jar --somearg=somevalue
 * `--somearg=somevalue` is arguments
 */
@Component
public class ShowArgs implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ShowArgs.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("Your application started with arguments: " + Arrays.toString(args.getSourceArgs()));
        log.info("Your application started with non-option arguments: " + args.getNonOptionArgs());
        log.info("Your application started with option arguments: " + args.getOptionNames());
    }
}