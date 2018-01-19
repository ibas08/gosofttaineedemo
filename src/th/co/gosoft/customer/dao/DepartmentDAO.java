package th.co.gosoft.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import th.co.gosoft.customer.dto.DepartmentDTO;

public class DepartmentDAO {
	public List<DepartmentDTO> selectAllDepartment() throws Exception {
		List<DepartmentDTO> resultList= new ArrayList<>();
		Connection connect=null;
		PreparedStatement pre=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://localhost/gosoft" +
				"?user=root&password=12345678");
	    String sql = "SELECT department_id, department_name from department";
	    pre=connect.prepareStatement(sql);
	    ResultSet result = pre.executeQuery();
	    while((result!=null) && (result.next())) { 
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDep_id(result.getInt("department_id"));
				departmentDTO.setDep_name(result.getString("department_name"));
				resultList.add(departmentDTO);
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
