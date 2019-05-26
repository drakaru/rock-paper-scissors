package uk.co.desecrated.game;

/**
 * Alice Houghton, 26/05/2019.
 */
public class Player {
    private String name;
    private Hand choice;

    public Player(String name) {
        this.name = name;
        this.choice = null;
    }

    public void setHand(Hand choice) {
        this.choice = choice;
    }


    public String getName() {
        return name;
    }


    public Hand getChoice() {
        return choice;
    }
}
