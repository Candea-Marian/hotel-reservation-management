package com.candea.hotelmanagement.util;

public class DistanceCalculator {
    // Calculate the distance between two points using the Euclidean distance formula
    // given that the distances used are small enough that the curvature of the Earth can be ignored

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double x = Math.pow(lat2 - lat1, 2);
        double y = Math.pow(lon2 - lon1, 2);
        return Math.sqrt(x + y);
    }
      
}
