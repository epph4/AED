/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.service;

import food.ac.thaed.test.tamsang.model.entity.Customer;
import food.ac.thaed.test.tamsang.model.message.CustomerChangeInfo;
import food.ac.thaed.test.tamsang.model.message.CustomerProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.repo.CustomerRepo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AF
 */
@Service
public class CustomerProfileService {
    
    @Autowired
    private CustomerRepo customerRepo;
    
    public List<Customer>findAllCustomerProfile(){
        
        return customerRepo.findAll();
    
    }
    public Customer saveProfile(CustomerProfileRequestMessage customerProfileRequestMessage){
        
        Customer customer = new Customer();
        customer.setFirstName(customerProfileRequestMessage.getFirstName());
        customer.setLastName(customerProfileRequestMessage.getLastName());
        customer.setEmailAddress(customerProfileRequestMessage.getEmailAddress());
        
        customerRepo.save(customer);
        
        return customer;
        
        
    }
    public void deleteProfileById(int id){
        customerRepo.deleteById(id);
    }
    public  CustomerChangeInfo updateProfile(CustomerProfileRequestMessage customerProfileRequestMessage){
        
        Customer oldCustomer = customerRepo.getOne(customerProfileRequestMessage.getId());
        if (oldCustomer == null) {
            return  null;
            
        }
        CustomerChangeInfo customerChangInfo = new CustomerChangeInfo();
        
        Customer tempOldCustomer = new Customer();
        BeanUtils.copyProperties(oldCustomer, tempOldCustomer);
        customerChangInfo.setOldCustomer(tempOldCustomer);
        
        oldCustomer.setFirstName(customerProfileRequestMessage.getFirstName());
        oldCustomer.setLastName(customerProfileRequestMessage.getLastName());
        oldCustomer.setEmailAddress(customerProfileRequestMessage.getEmailAddress());
        customerRepo.save(oldCustomer);
        
        tempOldCustomer = new Customer();
        BeanUtils.copyProperties(oldCustomer, tempOldCustomer);
        
        customerChangInfo.setNewCustomer(tempOldCustomer);
        
        return customerChangInfo;
    }
}
