package com.devsuperior.aula;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.OrderService;
import com.devsuperior.aula.services.ShippingService;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;
	@Autowired
	ShippingService shippingService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o código do pedido:");
		int codigo = sc.nextInt();
		System.out.println("Digite o valor do pedido:");
		double valor = sc.nextDouble();
		System.out.println("Digite o valor do desconto:");
		double desconto = sc.nextDouble();

		Order order = new Order(codigo, valor, desconto);

		System.out.println("Código do pedido: " + order.getCode());
		System.out.printf("Valor Total: R$ %.2f", orderService.total(order) + shippingService.shipping(order));

		sc.close();
	}

}
