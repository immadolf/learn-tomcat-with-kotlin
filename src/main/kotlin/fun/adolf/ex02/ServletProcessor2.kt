package `fun`.adolf.ex02

import `fun`.adolf.ex02.HttpServer1.Companion.WEB_ROOT
import cn.hutool.log.Log
import cn.hutool.log.LogFactory
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.net.URLStreamHandler
import javax.servlet.Servlet


class ServletProcessor2 {
    private val log: Log = LogFactory.get()

    fun process(servletRequest: Request, servletResponse: Response) {
        val servletName = servletRequest.uri.substringAfterLast("/")
        log.info("servletName: {}", servletName)
        val streamHandler: URLStreamHandler? = null
        val classPath = File(WEB_ROOT)
        val repository = URL("file", null, classPath.canonicalPath + File.separator).toString()
        log.info("repository: {}", repository)
        val urls = arrayOfNulls<URL>(1)
        urls[0] = URL(null, repository, streamHandler)
        val loader = URLClassLoader(urls)
        log.info("parent loader: {}", loader.parent)
        //由于loadClass时必须指定类的全限定名，因此servletName对应的servlet类必须位于源码的根目录下（即没有package）
        val servletClass: Class<*> = loader.loadClass(servletName)
        val servlet = servletClass.newInstance() as Servlet
        servlet.service(RequestFacade(servletRequest), ResponseFacade(servletResponse))
    }

}