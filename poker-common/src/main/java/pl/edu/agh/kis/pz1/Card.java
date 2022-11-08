package pl.edu.agh.kis.pz1;

import java.util.Objects;

public class Card {
    CardRank rank;
    CardSuit suit;

    Card(CardRank rank_, CardSuit suit_)
    {
        rank = rank_;
        suit = suit_;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "[" + rank + suit + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

}
