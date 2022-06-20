package com.wmrk.demotracker.geo;

import com.wmrk.demotracker.util.geo.SphericalMercatorConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SphericalMercatorConverterTest {
    @Test
    void testConversionLongitudeAndViceVersa() {
        final double LONGITUDE = -51.217655;

        SphericalMercatorConverter converter = new SphericalMercatorConverter();
        Assertions.assertEquals(LONGITUDE, converter.longitude(converter.xAxisProjection(LONGITUDE)));
    }

    @Test
    void testConversionLatitudeAndViceVersa() {
        final double LATITUDE = -30.034645;

        SphericalMercatorConverter converter = new SphericalMercatorConverter();
        Assertions.assertEquals(LATITUDE, converter.latitude(converter.yAxisProjection(LATITUDE)));
    }
}
