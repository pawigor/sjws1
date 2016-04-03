package servlets;

import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private AccountService service;

    public SignInServlet(AccountService service) {
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (service.signIn(login, password)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().append("Authorized: ").append(login);
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Unauthorized");
        }
    }
}
