package pl.edu.agh.kis.pz1;

public enum CardRank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String DisplayName;

    CardRank(String DisplayName_)
    {
        DisplayName = DisplayName_;
    }

    public String getDisplayName()
    {
        return DisplayName;
    }

    @Override
    public String toString()
    {
        return getDisplayName();
    }
}
