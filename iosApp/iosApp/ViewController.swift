import UIKit
import app

class ViewController: BaseViewController<HomeViewModel> {
    
    override func getViewModelInstance() -> HomeViewModel {
        return HomeProviderKt.homeViewModel
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        viewModel.getMovies().observe(lifecycle: lifecycle) { (value) -> KotlinUnit in
            NSLog("Teste")
            if (value as? Array<HomePresentation>) != nil {
                // TODO: set movies
            }
            
            return KotlinUnit()
        }
    }
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var imageView: UIImageView!
}
