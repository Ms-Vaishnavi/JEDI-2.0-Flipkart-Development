package com.flipkart.rest;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class GMSRestAPI extends Application<GMSRestAPIConfiguration> {
    public static void main(String[] args) throws Exception {
        new GMSRestAPI().run(args);
    }
    @Override
    public void run(GMSRestAPIConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(UserGMSRESTService.class);
        environment.jersey().register(AdminGMSRESTService.class);
        environment.jersey().register(CustomerGMSRESTService.class);
        environment.jersey().register(GymOwnerGMSRESTService.class);
    }
}