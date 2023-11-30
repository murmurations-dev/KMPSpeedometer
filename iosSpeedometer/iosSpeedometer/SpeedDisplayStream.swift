//
//  SpeedDisplayStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 30/11/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import KMPNativeCoroutinesAsync
import Speedometer

class SpeedDisplayStream : Speedometer.SpeedDisplayStream {
    init(
        initialRunningState: RunningState = .stopped,
        initialUnit: SpeedUnit = .kmh,
        displayFormat: String = "%.0f"
    ) {
        super.init(
            runningStream: RunningStream(initialState: initialRunningState),
            speedEvaluationStream: SpeedEvaluationStream(locationUpdateStream: LocationUpdateStream.shared),
            speedUnitStream: SpeedUnitStream(initialUnit: initialUnit),
            displayFormat: displayFormat
        )
    }
    
    func assignUnitDisplay<Root>(
        to receiver: Root,
        on keyPath: ReferenceWritableKeyPath<Root, String>
    ) {
        Task { @MainActor in
            for try await unitDisplay in asyncSequence(for: unitDisplayFlow) {
                receiver[keyPath: keyPath] = unitDisplay
            }
        }
    }
    
    func assignSpeedDisplay<Root>(
        to receiver: Root,
        on keyPath: ReferenceWritableKeyPath<Root, String>
    ) {
        Task { @MainActor in
            for try await speedDisplay in asyncSequence(for: speedDisplayFlow) {
                receiver[keyPath: keyPath] = speedDisplay
            }
        }
    }
}
