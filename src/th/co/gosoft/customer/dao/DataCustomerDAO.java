package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import th.co.gosoft.customer.dto.DataCustomerDTO;

public class DataCustomerDAO {
public List<DataCustomerDTO> selectAllCustomer() throws Exception {
	List<DataCustomerDTO> resultList =new ArrayList<>();
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
			DataCustomerDTO dataCustomerDTO = new DataCustomerDTO();
			dataCustomerDTO.setName(result.getString("name"));
			dataCustomerDTO.setLastname(result.getString("lastname"));
			dataCustomerDTO.setUsername(result.getString("username"));
			dataCustomerDTO.setBirthday(result.getString("birthday"));
			dataCustomerDTO.setAge(result.getInt("age"));
			dataCustomerDTO.setDep_name(result.getString("department_name"));
			resultList.add(dataCustomerDTO);
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
public static void main(String[] args) throws Exception {
	DataCustomerDAO dataCustomerDAO = new DataCustomerDAO();
	List<DataCustomerDTO> resultList =dataCustomerDAO.selectAllCustomer();
	System.out.println(resultList.get(0).getName());
	System.out.println(resultList.get(0).getLastname());
	System.out.println(resultList.get(0).getUsername());
	System.out.println(resultList.get(0).getBirthday());
	System.out.println(resultList.get(0).getAge());
	System.out.println(resultList.get(0).getDep_name());

	
}
}
