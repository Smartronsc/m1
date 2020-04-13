<!DOCTYPE html>
<%-- Rant Copyright 2015 RichardBradleySmith.com --%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% System.out.println("servlet " + request.getServletPath().toString()); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="images/favicon.png" />
<title>Counts</title>
<link href="css/rant.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="allHome id=Home"><a href="<c:url value="home"/>">Home</a></nav>
	<form id="rantwordtable" name="rantformdata" method="post" action="">
		<table class="table_counts">
			<c:forEach var="wordCount" items="${wordCount}">
				<tr id="wordCounttable">
				 <td>
					<input  value="${wordCount.word}"  name="wordCountw"  id="wordCountw" type="text" />
					<input  value="${wordCount.count}"  name="wordCountc"  id="wordCountc" type="text" />
				 </td>	
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
