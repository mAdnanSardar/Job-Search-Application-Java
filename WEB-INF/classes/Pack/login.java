package Pack;

import java.io.*; 
public class login implements Serializable{ 

private String email; 
private String password;
private String type;


public login(String e,String p) { 

email = e; 
password = p; 
}

public login(String e,String p,String t) { 

email = e; 
password = p; 
type=t;
} 



public void setEmail(String e){ 
email = e; } 

public void setPassword(String p){ 
password = p;} 

public void setType(String t){ 
type = t;}

public String getEmail( ){ 
return email; } 

public String getPassword( ){ 
return password;} 

public String getType( ){ 
return type;}

}