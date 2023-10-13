package Pack;

import java.io.*; 
public class save implements Serializable{ 

private String id; 
private String jname; 
private String email;
public save() { 
id = ""; 
jname = ""; 
email ="";
} 


public void setId(String i){ 
id = i; } 

public void setJname(String n){ 
jname = n; } 

public void setEmail(String e){ 
email = e; }

public String getId( ){ 
return id;} 

public String getJname( ){ 
return jname; } 

public String getEmail( ){ 
return email;} 

}