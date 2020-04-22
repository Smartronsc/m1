<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

  <head>
    <title>Rant!Rave</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="manifest" href="/manifest.json">
    <link rel="stylesheet" type="text/css" href="styles/inline.css">
    <link rel="stylesheet" type="text/css" media="all" href="css/rant.css" th:href="@{css/rant.css}"/>
  </head>
  <body>
      <div class=Outterform>
     <div class=Interform>
   <header class=Outterform> 
     <img src="../../images/rant!rave.png" alt="Rant!Rave" title="Rant!Rave logo" 
       th:src="@{/images/rant!rave.png}"/>    
   </header>
   <form action="#" th:action="@{/showCompany.jsp}" th:object="${company}" method="post">

      <input type="text" id="comapany" name="company" th:field="*{company}">
      <select  id="functions" name="functions" th:field="*{functions}" >
       <option value="">Select function</option>
       <option th:each="functions : ${functions}" th:value="${functions}" th:text="${functions}"/>
      </select>
      <input type="submit" value="Submit"/>

  </form>
        </div>
    </div>
 </body>

</html>