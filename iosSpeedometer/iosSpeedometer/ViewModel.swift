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
    var runningState: RunningState
    
    private var runningStream: RunningStream
    
    init(initialState: RunningState) {
        runningState = initialState
        runningStream = RunningStream(initialState: initialState)
        runningStream.assign(receiver: self, keyPath: \.runningState)
    }
    
    func start() { runningStream.start() }
    func stop() { runningStream.stop() }
}
