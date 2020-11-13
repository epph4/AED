/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.controller;

import food.ac.thaed.test.tamsang.model.entity.Customer;
import food.ac.thaed.test.tamsang.model.message.CustomerChangeInfo;
import food.ac.thaed.test.tamsang.model.message.CustomerProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.message.ResultMessage;
import food.ac.thaed.test.tamsang.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AF
 */
@RestController
@RequestMapping("/customer-profile")
public class CostomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;
    
    @GetMapping("/list")
    public ResultMessage list() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS");
        resultMessage.setData(customerProfileService.findAllCustomerProfile());
        return resultMessage;
    }
    @PostMapping("/add-profile")
    public ResultMessage addProfile(@RequestBody CustomerProfileRequestMessage customerProfileRequestMessage ){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS");
        
        Customer customer = customerProfileService.saveProfile(customerProfileRequestMessage);
        
        resultMessage.setData(customer);
        return resultMessage;
                
        
    }
    @GetMapping("/delete-profile")
    public ResultMessage addProfile(@RequestParam int id){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS");
        
        customerProfileService.deleteProfileById(id);
        
        resultMessage.setData(customerProfileService.findAllCustomerProfile());
        
        return resultMessage;
        
    }
    @PostMapping("/update-profile")
    public ResultMessage updateProfile(@RequestBody CustomerProfileRequestMessage customerProfileRequestMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("000");
        resultMessage.setReturnMessage("SUCCESS");
        
        CustomerChangeInfo customerChangeInfo = customerProfileService.updateProfile(customerProfileRequestMessage);
        
        resultMessage.setData(customerChangeInfo);
        
        return  resultMessage;
    }

}
