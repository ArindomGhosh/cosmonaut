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
        private var getLaunchesUseCase : GetLaunchesUseCase
        
        @LazyKoin
        private var mainActivityPresenter: MainActivityPresenter
        
        @Published var text = "Loading..."
        init() {
            //DomainWrapper<List<RocketLaunchEntity>>
            mainActivityPresenter.postIntent(intent: IntentGetAllLaunches())
        
//            mainActivityPresenter.states.collect(collector: Kotlinx_coroutines_coreFlowCollector, completionHandler:    )
            
//            { uiState, error in
//                if(let _uiState = uiState as? MainUiState){
//                    self.text = _uiState?.launches?.first?.missionName  ?? ""
//                }
//            }
//            getLaunchesUseCase.invoke { domainWrapper, error in
//                print(domainWrapper.debugDescription)
//                if let domainEntity = domainWrapper as? DomainWrapperEntity<RocketLaunchEntity> {
//                    let rocketLaunches = domainEntity.data as? [RocketLaunchEntity]
//
//                    self.text = rocketLaunches?.first?.missionName  ?? ""
//                }
//            }
//            SpacexService().getLaunches { rockets,error in
//                DispatchQueue.main.async {
//                    if let rockets = rockets {
//
//                        self.text =  rockets.first?.missionName ?? "no data found"
//                    } else {
//                      self.text = error?.localizedDescription ?? "error"
//                    }
//                }
//            }
        }
    }
}

//
//class ParentType<T> where T:Any{
//    var data :T?
//}
//
//var p = ParentType<[String]>()
//p.data = ["Arindom", "Raj"]
//
//print(p.data)

