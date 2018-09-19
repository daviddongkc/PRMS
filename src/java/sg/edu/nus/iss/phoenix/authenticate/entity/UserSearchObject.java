/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.authenticate.entity;

import java.util.ArrayList;

/**
 *
 * @author dong
 */
public class UserSearchObject extends User{
    // 0909modify is extends User needed???
    private String id;
    private String name;
    private String password;
    private ArrayList<Role> roles = new ArrayList<Role>();
    
    public UserSearchObject(){
        super();
    }
    public UserSearchObject(String id){
        super();
        this.id = id;
    }
    
    public String getid(){
        return id;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword (String password){
        this.password = password;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public ArrayList<Role> getRoles(){
        return roles;
    }
    
    public void setRole(ArrayList<Role> roles){
        this.roles = roles;
    }
    
}
