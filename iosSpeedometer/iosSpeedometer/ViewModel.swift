//
//  ViewModel.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 18/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

@Observable
class ViewModel {
    var started: StartedState!
    
    private var startedStream: StartedStream
    
    init(initialState: StartedState) {
        started = initialState
        startedStream = StartedStream(initialState: initialState)
        startedStream.plugTo(receiver: self, keyPath: \.started)
    }
    
    func start() { startedStream.start() }
    func stop() { startedStream.stop() }
}
