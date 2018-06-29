package net.slipp;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class WebServerLauncher {

  public static void main(String[] args) throws ServletException, LifecycleException {
    final String webappDirLocation = "Chapter05/webapp/";
    final Tomcat tomcat = new Tomcat();
    String webPort = System.getenv("PORT");
    if (webPort == null || webPort.isEmpty()) {
      webPort = "8080";
    }
    tomcat.setPort(Integer.parseInt(webPort));
    final Connector connector = tomcat.getConnector();
    connector.setURIEncoding("UTF-8");
    tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
    System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
    tomcat.start();
    tomcat.getServer().await();
  }
}
