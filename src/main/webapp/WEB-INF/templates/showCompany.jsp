<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Show message</title>
    <meta charset="UTF-8">
</head>
<body>

<a href="/m1/addCompany.jsp">Submit another message</a><br>

<table class="table table-striped">
                <thead>
                <tr>
                    <th>Company Name</th>
                    <th>City</th>
                    <th>State</th>
                </tr>
                </thead>
                <tbody>
                   <tr data-th-each="table : ${table}" th:field="*{table}">   
                    <td data-th-text="${table.companyTable_name}"></td>
                   </tr>
                </tbody>
</table>

</body>
</html>