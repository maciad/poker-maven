package pl.edu.agh.kis.pz1;

public class PlayerMoney {
    private int money = 100;

    public void winMoney(int amount)
    {
        money += amount;
    }

    public void loseMoney(int amount)
    {
        money -= amount;
    }

    public int getMoney() {
        return money;
    }
}
