import UIKit
import app

class ViewController: BaseViewController<HomePresenter>, HomeView {
    
    override func getPresenterInstance() -> HomePresenter {
        return PresenterProviderKt.provideHomePresenter(homeView: self)
    }
    
    @IBAction func didClickGetImages(_ sender: Any) {
        presenter.onClickGetMovies()
    }
    
    func onHomePresentationListUpdated(homePresentationList: Array<HomePresentation>) {
        print(homePresentationList)
    }
    
    override func onErrorThrown(throwable: KotlinThrowable) {
        // TODO: ("not implemented")
    }
}
