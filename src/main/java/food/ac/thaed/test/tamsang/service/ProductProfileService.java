/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.service;

import food.ac.thaed.test.tamsang.model.entity.Product;
import food.ac.thaed.test.tamsang.model.message.ProductChangeInfo;
import food.ac.thaed.test.tamsang.model.message.ProductProfileRequestMessage;
import food.ac.thaed.test.tamsang.model.repo.ProductRepo;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AF
 */
@Service
public class ProductProfileService {

    @Autowired
    public ProductRepo productRepo;

    public List<Product> findAllProductProfile() {

        return productRepo.findAll();
    }

    public Product saveProfile(ProductProfileRequestMessage productProfileRequestMessage) {

        Product product = new Product();
        product.setName(productProfileRequestMessage.getName());
        product.setDetail(productProfileRequestMessage.getDetail());
        product.setPrice(productProfileRequestMessage.getPrice());

        productRepo.save(product);

        return product;

    }

    public void deleteProfileById(int id) {
        productRepo.deleteById(id);
    }

    public ProductChangeInfo updateProfile(ProductProfileRequestMessage productProfileRequestMessage) {

        Product oldProduct = productRepo.getOne(productProfileRequestMessage.getId());
        if (oldProduct == null) {
            return null;

        }
        ProductChangeInfo productChangeInfo = new ProductChangeInfo();

        Product tempOldProduct = new Product();
        BeanUtils.copyProperties(oldProduct, tempOldProduct);
        productChangeInfo.setOldProduct(tempOldProduct);

        oldProduct.setDetail(productProfileRequestMessage.getDetail());
        oldProduct.setName(productProfileRequestMessage.getName());
        oldProduct.setPrice(productProfileRequestMessage.getPrice());
        productRepo.save(oldProduct);

        tempOldProduct = new Product();
        BeanUtils.copyProperties(oldProduct, tempOldProduct);

        productChangeInfo.setNewProduct(tempOldProduct);

        return productChangeInfo;

    }

}
