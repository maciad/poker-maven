package pl.edu.agh.kis.pz1;

import java.util.ArrayList;

public class PlayerHand {

    private final ArrayList<Card> hand = new ArrayList<>();
    private final int[] cardsCount = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private PokerRanks rank;

    //methods

    public void addCard(Card card_)
    {
        hand.add(card_);
        cardsCount[card_.getRank().ordinal()]++;
    }

    public void removeCard(Card card_)
    {
        hand.remove(card_);
    }

    public void removeCard(int index_)
    {
        hand.remove(index_);
    }

    public void setHandRank(PokerRanks rank_)
    {
        rank = rank_;
    }

    public PokerRanks getHandRank()
    {
        return rank;
    }

    public Card getCard(int index_)
    {
        return hand.get(index_);
    }

    public void clearHand()
    {
        hand.clear();
    }

    public int getHandSize()
    {
        return hand.size();
    }

    public ArrayList<Card> getCards() {
        return hand;
    }

    public int[] getCardsCount() {
        return cardsCount;
    }
    
    @Override
    public String toString()
    {
        StringBuilder cards = new StringBuilder();
        for(Card card : hand)
        {
            cards.append(card);
        }
        return cards + " " + rank;
    }
    
     public int compareTo(PlayerHand hand_)
    {
        if(this.rank.ordinal() > hand_.rank.ordinal())
        {
            return 1;
        }
        else if(this.rank.ordinal() < hand_.rank.ordinal())
        {
            return -1;
        }
//        else {
//            return switch (this.rank) {
//                case HIGH_CARD -> highCardCompareTo(hand_);
//                case PAIR -> pairCompareTo(hand_);
//                case TWO_PAIR -> twoPairCompareTo(hand_);
//                case THREE_OF_A_KIND -> threeOfAKindCompareTo(hand_);
//                case STRAIGHT -> straightCompareTo(hand_);
//                case FLUSH -> flushCompareTo(hand_);
//                case FULL_HOUSE -> fullHouseCompareTo(hand_);
//                case FOUR_OF_A_KIND -> fourOfAKindCompareTo(hand_);
//                case STRAIGHT_FLUSH -> straightFlushCompareTo(hand_);
//                case ROYAL_FLUSH -> 0;
//                default -> 0;
//            };
        return 0;

    }

}
