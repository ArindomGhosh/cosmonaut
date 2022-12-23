import SwiftUI
import shared
import Combine


struct ContentView: View {

    @ObservedObject private(set) var viewModel: ViewModel //= ContentView.ViewModel()
    
	var body: some View {
        Text(
            viewModel.text
        ).onAppear(perform:{
            viewModel.onStart()
        }).onDisappear(perform:{
            viewModel.onDestroy()
        })
        
	}
}

@MainActor
extension ContentView {
    class ViewModel: ObservableObject {
        
        @LazyKoin
        private var mainActivityPresenter: MainActivityPresenter
        
        @Published var text = "Loading..."
        
        private var cancellables = [AnyCancellable]()
        
        init() {
            doPublish(mainActivityPresenter.flowAdapter(flow: mainActivityPresenter.sideEffects)){[weak self] sideEffect in
                if sideEffect != nil {
                    // handle sideEffects
                }
            }.store(in: &cancellables)
        }
        
        func onStart(){
            getLaunches()
        }
        
        func onDestroy(){
            cancellables.forEach { $0.cancel() }
            cancellables.removeAll()
            mainActivityPresenter.clear()
        }
        
        private func getLaunches() {
            mainActivityPresenter.postIntent(intent: IntentGetAllLaunches())
            
            doPublish(mainActivityPresenter.flowAdapter(flow: mainActivityPresenter.states)){ [weak self] uiState in
                if(uiState.loading){
                    self?.text = "Loading ....."
                }
                if(!uiState.launches.isEmpty){
                    self?.text = uiState.launches.first!.missionName
                }
            }.store(in: &cancellables)
            
           
//            mainActivityPresenter.states.collect(collector: FlowCollector<MainUiState>(){ uiState in
//                if(!uiState.launches.isEmpty){
//                    self.text = uiState.launches.first!.missionName
//                }
//            }) { err in
//                if let error = err {
//                    self.text = error.localizedDescription
//                   }
//            }
           
        }
    }
}
