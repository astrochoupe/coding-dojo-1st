package org.lorrainejug;

/**
 * Created by gbilley on 18/05/17.
 */
public class Tour {

    int lancer1;
    int lancer2;
    Bonus bonus;
    enum Bonus { SPARE, STRIKE, AUCUN};

    public Tour(final int lancer1, final int lancer2) {
        this.lancer1 = lancer1;
        this.lancer2 = lancer2;
        if(lancer1 == 10)
            bonus = Bonus.STRIKE;
        else if(lancer1+lancer2 ==10)
            bonus=Bonus.SPARE;
        else
            bonus = Bonus.AUCUN;
    }

    public int getLancer1() {
        return lancer1;
    }

    public int getLancer2() {
        return lancer2;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
