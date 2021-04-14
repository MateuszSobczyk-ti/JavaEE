package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import pack2.ConnectionProvider;

public class UserDAO {

	private final static String CREATEUSER = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?);";
	private final static String CREATEROLE = "INSERT INTO user_role VALUES(?, ?);";
	private final static String READALL = "SELECT u.user_name,u.password,u.email,u.phone,uc.country_name from user u inner join user_country uc on u.country = uc.ID_user_country;";
    private final static String UPDATE = "UPDATE user SET password=?, email=?, phone=? WHERE user_name = ?;";
    private final static String DELETEROLE = "DELETE FROM user_role WHERE user_name=?;";
    private final static String DELETEUSER = "DELETE FROM user WHERE user_name=?;";

    
    //wprowadz dane do tabeli user, nastepnie do tabeli user_role, w ktorej przypisane sa role do poszczegolnych uzytkownikow
    //taka kolejnosc jest obowiazkowa ze wzgledu na wiezy integralnosci miedzy tymi tabelami
    public void create(User user) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(CREATEUSER)) {
        	prepStmt.setString(1, user.getUser_name());
        	prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getEmail());
            prepStmt.setString(4, user.getPhone());
            prepStmt.setInt(5, user.getAgr_on_not());
            prepStmt.setInt(6, user.getCountry());
            prepStmt.setInt(7, user.getStatus());
            
            prepStmt.executeUpdate();
        }
        try (Connection conn = ConnectionProvider.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(CREATEROLE)) {
                prepStmt.setString(1, user.getUser_role());
           	    prepStmt.setString(2, user.getUser_name());
           	    
            prepStmt.executeUpdate();
           }
    }
    
    //odczytaj wszystkich uzytkownikow z tabeli user
    //dane zapisywane sa najpierw do wyniku zapytania resultset, nastepnie do modelu User, i na koncu sa dodawane do listy uzytkownikow listUsers
    public List<User> readall() throws SQLException {
        User resultUser = null;
        List<User> listUsers = new ArrayList<>();
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(READALL);) {
            ResultSet resultSet = prepStmt.executeQuery();
            while(resultSet.next()) {
            	resultUser = new User();
            	resultUser.setUser_name(resultSet.getString("u.user_name"));
            	resultUser.setPassword(resultSet.getString("u.password"));
            	resultUser.setEmail(resultSet.getString("u.email"));
            	resultUser.setPhone(resultSet.getString("u.phone"));
            	resultUser.setCc(resultSet.getString("uc.country_name"));
            	listUsers.add(resultUser);
            }
            
        }
        return listUsers;
    }
    
    //zaktualizuj dane uzytkownika user w tabeli user
    public void update(User user) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(UPDATE);) {
            prepStmt.setString(1, user.getPassword());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPhone());
            prepStmt.setString(4, user.getUser_name());
            prepStmt.executeUpdate();
        }
    }
    
    
    //usun role uzytkownika user z tabeli user_role, a nastepnie dane uzytkownika user z tabeli user po user_name
    //taka kolejnosc jest obowiazkowa ze wzgledu na wiezy integralnosci miedzy tymi tabelami
    public void delete(User user) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(DELETEROLE);) {
            prepStmt.setString(1, user.getUser_name());
            prepStmt.executeUpdate();
        }
        try (Connection conn = ConnectionProvider.getConnection();
                PreparedStatement prepStmt = conn.prepareStatement(DELETEUSER);) {
               prepStmt.setString(1, user.getUser_name());
               prepStmt.executeUpdate();
        }
    }

}