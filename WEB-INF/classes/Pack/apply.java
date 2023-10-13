package Pack;

import java.io.*; 
public class apply implements Serializable{ 

private String name; 
private String email; 
private int experience;
private int age;


public apply() { 
name = ""; 
email = ""; 
experience = 0; 
age=0;
} 


public void setName(String n){ 
name = n; } 

public void setEmail(String e){ 
email = e; } 

public void setExperience(int p){ 
experience = p;}

public void setAge(int a){ 
age = a;} 



public String getName( ){ 
return name;} 

public String getEmail( ){ 
return email; } 

public int getExperience( ){ 
return experience;}

public int getAge( ){ 
return age;} 

}