package com.candea.hotelmanagement.util;

public class CoordinateConverter {
    private static final double EARTH_RADIUS = 6371000; // meters

    public static double convertLatitudeToMeters(double latitude) {
        return Math.toRadians(latitude) * EARTH_RADIUS;
    }

    public static double convertLongitudeToMeters(double longitude, double latitude) {
        return Math.toRadians(longitude) * EARTH_RADIUS * Math.cos(Math.toRadians(latitude));
    }

}
