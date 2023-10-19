import SwiftUI

struct ContentView: View {
    var model = ViewModel(initialState: .stopped)
    
    var body: some View {
        VStack {
            Text("model.speed")
            
            Button("Start") {
                model.start()
            }
            .disabled(model.started == .started)
            
            Button("Stop") {
                model.stop()
            }
            .disabled(model.started == .stopped)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
