package `fun`.adolf.ex02

import `fun`.adolf.ex01.HttpServer
import java.io.File
import java.io.OutputStream
import java.io.PrintWriter
import java.util.*
import javax.servlet.ServletOutputStream
import javax.servlet.ServletResponse

class Response(private val output: OutputStream) : ServletResponse {

    lateinit var request: Request

    //读取静态资源并写到输出流
    fun sendStaticResource() {
        val file = File(HttpServer.WEB_ROOT, request.uri ?: "/not-exist")
        if (file.exists() && file.isFile) {
            //这里不能直接把流写出去，因为需要加上http协议的头部
            file.inputStream().use {
                val buffer = ByteArray(it.available())
                it.read(buffer)
                val body = String(buffer)
                val responseMessage = """HTTP/1.1 200 OK
                    |Content-Type: text/html
                    |Content-Length: ${body.replace(System.lineSeparator(), "").length}
                    |
                    |${body}
                """.trimMargin()
                output.write(responseMessage.toByteArray())
            }
        } else {
            val errorMessage = """HTTP/1.1 404 File Not Found
                |Content-Type: text/html
                |Content-Length: 23
                |
                |<h1>File Not Found</h1>
            """.trimMargin()
            output.write(errorMessage.toByteArray())
        }
    }


    override fun getCharacterEncoding(): String {
        TODO("Not yet implemented")
    }

    override fun isCommitted(): Boolean = false

    override fun flushBuffer() {
        TODO("Not yet implemented")
    }

    override fun setBufferSize(size: Int) {
        TODO("Not yet implemented")
    }

    override fun getLocale(): Locale {
        TODO("Not yet implemented")
    }

    override fun setCharacterEncoding(charset: String?) {
        TODO("Not yet implemented")
    }

    override fun getContentType(): String {
        TODO("Not yet implemented")
    }

    override fun getWriter(): PrintWriter {
        //autoFlush = true，表示对writer调用println方法会自动刷新输出，而print方法则不会
        return PrintWriter(output, true)
    }

    override fun setLocale(loc: Locale?) {
        TODO("Not yet implemented")
    }

    override fun getOutputStream(): ServletOutputStream {
        TODO("Not yet implemented")
    }

    override fun setContentLength(len: Int) {
        TODO("Not yet implemented")
    }

    override fun setContentType(type: String?) {
        TODO("Not yet implemented")
    }

    override fun getBufferSize(): Int = 0

    override fun resetBuffer() {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }
}