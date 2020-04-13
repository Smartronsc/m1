<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <head>
    <title>Rant!Rave</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" media="all" href="../../css/stsm.css" th:href="@{/css/stsm.css}"/>
  </head>
  <body>
   <form:form>
   <form action="#" th:action="@{/companies}" th:object="${Companies}" method="post">
    <div>
      <img src="../../images/rantlogo.png" alt="Rant logo" title="Rant logo" 
           th:src="@{/images/rantlogo.png}"/>
            <img src="../../images/rant!rave.png" alt="Rant!Rave" title="Rant!Rave logo" 
           th:src="@{/images/rant!rave.png}"/>    
    </div>
    <input type="text" th:field="*{companies_websitec}" />
  </form>
  </form:form>
  </body>
</html>