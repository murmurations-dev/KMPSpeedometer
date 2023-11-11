import SwiftUI

struct SpeedometerView: View {
    var model = ViewModel(initialState: .stopped)
    
    var body: some View {
        VStack {
//            let text = switch (model.updateLocation) {
//            case .stopped: "Stopped"
//            case .started: "Started"
//            }
//            Text(text)
            Text(model.updateLocation.description)
            
//            Spacer().frame(height: 16)
//            
//            Button("Start", action: model.start)
//            .disabled(model.updateLocation == .started)
//            
//            Button("Stop", action: model.stop)
//            .disabled(model.updateLocation == .stopped)
        }
    }
}

struct SpeedometerView_Previews: PreviewProvider {
    static var previews: some View {
        SpeedometerView()
    }
}
