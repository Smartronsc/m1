<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>Rant!Rave</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="manifest" href="/manifest.json">
    <link rel="stylesheet" type="text/css" href="styles/inline.css">
    <link rel="stylesheet" type="text/css" media="all" href="/css/rant.css" th:href="@{/css/rant.css}"/>
  </head>
  <body>

    <header class=Outterform> 
    <h1>   
     <img src="../../images/rant!rave.png" alt="Rant!Rave" title="Rant!Rave logo" 
       th:src="@{/images/rant!rave.png}"/>    
     </h1>
  </header>

  <nav class="nav">

  </nav>

  <main class="main">
 
  <form action="#" th:action="@{/showCompany.jsp}" th:object="${company}" method="post">
    <div class=Outterform>
     <input type="text" id="comapany" name="company" th:field="*{company}">
 <!-- <input type="text" id="functions" name="functions" th:field="*{functions}">  -->
     <select  id="functions" name="functions" th:field="*{functions}" >
      <option value="">Select function</option>
      <option th:each="functions : ${functions}" th:value="${functions}" th:text="${functions}"/>
     </select>
     <input type="submit" value="Submit"/>
    </div>
  </form>
  </main>

  <div class="dialog-container">

  </div>

  <div class="loader">
    <!-- Show a spinner or placeholders for content -->
  </div>

 </body>
</html>