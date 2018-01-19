<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

		<center>
<p>รายละเอียดลูกค้า</p>
	<table>
<tr><td>Name:     </td><td>  ${name}</td></tr>
<tr><td>Last name:</td><td>  ${lastname}</td></tr>
<tr><td>User name:</td><td>  ${username}</td></tr>
<tr><td>BirthDay: </td><td>  ${birthday}</td></tr>
	</table>
	${complete}
		</center>
		
		
</body>
</html>