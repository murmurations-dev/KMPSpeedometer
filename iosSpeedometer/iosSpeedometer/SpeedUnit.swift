//
//  SpeedUnit.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Speedometer


enum SpeedUnit {
    case metricSystem
    case kmh
    case mph
}

extension SpeedUnit {
    @Sendable init?(kotlinObject: Speedometer.SpeedUnit) {
        switch (kotlinObject) {
        case is SpeedUnitMetricSystem: self = .metricSystem
        case is SpeedUnitKmh: self = .kmh
        case is SpeedUnitMph: self = .mph
        default: return nil
        }
    }

    var kotlinObject: Speedometer.SpeedUnit {
        switch self {
        case .metricSystem: SpeedUnitMetricSystem()
        case .kmh: SpeedUnitKmh()
        case .mph: SpeedUnitMph()
        }
    }
    
    var userDisplay: String { kotlinObject.userDisplay }
}

//extension SpeedUnitMetricSystem : Speedometer.SpeedUnit {}
//extension SpeedUnitKmh : Speedometer.SpeedUnit {}
//extension SpeedUnitMph : Speedometer.SpeedUnit {}
