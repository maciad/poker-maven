package pl.edu.agh.kis.pz1;

public class EvaluateHandRank {

    static public void evaluateHandRank(Player player)
    {
        // check for royal flush
        if(isRoyalFlush(player))
        {
            player.getHand().setHandRank(PokerRanks.ROYAL_FLUSH);
        }
        //check for straight flush
        else if(isStraightFlush(player))
        {
            player.getHand().setHandRank(PokerRanks.STRAIGHT_FLUSH);
        }
        //check for four of a kind
        else if(isFourOfAKind(player))
        {
            player.getHand().setHandRank(PokerRanks.FOUR_OF_A_KIND);
        }
        //check for full house
        else if(isFullHouse(player))
        {
            player.getHand().setHandRank(PokerRanks.FULL_HOUSE);
        }
        //check for flush
        else if(isFlush(player))
        {
            player.getHand().setHandRank(PokerRanks.FLUSH);
        }
        //check for straight
        else if(isStraight(player))
        {
            player.getHand().setHandRank(PokerRanks.STRAIGHT);
        }
        //check for three of a kind
        else if(isThreeOfAKind(player))
        {
            player.getHand().setHandRank(PokerRanks.THREE_OF_A_KIND);
        }
        //check for two pair
        else if(howManyPair(player) == 2)
        {
            player.getHand().setHandRank(PokerRanks.TWO_PAIR);
        }
        //check for one pair
        else if(howManyPair(player) == 1)
        {
            player.getHand().setHandRank(PokerRanks.ONE_PAIR);
        }
        //check for high card
        else
        {
            player.getHand().setHandRank(PokerRanks.HIGH_CARD);
        }
    }

    static private int howManyPair(Player player)
    {
        int count = 0;
        for(int i = 0; i < 13; i++)
        {
            if(player.getHand().getCardsCount()[i] == 2)
            {
                count ++;
            }
        }
        return count;
    }

    static private boolean isThreeOfAKind(Player player)
    {
        for(int i = 0; i < 13; i++)
        {
            if(player.getHand().getCardsCount()[i] == 3)
            {
                return true;
            }
        }
        return false;
    }

    static private boolean isFourOfAKind(Player player)
    {
        for(int i = 0; i < 13; i++)
        {
            if(player.getHand().getCardsCount()[i] == 4)
            {
                return true;
            }
        }
        return false;
    }

    static private boolean isStraight(Player player)
    {
        //straight with ace as low card
        if( player.getHand().getCardsCount()[0] == 1 && player.getHand().getCardsCount()[1] == 1 &&
            player.getHand().getCardsCount()[2] == 1 && player.getHand().getCardsCount()[3] == 1 &&
            player.getHand().getCardsCount()[12] == 1)
        {
        return true;
        }
        //regular straight
        int count = 0;
        for(int i = 0; i < 13; i++)
        {
            if(player.getHand().getCardsCount()[i] == 1)
            {
                count++;
            }
            else
            {
                count = 0;
            }
            if(count == 5)
            {
                return true;
            }
        }
        return false;
    }

    static private boolean isFlush(Player player)
    {
        CardSuit suit = player.getHand().getCard(0).getSuit();
        for(int i = 1; i < player.getHand().getHandSize(); i++)
        {
            if(player.getHand().getCard(i).getSuit() != suit)
            {
                return false;
            }
        }
        return true;
    }

    static private boolean isFullHouse(Player player)
    {
        return isThreeOfAKind(player) && howManyPair(player) == 1;
    }

    static private boolean isStraightFlush(Player player)
    {
        return isStraight(player) && isFlush(player);
    }

    static private boolean isRoyalFlush(Player player)
    {
        return isStraightFlush(player) &&  player.getHand().getCardsCount()[12] == 1;
    }
}
