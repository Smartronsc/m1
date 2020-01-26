<!DOCTYPE html>
<body>
	<form method="post" action="/spring-mvc-basics/counts" modelAttribute="employee">
	   <form:label path="name">Name</form:label>
          <form:input path="name" />
       <form:label path="id">Id</form:label>
          <form:input path="id" />
       <input type="submit" value="Submit" />
	</form>
</body>
</html>
