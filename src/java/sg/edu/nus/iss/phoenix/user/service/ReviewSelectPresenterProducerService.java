/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;

/**
 *
 * @author dong
 */

public class ReviewSelectPresenterProducerService {
    DAOFactoryImpl factory;
    UserDao userdao;
    
    public ReviewSelectPresenterProducerService(){
        super();
        factory = new DAOFactoryImpl();
        userdao = factory.getUserDAO();
    }
    
    public List<User> reviewSelectPresenterProducer(){
        List<User> data = null;
        try {
            data = userdao.loadAll();
        } catch(SQLException e){
            Logger.getLogger(ReviewSelectPresenterProducerService.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
}
