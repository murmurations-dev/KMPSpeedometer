//
//  SpeedUnitStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 31/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Speedometer

class SpeedUnitStream : Speedometer.SpeedUnitStream {
    init(initialUnit: SpeedUnit) {
        super.init(initialState: initialUnit.kotlinObject)
    }
    func setUnit(unit: SpeedUnit) { super.setState(unit.kotlinObject) }
}
