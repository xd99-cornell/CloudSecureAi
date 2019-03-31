package app.xdu.com.androidassessment.data

import java.util.ArrayList

class UserData {
    private var user: User? = null
    private val userVideos: MutableList<UserVideos>
    private val videoList2: MutableList<VideoDetail>

    val videoDetails: List<VideoDetail>
        get() = videoList2

    init {
        userVideos = ArrayList()
        videoList2 = ArrayList()
    }

    fun initData(user: User, userVideos: List<UserVideos>) {
        this.user = user
        this.userVideos.addAll(userVideos)
    }

    fun initDetails(details: List<VideoDetail>) {
        this.videoList2.addAll(details)
    }

    fun getUserVideos(): List<UserVideos> {
        return userVideos
    }

}
