package Pack;

import java.io.*; 
public class User implements Serializable{ 

private String name; 
private String email; 
private String password;
private String type;


public User() { 
name = ""; 
email = ""; 
password = ""; 
type="";
} 


public void setName(String n){ 
name = n; } 

public void setEmail(String e){ 
email = e; } 

public void setPassword(String p){ 
password = p;}

public void setType(String t){ 
type = t;} 



public String getName( ){ 
return name;} 

public String getEmail( ){ 
return email; } 

public String getPassword( ){ 
return password;}

public String getType( ){ 
return type;} 

}