<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<s:debug></s:debug>
	
	<!-- 
		<s:property value="exceptionStack"/><br/>
	 -->
	 
	<s:property value="exception"/> <br/>
	
	<s:property value="exception.message"/> <br/>
	
	EL 显示 exception ---- ${ exception } <br/>
	EL 显示 exception.message ---- ${ exception.message } <br/>

	<form action="product-save.action" method="post">
		
		ProductName: <input type="text" name="productName"/>
		<br><br>
		
		ProductDesc: <input type="text" name="productDesc"/>
		<br><br>
		
		ProductPrice: <input type="text" name="productPrice"/>
		<br><br>
		
		<input type="submit" value="submit"/>
	</form>

</body>
</html>