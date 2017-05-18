package org.lorrainejug;

/**
 * Created by gbilley on 18/05/17.
 */
public class Player {

    Tour[] tours = new Tour[12];

    private int tourCourant = 0;

    public void play(int scoreBall1, int scoreBall2) {

        if (tourCourant >= 10) throw new IndexOutOfBoundsException();
        if (scoreBall1 < 0 || scoreBall2 < 0) throw new IllegalArgumentException();
        int score = scoreBall1 + scoreBall2;

        if (score > 10) throw new IllegalArgumentException();


        tours[tourCourant++] = new Tour(scoreBall1, scoreBall2);
    }

    public int getScore(int frame) {
        Tour tourActuel = tours[frame - 1];
        if (tourActuel == null) return 0;
        if (tourActuel.getBonus() == Tour.Bonus.SPARE) {
            Tour tourSuivant = tours[frame];
            return 10 + (tourSuivant == null ? 0 : tourSuivant.getLancer1());
        }
        else if(tourActuel.getBonus() == Tour.Bonus.STRIKE) {
            Tour tourSuivant = tours[frame];
            return 10 + (tourSuivant == null ? 0 : tourSuivant.getLancer1()+tourSuivant.getLancer2());
        }
        return tourActuel.getLancer1() + tourActuel.getLancer2();
    }

    public int getScore() {
        int result = 0;
        for (int i = 0; i < tours.length; i++) {
            result += getScore(i + 1);
        }
        return result;
    }

}
