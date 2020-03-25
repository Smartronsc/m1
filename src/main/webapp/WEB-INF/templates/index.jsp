<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Rant!Rave</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="../../css/stsm.css" th:href="@{/css/stsm.css}"/>
  </head>
  <body>
    <div>
      <img src="../../images/rantlogo.png" alt="Rant logo" title="Rant logo" 
           th:src="@{/images/rantlogo.png}"/>
            <img src="../../images/rant!rave.png" alt="Rant!Rave" title="Rant!Rave logo" 
           th:src="@{/images/rant!rave.png}"/>    
    </div>
 <h1>Start here</h1>
    <form action="#" th:action="@{/companies.jsp}" th:object="${company}" method="post">   
      <p>Company: <input type="text" th:field="*{company}"/></p>
      <p>User Id: <input type="text" th:field="*{userid}"/></p>
      <p>Website: <input type="text" th:field="*{website}"/></p>
      <input type="text" id="*{website}" name="*{website}"/>
      <button type="submit" name="website" value="save">save</button>
    </form>
  </body>
</html>