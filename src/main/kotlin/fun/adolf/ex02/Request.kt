package `fun`.adolf.ex02

import java.io.BufferedReader
import java.io.InputStream
import java.util.*
import javax.servlet.RequestDispatcher
import javax.servlet.ServletInputStream
import javax.servlet.ServletRequest

class Request(private val input: InputStream) : ServletRequest {

    lateinit var uri: String
        private set


    fun parse() {
        try {
            val buffer = ByteArray(input.available())
            input.read(buffer)
            val requestStr = String(buffer)
            println(requestStr)
            uri = parseUri(requestStr).orEmpty()
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

    override fun getProtocol(): String {
        TODO("Not yet implemented")
    }

    override fun getLocale(): Locale {
        TODO("Not yet implemented")
    }

    override fun getParameterMap(): MutableMap<Any?, Any?> {
        TODO("Not yet implemented")
    }

    override fun getLocalPort(): Int {
        TODO("Not yet implemented")
    }

    override fun getAttributeNames(): Enumeration<*> {
        TODO("Not yet implemented")
    }

    override fun setCharacterEncoding(env: String?) {
        TODO("Not yet implemented")
    }

    override fun getParameterValues(name: String?): Array<String> {
        TODO("Not yet implemented")
    }

    override fun getRemoteAddr(): String {
        TODO("Not yet implemented")
    }

    override fun getReader(): BufferedReader {
        TODO("Not yet implemented")
    }

    override fun getScheme(): String {
        TODO("Not yet implemented")
    }

    override fun getLocales(): Enumeration<*> {
        TODO("Not yet implemented")
    }

    override fun getInputStream(): ServletInputStream {
        TODO("Not yet implemented")
    }

    override fun getRealPath(path: String?): String {
        TODO("Not yet implemented")
    }

    override fun getLocalName(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterEncoding(): String {
        TODO("Not yet implemented")
    }

    override fun getParameterNames(): Enumeration<*> {
        TODO("Not yet implemented")
    }

    override fun removeAttribute(name: String?) {
        TODO("Not yet implemented")
    }

    override fun getContentLength(): Int {
        TODO("Not yet implemented")
    }

    override fun getContentType(): String {
        TODO("Not yet implemented")
    }

    override fun getServerPort(): Int {
        TODO("Not yet implemented")
    }

    override fun getRequestDispatcher(path: String?): RequestDispatcher {
        TODO("Not yet implemented")
    }

    override fun getAttribute(name: String?): Any {
        TODO("Not yet implemented")
    }

    override fun setAttribute(name: String?, o: Any?) {
        TODO("Not yet implemented")
    }

    override fun getParameter(name: String?): String {
        TODO("Not yet implemented")
    }

    override fun getRemotePort(): Int {
        TODO("Not yet implemented")
    }

    override fun getRemoteHost(): String {
        TODO("Not yet implemented")
    }

    override fun getServerName(): String {
        TODO("Not yet implemented")
    }

    override fun getLocalAddr(): String {
        TODO("Not yet implemented")
    }

    override fun isSecure(): Boolean {
        TODO("Not yet implemented")
    }

}