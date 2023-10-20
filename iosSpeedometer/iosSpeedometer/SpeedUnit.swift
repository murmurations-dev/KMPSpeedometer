//
//  SpeedUnit.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation

import Speedometer


enum SpeedUnit {
    case metricSystem
    case kmh
    case mph
}

extension SpeedUnit {
    
    @Sendable init?(abstracted: SpeedUnit_I) {
        switch (abstracted) {
        case is SpeedUnit_TMetricSystem: self = .metricSystem
        case is SpeedUnit_TKmh: self = .kmh
        case is SpeedUnit_TMph: self = .mph
        default: return nil
        }
    }

    var abstractedType: SpeedUnit_I {
        switch self {
        case .metricSystem: SpeedUnit_TMetricSystem()
        case .kmh: SpeedUnit_TKmh()
        case .mph: SpeedUnit_TMph()
        }
    }
    
    var userDisplay: String { abstractedType.userDisplay }
}
