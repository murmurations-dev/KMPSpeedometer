//
//  ViewModel.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 18/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation
import SwiftUI
import Speedometer

@Observable class ViewModel {
    private let speedDisplayStream: SpeedDisplayStream
    
    var unitDisplay: String
    var speedDisplay = "--" // No speed display
    var runningState: RunningState
        
    let start: () -> ()
    let stop: () -> ()
    let setUnit: (SpeedUnit) -> ()
    
    init(
        initialRunningState: RunningState = .stopped,
        initialUnit: SpeedUnit = .kmh
    ) {
        speedDisplayStream = SpeedDisplayStream(
            initialRunningState: initialRunningState,
            initialUnit: initialUnit,
            displayFormat: "%.0f"
        )
        
        start = speedDisplayStream.start
        stop = speedDisplayStream.stop
        setUnit = speedDisplayStream.setUnit

        unitDisplay = initialUnit.userDisplay
        runningState = initialRunningState
        
        speedDisplayStream.assignUnitDisplay(to: self, on: \.unitDisplay)
        speedDisplayStream.assignSpeedDisplay(to: self, on: \.speedDisplay)
        speedDisplayStream.assignRunningState(to: self, on: \.runningState)
    }
}

//@Observable
//class ViewModel {
//    private let updateLocationStream: LocationUpdateStream
//    var updateLocation: CLLocation
//        
//    init(initialState: RunningState) {
//        updateLocationStream = LocationUpdateStream.shared
//        updateLocation = CLLocation()
//        updateLocationStream.assign(to: self, on: \.updateLocation)
//    }
//}

//@Observable
//class ViewModel {
//    private let runningStream: RunningStream
//    var runningState: RunningState
//        
//    init(initialState: RunningState) {
//        runningStream = RunningStream(initialState: initialState)
//        runningState = initialState
//        runningStream.assign(to: self, on: \.runningState)
//    }
//}
//
//extension ViewModel {
//    func start() { runningStream.start() }
//    func stop() { runningStream.stop() }
//}
