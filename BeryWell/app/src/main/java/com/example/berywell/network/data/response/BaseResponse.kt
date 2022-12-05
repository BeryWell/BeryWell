package com.example.berywell.network.data.response

import com.example.berywell.network.ServerResult

open class BaseResponse<T>(
     var success: Boolean = false,
     var code: Int = -1,
     var msg: String? = null,
     val data: T,
 ) : ServerResult {
    override fun isSuccess(): Boolean {
        return success && code == 0
    }

    override fun code(): String {
        return code.toString()
    }

    override fun errorMessage(): String? {
        return codeMessage(code)
    }
}

private fun codeMessage(code: Int): String {
    var message:String = ""
    message = "에러발생!"

    return message
}