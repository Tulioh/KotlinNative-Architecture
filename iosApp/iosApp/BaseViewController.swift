import UIKit
import app

class BaseViewController<T : BasePresenter>: UIViewController, BaseView {
    
    lazy var presenter: T = {
        return getPresenterInstance()
    }()
    
    func getPresenterInstance() -> T {
        let exception = NSException(
            name: NSExceptionName(rawValue: "Not implemented!"),
            reason: "A concrete subclass did not provide its own implementation of getPresenterInstance()",
            userInfo: nil
        )
        exception.raise()
        abort()
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
    
        presenter.onCleared()
    }
    
    func onErrorThrown(throwable: KotlinThrowable) {
        
    }
}
