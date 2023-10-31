import os
import SwiftUI

let logger = Logger()

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			SpeedometerView()
		}
	}
}
