<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Post</h1>
    <form action="#" th:action="@{/companies}" th:object="${companies}" method="post">
    	<p>Id: <input type="text" th:field="*{company_name}" /></p>
        <p>Message: <input type="text" th:field="*{company_websitec}" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>