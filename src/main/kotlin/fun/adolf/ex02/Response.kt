package `fun`.adolf.ex02

import java.io.OutputStream
import java.io.PrintWriter
import java.util.*
import javax.servlet.ServletOutputStream
import javax.servlet.ServletResponse

class Response(private val output: OutputStream) : ServletResponse {

    lateinit var request: Request

    override fun getCharacterEncoding(): String {
        TODO("Not yet implemented")
    }

    override fun isCommitted(): Boolean {
        TODO("Not yet implemented")
    }

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
        TODO("Not yet implemented")
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

    override fun getBufferSize(): Int {
        TODO("Not yet implemented")
    }

    override fun resetBuffer() {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }
}