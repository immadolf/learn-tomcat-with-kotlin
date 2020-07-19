package `fun`.adolf.ex01

import java.io.File
import java.io.OutputStream

const val BUFFER_SIZE: Int = 1024

class Response(private val output: OutputStream) {

    lateinit var request: Request

    //读取静态资源并写到输出流
    fun sendStaticResource() {
        val file = File(HttpServer.WEB_ROOT, request.uri.orEmpty())
        if (file.exists() && file.isFile) {
            file.inputStream().use {
                try {
                    println(it.transferTo(output))
//                    output.write()
                } catch (e: Exception) {
                    println(e)
                }
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