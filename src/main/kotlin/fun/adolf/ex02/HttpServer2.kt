package `fun`.adolf.ex02

import java.io.File
import java.io.IOException
import java.lang.Exception
import java.net.InetAddress
import java.net.ServerSocket
import kotlin.system.exitProcess

/**
 *
 *
 * @author adolf
 * @date 2020/11/11
 * @since
 */
class HttpServer2 {

    private var shutdown = false
    private val servletProcessor2: ServletProcessor2 = ServletProcessor2()
    private val staticResponseProcessor: StaticResponseProcessor = StaticResponseProcessor()

    companion object {
        val WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot"
        private const val SHUTDOWN_COMMAND = "/SHUTDOWN"
    }

    @ExperimentalStdlibApi
    fun await() {
        val port = 8080
        val serverSocket: ServerSocket
        try {
            serverSocket = ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            exitProcess(1)
        }
        //循环接收请求
        while (!shutdown) {
            try {
                val socket = serverSocket.accept()
                //自动关闭 socket
                socket.use {
                    val input = socket.getInputStream()
                    val output = socket.getOutputStream()
                    //根据输入流创建请求对象 Request
                    val request = Request(input)
                    //根据 HTTP 协议进行解析
                    request.parse()

                    //创建响应对象 Response
                    val response = Response(output)
                    response.request = request

                    //以下部分为在 ex01 基础上新增的代码
                    //==================================
                    if (isStaticResource(request.uri)) {
                        staticResponseProcessor.process(request, response)
                    } else {
                        servletProcessor2.process(request, response)
                    }
                    //==================================
                    //检查是否是请求命令
                    shutdown = request.uri == SHUTDOWN_COMMAND
                }
            } catch (e: Exception) {
                e.printStackTrace()
                continue
            }
        }
    }

    //在这个例子中，所有的servlet都位于
    private fun isStaticResource(uri: String): Boolean {
        return !uri.startsWith("/servlet/")
    }

}

@ExperimentalStdlibApi
fun main() {
    val server = HttpServer2()
    server.await()
}
