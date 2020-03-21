<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Show message</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>Result</h1>

<p th:text="'Company: ' + ${company.company}"></p>
<p th:text="'UserId: ' + ${company.userid}"></p>	
<p th:text="'Website: ' + ${company.website}"></p>
<a href="/addCompany.jsp">Submit another message</a>

</body>
</html>