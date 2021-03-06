<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	
	以下为修改之后，从request中获取的数值：ProductName:  <%= request.getAttribute("productName") %>
	<br><br>
	
	ProductDesc : ${productDesc}
	<br><br>
	
	获取从表单提交的 ProductDesc : <s:property value="[1].productDesc"/>
	<br><br>
	
	ProductPrice : ${productPrice}
	<br><br>
	
	requset: <%= request %>
	
	<s:debug></s:debug>
	
	结合 s:property 标签 显示 ProductPrice : <s:property value="[0].ProductPrice"/><br/><br/>
	
	使用EL获取 ProductName1:  ${ sessionScope.product.productName }<br/><br/>
	
	使用EL获取 ProductName2:  ${ requestScope.test.productName }<br/><br/>
	
	使用OGNL获取 ProductName1:  <s:property value="#session.product.productName"/> <br/><br/>
	
	使用OGNL获取 ProductName2:  <s:property value="#request.test.productName"/> <br/><br/>
	
	<!-- 使用 OGNL 调用 public 类的 public 类型的静态字段和静态方法 -->
	<s:property value="@java.lang.Math@PI"/> <br/><br/>

	<s:property value="@java.lang.Math@cos(0)"/> <br/><br/>
	
	<!-- 调用对象栈的方法为一个属性赋值 -->
	<s:property value="setProductName('hohoTT')"/> 
	<s:property value="ProductName"/> <br/><br/>
	
	<!-- 调用数值对象的属性 -->
	<%
		String[] names = new String[]{"aa", "bb", "cc"};
		request.setAttribute("names", names);
	%>
	
	<!-- 使用 OGNL 访问 数值对象-->
	length : <s:property value="#attr.names.length"/> <br/><br/>
	
	neams[1] : <s:property value="#attr.names[1]"/> <br/><br/>
	
	<!-- 使用 OGNL 创建 List -->
	<%
		List<String> list = new ArrayList();
		
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		
		request.setAttribute("list", list);
		
	%>
	
	<!-- 使用 OGNL 访问 list-->
	list.size ：<s:property value="#attr.list.size"/> <br/><br/>
	
	list.[2] ：<s:property value="#attr.list[2]"/> <br/><br/>
	
	<!-- 使用 OGNL 创建 Map -->
	<%
		Map<String, String> letters = new HashMap<String, String>();
		request.setAttribute("letters", letters); 
		
		// 创建键值对
		letters.put("AA", "a");
		letters.put("BB", "b");
		letters.put("CC", "c");
		
	%>
	
	<!-- 使用 OGNL 访问 Map -->
	letters.size : <s:property value="#attr.letters.size"/> <br/><br/>
	letters['AA'] : <s:property value="#attr.letters['AA']"/> <br/><br/>
	
	
</body>
</html>