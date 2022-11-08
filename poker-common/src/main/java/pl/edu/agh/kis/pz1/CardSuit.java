package pl.edu.agh.kis.pz1;

public enum CardSuit {
    HEARTS("♥"),
    CLUBS("♣"),
    DIAMONDS("♦"),
    SPADES("♠");

    private final String DisplayName;

    CardSuit(String DisplayName_)
    {
        DisplayName = DisplayName_;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
