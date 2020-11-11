package `fun`.adolf.ex02

class StaticResponseProcessor {

    fun process(servletRequest: Request, servletResponse: Response) {
        servletResponse.sendStaticResource()
    }

}