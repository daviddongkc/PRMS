/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

/**
 *
 * @author dong
 */
import java.util.ArrayList;

import sg.edu.nus.iss.phoenix.authenticate.entity.UserSearchObject;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.user.service.UserService;

public class UserDelegate {
    
    public ArrayList<User> findAllUser(){
        UserService service = new UserService();
        return service.findAllUser();
    }
    
    public void procesCreate(User user){
        UserService service = new UserService();
        service.processCreate(user);
    }
    
    public void procesModify(User user){
        UserService service = new UserService();
        service.processModify(user);
    }

    public void procesDelete(String username){
        // 0909modify username or ID?
        UserService service = new UserService();
        service.processDelete(username);
    } 
    
    public ArrayList<User> findAllPP(){
        UserService service = new UserService();
        return service.findAllPP();
    }
}
