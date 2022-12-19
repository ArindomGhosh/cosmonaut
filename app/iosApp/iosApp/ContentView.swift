import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    @ObservedObject private(set) var viewModel: ViewModel
    
	var body: some View {
        Text(viewModel.text)
	}
}

extension ContentView {
    class ViewModel: ObservableObject {
        
        @LazyKoin
        private var getLaunchesUseCase : GetLaunchesUseCase
        
        @Published var text = "Loading..."
        init() {
            getLaunchesUseCase.invoke { domainWrapper, error in
              
            }
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

