package com.deloitte.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.ms.entity.Cart;

@RestController
@RequestMapping("/get")
public class AuthController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/productlist")
	public List<Object> getProduct() {
		String url="http://localhost:3004/product/getAll";
		Object object= restTemplate.getForObject(url, Object.class);
		return Arrays.asList(object);
	}
	
	@GetMapping("/cartlist/{customername}")
	public List<Object> getCart(@PathVariable String customername) {
		String url="http://localhost:3004/cart/getAll/"+customername;
		Object object= restTemplate.getForObject(url, Object.class);
		return Arrays.asList(object);
	}
	
	@PostMapping("/addtocart/{customername}/{id}")
	public Object addToCart(@PathVariable String customername,@PathVariable Integer id, @RequestBody Cart c) {
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Cart> cart= new HttpEntity<Cart>(c,headers);
		String url="http://localhost:3004/cart/add/"+customername+"/"+id;
		Cart object= restTemplate.postForObject(url,cart,Cart.class);
		String message= "Product added to the cart for "+customername.toUpperCase();
		return message;
	}
	
}

