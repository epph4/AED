/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.model.repo;

import food.ac.thaed.test.tamsang.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AF
 */
public interface ProductRepo extends JpaRepository<Product, Integer>{
    
}
