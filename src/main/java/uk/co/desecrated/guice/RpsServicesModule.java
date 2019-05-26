package uk.co.desecrated.guice;

import com.google.inject.AbstractModule;
import uk.co.desecrated.resources.RpsResource;
import uk.co.desecrated.service.RpsService;
import uk.co.desecrated.service.RpsServiceImpl;

public class RpsServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(RpsService.class).to(RpsServiceImpl.class);
    }

}
