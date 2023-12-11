//
//  StartedState.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Speedometer


enum RunningState {
    case stopped
    case started
    
    enum Kotlin {
        class Stopped : RunningSeedStopped {}
        class Started : RunningSeedStarted {}
    }
}

extension RunningState.Kotlin.Stopped : Speedometer.RunningSeed {}
extension RunningState.Kotlin.Started : Speedometer.RunningSeed {}


extension RunningState {
    @Sendable init?(kotlinObject: Speedometer.RunningState) {
        switch (kotlinObject) {
        case is RunningStateStopped: self = .stopped
        case is RunningStateStarted: self = .started
        default: return nil
        }
    }

    @Sendable init?(kotlinObject: Speedometer.RunningSeed) {
        switch (kotlinObject) {
        case is RunningSeedStopped: self = .stopped
        case is RunningSeedStarted: self = .started
        default: return nil
        }
    }

    var kotlinObject: Speedometer.RunningState {
        switch self {
        case .stopped: RunningStateStopped()
        case .started: RunningStateStarted()
        }
    }

    var kotlin: Speedometer.RunningSeed {
        switch self {
        case .stopped: Kotlin.Stopped()
        case .started: Kotlin.Started()
        }
    }
}


