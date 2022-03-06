package hs.project.retrofitexample.data.photo


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean?,
    val bio: Any?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("for_hire")
    val forHire: Boolean?,
    val id: String?,
    @SerializedName("instagram_username")
    val instagramUsername: String?,
    @SerializedName("last_name")
    val lastName: Any?,
    val links: LinksXXX?,
    val location: Any?,
    val name: String?,
    @SerializedName("portfolio_url")
    val portfolioUrl: Any?,
    @SerializedName("profile_image")
    val profileImage: ProfileImageX?,
    val social: SocialX?,
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