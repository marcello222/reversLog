package com.marcello.course.config;

import com.marcello.course.entities.*;
import com.marcello.course.entities.enums.GuaranteeStatus;
import com.marcello.course.entities.enums.OrderStatus;
import com.marcello.course.entities.enums.RefundStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Component
public class InsertConfig {

    List<Product> initializeDataProduct() {
        Product p1 = Product.builder()
                .name("Mouse")
                .defectDescription("perde conexão via bluetooth")
                .price(90.5)
                .imgUrl("imagemDefeitoMouse.png")
                .build();

        Product p2 = Product.builder()
                .name("Smart TV")
                .defectDescription("falha no led da tela")
                .price(2190.0)
                .imgUrl("imagemDefeitoTela.png")
                .build();

        Product p3 = Product.builder()
                .name("Macbook Pro")
                .defectDescription("Problema na fonte.")
                .price(1250.0)
                .imgUrl("imagemDefeitoMacbbok.png")
                .build();

        Product p4 = Product.builder()
                .name("PC Gamer")
                .defectDescription("Windows não esta ativado")
                .price(1200.0)
                .imgUrl("imagemDefeitoPcGamer.png")
                .build();

        Product p5 = Product.builder()
                .name("Teclado")
                .defectDescription("Não funciona tecla enter")
                .price(100.99)
                .imgUrl("imagemDefeitoTeclado.png")
                .build();

        return Arrays.asList(p1, p2, p3, p4, p5);
    }

    List<Category> initializeDataCategory() {
        Category cat1 = Category.builder()
                .id(null)
                .name("Electronics")
                .build();

        Category cat2 = Category.builder()
                .id(null)
                .name("Accessories")
                .build();

        Category cat3 = Category.builder()
                .id(null)
                .name("Computers")
                .build();

        return Arrays.asList(cat1, cat2, cat3);
    }

    List<Refund> initializeDataRefund(Product p1, Product p2) {
        Refund rev1 = new Refund(null, "R$1.2334,00", RefundStatus.VALUE, null,  p1);
        Refund rev2 = new Refund(null, null, RefundStatus.VOUCHER, "R$2.538,00",  p2);

        return Arrays.asList(rev1, rev2);
    }

    List<Client> initializeDataClient() {
        Client u1 = new Client(null, "João Alves", "joao@gmail.com", "9888488888", "123456");
        Client u2 = new Client(null, "Joana Maria", "joana@gmail.com", "977777777", "123456");

        return Arrays.asList(u1, u2);
    }


    List<Order> initializeDataOrder(Client u1, Client u2) {
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WITHIN_WARRANTY, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.OUT_OF_WARRANTY, u2);

        return Arrays.asList(o1, o2);
    }


    List<OrderItem> initializeDataOrderItem(Order o1, Order o2, Product p1, Product p3) {
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

        return Arrays.asList(oi1, oi2, oi3);
    }

    Guarantee initializeDataGuarantee(Order o1) {
        return Guarantee.builder()
                .guaranteeStatusCode(GuaranteeStatus.OUT_GUARANTEE.getCode())
                .purchaseDate(Instant.parse("2019-06-20T21:53:07Z"))
                .order(o1)
                .build();
    }

}
