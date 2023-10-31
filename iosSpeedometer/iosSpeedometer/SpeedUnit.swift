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
    @Sendable init?(kotlinObject: any Speedometer.SpeedUnit) {
        switch (kotlinObject) {
        case is SpeedUnitMetricSystem: self = .metricSystem
        case is SpeedUnitKmh: self = .kmh
        case is SpeedUnitMph: self = .mph
        default: return nil
        }
    }

    var kotlinObject: some Speedometer.SpeedUnit {
        switch self {
        case .metricSystem: SpeedUnitMetricSystem() as! Speedometer.SpeedUnit
        case .kmh: SpeedUnitKmh() as! Speedometer.SpeedUnit
        case .mph: SpeedUnitMph() as! Speedometer.SpeedUnit
        }
    }
    
    var userDisplay: String { kotlinObject.userDisplay }
}
