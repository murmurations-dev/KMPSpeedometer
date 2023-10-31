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
    
    @Sendable init?(kotlinObject: any SpeedUnit_T) {
        switch (kotlinObject) {
        case is SpeedUnit_TMetricSystem: self = .metricSystem
        case is SpeedUnit_TKmh: self = .kmh
        case is SpeedUnit_TMph: self = .mph
        default: return nil
        }
    }

    var kotlinObject: some SpeedUnit_T {
        switch self {
        case .metricSystem: SpeedUnit_TMetricSystem() as! SpeedUnit_T
        case .kmh: SpeedUnit_TKmh() as! SpeedUnit_T
        case .mph: SpeedUnit_TMph() as! SpeedUnit_T
        }
    }
    
    var userDisplay: String { kotlinObject.userDisplay }
}
