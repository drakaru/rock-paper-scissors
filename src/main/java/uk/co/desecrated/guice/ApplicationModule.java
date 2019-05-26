package uk.co.desecrated.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import uk.co.desecrated.guice.providers.PropertiesProvider;

import java.util.Properties;

import static com.google.inject.name.Names.bindProperties;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        // this allows us to inject Properties in our code
        binder().bind(Properties.class).toProvider(PropertiesProvider.class).in(Singleton.class);
        // this allows us to use @Named
        bindProperties(binder(), PropertiesProvider.getProperties());

        install(new RpsResourcesModule());
        install(new RpsServicesModule());
    }

}
