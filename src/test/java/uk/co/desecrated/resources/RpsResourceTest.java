package uk.co.desecrated.resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import uk.co.desecrated.service.RpsService;
import uk.co.desecrated.util.ResourceUtil;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RpsResourceTest {

    @InjectMocks
    private RpsResource resource = new RpsResource();

    @Mock
    private RpsService service;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void endpoint_test() {
        // assemble

        // act

        // assert

    }

}
