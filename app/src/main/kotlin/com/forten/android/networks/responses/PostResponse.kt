package com.forten.android.networks.responses

/**
 * Created by mspark on 2015. 9. 25..
 */
public class PostResponse : BasicResponse() {
    class Post {
        var id: String? = null
        var body: String? = null
        var owner: UserResponse.User? = null
        var createdAt: Long? = null
    }

    var post: Post? = null
}