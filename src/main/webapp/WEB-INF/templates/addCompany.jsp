<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Rant!Rave</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="/css/rant.css" th:href="@{/css/rant.css}"/>
  </head>
  <body>
    <div class=divOutterform>
     <img src="../../images/rant!rave.png" alt="Rant!Rave" title="Rant!Rave logo" 
      th:src="@{/images/rant!rave.png}"/>    
    </div>
  <form action="#" th:action="@{/showCompany.jsp}" th:object="${company}" method="post">
    <div class=divOutterform>
     <div class=divInnerform>Research Company</div><div class=divInnerform>Represent Company</div><br> 
     <input type="text" th:field="*{company}">
     <input type="submit" value="Submit"/> <input type="reset" value="Reset"> 
     </div>
  </form>

</body>
</html>