package th.co.gosoft.customer.dao;

import th.co.gosoft.customer.dto.CustomerDTO;
import java.sql.*;
public class CustomerDAO {
public void insert(CustomerDTO customerDTO) throws SQLException {
//connectdata
	Connection connect=null;
	PreparedStatement pre=null;
	try {
      Class.forName("com.mysql.jdbc.Driver");
      connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
        "?user=root&password=12345678");
      		String name = customerDTO.getName();
            String lastname = customerDTO.getLastname();
            String username = customerDTO.getUsername();
            String password = customerDTO.getPassword();
            String birthday = customerDTO.getBirthday();
            int age = customerDTO.getAge();
            int departmentId = customerDTO.getDepartmentId();
     
            
            String sql = "INSERT INTO customer (name, lastname, username, password, birthday,age,department_id) "
        + "VALUES (?,?,?,?,?,?,?)";
      
      pre=connect.prepareStatement(sql);
      pre.setString(1, name);
      pre.setString(2, lastname);
      pre.setString(3, username);
      pre.setString(4, password);
      pre.setString(5, birthday);
      pre.setInt(6, age);
      pre.setInt(7, departmentId);
      pre.executeUpdate();
      	      
      } catch (Exception e) {
    	  e.printStackTrace();
      } finally {
    	  if(pre != null){
  	         pre.close();
    	  }
    	  if(connect != null){
    		 connect.close();
    	  }
	  }
  }
	
}
