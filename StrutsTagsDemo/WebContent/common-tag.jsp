<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.wt.valueStack.Person"%>
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
	
	<h4>Test Common-tag Page</h4>
	
	<s:debug></s:debug> <br/><br/>
	
	<!-- 以下为 s: property 标签的使用介绍 -->
	以下为 s: property 标签的使用介绍 <hr/>
	
	s: property: 打印值栈中的属性值的：对于对象栈，打印值栈中对于的属性值 <br/><br/>
	<s:property value="productName"/> <br/><br/>
	
	对于 Map 栈，打印 request、session、application 某个属性值 或 某个请求参数的值 <br/><br/>
	<s:property value="#session.date"/> <br/><br/>
	
	<s:property value="#parameters.name"/> <br/><br/>
	
	
	
	
	<!-- 以下为 s:url 标签的使用介绍 -->
	以下为 s:url 标签的使用介绍 <hr/>
	
	s:url: 创建一个 URL 字符串的 <br/><br/>
	<s:url value="/getProduct" var="url1">
		<!-- 指定包含参数的url值，数字不会被当做是参数处理, Struts2 直接把数字作为属性值 -->
		<s:param name="productId" value="6666"></s:param>
	</s:url> 
	${ url1 } <br/><br/>
	
	<s:url value="/getProduct" var="url2">
		<!-- 对于 value 值会自动的进行 OGNL 解析 -->
		<s:param name="productId" value="productId"></s:param>
		
		<!-- OGNL 解析 date -->
		<s:param name="date" value="#session.date"></s:param>
	</s:url> 
	${ url2 } <br/><br/>
	
	<s:url value="/getProduct" var="url3">
		<!-- 对于 value 值会自动的进行 OGNL 解析, 若不希望进行 OGNL 解析，则使用单引号引起来 -->
		<s:param name="productId" value="'abcd'"></s:param>
	</s:url> 
	${ url3 } <br/><br/>
	
	<!-- 构建一个请求 action 的地址 -->
	<s:url action="testAction" namespace="/hohoTT" method="testTag" var="url4"></s:url>
	${ url4 } <br/><br/>
	
	<!-- 可以获取请求 url 中的参数值，includeParams="get"，此时获取的为 get 请求的参数-->
	<s:url value="/testUrl" var="url5" includeParams="get"></s:url>
	${ url5 } <br/><br/>
	
	<!-- 可以获取请求 url 中的参数值，includeParams="all"，此时获取的为 post 请求的参数-->
	<s:url value="/testUrl" var="url6" includeParams="all"></s:url>
	${ url6 } <br/><br/>
	
	
	
	
	<!-- 以下为 s:set 标签的使用介绍 -->
	以下为 s:set 标签的使用介绍 <hr/>
	
	s:set: 向 page、request、session、application 域对象中加入一个属性值
	
	<!-- 对 value 属性值自动的进行 OGNL 解析 -->
	<s:set name="productName" value="productName" scope="request"></s:set>
	productName: ${ requestScope.productName } <br/><br/>
	
	<s:set name="productDesc" value="productDesc" scope="page"></s:set>
	productDesc: ${ pageScope.productDesc } <br/><br/>
	
	<br/><br/>
	
	
	
	<!-- 以下为 s:push 标签的使用介绍 -->
	以下为 s:push 标签的使用介绍 <hr/>
	
	s:push: 把一个对象在标签开始后压入到值栈中，标签结束后，弹出值栈
	<!-- 临时写一个对象 -->
	<%
		Person person = new Person();
		person.setName("Person_hohoTT");
		person.setAge(21);
		
		request.setAttribute("person", person);
	%>
	
	<!-- 将之前临时创建的对象压入到值栈中 -->
	<s:push value="#request.person">
		将之前临时创建的对象压入到值栈中 : ${ name }
		<br/><br/>
		<!-- 只有在 push 标签内有效，出了标签之后，该对象会自动弹出值栈 -->
		hhh: <s:property value="name" />
	</s:push>
	<br/><br/>
	
	
	
	
	<!-- 以下为 s:if, s:else, s:elseif 标签的使用介绍 -->
	以下为 s:if, s:else, s:elseif 标签的使用介绍 <hr/>
	
	<!-- 可以直接使用值栈中的属性，测试值栈中的 productPrice -->
	<s:if test="productPrice > 1000">
		productPrice > 1000
	</s:if>
	<s:elseif test="productPrice > 800">
		productPrice > 800
	</s:elseif>
	<s:else>
		else
	</s:else>
	<br/><br/>
	
	<!-- 测试值栈中的 age -->
	<s:if test="#request.person.age > 21">
		#request.person.age > 21
	</s:if>
	<s:else>
		#request.person.age <= 21
	</s:else>
	<br/><br/>
	
	
	
	<!-- 以下为 s:iterator 标签的使用介绍 -->
	以下为 s:iterator 标签的使用介绍 <hr/>
	
	s:iterator: 遍历集合的，把这个可遍历对象里的每一个对象依次压入和弹出
	<br/><br/>
	
	<!-- 构架一个集合 -->
	<%
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("AA", 10));
		persons.add(new Person("BB", 20));
		persons.add(new Person("CC", 30));
		persons.add(new Person("DD", 40));
		persons.add(new Person("EE", 50));
		
		request.setAttribute("persons", persons);
	%>
	
	<!-- 从request中获取之前存入的集合属性 -->
	从request中获取之前存入的集合属性   <br/>
	<s:iterator value="#request.persons">
		name: ${ name }  --- age: ${ age }<br/>
	</s:iterator>
	<br/><br/>
	
	从request中获取之前存入的集合属性, 显示status中的属性值(例：index、count)   <br/>
	<s:iterator value="#request.persons" status="status">
		index: ${ status.index } ---- count: ${ status.count } : name: ${ name }  --- age: ${ age }<br/>
	</s:iterator>
	<br/><br/>
	
	<!-- 从值栈中获取之前存入的集合属性 -->
	从值栈中获取之前存入的集合属性 <br/>
	<s:iterator value="persons">
		name: ${ name }  --- age: ${ age }<br/>
	</s:iterator>
	<br/><br/>
	
	<br/><br/>
	<br/><br/>
	<br/><br/>
	<br/><br/>
	<br/><br/>

</body>
</html>