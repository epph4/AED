/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.service;

import food.ac.thaed.test.tamsang.model.entity.ProductOrder;
import food.ac.thaed.test.tamsang.model.message.ProductOrderChangeInfo;
import food.ac.thaed.test.tamsang.model.message.ProductOrderProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.repo.ProductOrderRepo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AF
 */
@Service
public class ProductOrderProfileService {
    
    @Autowired
    private ProductOrderRepo productOrderRepo;
    
    public List<ProductOrder>findAllProductOrderProfile(){
        
        return productOrderRepo.findAll();
    }
    public ProductOrder saveProfile(ProductOrderProfileRequestMessage productOrderProfileRequestMessage){
        
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrderNo(productOrderProfileRequestMessage.getOrderNo());
        productOrder.setOrderDate(productOrderProfileRequestMessage.getOrderDate());
        
        productOrderRepo.save(productOrder);
        
        return productOrder;
    }
    public void deleteProfileById(int id){
        productOrderRepo.deleteById(id);  
    }
 public  ProductOrderChangeInfo updateProfile(ProductOrderProfileRequestMessage productOrderProfileRequestMessage){
        
        ProductOrder oldProductOrder = productOrderRepo.getOne(productOrderProfileRequestMessage.getId());
        if (oldProductOrder == null) {
            return  null;
            
        }
        ProductOrderChangeInfo productOrderChangeInfo = new ProductOrderChangeInfo();
        
        ProductOrder tempOldProductOrder= new ProductOrder();
        BeanUtils.copyProperties(oldProductOrder, tempOldProductOrder);
        productOrderChangeInfo.setOldProductOrder(tempOldProductOrder);
        
        oldProductOrder.setOrderNo(productOrderProfileRequestMessage.getOrderNo());
        oldProductOrder.setOrderDate(productOrderProfileRequestMessage.getOrderDate());
        oldProductOrder.save(oldProductOrder);
        
        tempOldProductOrder = new ProductOrder();
        BeanUtils.copyProperties(oldProductOrder, tempOldProductOrder);
        
        productOrderChangeInfo.setNewProductOrder(tempOldProductOrder);
        
        return productOrderChangeInfo;
    }
}
