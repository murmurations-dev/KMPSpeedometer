//
//  ViewModel.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 18/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import Foundation
import SwiftUI

@Observable
class ViewModel :  RunningStream {
    var runningState: RunningState
        
    override init(initialState: RunningState) {
        runningState = initialState
        super.init(initialState: initialState)
        assignStream(to: self, on: \.runningState)
    }
}
