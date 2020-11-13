/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.controller;

import food.ac.thaed.test.tamsang.model.entity.ProductOrder;
import food.ac.thaed.test.tamsang.model.message.ProductOrderChangeInfo;
import food.ac.thaed.test.tamsang.model.message.ProductOrderProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.message.ResultMessage;
import food.ac.thaed.test.tamsang.service.ProductOrderProfileService;
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
@RequestMapping("/productorder-profile")
public class ProductOrderProfileController {
    
    @Autowired
    private ProductOrderProfileService productOrderProfileService;
    
    @GetMapping("/list")
    public ResultMessage list() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("222");
        resultMessage.setReturnMessage("SUCCESS");
        resultMessage.setData(productOrderProfileService.findAllProductOrderProfile());    
        return resultMessage;
   }
    @PostMapping("/add-profile")
    public ResultMessage addProfile(@RequestBody ProductOrderProfileRequestMessage productOrderProfileRequestMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("222");
        resultMessage.setReturnMessage("SUCCESS");
        
        ProductOrder productOrder =  productOrderProfileService.saveProfile(productOrderProfileRequestMessage);
        
        resultMessage.setData(productOrder);
        return  resultMessage;
        
    }
    @GetMapping("/delete-profile")
    public ResultMessage addProfile(@RequestParam int id){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("222");
        resultMessage.setReturnMessage("SUCCESS");
        
        productOrderProfileService.deleteProfileById(id);
        
        resultMessage.setData(productOrderProfileService.findAllProductOrderProfile());
        
        return  resultMessage;
        
    }
    @PostMapping("/update-profile")
    public ResultMessage updateProfile(@RequestBody ProductOrderProfileRequestMessage productOrderProfileRequestMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("222");
        resultMessage.setReturnMessage("SUCCESS");
        
        ProductOrderChangeInfo productOrderChangeInfo = productOrderProfileService.updateProfile(productOrderProfileRequestMessage);
        
        resultMessage.setData(productOrderChangeInfo);
        
        return resultMessage;
        
    }
}
