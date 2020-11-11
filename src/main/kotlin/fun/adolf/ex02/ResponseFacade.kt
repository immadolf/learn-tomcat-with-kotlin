package `fun`.adolf.ex02

import javax.servlet.ServletResponse

/**
 * 直接将request对象和response对象传递给servlet时，存在安全风险——对于那些了解实现细节的人，完全可以将ServletRequest和ServletResponse向下转型成具体的request、response类型，借此就可以调用它们特有的公共方法了。
 *
 * @author adolf
 * @date 2020/11/11
 * @since
 */
class ResponseFacade(response: Response) : ServletResponse by response