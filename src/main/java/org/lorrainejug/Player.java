package org.lorrainejug;

public class Player {

    Tour[] tours = new Tour[12];

    private int tourCourant = 0;

    public void play(int scoreLancer1, int scoreLancer2) {

        if (tourCourant >= 10) throw new IndexOutOfBoundsException();
        if (scoreLancer1 < 0 || scoreLancer2 < 0) throw new IllegalArgumentException();
        int scoreDuTour = scoreLancer1 + scoreLancer2;

        if (scoreDuTour > 10) throw new IllegalArgumentException();

        tours[tourCourant++] = new Tour(scoreLancer1, scoreLancer2);
    }

    public int getScore(int numTour) {
        Tour tourCourant = tours[numTour - 1];
        if (tourCourant == null) return 0;
        if (tourCourant.getBonus() == Tour.Bonus.SPARE) {
            Tour tourSuivant = tours[numTour];
            return 10 + (tourSuivant == null ? 0 : tourSuivant.getLancer1());
        }
        else if(tourCourant.getBonus() == Tour.Bonus.STRIKE) {
            Tour tourSuivant = tours[numTour];
            if(tourSuivant != null && tourSuivant.getBonus() == Tour.Bonus.STRIKE) {
                Tour tourSuivantSuivant = tours[numTour + 1];
                return 20 + (tourSuivantSuivant == null ? 0 : tourSuivantSuivant.getLancer1() + tourSuivantSuivant.getLancer2());
            } else {
                return 10 + (tourSuivant == null ? 0 : tourSuivant.getLancer1() + tourSuivant.getLancer2());
            }
        }
        else {
            return tourCourant.getLancer1() + tourCourant.getLancer2();
        }
    }

    public int getScore() {
        int score = 0;
        for (int numTour = 1; numTour <= tours.length; numTour++) {
            score += getScore(numTour);
        }
        return score;
    }

}
