import SwiftUI

struct SpeedometerView: View {
    var model = ViewModel(initialState: .stopped)
    
    var body: some View {
        VStack {
            let text = switch (model.runningState) {
            case .stopped: "Stopped"
            case .started: "Started"
            }
            Text(text)
            
            Spacer().frame(height: 16)
            
            Button("Start", action: model.start)
            .disabled(model.runningState == .started)
            
            Button("Stop", action: model.stop)
            .disabled(model.runningState == .stopped)
        }
    }
}

struct SpeedometerView_Previews: PreviewProvider {
    static var previews: some View {
        SpeedometerView()
    }
}
