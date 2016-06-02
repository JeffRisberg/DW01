package com.incra;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AdTechServer extends Application<AdTechServerConfig> {
    public static void main(String[] args) throws Exception {
        new AdTechServer().run(args);
    }

    @Override
    public String getName() {
        return "ad-tech-service";
    }

    @Override
    public void initialize(Bootstrap<AdTechServerConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AdTechServerConfig configuration,
                    Environment environment) {
        environment.jersey().register(new TaskListResource(configuration.getMaxLength()));

        environment.jersey().register(new CampaignsResource());

        environment.jersey().register(new KeywordsResource());
    }
}