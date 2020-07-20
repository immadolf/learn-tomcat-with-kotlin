package `fun`.adolf.ex01

import java.io.File
import java.io.OutputStream

class Response(private val output: OutputStream) {

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
}