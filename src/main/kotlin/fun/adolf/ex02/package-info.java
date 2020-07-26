/**
 * 第二章:一个简单的 servlet 容器.<br>
 * 本章通过两个小应用程序说明如何开发自己的 servlet 容器.<br>
 * 第一个应用程序的设计非常简单,仅用来说明 servlet 容器是如何运行的.然后它将演变成第二个 servlet 容器,后者稍微复杂一些.<br>
 *
 * <p>
 *     下面从 servlet 容器的角度审视 servlet 程序的开发.简单来说,对一个 servlet 的每个 HTTP 请求,一个功能齐全的servlet 容器有以下几件事要做:
 *     <ul>
 *         <li>当第一次调用某个 servlet 时,要载入该 servlet 类,并调用其 init 方法(仅此一次);</li>
 *         <li>针对每个 request 请求,创建一个 javax.servlet.ServletRequest 实例和一个 javax.servlet.ServletResponse 实例;</li>
 *         <li>调用该 servlet 的 service 方法时,将 servletRequest 对象和 servletResponse 对象作为参数传入;</li>
 *         <li>当关闭该 servlet 类时,调用其 destroy 方法,并卸载该 servlet 类.</li>
 *     </ul>
 * </p>
 *
 * <p>
 *     本章要建立的 servlet 容器是一个很小的容器,没有实现所有的功能.因此,它只能运行非常简单的 servlet,而且也不会调用 servlet 的 init 和 destroy 方法.它会做以下几件事:
 *     <ul>
 *         <li>等待 HTTP 请求</li>
 *         <li>创建一个 servletRequest 对象和一个 servletResponse 对象</li>
 *         <li>若请求的是一个静态资源,则调用 StaticResourceProcessor 对象的 process 方法,传入 servletRequest 对象和 servletResponse 对象</li>
 *         <li>若请求的是 servlet,则载入相应的类,调用其 service 方法,传入 servletRequest 对象和 servletResponse 对象</li>
 *     </ul>
 * </p>
 *
 */
package fun.adolf.ex02;