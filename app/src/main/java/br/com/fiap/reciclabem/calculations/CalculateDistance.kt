package br.com.fiap.reciclabem.calculations

import kotlin.math.*

fun calculateDistance(userLat: Double, userLng: Double, placeLat: Double, placeLng: Double): Double {
    val earthRadius = 6371000.0
    val dLat = Math.toRadians(placeLat - userLat)
    val dLon = Math.toRadians(placeLng - userLng)
    val a = sin(dLat / 2) * sin(dLat / 2) +
            cos(Math.toRadians(userLat)) * cos(Math.toRadians(placeLat)) *
            sin(dLon / 2) * sin(dLon / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadius * c
}

fun formatDistance(distanceInMeters: Double): String {
    return if (distanceInMeters < 1000) {
        "${distanceInMeters}m"
    } else {
        val distanceInKm = distanceInMeters / 1000
        "${String.format("%.2f", distanceInKm)}km"
    }
}