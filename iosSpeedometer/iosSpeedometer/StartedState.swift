//
//  StartedState.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

import Speedometer


enum StartedState {
    case stopped
    case started
}

//protocol StartedStateSwiftType : StartedState_I {
//    var swiftType: StartedState { get }
//}

extension StartedState {
    
    @Sendable init?(abstracted: Speedometer.StartedState) {
        switch (abstracted) {
        case is StartedStateStopped: self = .stopped
        case is StartedStateStarted: self = .started
        default: return nil
        }
    }

    var abstractedType: Speedometer.StartedState {
        switch self {
        case .stopped: StartedStateStopped()
        case .started: StartedStateStarted()
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


