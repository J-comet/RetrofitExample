package hs.project.retrofitexample.util

/* 문자열이 json 형태인지 확인 */
fun String?.isJsonObject(): Boolean {
//    if(this?.startsWith("{") == true && this.endsWith("}")){
//        return true
//    } else {
//        return false
//    }

    return this?.startsWith("{") == true && this.endsWith("}")
}

/* 문자열이 json array 인지 확인 */
fun String?.isJsonArray(): Boolean {
    if(this?.startsWith("[") == true && this.endsWith("]")){
        return true
    } else {
        return false
    }
}