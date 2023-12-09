import os
import Speedometer
import SwiftUI

let logger = Logger()

@main
struct iOSApp: App {
    let speedEvaluation = SpeedEvaluationStream(locationUpdateStream: LocationUpdateStream.shared)
    
	var body: some Scene {
		WindowGroup {
			SpeedometerView()
		}
	}
}
