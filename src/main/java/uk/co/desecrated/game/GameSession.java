package uk.co.desecrated.game;

/**
 * Alice Houghton, 26/05/2019.
 */
public class GameSession {

    Player player1;
    Player player2;

    public GameSession() {
        this.player1 = null;
        this.player2 = null;
    }

    public void addPlayer(Player player) throws Exception {
        if (player1 == null) {
            this.player1 = player;
        } else if (player2 == null) {
            this.player2 = player;
        } else {
            throw new Exception("Game is full");
        }
    }

    public void makeChoice(String name, String choice) throws Exception {
        if (!this.isFinished()) {
            if (name.equalsIgnoreCase(player1.getName())) {
                player1.setHand(Hand.valueOf(choice.toUpperCase()));
            } else if (name.equalsIgnoreCase(player2.getName())) {
                player2.setHand(Hand.valueOf(choice.toUpperCase()));
            } else {
                throw new Exception("Unknown player: " + name);
            }
        }
    }

    public String getGameState() {
        if (this.waitingForPlayers()) {
            return "Waiting for player(s)!";
        } else if(player1.getChoice() == null) {
            return "Waiting for " + player1.getName() + " to choose a hand!";
        } else if(player2.getChoice() == null) {
            return "Waiting for " + player2.getName() + " to choose a hand!";
        } else {
            Hand hand1 = player1.getChoice();
            Hand hand2 = player2.getChoice();
            if (hand1 == hand2) {
                return "It's a draw!";
            } else {
                String winner = hand1.beats(hand2) ? player1.getName() : player2.getName();
                return hand1.getDisplayName() + " beats " + hand2.getDisplayName() + ", " + winner + " wins!";
            }
        }
    }

    public boolean waitingForPlayers() {
        return player1 == null || player2 == null;
    }

    public boolean isFinished() {
        return !waitingForPlayers() && player1.getChoice() != null && player2.getChoice() != null;
    }
}
