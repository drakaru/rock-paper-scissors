package uk.co.desecrated.guice.providers;

import com.google.inject.Provider;

import java.util.Properties;

import static uk.co.desecrated.util.ResourceUtil.getResource;

public class PropertiesProvider implements Provider<Properties> {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(getResource("rps.properties"));
            System.out.println("get()");
            System.out.println("properties = " + properties);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Properties get() {
        return properties;
    }

    public static Properties getProperties() {
        System.out.println("getProperties()");
        System.out.println("properties = " + properties);
        return properties;
    }
 }
