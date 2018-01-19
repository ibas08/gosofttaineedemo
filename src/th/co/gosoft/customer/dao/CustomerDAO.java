package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import th.co.gosoft.customer.dto.CustomerDTO;
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
		public List<CustomerDTO> selectCustomer() throws Exception {
			List<CustomerDTO> resultList =new ArrayList<>();
			Connection connect=null;
			PreparedStatement pre=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
					"?user=root&password=12345678");
		    String sql = "SELECT customer.name, customer.lastname, customer.username, customer.birthday, customer.age, department.department_name " + 
		    		"FROM customer " + 
		    		"INNER JOIN department " + 
		    		"ON customer.department_id = department.department_id";
		    pre=connect.prepareStatement(sql);
		    ResultSet result = pre.executeQuery();
		    while((result!=null) && (result.next())) { 
					CustomerDTO CustomerDTO = new CustomerDTO();
					CustomerDTO.setName(result.getString("name"));
					CustomerDTO.setLastname(result.getString("lastname"));
					CustomerDTO.setUsername(result.getString("username"));
					CustomerDTO.setBirthday(result.getString("birthday"));
					CustomerDTO.setAge(result.getInt("age"));
					CustomerDTO.setDep_name(result.getString("department_name"));
					resultList.add(CustomerDTO);
		    }
				
			return resultList;}
		    catch (Exception e) {
		    	  e.printStackTrace();
		    	  throw e;}
		    finally {
		     if(pre != null){
		  	    pre.close();
		     }
		     if(connect != null){
		    	connect.close();
		     }
			}
			
		}
		 
		
	
}
