package nts.sixblack.socket.client;

import nts.sixblack.socket.form.MessageForm;
import nts.sixblack.socket.modelResponse.MessageResponse;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

public class ClientOneSessionHandler implements StompSessionHandler {
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("connect "+session.getSessionId());
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return MessageResponse.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        MessageResponse message = (MessageResponse) payload;
        System.out.println("channel: "+message.getChannelId()+", name: "+message.getName()+", message: "+message.getMessage());
    }
}
