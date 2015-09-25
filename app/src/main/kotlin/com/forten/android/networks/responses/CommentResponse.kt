package com.forten.android.networks.responses

/**
 * Created by mspark on 2015. 9. 25..
 */
public class CommentResponse : BasicResponse() {
    class Comment {
        var id: String? = null
        var body: String? = null
        var owner: UserResponse.User? = null
        var post: PostResponse.Post? = null
        var createdAt: Long? = null
    }

    var comment: Comment? = null
}