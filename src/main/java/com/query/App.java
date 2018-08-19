package com.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import com.query.api.APIs;
import com.query.api.Helper;
import com.query.api.IWizardApi;
import com.query.service.RestClientService;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private RestClientService service;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
    	
    	final Options options = new Options();
    	options.addRequiredOption("api", "api", true, "Api")
    	.addRequiredOption("movie", "movie", true, "Movie");

        CommandLine commandLine;
        CommandLineParser parser = new DefaultParser();

        try {

            commandLine = parser.parse(options, args);

            String movie = commandLine.getOptionValue("movie");
            String api = commandLine.getOptionValue("api");

            IWizardApi iWizardApi = Helper.getAPI(api);

            if( null == iWizardApi  ) {
            	System.out.println("This Api not exist");
            	System.out.println("There are these APIs available " + java.util.Arrays.asList(APIs.values()));
            	return;
            }

            System.out.println( "Running by Api: " + api + " - Movie: " + movie + " Searching..." );
            service.search(iWizardApi, movie);
        }
        catch (ParseException exception)
        {
            System.out.print("Error to call the query: ");
            System.out.println(exception.getMessage());

            System.out.println("Samples: java -jar -api MOVIEDB -movie \"Indiana Jones\" query.jar");
        }
    }
}