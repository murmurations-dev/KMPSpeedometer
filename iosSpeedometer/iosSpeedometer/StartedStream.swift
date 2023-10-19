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


class StartedStream : StartedStream_T {
    
    init(initialState: StartedState) {
        super.init(initialState: initialState.abstractedType)
    }
    
    func plugTo<Root>(
        receiver: Root,
        keyPath: ReferenceWritableKeyPath<Root, StartedState>
    ) {
        Task { @MainActor in
            for try await started in startedSequence {
                receiver[keyPath: keyPath] =  started
            }
        }
    }
    
    var startedSequence: AsyncCompactMapSequence<some AsyncSequence, StartedState> {
        asyncSequence(for: startedFlow).compactMap(StartedState.init)
    }
}
