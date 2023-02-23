package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.CartDetails;
import com.deloitte.ms.entity.Product;
import com.deloitte.ms.repo.CartRepo;
import com.deloitte.ms.repo.ProductRepo;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ProductRepo productrepo;
	
	@GetMapping("/getAll/{customername}")
	public ResponseEntity<List<CartDetails>> getCartItems(@PathVariable String customername) {
		return new ResponseEntity<List<CartDetails>>(cartRepo.getCartByCustomername(customername), HttpStatus.OK);
	}

	@PostMapping("/add/{customername}/{id}")
	public ResponseEntity<CartDetails> addCart(@PathVariable String customername, @PathVariable Integer id,@RequestBody CartDetails cd)
	{
		CartDetails cart= new CartDetails(cd.getStock(),productrepo.getProductsById(id).getProductCategory(), customername, productrepo.getProductsById(id).getProductName(), productrepo.getProductsById(id).getProductPrice());
		return new ResponseEntity<CartDetails>(cartRepo.save(cart),HttpStatus.OK);
				
	}
	
}
