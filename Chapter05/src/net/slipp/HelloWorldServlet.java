package net.slipp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
      throws IOException {
    final PrintWriter writer = resp.getWriter();
    writer.print("<h1>Hello World!</h1>");
  }
}
