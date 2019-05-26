package uk.co.desecrated.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.desecrated.game.GameSession;
import uk.co.desecrated.game.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RpsServiceImpl implements RpsService {

    private static final Map<String, GameSession> gameSessions = new ConcurrentHashMap<>();

    @Override
    public void processRequest() {
        // todo : implement
    }

    @Override
    public String findOrCreateGame(String player) throws Exception {
        synchronized (gameSessions) {
            for (String sessionId : gameSessions.keySet()) {
                GameSession session = gameSessions.get(sessionId);
                if (session.waitingForPlayers()) {
                    session.addPlayer(new Player(player));
                    return sessionId;
                }
            }

            GameSession session = new GameSession();
            session.addPlayer(new Player(player));
            String sessionId = UUID.randomUUID().toString();
            gameSessions.put(sessionId, session);
            return sessionId;
        }
    }

    @Override
    public void makeChoice(String id, String player, String choice) throws Exception {
        synchronized (gameSessions) {
            GameSession session = gameSessions.get(id);
            session.makeChoice(player, choice);
        }
    }

    @Override
    public String getGameStatus(String id) throws Exception {
        if (gameSessions.containsKey(id)) {
            return gameSessions.get(id).getGameState();
        } else {
            throw new Exception("Game not found.");
        }
    }

}
