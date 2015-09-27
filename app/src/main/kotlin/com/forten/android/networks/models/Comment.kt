package com.forten.android.networks.models

public class Comment {
    var id: String? = null
    var body: String? = null
    var owner: User? = null
    var post: Post? = null
    var createdAt: Long? = null
}