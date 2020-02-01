<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
	<form:form method="post" action="/spring-mvc-basics/companies" modelAttribute="company_company">
	   <table>
	      <tr>
	         <td><form:label path="url">company_website</form:label></td> 
             <td><form:input path="url" /></td>     
          </tr> 
          <tr>     
	         <td><form:label path="name">company_name</form:label></td>
             <td><form:input path="name" /></td>
          </tr>

          <tr>
             <td colspan = "2">
                <input type="submit" value="Submit" />
             </td>
          </tr>
	   </table>
    </form:form>
</body>
