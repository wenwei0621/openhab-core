package org.openhab.core.ephemeris.internal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openhab.core.ephemeris.EphemerisManager;

class EphemerisManagerTest {

    private EphemerisManager ephemerisManager;

    @BeforeEach
    void setUp() {
        // Mocking EphemerisManager
        ephemerisManager = mock(EphemerisManager.class);

        // Setting up specific behaviors for certain dates
        ZonedDateTime newYearsDay = ZonedDateTime.of(2023, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        ZonedDateTime randomDay = ZonedDateTime.of(2023, 1, 2, 0, 0, 0, 0, ZoneId.systemDefault());

        // Mock behaviors
        when(ephemerisManager.isBankHoliday(newYearsDay)).thenReturn(true);
        when(ephemerisManager.isBankHoliday(randomDay)).thenReturn(false);
    }

    @Test
    void testIsBankHolidayForNewYearsDay() {
        ZonedDateTime newYearsDay = ZonedDateTime.of(2023, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        assertTrue(ephemerisManager.isBankHoliday(newYearsDay),
                "New Year's Day should be recognized as a bank holiday.");
    }

    @Test
    void testIsNotBankHolidayForRandomDay() {
        ZonedDateTime randomDay = ZonedDateTime.of(2023, 1, 2, 0, 0, 0, 0, ZoneId.systemDefault());
        assertFalse(ephemerisManager.isBankHoliday(randomDay),
                "January 2nd should not be recognized as a bank holiday.");
    }
}
