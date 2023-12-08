//
//  StartedStream.swift
//  iosSpeedometer
//
//  Created by Etienne Vautherin on 17/10/2023.
//  Copyright © 2023 Murmurations Dev. All rights reserved.
//

import KMPNativeCoroutinesAsync
import Speedometer


//class RunningStream : Speedometer.RunningStream {
    
//    init(initialState: RunningState) {
//        super.init(initialState: initialState.kotlinObject)
//    }
    
//    func assign<Root>(
//        to receiver: Root,
//        on keyPath: ReferenceWritableKeyPath<Root, RunningState>
//    ) {
//        Task { @MainActor in
//            for try await runningState in runningStateSequence {
//                receiver[keyPath: keyPath] = runningState
//            }
//        }
//    }
//    
//    var runningStateSequence: AsyncCompactMapSequence<some AsyncSequence, RunningState> {
//        asyncSequence(for: runningFlow).compactMap(RunningState.init)
//    }
//}


extension RunningStream {
    convenience init(initialState: RunningState) {
        self.init(initialState: initialState.kotlinObject)
    }

    func assign<Root>(
        to receiver: Root,
        on keyPath: ReferenceWritableKeyPath<Root, RunningState>
    ) {
        Task { @MainActor in
            for try await runningState in runningStateSequence {
                receiver[keyPath: keyPath] = runningState
            }
        }
    }
    
    var runningStateSequence: AsyncCompactMapSequence<some AsyncSequence, RunningState> {
        asyncSequence(for: runningFlow).compactMap(RunningState.init)
    }
}
