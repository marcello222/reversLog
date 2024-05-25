package template;

import com.marcello.course.entities.Client;

public class ClientTemplate {


    public static Client templateClient() {
        Client client = new Client();

        client.setName("Test Client");
        client.setEmail("testclient@email.com");
        client.setTel("123456789");
        client.setPassword("password");

        return client;
    }
}
