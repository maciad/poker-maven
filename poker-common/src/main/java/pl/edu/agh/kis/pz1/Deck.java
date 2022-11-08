package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck = new ArrayList<>();

    //methods

    //method that creates full 52 card deck
    void createDeck()
    {
        for(CardSuit suit : CardSuit.values())
        {
            for(CardRank rank : CardRank.values())
            {
                deck.add(new Card(rank, suit));
            }
        }
    }

    //method that shuffles the deck
    static void shuffle(Deck deck_)
    {
        Collections.shuffle(deck_.deck);
    }

    //method that draws a card from the deck
    public Card drawCard()
    {
        return deck.remove(0);
    }

    @Override
    public String toString()
    {
        StringBuilder cards = new StringBuilder();
        for(Card card : deck)
        {
            cards.append(card);
        }
        return cards.toString();
    }

}
