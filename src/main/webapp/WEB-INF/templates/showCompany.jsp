<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Show message</title>
    <meta charset="UTF-8">
</head>
<body>

<p th:text="'Company: ' + ${company.company}"></p>
<p th:text="'UserId: ' + ${company.userid}"></p>	
<p th:text="'Website: ' + ${company.website}"></p>
<a href="/m1/addCompany.jsp">Submit another message</a>


<a href="/m1/addCompany.jsp">Submit another message</a>

<table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Cost</th>
                    <th>Mins to prepare</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                    <tr th:each="companyTable : ${companyTable}">
                     <td>companyTable.name</td>
                     <td>companyTable.city</td>
                     <td>companyTable.state</td>
                    </tr>   

                </tbody>
</table>

</body>
</html>