package com.example.ed09_ate_11.models

import com.google.gson.annotations.SerializedName
import java.util.Date


/*data class Filmes(

    @SerializedName("id") var id: Int = 0,

    @SerializedName("name") var name: String = "",

    @SerializedName("url") var url: String = "",

    @SerializedName("images") var images: Images? = null,
){
   data class Images(
        @SerializedName("small") var small: String = "",
        @SerializedName("large") var large: String = "",
    )
}*/


data class Comment (
    @SerializedName ("user_data") var user_data: UserData? = null,
    @SerializedName ("id") var id: Int = 0,
    @SerializedName ("comment") var comment: String? = null,
    @SerializedName ("created_at") var created_at: Date? = null,
    @SerializedName ("updated_at") var updated_at: Date? = null,
    @SerializedName ("report_count") var report_count: Any? = null,
)

class Commenter {
    var id = 0
    var name: String? = null
    var screen_name: String? = null
    var profile_image: String? = null
}


data class Images (
    @SerializedName("small") var small: String = "",
    @SerializedName("large") var large: String = "",
    )

data class Filmes (
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("url") var url: String = "",
    @SerializedName("images") var images: Images? = null,
    @SerializedName("creator") var criador: Criador? = null,
    @SerializedName("comment") var comment: Comment? = null,
)

data class Criador (
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("screen_name") var screen_name: String = "",
    @SerializedName("profile_image") var profile_image: String = "",
)

class LatestComment {
    var user_data: UserData? = null
    var id = 0
    var comment: String? = null
    var created_at: Date? = null
    var updated_at: Date? = null
    var report_count: Any? = null
    var blocked = false
    var user: User? = null
    var commenter: Commenter? = null
}

class Meta {
    var current_page = 0
    var next_page = 0
    var previous_page: Any? = null
    var per_page = 0
    var total_pages = 0
    var total_count = 0
    var page_type: String? = null
    var sorted_by: String? = null
    var filtered_by: Any? = null
    var searched_by: Any? = null
}

class Root {
    var items: ArrayList<Filmes>? = null
    var meta: Meta? = null
}

class Share {
    var shareTitle: String? = null
    var shareSource: String? = null
    var shareDescription: String? = null
    var shareImage: String? = null
    var shareURL: String? = null
}

class Stats {
    var commentCount = 0
    var listCount = 0
    var followerCount = 0
    var followingCount = 0
    var helperCount = 0
    var embedCount = 0
    var viewCount = 0
    var listSeenCount = 0
}

class Status {
    var isCurator = false
    var hasPro = false
}

class User {
    var id = 0
    var name: String? = null
    var screen_name: String? = null
    var profile_image: String? = null
}

class UserData {
    var createdByMe = false
    var editableByMe = false
    var curatableByMe = false
    var userIsMe = false
    var followedByMe = false
}




