//
//  StartedState.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
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
    
    @Sendable init?(abstracted: Speedometer.RunningState) {
        switch (abstracted) {
        case is RunningStateStopped: self = .stopped
        case is RunningStateStarted: self = .started
        default: return nil
        }
    }

    var abstractedType: Speedometer.RunningState {
        switch self {
        case .stopped: RunningStateStopped()
        case .started: RunningStateStarted()
        }
    }
    
//    class Stopped : StartedState_IStopped_A, StartedStateSwiftType {
//        var swiftType: StartedState { .stopped }
//    }
//    
//    class Started : StartedState_IStarted_A, StartedStateSwiftType {
//        var swiftType: StartedState { .started }
//    }
}


