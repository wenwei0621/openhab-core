package org.openhab.core.addon.eclipse.internal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openhab.core.addon.AddonInfoRegistry;
import org.osgi.framework.BundleContext;

class EclipseAddonServiceTest {

    @Mock
    private BundleContext mockBundleContext;
    @Mock
    private AddonInfoRegistry mockAddonInfoRegistry;

    @InjectMocks
    private EclipseAddonService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Tests that the service is created properly
    @Test
    void testServiceCreation() {
        assertNotNull(service, "Service should be created");
    }

    // Tests that deactivate throws the expected UnsupportedOperationException
    @Test
    void testDeactivateThrowsException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, service::deactivate);
        assertEquals("Deactivation of this service is not supported.", exception.getMessage());
    }

    // Tests that refreshSource throws the expected UnsupportedOperationException
    @Test
    void testRefreshSourceThrowsException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, service::refreshSource);
        assertEquals("refreshSource is not supported by EclipseAddonService.", exception.getMessage());
    }

    // Tests that install throws the expected UnsupportedOperationException
    @Test
    void testInstallThrowsException() {
        String addonId = "sample-addon";
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> service.install(addonId));
        assertEquals("Eclipse Add-on Service does not support installing add-ons", exception.getMessage());
    }

    // Tests that uninstall throws the expected UnsupportedOperationException
    @Test
    void testUninstallThrowsException() {
        String addonId = "sample-addon";
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> service.uninstall(addonId));
        assertEquals("Eclipse Add-on Service does not support uninstalling add-ons", exception.getMessage());
    }
}
