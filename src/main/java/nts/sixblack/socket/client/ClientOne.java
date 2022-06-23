package nts.sixblack.socket.client;

import nts.sixblack.socket.form.MessageForm;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class ClientOne {
    public static void main(String[] args) throws Exception {
        long userId = 1;
        long channelId = 1;

        Scanner scanner = new Scanner(System.in);
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        ClientOneSessionHandler clientOneSessionHandler = new ClientOneSessionHandler();
        ListenableFuture<StompSession> listenableFuture = stompClient.connect(
                "ws://localhost:8080/ws",clientOneSessionHandler
//                "ws://localhost:8091/websocket-example",clientOneSessionHandler

        );
        StompSession session = listenableFuture.get();
        session.subscribe("/topic/messages/"+userId,clientOneSessionHandler);
        while (true){
            Thread.sleep(2000);
            System.out.print("Said something: ");
            String text = scanner.nextLine();
            session.send("/app/chat", new MessageForm(userId, channelId, text));
        }
    }


}
