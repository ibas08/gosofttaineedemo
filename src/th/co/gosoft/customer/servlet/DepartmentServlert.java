package th.co.gosoft.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import th.co.gosoft.customer.dao.DepartmentDAO;
import th.co.gosoft.customer.dto.DepartmentDTO;

@WebServlet("/DepartmentServlert")
public class DepartmentServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepartmentServlert() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<DepartmentDTO> resultList =null;
		try {
			resultList=departmentDAO.selectAllDepartment();
			Gson gson=new Gson();
			String result=gson.toJson(resultList);
			response.setContentType("application/Json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

