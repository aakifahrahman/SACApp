package com.triloaded.sac.contacts;

public class Contact {

    int _id;
    String name;
    String post;
    String phone;
    String email;

    public Contact(){
    	
    }
    
    public Contact(int id, String name, String post, String phone, String email){
        this._id = id;
        this.name = name;
        this.post = post;
        this.phone = phone;
        this.email = email;
    }
     
    
    public int getId(){
        return this._id;
    }
     
    public void setId(int id){
        this._id = id;
    }
     
    public String getName(){
        return this.name;
    }
     
    public void setName(String name){
        this.name = name;
    }
   
    public String getPost(){
        return this.post;
    }
     
    public void setPost(String post){
        this.post = post;
    }
    
    public String getPhone(){
        return this.phone;
    }
     
    public void setPhone(String phone){
        this.phone = phone;
    }
 
    public String getEmail(){
        return this.email;
    }
     
    public void setEmail(String email){
        this.email = email;
    }
}
