package hs.project.retrofitexample.util

object Constant {
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class RESPONSE_STATE {
    SUCCESS,
    FAIL
}

object API {
    const val BASE_URL : String = "https://api.unsplash.com/"

    const val CLIENT_ID : String = "tfQqMPLwxcRfkTCqL1IS_yuLn9mA2-1c0gFYtZ-368c"
    const val SEARCH_PHOTO : String = "search/photos"
    const val SEARCH_USERS : String = "search/users"
}