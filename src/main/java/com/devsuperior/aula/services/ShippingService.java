package com.devsuperior.aula.services;

import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Order;

@Service
public class ShippingService {
	
	double valorFrete;
	
	public double shipping(Order order) {
		if(order.getBasic() < 100.00) {
			valorFrete = 20.00;
		}else if(order.getBasic() >= 100.00 && order.getBasic() <= 300.00) {			
			valorFrete = 12.00;
		}else if(order.getBasic() > 300.00){
			valorFrete = 0.0;
		}
		return valorFrete;
	}
}
