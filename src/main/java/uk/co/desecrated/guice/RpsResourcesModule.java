package uk.co.desecrated.guice;

import com.google.inject.AbstractModule;
import uk.co.desecrated.resources.RpsResource;

public class RpsResourcesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RpsResource.class);
    }

}
