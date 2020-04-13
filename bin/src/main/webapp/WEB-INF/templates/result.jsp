<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head> 
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Result</h1>
    <p th:text="'Company: ' + ${company.company}" />
    <p th:text="'User id: ' + ${company.userid}" />
    <a href="/m1/companiesURL">Submit another message</a>
</body>
</html>