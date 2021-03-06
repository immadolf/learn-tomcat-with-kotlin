/**
 * 第一章：一个简单的 Web 服务器。
 * 应用程序的入口点在 HTTPServer 文件中。main 方法创建一个 HTTPServer 实例，然后，调用其 await 方法。
 * 顾名思义，await 方法会在指定端口上等待 HTTP 请求，对其进行处理，然后发送响应信息到客户端。
 * 在接收到关闭命令前，它会保持等待状态。
 *
 * 该应用程序仅发送位于指定目录下的静态资源的请求，如 HTML 文件和图像文件。它也可以将传入到的 HTTP 请求字节流显示到控制台上。
 * 但是，它并不发送任何头信息到浏览器，如日期或 cookies 等。
 */
package fun.adolf.ex01;