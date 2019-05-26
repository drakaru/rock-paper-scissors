package uk.co.desecrated.game;

/**
 * Alice Houghton, 26/05/2019.
 */
public enum Hand {

    SCISSORS("Scissors"),
    PAPER("Paper"),
    ROCK("Rock");

    private String displayName;

    Hand(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean beats(Hand other) {
        return other.ordinal() == this.ordinal() + 1 || this == ROCK && other == SCISSORS;
    }

    public static void main(String[] args) {
        System.out.println(Hand.valueOf("ROCK").getDisplayName());
        System.out.println("SCISSORS.beats(PAPER): " + SCISSORS.beats(PAPER));
        System.out.println("SCISSORS.beats(ROCK): " + SCISSORS.beats(ROCK));
        System.out.println("PAPER.beats(ROCK): " + PAPER.beats(ROCK));
        System.out.println("PAPER.beats(SCISSORS): " + PAPER.beats(SCISSORS));
        System.out.println("ROCK.beats(PAPER): " + ROCK.beats(PAPER));
        System.out.println("ROCK.beats(SCISSORS): " + ROCK.beats(SCISSORS));
    }
}
