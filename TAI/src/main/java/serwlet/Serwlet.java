package serwlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;
import validation.DoValidate;

@WebServlet("/Serwlet")
public class Serwlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String country = request.getParameter("country");
        String agree = request.getParameter("agree");

        
        
        try {
            User user = new User(name, password, email, phone, agree, country);
            List<String> errors = DoValidate.validate(user);

            if (!errors.isEmpty()) {
                request.setAttribute("errMsg", errors);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
            UserDAO dao = new UserDAO();
            dao.create(user);
            
            request.setAttribute("errMsg", "Zostales zarejestrowany");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("ErrorSerwlet.jsp").forward(request, response);
        }
    }

}