package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import pack2.ConnectionProvider;

public class DaoComment {

	private final static String READALL = "select content,date,user_name from comment;";
	private final static String CREATE = "INSERT INTO comment(content,date,user_name) VALUES(?,?,?);";

    public List<Comment> readall() throws SQLException {
        Comment resultCom = null;
        List<Comment> listCom = new ArrayList<>();
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(READALL);) {
            ResultSet resultSet = prepStmt.executeQuery();
            while(resultSet.next()) {
            	resultCom = new Comment();
            	resultCom.setUser_name(resultSet.getString("user_name"));
            	resultCom.setContent(resultSet.getString("content"));
            	resultCom.setDate(resultSet.getTimestamp("date"));
           	
            	listCom.add(resultCom);
            }
            
        }
        return listCom;
    }
    
    public void create(Comment com) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(CREATE)) {
        	prepStmt.setString(1, com.getContent());
        	prepStmt.setTimestamp(2, com.getDate());
            prepStmt.setString(3, com.getUser_name());
            
            prepStmt.executeUpdate();
        }
    }
}
    