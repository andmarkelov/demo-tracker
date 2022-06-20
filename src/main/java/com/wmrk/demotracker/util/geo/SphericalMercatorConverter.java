package com.wmrk.demotracker.util.geo;

public class SphericalMercatorConverter {
    public static final double LAT_LON_PRECISION = 1000000.0d;
    private static final double RADIUS_MAJOR = 6378137.0; //Equatorial radius (m)
    private static final double RADIUS_MINOR = 6356752.3142; //Polar radius (m)

    double xAxisProjection(double longitude) {
        return Math.toRadians(longitude) * RADIUS_MAJOR;
    }

    double yAxisProjection(double latitude) {
        return Math.log(Math.tan(Math.PI / 4.0d + Math.toRadians(latitude) / 2.0d)) * RADIUS_MAJOR;
    }

    public double longitude(double x) {
        double lon = Math.toDegrees(x / RADIUS_MAJOR) ;
        return (double) Math.round(lon * LAT_LON_PRECISION) / LAT_LON_PRECISION;
    }

    public double latitude(double y) {
        double lat = Math.toDegrees((Math.atan(Math.exp(y / RADIUS_MAJOR))  - Math.PI / 4.0d) * 2.0d);
        return (double) Math.round(lat * LAT_LON_PRECISION) / LAT_LON_PRECISION;
    }
}