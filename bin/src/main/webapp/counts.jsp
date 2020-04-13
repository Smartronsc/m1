<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
	<form:form method="post" action="/spring-mvc-basics/counts" modelAttribute="employee">
	   <table>
	      <tr>
	         <td><form:label path="url">Address</form:label></td> 
             <td><form:input path="url" /></td>     
          </tr> 
          <tr>     
	         <td><form:label path="name">Name</form:label></td>
             <td><form:input path="name" /></td>
          </tr>
          <tr>  
             <td><form:label path="id">Id</form:label></td>
             <td><form:input path="id" /></td>
          </tr>
          <tr>
             <td colspan = "2">
                <input type="submit" value="Submit" />
             </td>
          </tr>
	   </table>
    </form:form>
</body>
