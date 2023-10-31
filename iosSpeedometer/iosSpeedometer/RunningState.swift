//
//  StartedState.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation

import Speedometer


enum RunningState {
    case stopped
    case started
}

//protocol StartedStateSwiftType : StartedState_I {
//    var swiftType: StartedState { get }
//}

extension RunningState {
    
    @Sendable init?(kotlinObject: Speedometer.RunningState) {
        switch (kotlinObject) {
        case is RunningStateStopped: self = .stopped
        case is RunningStateStarted: self = .started
        default: return nil
        }
    }

    var kotlinObject: Speedometer.RunningState {
        switch self {
        case .stopped: RunningStateStopped()
        case .started: RunningStateStarted()
        }
    }
}


