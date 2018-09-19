/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
/**
 *
 * @author dong
 */
public class Users {
    private List <User> userList;
    
    public List<User> getUserList(){
        return userList;
    }
    
    public void setUserList(List<User> userList){
        this.userList = userList;
    }
}
