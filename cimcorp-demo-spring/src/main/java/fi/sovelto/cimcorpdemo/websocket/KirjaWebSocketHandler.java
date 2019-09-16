package fi.sovelto.cimcorpdemo.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fi.sovelto.cimcorpdemo.KirjaEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class KirjaWebSocketHandler extends TextWebSocketHandler {
    private static List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private static final Logger logger = Logger.getLogger("KirjaWebSocketHandler");

    @EventListener
    public void kirjaLisättyEventListener(KirjaEvent event) throws IOException {
        for(WebSocketSession session : sessions) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(event.getMessage());
                session.sendMessage(new TextMessage(json));
            } catch (JsonProcessingException e) {
                logger.log(Level.SEVERE, e.toString());
            }
        }

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        logger.info("Lisätty sessio, nyt " + sessions.size());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        logger.info("Poistettu sessio, jäljellä " + sessions.size());
    }
}