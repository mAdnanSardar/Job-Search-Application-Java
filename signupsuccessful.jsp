<%@page errorPage="Error.jsp" %> 
<%
   if (session.getAttribute("type")==null)
	{
		response.sendRedirect("index.html");
	} 
else {
%>
<html><body><center> 

<h1>SignUp successfully!</h1> 

</center></body></html> 
<%
}
%>