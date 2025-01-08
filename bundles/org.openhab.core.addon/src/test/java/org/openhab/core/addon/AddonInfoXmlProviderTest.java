package org.openhab.core.addon;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openhab.core.addon.internal.xml.AddonInfoXmlProvider;
import org.openhab.core.addon.internal.xml.XmlAddonInfoProvider;
import org.openhab.core.config.core.xml.AbstractXmlConfigDescriptionProvider;
import org.osgi.framework.Bundle;

@TestInstance(Lifecycle.PER_CLASS)
class AddonInfoXmlProviderTest {

    private AddonInfoXmlProvider addonInfoXmlProvider;
    private Bundle bundle;
    private XmlAddonInfoProvider addonInfoProvider;
    private AbstractXmlConfigDescriptionProvider configDescriptionProvider;

    @BeforeAll
    void beforeAll() {
        // Create mocks for the dependencies
        bundle = mock(Bundle.class);
        addonInfoProvider = mock(XmlAddonInfoProvider.class);
        configDescriptionProvider = mock(AbstractXmlConfigDescriptionProvider.class);
    }

    /**
     * Test the constructor with valid parameters (no nulls).
     */
    @Test
    void testConstructor_withValidParameters() {
        // Act: Create the AddonInfoXmlProvider with mocked dependencies
        addonInfoXmlProvider = new AddonInfoXmlProvider(bundle, addonInfoProvider, configDescriptionProvider);

        // Assert: Ensure the provider is not null after construction
        assertNotNull(addonInfoXmlProvider);
    }

    /**
     * Test the constructor with null parameters. Compile error will throw
     */
    // @Test
    // void testConstructor_withValidParameters2() {
    // // Act: Create the AddonInfoXmlProvider with mocked dependencies
    // addonInfoXmlProvider = new AddonInfoXmlProvider(null, addonInfoProvider, configDescriptionProvider);
    //
    // // Assert: Ensure the provider is not null after construction
    // assertNotNull(addonInfoXmlProvider);
    // }
}
