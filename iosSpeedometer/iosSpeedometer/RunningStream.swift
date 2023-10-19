//
//  StartedStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import KMPNativeCoroutinesAsync
import Speedometer


class RunningStream : RunningStream_T {
    
    init(initialState: RunningState) {
        super.init(initialState: initialState.abstractedType)
    }
    
    func assign<Root>(
        receiver: Root,
        keyPath: ReferenceWritableKeyPath<Root, RunningState>
    ) {
        Task { @MainActor in
            for try await runningState in runningSequence {
                receiver[keyPath: keyPath] =  runningState
            }
        }
    }
    
    var runningSequence: AsyncCompactMapSequence<some AsyncSequence, RunningState> {
        asyncSequence(for: runningFlow).compactMap(RunningState.init)
    }
}
