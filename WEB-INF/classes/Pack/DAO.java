package Pack;

import Pack.User;
import java.util.*; 
import java.sql.*; 

public class DAO {

    private Connection con;

    public DAO() throws ClassNotFoundException, SQLException {
        establishConnection();
    }

    private void establishConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String conUrl = "jdbc:mysql://127.0.0.1/signin";
        con = DriverManager.getConnection(conUrl, "root", "root");
    }

    public void addUser(User user) throws SQLException {

        String sql = " INSERT INTO user VALUES (?, ?, ?, ?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        String name = user.getName();
        String em = user.getEmail();
        String pass = user.getPassword();
	String type = user.getType();

        pStmt.setString(1, name);
        pStmt.setString(2, em);
        pStmt.setString(3, pass);
	pStmt.setString(4, type);

        pStmt.executeUpdate();

    }

public login authenticate(String em,String p) throws SQLException { 
	login user=null;
String sql = "Select * from user where email='"+em+"' AND password='"+p+"' "; 
Statement st=con.createStatement(); 

ResultSet rs = st.executeQuery(sql); 
   
     if(rs.next())
		{
		String email=rs.getString("email");
		String pass=rs.getString("password");
		String type=rs.getString("type");
		user=new login(email,pass,type);
		}
	return user;
	
}

//user show

public ArrayList retrieveuserList() throws SQLException { 

ArrayList u = new ArrayList(); 

String sql = " SELECT * FROM user "; 
PreparedStatement pStmt = con.prepareStatement(sql);   
ResultSet rs = pStmt.executeQuery(); 

String name; 
String email; 
String pass; 

while ( rs.next() ) { 
name = rs.getString("name"); 
email = rs.getString("email"); 
pass = rs.getString("password");  

User user = new User(); 
user.setName(name); 
user.setEmail(email); 
user.setPassword(pass); 
u.add(user); 

} 

 return u; 

}

//Add Job

    public void addJob(addJob job) throws SQLException {

        String sql = " INSERT INTO Job VALUES (?, ?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        String id = job.getId();
        String name = job.getJname();

        pStmt.setString(1, id);
        pStmt.setString(2, name);

        pStmt.executeUpdate();

    }

//Delete Job

    public void deleteJob(String id) throws SQLException {

        String sql = " delete from Job where id='"+id+"' ";
        Statement pStmt = con.createStatement();

   
        pStmt.executeUpdate(sql);

    }

// show Job

public ArrayList jobList() throws SQLException { 

ArrayList j = new ArrayList(); 

String sql = " SELECT * FROM job "; 
PreparedStatement pStmt = con.prepareStatement(sql);  
ResultSet rs = pStmt.executeQuery(); 

String id; 
String jname;  

while ( rs.next() ) { 
id = rs.getString("id"); 
jname = rs.getString("jname"); 

addJob job = new addJob(); 
job.setId(id); 
job.setJname(jname);  

j.add(job); 

} 

 return j; 

}

//apply job

    public void applyJob(apply a) throws SQLException {

        String sql = " INSERT INTO apply VALUES (?, ?, ?, ?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        String name = a.getName();
        String em = a.getEmail();
        int exp = a.getExperience();
	int age = a.getAge();

        pStmt.setString(1, name);
        pStmt.setString(2, em);
        pStmt.setInt(3, exp);
	pStmt.setInt(4, age);

        pStmt.executeUpdate();

    }

//save job

    public void saveJob(save save) throws SQLException {
	
	String i = save.getId();
        String n = save.getJname();
	String sq="select * from job where jname='"+n+"' and id='"+i+"' ";
	Statement st= con.createStatement();
	ResultSet rs = st.executeQuery(sq);
	if(rs.next()){	        

	String sql = " INSERT INTO save VALUES (?, ?,?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        String id = save.getId();
        String name = save.getJname();
	String e = save.getEmail();
        pStmt.setString(1, id);
        pStmt.setString(2, name);
	pStmt.setString(3, e);
        pStmt.executeUpdate();
	}
    }
//save show

public ArrayList retrieveSaveJob(String n) throws SQLException { 

ArrayList u = new ArrayList(); 

String sql = " SELECT * FROM save where email='"+n+"' "; 
PreparedStatement pStmt = con.prepareStatement(sql);   
ResultSet rs = pStmt.executeQuery(); 

String name; 
String id; 
String pass; 

while ( rs.next() ) { 
name = rs.getString("jname"); 
id = rs.getString("id");  

save save = new save(); 
save.setJname(name); 
save.setId(id); 

u.add(save); 

} 

 return u; 

}


}


