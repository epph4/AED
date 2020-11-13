/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.controller;

import food.ac.thaed.test.tamsang.model.entity.Product;
import food.ac.thaed.test.tamsang.model.message.ProductChangeInfo;
import food.ac.thaed.test.tamsang.model.message.ProductProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.message.ResultMessage;
import food.ac.thaed.test.tamsang.service.ProductProfileService;
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
@RequestMapping("/product-profile")
public class ProductProfileContorller {
    
    @Autowired
    private ProductProfileService productProfileService;
    
    @GetMapping("/list")
    public ResultMessage list() {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("111");
        resultMessage.setReturnMessage("SUCCESS");
        resultMessage.setData(productProfileService.findAllProductProfile());
        return resultMessage;
    }
    @PostMapping("/add-profile")
    public ResultMessage addProfile(@RequestBody ProductProfileRequestMessage productProfileRequestMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("111");
        resultMessage.setReturnMessage("SUCCESS");
        
        Product product =  productProfileService.saveProfile(productProfileRequestMessage);
        
        resultMessage.setData(product);
        return  resultMessage;
        
    }
    @GetMapping("/delete-profile")
    public ResultMessage addProfile(@RequestParam int id){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("111");
        resultMessage.setReturnMessage("SUCCESS");
        
        productProfileService.deleteProfileById(id);
        
        resultMessage.setData(productProfileService.findAllProductProfile());
        
        return  resultMessage;
        
    }
    @PostMapping("/update-profile")
    public ResultMessage updateProfile(@RequestBody ProductProfileRequestMessage productProfileRequestMessage){
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setReturnCode("111");
        resultMessage.setReturnMessage("SUCCESS");
        
        ProductChangeInfo productChangeInfo = productProfileService.updateProfile(productProfileRequestMessage);
        
        resultMessage.setData(productChangeInfo);
        
        return resultMessage;
        
    }
}
