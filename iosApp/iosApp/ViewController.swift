import UIKit
import app

class ViewController: UIViewController {
    
    var lifecycle = Multiplatform_livedata_iosKLifecycle()
    
    var homeViewModel = HomeProviderKt.homeViewModel
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        homeViewModel.getMovies().observe(lifecycle: lifecycle) { (value) -> KotlinUnit in
            if (value as? Array<HomePresentation>) != nil {
                // TODO: set movies
            }
            
            return KotlinUnit()
        }
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        lifecycle.stop()
    }
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var imageView: UIImageView!
}
