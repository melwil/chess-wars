package no.mesan.sjakk.kursimplementation.model;

/**
 * @author Håvard Slettvold
 */
public class Round {

    private short myMove;
    private short hisMove;

    private int minBesteScore;
    private int motstanderBesteScore;

    public Round(short myMove, short hisMove, int minBesteScore, int motstanderBesteScore) {
        this.myMove = myMove;
        this.hisMove = hisMove;
        this.minBesteScore = minBesteScore;
        this.motstanderBesteScore = motstanderBesteScore;
    }

    public short getMyMove() {
        return myMove;
    }

    public short getHisMove() {
        return hisMove;
    }

    public int getMinBesteScore() {
        return minBesteScore;
    }

    public int getMotstanderBesteScore() {
        return motstanderBesteScore;
    }
}
