//
//  SpeedUnitStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 31/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation
import Speedometer

class SpeedUnitStream : SpeedUnitStream_T {
    func setUnit(unit: SpeedUnit) {
        super.setUnit(unit: unit.kotlinObject)
    }
}
