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

import DAO.UserDAO;
import model.User;
import validation.DoValidate;

@WebServlet("/AdminSerwlet")
public class AdminSerwlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String action = request.getParameter("submit");
    	request.setAttribute("action", action);
    	List<User> listUsers = null;
    	try {
    		UserDAO dao = new UserDAO();
    	switch(action) {
    	case "Przegladaj uzytkownikow":	
    		    listUsers = new ArrayList<>();
				listUsers = dao.readall();
				request.setAttribute("listUsers", listUsers);
    	break;
    	case "Edytuj uzytkownika":
    	    listUsers = new ArrayList<>();
			listUsers = dao.readall();
			request.setAttribute("listUsers", listUsers);
    		//request.getRequestDispatcher("admin.jsp").forward(request, response);
    		break;
    	case "Zapisz":
    		 request.setCharacterEncoding("UTF-8");
    		 listUsers = new ArrayList<>();
			 listUsers = dao.readall();
			 request.setAttribute("listUsers", listUsers);
    	     int id = Integer.parseInt(request.getParameter("id"));
    	     id--;
    	     if(id >=0 && id < listUsers.size()) {
    	     User user = listUsers.get(id);
    	     
    	     User userCopy = new User(user);
    	     
    	     user.setPassword(request.getParameter("password"));
    	     user.setEmail(request.getParameter("email"));
    	     user.setPhone(request.getParameter("phone"));
    	     user.setCountry(request.getParameter("country"));
    	     user.setAgr_on_not(request.getParameter("agree"));
    	     
    	     List<String> errors = DoValidate.validate(user);
             if (!errors.isEmpty()) {
                 request.setAttribute("errMsg", errors);
                 request.setAttribute("action", "Edytuj uzytkownika");
                 listUsers.set(id, userCopy);
             } else {
    	     dao.update(user);
    	     request.setAttribute("message", "Tabela zostala zaktualizowana");
             }}
    	     else {
    	    	 List<String> errors = new ArrayList<String>();
    	    	 errors.add("Wprowadz poprawne id");
    	    	 request.setAttribute("errMsg", errors);
                 request.setAttribute("action", "Edytuj uzytkownika");
    	     }
    		break;
    	case "Usun uzytkownika":
    		listUsers = new ArrayList<>();
			listUsers = dao.readall();
			request.setAttribute("listUsers", listUsers);
    		break;
    	case "Usun":
    		listUsers = new ArrayList<>();
			listUsers = dao.readall();
			request.setAttribute("listUsers", listUsers);
    		int idToDelete = Integer.parseInt(request.getParameter("id"));
    		idToDelete--;
   	     	if(idToDelete >=0 && idToDelete < listUsers.size()) {
   	     	User user = listUsers.get(idToDelete);
   	     	dao.delete(user);
   	     	request.setAttribute("message", "uzytkownik "+user.getUser_name()+" zostal usuniety z bazy danych.");
   	     	}
   	     	else {
   	     	List<String> errors = new ArrayList<String>();
   	     	errors.add("Wprowadz poprawne id");
	    	request.setAttribute("errMsg", errors);
            request.setAttribute("action", "Usun uzytkownika");	
   	     	}
    		break;
    	case "Dodaj":
    		request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String country = request.getParameter("country");
            String agree = request.getParameter("agree");
            
                User user = new User(name, password, email, phone, agree, country);
                List<String> errors = DoValidate.validate(user);

                if (!errors.isEmpty()) {
                    request.setAttribute("errMsg", errors);    
                    request.setAttribute("action", "Dodaj uzytkownika");
                } else {             
                dao.create(user);
                request.setAttribute("message", "uzytkownik "+user.getUser_name()+" zostal dodany do bazy danych.");
                }
    		break;
    	case "DodajAd":
    		request.setCharacterEncoding("UTF-8");
            String nam = request.getParameter("name");
            String passwd = request.getParameter("password");
            String em = request.getParameter("email");
            String ph = request.getParameter("phone");
            String cnt = request.getParameter("country");
            String agr = request.getParameter("agree");
            
                User us = new User(nam, passwd, em, ph, agr, cnt);
                us.setUser_role("admin_role");
                List<String> err = DoValidate.validate(us);

                if (!err.isEmpty()) {
                    request.setAttribute("errMsg", err);    
                    request.setAttribute("action", "Dodaj admina");
                } else {             
                dao.create(us);
                request.setAttribute("message", "uzytkownik "+us.getUser_name()+" zostal dodany do bazy danych.");
                }
    		
    		break;
    	}
		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("ErrorSerwlet.jsp").forward(request, response);
		}  	
    	request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}