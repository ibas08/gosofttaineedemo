package th.co.gosoft.customer.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import th.co.gosoft.customer.model.RegisterCustomerModel;
import th.co.gosoft.customer.service.CustomerService;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();
		RegisterCustomerModel registerCustomerModel = gson.fromJson(reader, RegisterCustomerModel.class);
		System.out.println("name : "+registerCustomerModel.getName());
		
//		RegisterCustomerModel registerCustomerModel =new RegisterCustomerModel();
//		registerCustomerModel.setName(request.getParameter("name"));
//		registerCustomerModel.setLastname(request.getParameter("lastname"));
//		registerCustomerModel.setUsername(request.getParameter("username"));
//		registerCustomerModel.setPassword(request.getParameter("password"));
//		registerCustomerModel.setBirthday(request.getParameter("birthday"));
		String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        request.setAttribute("name", name);
        request.setAttribute("lastname", lastname);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("birthday", birthday);
        String complete = "Register Complete";
        request.setAttribute("complete", complete);
		CustomerService customerService=new CustomerService();
		customerService.registerCustomer(registerCustomerModel);
		RequestDispatcher dispatcher=request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request,response);
	}
}


