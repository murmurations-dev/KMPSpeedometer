//
//  LocationUpdateStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 31/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import CoreLocation
import Speedometer

class LocationUpdateStream : Speedometer.LocationUpdateStream {
    static let shared = LocationUpdateStream()
    
    override func startLocationUpdates(updateLocation: @escaping (CLLocation) -> Void) -> () -> Void {
        logger.info("Start Location Updates")
        
        let manager = CLLocationManager()

        if manager.authorizationStatus == .notDetermined {
            manager.requestWhenInUseAuthorization()
        }
        
        let activitySession = CLBackgroundActivitySession()
        let locationUpdateTask = Task {
            let updates = CLLocationUpdate.liveUpdates()
            for try await location in updates.compactMap(\.location) {
                logger.info("Got location update: \(location)")
                updateLocation(location)
            }
        }
        
        return {
            logger.info("Stop Location Updates")
            activitySession.invalidate()
            locationUpdateTask.cancel()
        }
    }
}
