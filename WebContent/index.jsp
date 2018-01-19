<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
<link href ="./bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src = "./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src = "./bootstrap/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		initialDepartment();	
		showDataCustomer();
	});
	function showDataCustomer(){
 	$.ajax({
            type: 'POST',
            url	: '/CustomerRegisterWeb/DataCustomerServlert',
            dataType: "json",
            success	: function (data) {
            	var trHTML = '';
                $.each(data, function (i, item) {
                    trHTML += 
                    '<tr><td>' + item.name + 
                    '</td><td>'+ item.lastname + 
                    '</td><td>'+ item.username + 
                    '</td><td>'+ item.birthday + 
                    '</td><td>'+ item.age + 
                    '</td><td>'+ item.dep_name + '</td></tr>'  ;
                });
                $('#showdata').append(trHTML);
            }
         }); 
	}
	function initialDepartment(){
		 $.ajax({
            type: 'POST',
            url	: '/CustomerRegisterWeb/DepartmentServlert',
            dataType: "json",
            success	: function (data) {
            	$.each(data,function(i, option){
        			$('#department').append($('<option/>').attr("value", option.dep_id).text(option.dep_name));
                })
            }
         }); 
	}
	function saveUser(){
		 var obj = new Object();
		 obj.name = $("#name").val();
		 obj.lastname = $("#lastname").val();
		 obj.password = $("#password").val();
		 obj.username = $("#username").val();
		 obj.birthday = $("#birthday").val();
		 obj.departmentId = $("#department").val();
    $.ajax({
    	 url: '/CustomerRegisterWeb/RegisterServlet',
    	 type: 'POST',
    	 contentType: 'application/json',
    	 data: JSON.stringify(obj),
    success: function(result) {
         alert('successfully sent to the server');
         $("#name").val("");
         $("#lastname").val("");
         $("#username").val("");
         $("#password").val("");
         $("#confirm").val("");
         $("#birthday").val("");
         $("#div1").html("success");
         window.location.reload();
    		}
    });		
    }
</script>
<body>
<form name="input" action="RegisterServlet" method="Post">
<div class="container"> 
		<center><h1>ลงทะเบียนลูกค้า</h1></center>
		<hr>
		<div class="row">
			<div class="col-sm-4" >     </div>		
	    	<div class="col-sm-4" >
			    <label >Name:<input type="text" class="form-control" id="name"></label>
			    <label >LastName:<input name type="text" class="form-control" id="lastname"></label>
			    <label >Username:<input type="text" class="form-control" id="username"></label>
			    <label >Password:<input type="text" class="form-control" id="password"></label>
			    <label >Confirm Password:<input type="text" class="form-control" id="confirm"></label>
			    <label >Birthday:<input type="text" class="form-control" id="birthday"></label>
			    <br><br>
			    <label>Department:</label>
				<select class="custom-select" id="department">
			    
			   </select>
				<br>
				<br>
				<button type="button" class="btn btn-info" onclick="saveUser()"">Save</button>
			 </div>
		    <div class="col-sm-4" >     </div>
		</div>
					<hr>
		<div class="row">
			<div class="col-sm-12" >
			<table class="table table-striped " id="showdata">
			  <thead>
			      <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Lastname</th>
			      <th scope="col">Username</th>
			      <th scope="col">Birthday</th>
			      <th scope="col">Age</th>
			      <th scope="col">Department</th>
			     </tr>
			  </thead>
	  			  <tbody></tbody>
			</table>
			</div>
		</div>	
</form>
</body>
</html>
