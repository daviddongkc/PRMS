/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author dong
 */
public class UserService {
    DAOFactoryImpl factory;
    UserDao userdao;
    RoleDao roledao;
    
    public UserService(){
        super();
        // 0909modify
        factory = new DAOFactoryImpl();
        userdao = factory.getUserDAO();
        roledao = factory.getRoleDAO();
    }
    
    public ArrayList<User> searchUsers(User userso){
        ArrayList<User> list = new ArrayList<User>();
        try{
            list = (ArrayList<User>) userdao.searchMatching(userso);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<User> findUserCriteria(User user){
        ArrayList<User> currentList = new ArrayList<User>();
        try{
            currentList = (ArrayList<User>) userdao.searchMatching(user);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return currentList;
    }
    
    public User findUser(String userName) {
        //0909modify whehter userName or userID
        User currentuser = new User();
        currentuser.setName(userName);
        try{
            currentuser = ((ArrayList<User>) userdao.searchMatching(currentuser)).get(0);
            return currentuser;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return currentuser;
    }

    public ArrayList<User> findAllUser() {
        
        ArrayList<User> currentList = new ArrayList<User>();
        try{
            currentList = (ArrayList<User>) userdao.loadAll();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return currentList;
    }
    
    
    public ArrayList<User> findAllPP() {
        
        ArrayList<User> currentList = new ArrayList<>();
        try{
            currentList = (ArrayList<User>) userdao.loadPP();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return currentList;
    }
    
    public void processCreate(User user){
        try{
            userdao.create(user);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void processModify(User user){
        try{
            userdao.save(user);
        } catch(NotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void processDelete(String username){
        //0909modify to check to pass username or userID
        try{
            User user = new User(username);
            userdao.delete(user);
        } catch(NotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }    
}
