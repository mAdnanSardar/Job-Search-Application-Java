package Pack;

import java.io.*;
import java.sql.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*; 
public class ControllerServlet extends HttpServlet {


// This method only calls processRequest() 

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
         ServletException, IOException {
  processRequest(request, response);
 }

 // This method only calls processRequest()
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
         ServletException, IOException {
  processRequest(request, response);
 }

 protected void processRequest(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {

  String userAction = request.getParameter("action");


  if (userAction.equals("Sign")) {
   addUser(request, response);
  }
if (userAction.equals("SignIn")) {
   Login(request, response);
  }
if (userAction.equals("logout")) {
   logout(request, response);
  }
if (userAction.equals("show")) {
   showUser(request, response);
  }
if (userAction.equals("Add Job")) {
   addJob(request, response);
  }
if (userAction.equals("delete")) {
   deleteJob(request, response);
  }
if (userAction.equals("Search")) {
   showJob(request, response);
  }
if (userAction.equals("Apply")) {
   Apply(request, response);
  }
if (userAction.equals("Save")) {
   saveJob(request, response);
  }
if (userAction.equals("Show")) {
   saveJobDetails(request, response);
  }

 } //EnD

// ADD USER

 private void addUser(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  try {
   DAO uDAO = new DAO();

   User user = new User();

   String uName = request.getParameter("name");
   user.setName(uName);

   String em = request.getParameter("email");
   user.setEmail(em);

   String p = request.getParameter("password");
   user.setPassword(p);

   String t = request.getParameter("type");
   user.setType(t);

   uDAO.addUser(user);


   response.sendRedirect("signupsuccessful.jsp");
  } catch (SQLException sqlex) {

// setting SQLException instance 
   request.setAttribute("javax.servlet.jsp.JspException", sqlex);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  } catch (ClassNotFoundException cnfe) {

   // setting ClassNotFoundException instance
   request.setAttribute("javax.servlet.jsp.JspException", cnfe);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  }

 }


private void Login(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try {

String email = request.getParameter("email"); 
String password = request.getParameter("password");
DAO lDAO = new DAO(); 
// User Authentication

 String ty = "";
 login user = lDAO.authenticate(email,password);
if(user==null){
 RequestDispatcher rd = request.getRequestDispatcher("index.html"); 
 rd.forward(request, response);}
else{
ty = user.getType();
if(!ty.equals("admin")){
  	
	String y = user.getType();
	HttpSession session = request.getSession(true);
	session.setAttribute("type",y);
	session.setAttribute("email",email);	

	RequestDispatcher rd = request.getRequestDispatcher("loginsuccessful.jsp"); 
 rd.forward(request, response);}
else{
	String t = user.getType();
	HttpSession session = request.getSession(true);
	session.setAttribute("type",t);

 RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
 rd.forward(request, response);}
}
}
catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 

}catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response);}
 
}

//log out

private void logout(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
	HttpSession session = request.getSession();		
	session.invalidate();
	
 RequestDispatcher rd = request.getRequestDispatcher("index.html"); 
 rd.forward(request, response); 
}

//show user details

private void showUser(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try {

DAO uDAO = new DAO(); 


ArrayList list = uDAO.retrieveuserList(); 
request.setAttribute("l", list); 


 RequestDispatcher rd = request.getRequestDispatcher("showuser.jsp"); 
 rd.forward(request, response); 
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 

}catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response); 


} 
}

// ADD JOB
 private void addJob(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  try {
   DAO uDAO = new DAO();

   addJob job = new addJob();

   String id = request.getParameter("id");
   job.setId(id);

   String na = request.getParameter("jname");
   job.setJname(na);

   uDAO.addJob(job);


   response.sendRedirect("admin.jsp");
  } catch (SQLException sqlex) {

// setting SQLException instance 
   request.setAttribute("javax.servlet.jsp.JspException", sqlex);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  } catch (ClassNotFoundException cnfe) {

   // setting ClassNotFoundException instance
   request.setAttribute("javax.servlet.jsp.JspException", cnfe);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  }

 }

//Delete Job

private void deleteJob(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try {

DAO uDAO = new DAO(); 

String id = request.getParameter("id"); 
	uDAO.deleteJob(id); 

 RequestDispatcher rd = request.getRequestDispatcher("delete.jsp"); 
 rd.forward(request, response); 
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 

}catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response); 


} 
}

//show job details

private void showJob(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try {

DAO uDAO = new DAO(); 

ArrayList List = uDAO.jobList(); 
request.setAttribute("list", List); 


 RequestDispatcher rd = request.getRequestDispatcher("showjob.jsp"); 
 rd.forward(request, response); 
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 

}catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response); 


} 
}

//Apply Job

private void applyJob(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException {


 RequestDispatcher rd = request.getRequestDispatcher("jobapply.jsp"); 
 rd.forward(request, response); 
}

//Apply Job

private void Apply(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ try 

{
 DAO pDAO = new DAO(); 

 apply user = new apply();

 String Name = request.getParameter("name"); 
 user.setName(Name); 

 String email = request.getParameter("email"); 
 user.setEmail(email); 
 
 String e = request.getParameter("experience"); 
 int exp = Integer.parseInt(e); 
 user.setExperience(exp); 

String a = request.getParameter("age"); 
 int age = Integer.parseInt(a); 
 user.setAge(age); 


pDAO.applyJob(user); 


 response.sendRedirect("jobapply.jsp"); 
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response); } 

catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance 
request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 
} 

} 

//Save JOB
 private void saveJob(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  try {
   DAO uDAO = new DAO();

   save save = new save();

   String id = request.getParameter("id");
   save.setId(id);

   String na = request.getParameter("jname");
   save.setJname(na);
	
   String e = request.getParameter("email");
   save.setEmail(e);

   uDAO.saveJob(save);


   response.sendRedirect("loginsuccessful.jsp");
  } catch (SQLException sqlex) {

// setting SQLException instance 
   request.setAttribute("javax.servlet.jsp.JspException", sqlex);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  } catch (ClassNotFoundException cnfe) {

   // setting ClassNotFoundException instance
   request.setAttribute("javax.servlet.jsp.JspException", cnfe);
   RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
   rd.forward(request, response);
  }

 }

//save job details

private void saveJobDetails(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException { 
try {

DAO uDAO = new DAO(); 
HttpSession session=request.getSession(false);
String email = (String)session.getAttribute("email");
ArrayList List = uDAO.retrieveSaveJob(email); 
request.setAttribute("list", List); 


 RequestDispatcher rd = request.getRequestDispatcher("showSaveJob.jsp"); 
 rd.forward(request, response); 
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
rd.forward(request,response); 

}catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
rd.forward(request, response); 


} 
}




}




