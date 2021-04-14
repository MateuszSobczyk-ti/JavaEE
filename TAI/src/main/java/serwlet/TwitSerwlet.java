package serwlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DaoComment;
import model.Comment;
import validation.DoValidate;
import validation.DoValidateCom;

@WebServlet("/TwitSerwlet")
public class TwitSerwlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String action = request.getParameter("submit");
    	request.setAttribute("action", action);
        try {        
            DaoComment dao = new DaoComment();
        switch(action) {
        case "Pokaz wpisy":
        	List<Comment> listCom = null;
            listCom = new ArrayList<>();
            
            listCom = dao.readall();
			request.setAttribute("listCom", listCom);
			break;
        case "Dodaj":
        	HttpSession session = request.getSession();
        	String user_name = (String)session.getAttribute("user_name");
        	Comment com = new Comment();
        	com.setContent(request.getParameter("wpis"));
        	com.setDate();
        	com.setUser_name(user_name);
        	
        	List<String> errors = DoValidateCom.validate(com);
            if (!errors.isEmpty()) {
                request.setAttribute("msg", errors);
            } else {      	
        	dao.create(com);
        	request.setAttribute("msg", "Twoj wpis zostal dodany");
            }
        	break;
        }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("ErrorSerwlet.jsp").forward(request, response);
        }
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

}