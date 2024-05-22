package com.marcello.course.config;

import com.marcello.course.entities.*;
import com.marcello.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile({"dev", "test"})
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

    @Autowired
    private InsertConfig insertConfig;

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = insertConfig.initializeDataCategory();
        Category cat1 = categories.get(0);
        Category cat2 = categories.get(1);
        Category cat3 = categories.get(2);

        List<Product> products = insertConfig.initializeDataProduct();
        Product p1 = products.get(0);
        Product p2 = products.get(1);
        Product p3 = products.get(2);
        Product p4 = products.get(3);
        Product p5 = products.get(4);

        List<Refund> refunds = insertConfig.initializeDataRefund(p1, p2);
        refundRepository.saveAll(refunds);

        categoryRepository.saveAll(categories);
        productRepository.saveAll(products);

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(products);

        List<Client> clients = insertConfig.initializeDataClient();
        clientRepository.saveAll(clients);

        List<Order> orders = insertConfig.initializeDataOrder(clients.get(0), clients.get(1));
        orderRepository.saveAll(orders);

        List<OrderItem> orderItems = insertConfig.initializeDataOrderItem(orders.get(0), orders.get(1), p1, p3);
        orderItemRepository.saveAll(orderItems);

        Guarantee pay1 = insertConfig.initializeDataGuarantee(orders.get(0));
        orders.get(0).setPayment(pay1);
        orderRepository.save(orders.get(0));
    }

}
