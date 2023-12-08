//
//  SpeedEvaluationStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 05/12/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Speedometer

extension SpeedEvaluationStream {
    static let shared = SpeedEvaluationStream(locationUpdateStream: LocationUpdateStream.shared)
}
