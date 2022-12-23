import SwiftUI
import shared

struct ContentView: View {

    @ObservedObject private(set) var viewModel: ViewModel = ContentView.ViewModel()
    
	var body: some View {
        Text(viewModel.text)
	}
}

@MainActor
extension ContentView {
    class ViewModel: ObservableObject {
        
        @LazyKoin
        private var mainActivityPresenter: MainActivityPresenter
        
        @Published var text = "Loading..."
        
        init() {
            getLaunches()
        }
        
        func getLaunches() {
            mainActivityPresenter.postIntent(intent: IntentGetAllLaunches())
            mainActivityPresenter.states.collect(collector: FlowCollector<MainUiState>(){ uiState in
                if(!uiState.launches.isEmpty){
                    self.text = uiState.launches.first!.missionName
                }
            }) { err in
                if let error = err {
                    self.text = error.localizedDescription
                   }
            }
           
        }
    }
}
