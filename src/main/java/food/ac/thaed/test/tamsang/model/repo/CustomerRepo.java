/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import food.ac.thaed.test.tamsang.model.entity.Customer;

/**
 *
 * @author AF
 */
public interface CustomerRepo extends JpaRepository<Customer,Integer>{

    
}
