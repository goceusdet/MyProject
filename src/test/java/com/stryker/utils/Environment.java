package com.stryker.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String URL;
    public static final String BASE_URL;
    public static final String CAREERS_PAGE_URL;
    public static final String INVESTORS_PAGE_URL;
    public static final String INTERNATIONAL_PAGE_URL;

    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.getProperty("environment");
        //this field will get its value from configuration.properties file environment key /qa1 qa2 qa3
        //String environment = ConfigurationReader.getProperty("environment");

        try {
            //Out file is found via this path:
            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("stryker.url");
        BASE_URL = properties.getProperty("API.base.URI");
        CAREERS_PAGE_URL = properties.getProperty("strykerCareersPageUrl");
        INVESTORS_PAGE_URL = properties.getProperty("strykerInvestorsPageUrl");
        INTERNATIONAL_PAGE_URL = properties.getProperty("strykerInternationalPageUrl");
    }

}
