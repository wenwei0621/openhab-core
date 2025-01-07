package org.openhab.core.ui.icon.internal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openhab.core.io.rest.LocaleService;
import org.openhab.core.ui.icon.IconProvider;
import org.openhab.core.ui.icon.IconSet;

class IconSetResourceTest {

    private IconSetResource iconSetResource;
    private LocaleService mockLocaleService;
    private IconProvider mockIconProvider1;
    private IconProvider mockIconProvider2;

    @BeforeEach
    void setUp() {
        mockLocaleService = mock(LocaleService.class);
        mockIconProvider1 = mock(IconProvider.class);
        mockIconProvider2 = mock(IconProvider.class);

        iconSetResource = new IconSetResource(mockLocaleService);
        iconSetResource.addIconProvider(mockIconProvider1);
        iconSetResource.addIconProvider(mockIconProvider2);
    }

    @Test
    void testGetAllReturnsAllIconSets() {
        // Arrange
        Locale locale = Locale.ENGLISH;
        when(mockLocaleService.getLocale(null)).thenReturn(locale);

        IconSet iconSet1 = new IconSet("set1", "Set 1", "Description 1", Collections.emptySet());
        IconSet iconSet2 = new IconSet("set2", "Set 2", "Description 2", Collections.emptySet());

        when(mockIconProvider1.getIconSets(locale)).thenReturn(Set.of(iconSet1));
        when(mockIconProvider2.getIconSets(locale)).thenReturn(Set.of(iconSet2));

        // Act
        Response response = iconSetResource.getAll(null);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
        List<?> iconSets = (List<?>) response.getEntity();
        assertNotNull(iconSets);
        assertEquals(2, iconSets.size());
        assertTrue(iconSets.contains(iconSet1));
        assertTrue(iconSets.contains(iconSet2));
    }

    @Test
    void testGetAllReturnsEmptyListWhenNoIconSetsAvailable() {
        // Arrange
        Locale locale = Locale.ENGLISH;
        when(mockLocaleService.getLocale(null)).thenReturn(locale);

        when(mockIconProvider1.getIconSets(locale)).thenReturn(Collections.emptySet());
        when(mockIconProvider2.getIconSets(locale)).thenReturn(Collections.emptySet());

        // Act
        Response response = iconSetResource.getAll(null);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
        List<?> iconSets = (List<?>) response.getEntity();
        assertNotNull(iconSets);
        assertTrue(iconSets.isEmpty());
    }
}
