package uk.co.desecrated.util;

import java.io.InputStream;

public class ResourceUtil {

    public static InputStream getResource(String path) {
        ClassLoader classLoader = ResourceUtil.class.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }

}
