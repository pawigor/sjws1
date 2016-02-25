package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.Task1;

/**
 *
 * класс Main инициализация jetty
 *
 * Created by z on 26.02.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Task1 task1 = new Task1();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(task1), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
