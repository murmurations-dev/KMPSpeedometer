//
//  ViewModel.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 18/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation
import SwiftUI

@Observable
class ViewModel {
    private let runningStream: RunningStream
    var runningState: RunningState
        
    init(initialState: RunningState) {
        runningStream = RunningStream(initialState: initialState)
        runningState = initialState
        runningStream.assignStream(to: self, on: \.runningState)
    }
}

extension ViewModel {
    func start() { runningStream.start() }
    func stop() { runningStream.stop() }
}
