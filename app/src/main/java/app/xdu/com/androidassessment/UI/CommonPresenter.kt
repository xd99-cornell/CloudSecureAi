package app.xdu.com.androidassessment.UI

import android.content.Context
import android.support.v7.widget.RecyclerView
import app.xdu.com.androidassessment.Constant.GlobalData
import app.xdu.com.androidassessment.HttpRequest
import app.xdu.com.androidassessment.ViewData.RVAdapter


class CommonPresenter(internal var context: Context, internal var adapter: RecyclerView.Adapter<*>) {
    internal var presenterHelper: PresenterHelper = PresenterHelper()


    fun retrieveUserData() {
        var httpRequest = HttpRequest(adapter, this)
        httpRequest.execute(GlobalData.URL_1)

    }

    fun updateView(result: String) {
        if (adapter is RVAdapter) {
            presenterHelper.parseUserData(result)
        } else {
            presenterHelper.parseVideoData(result)
        }
    }

    fun retrieveVideoDetails(id: Int) {
        var httpRequest = HttpRequest(adapter, this)
        httpRequest.execute(GlobalData.URL_2 + id)
    }


}
