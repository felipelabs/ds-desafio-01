package com.devsuperior.aula.services;

import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Order;

@Service
public class OrderService {
	
	public double total(Order order) {
		return order.getBasic() - ((order.getDiscount() / 100) * order.getBasic());
	}
}
