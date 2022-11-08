package pl.edu.agh.kis.pz1;

public class Player implements Comparable<Player> {
    private final String name;
    private final PlayerHand hand = new PlayerHand();
    private final PlayerMoney money = new PlayerMoney();

    //methods

    public Player(String name_)
    {
        name = name_;
    }

    public String getName()
    {
        return name;
    }

    public PlayerHand getHand()
    {
        return hand;
    }

    public String toString()
    {
        return name + ": " + hand;
    }

    public void drawCards(Deck deck_, int numCards_)
    {
        for(int i = 0; i < numCards_; i++)
        {
            hand.addCard(deck_.drawCard());
        }
    }

    public int compareTo(Player player_)
    {
        return hand.compareTo(player_.getHand());
    }





}
