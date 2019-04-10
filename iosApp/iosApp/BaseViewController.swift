import UIKit
import app

class BaseViewController<T : BaseViewModel>: UIViewController {
    
    var lifecycle = Multiplatform_livedata_iosKLifecycle()
    
    lazy var viewModel: T = {
        return getViewModelInstance()
    }()
    
    func getViewModelInstance() -> T {
        let exception = NSException(
            name: NSExceptionName(rawValue: "Not implemented!"),
            reason: "A concrete subclass did not provide its own implementation of getViewModelInstance()",
            userInfo: nil
        )
        exception.raise()
        abort()
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        lifecycle.stop()
        viewModel.onCleared()
    }
}
