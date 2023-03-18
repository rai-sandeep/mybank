package com.sandeeprai.mybank;

import com.sandeeprai.mybank.web.MyBankServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        String serverPort = System.getProperty("server.port");
        tomcat.setPort(serverPort == null ? 8080: Integer.valueOf(serverPort));

        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper servlet = tomcat.addServlet(context, "myBankServlet", new MyBankServlet());

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
    }
}
