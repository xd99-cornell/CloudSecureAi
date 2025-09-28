package app.xdu.com.androidassessment.data

import app.xdu.com.androidassessment.ViewData.UserInfo

class UserVideos(private val id: Int, private val name: String, private val link: String, private val imageUrl: String, private val numberOfViews: Int,
                 private val channel: Channel, var userInfo: UserInfo?)
