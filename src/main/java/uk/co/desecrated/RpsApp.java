package uk.co.desecrated;

import org.apache.catalina.LifecycleException;
import uk.co.desecrated.util.TomcatWebContainer;

public class RpsApp {

    public static void main(String[] args) {

        try {
            TomcatWebContainer tomcat = new TomcatWebContainer(80, "");
            tomcat.start();
            tomcat.await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
