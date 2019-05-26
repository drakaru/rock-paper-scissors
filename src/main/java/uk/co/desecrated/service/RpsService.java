package uk.co.desecrated.service;

/**
 * Rps service interface
 */
public interface RpsService {

    /**
     * Service function that does something
     */
    void processRequest();

    String findOrCreateGame(String player) throws Exception;

    void makeChoice(String id, String player, String choice) throws Exception;

    String getGameStatus(String id) throws Exception;
}
