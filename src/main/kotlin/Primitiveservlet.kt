import cn.hutool.log.Log
import cn.hutool.log.LogFactory
import java.io.IOException
import javax.servlet.*

/**
 * 这个类位于根目录下，这个是关键.
 * 编译后手动将class文件移到到src目录同级的webroot目录下.
 * @author adolf
 * @date 2020/11/11
 * @since
 */
class Primitiveservlet : Servlet {

    val log: Log = LogFactory.get()

    @Throws(ServletException::class)
    override fun init(config: ServletConfig) {
        log.info("init...")
    }

    override fun getServletConfig(): ServletConfig? {
        return null
    }

    @Throws(ServletException::class, IOException::class)
    override fun service(req: ServletRequest, res: ServletResponse) {
        log.info("service...")
        res.writer.println("Hello. Roses are red.")
        res.writer.print("Hello. Violets are blue.")
    }

    override fun getServletInfo(): String? {
        return null
    }

    override fun destroy() {
        log.info("destroy...")
    }
}