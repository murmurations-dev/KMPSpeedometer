import SwiftUI

struct ContentView: View {
    var model = ViewModel(initialState: .stopped)
    
    var body: some View {
        VStack {
            Text("model.speed")
            
            Spacer().frame(height: 16)
            
            Button("Start") {
                model.start()
            }
            .disabled(model.runningState == .started)
            
            Button("Stop") {
                model.stop()
            }
            .disabled(model.runningState == .stopped)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
