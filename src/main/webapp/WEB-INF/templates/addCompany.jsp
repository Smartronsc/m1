<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Rant!Rave</title>
    <meta charset="UTF-8">
</head>
<body>

<h1>Add User</h1>

<form action="#" th:action="@{/showCompany.jsp}" th:object="${company}" method="post">
    <p>Company: <input type="text" th:field="*{company}"></p> 
    <p>User Id: <input type="text" th:field="*{userid}"></p>
    <p>Website: <input type="text" th:field="*{website}"></p>
    <p><input type="submit" value="Submit"/> <input type="reset" value="Reset"></p> 
</form>

</body>
</html>