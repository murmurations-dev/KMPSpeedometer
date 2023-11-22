//
//  LocationUpdateStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 31/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import CoreLocation
import Speedometer

//*** Progress
import KMPNativeCoroutinesAsync


class LocationUpdateStream : LocationUpdateStream_T {
    static let shared = LocationUpdateStream()
    
    override func startLocationUpdates(updateLocation: @escaping (CLLocation) -> Void) -> () -> Void {
        logger.info("Start Location Updates")
        LoggerKt.i(string: "Hello from Swift")

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
    
    //*** Progress
    func assign<Root>(
        to receiver: Root,
        on keyPath: ReferenceWritableKeyPath<Root, CLLocation>
    ) {
        Task { @MainActor in
            for try await locationUpdate in asyncSequence(for: locationUpdateFlow) {
                receiver[keyPath: keyPath] =  locationUpdate
            }
        }
    }
    
//    var locationUpdateSequence: AsyncCompactMapSequence<some AsyncSequence, RunningState> {
//        asyncSequence(for: locationUpdateFlow).compactMap(RunningState.init)
//    }
}
