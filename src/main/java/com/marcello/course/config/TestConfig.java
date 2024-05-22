package com.marcello.course.config;

import java.time.Instant;
import java.util.Arrays;

import com.marcello.course.entities.*;
import com.marcello.course.entities.enums.GuaranteeStatus;
import com.marcello.course.entities.enums.RefundStatus;
import com.marcello.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcello.course.entities.enums.OrderStatus;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private RefundRepository refundRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Accessories");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "Mouse", "perde conexão via bluetooth", 90.5, "imagemDefeitoMouse.png");
		Product p2 = new Product(null, "Smart TV", "falha no led da tela", 2190.0, "imagemDefeitoTela.png");
		Product p3 = new Product(null, "Macbook Pro", "Problema na fonte.", 1250.0, "imagemDefeitoMacbbok.png");
		Product p4 = new Product(null, "PC Gamer", "Windows não esta ativado", 1200.0, "imagemDefeitoPcGamer.png");
		Product p5 = new Product(null, "Teclado", "Não funciona tecla enter", 100.99, "imagemDefeitoTeclado.png");

		Refund rev1 = new Refund(null, "R$1.2334,00", RefundStatus.VALUE, null,  p1);
		Refund rev2 = new Refund(null, null, RefundStatus.VOUCHER, "R$2.538,00",  p2);

		refundRepository.saveAll(Arrays.asList(rev1, rev2));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Client u1 = new Client(null, "João Alves", "joao@gmail.com", "9888488888", "123456");
		Client u2 = new Client(null, "Joana Maria", "joana@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WITHIN_WARRANTY, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.OUT_OF_WARRANTY, u2);

		clientRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

		Guarantee pay1 = new Guarantee(null, GuaranteeStatus.OUT_GUARANTEE, Instant.parse("2019-06-20T21:53:07Z"), o1 );
		o1.setPayment(pay1);

		orderRepository.save(o1);

	}

}
