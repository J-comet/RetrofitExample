package hs.project.retrofitexample.data.user


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean?,
    val bio: Any?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("followed_by_user")
    val followedByUser: Boolean?,
    @SerializedName("for_hire")
    val forHire: Boolean?,
    val id: String?,
    @SerializedName("instagram_username")
    val instagramUsername: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val links: Links?,
    val location: Any?,
    val name: String?,
    val photos: List<Photo>?,
    @SerializedName("portfolio_url")
    val portfolioUrl: Any?,
    @SerializedName("profile_image")
    val profileImage: ProfileImage?,
    val social: Social?,
    @SerializedName("total_collections")
    val totalCollections: Int?,
    @SerializedName("total_likes")
    val totalLikes: Int?,
    @SerializedName("total_photos")
    val totalPhotos: Int?,
    @SerializedName("twitter_username")
    val twitterUsername: Any?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    val username: String?
)