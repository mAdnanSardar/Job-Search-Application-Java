package Pack;

import java.io.*; 
public class addJob implements Serializable{ 

private String id; 
private String jname; 

public addJob() { 
id = ""; 
jname = ""; 
} 


public void setId(String i){ 
id = i; } 

public void setJname(String n){ 
jname = n; } 

public String getId( ){ 
return id;} 

public String getJname( ){ 
return jname; } 

}