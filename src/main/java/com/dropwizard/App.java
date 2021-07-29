package com.dropwizard;

/**
 * Hello world!
 *
 */

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.controller.HelloRestController;

// To run the server -
// mvn clean package
//  java -jar target/DropWizardExample-1.0-SNAPSHOT.jar server src/main/java/config.yaml

// initialize and run are dropwizard lifecycle methods
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        //  Register all services inside jersey container like this
        e.jersey().register(new HelloRestController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
