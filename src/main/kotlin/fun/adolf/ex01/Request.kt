package `fun`.adolf.ex01

import java.io.InputStream

class Request(val input:InputStream) {

    //通过调用 uri 属性的 get 访问器，会返回 HTTP 请求的 URI。
    var uri:String? = null
        private set

    /**
     * parse()方法用于解析 HTTP 请求中的原始数据。parse()方法会调用私有方法 parseUri() 来解析HTTP的 Uri，除此之外，并没有做太多的工作。
     */
    @ExperimentalStdlibApi
    fun parse() {
        try {
            val buffer = ByteArray(input.available())
            input.read(buffer)
            val requestStr = String(buffer)
            println(requestStr)
            uri = parseUri(requestStr)
        } catch (e: Exception) {
            println(e)
        }
    }

    /**
     * parseUri()方法将 URI 存储在变量 uri 中。
     * 请求行以请求方法开始，接着是请求的 URI 和请求所使用的的协议以及版本，并以 CRLF 符结束。
     * GET /index.html HTTP/1.1
     */
    private fun parseUri(requestString: String):String? {
        //解析两个空格之间的字符串，如果存在那就是 uri，如果不存在则返回 null
        val uri = requestString.substringAfter(' ', "null").substringBefore(' ', "null")
        return if (uri == "null") null else uri
    }

}