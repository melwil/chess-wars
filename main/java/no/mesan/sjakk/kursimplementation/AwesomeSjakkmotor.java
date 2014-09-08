package no.mesan.sjakk.kursimplementation;

import no.mesan.sjakk.kursimplementation.model.Round;
import no.mesan.sjakk.motor.AbstraktSjakkmotor;
import no.mesan.sjakk.motor.Posisjon;
import no.mesan.sjakk.motor.Trekk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwesomeSjakkmotor extends AbstraktSjakkmotor {

    private static boolean debug = true;
    private static boolean debug2 = true;

    private int moveCounter = 0;
    private long startTime = 0;

    private List<Round> deeperAnalysis = new ArrayList<>();

    @Override
    protected void finnBesteTrekk(Posisjon posisjon) {
        moveCounter++;
        startTime = System.currentTimeMillis();
        deeperAnalysis.clear();

        if (debug) {
            Logger.log("--- New evaluation --------");
            Logger.log(" My moves: " +Arrays.toString(posisjon.alleLovligeTrekkPrimitiv()));
        }



        /*
            Initial analysis
         */
        int minBesteScore = Integer.MIN_VALUE;
        for (final Trekk mittTrekk : posisjon.alleTrekk()) {
            posisjon.gjorTrekk(mittTrekk);
            int motstandersBesteScore = Integer.MAX_VALUE;
            for (final Trekk motstandersTrekk : posisjon.alleTrekk()) {
                posisjon.gjorTrekk(motstandersTrekk);
                motstandersBesteScore = Math.min(motstandersBesteScore,
                        posisjon.sumAvMateriellPaaBrettet());
                deeperAnalysis.add(new Round(mittTrekk.move().getShortMoveDesc(), motstandersTrekk.move().getShortMoveDesc(), minBesteScore, motstandersBesteScore));
                posisjon.taTilbakeSisteTrekk();
            }
            posisjon.taTilbakeSisteTrekk();
            if (minBesteScore < motstandersBesteScore) {
                minBesteScore = motstandersBesteScore;
                settBesteTrekk(mittTrekk);
            }
        }

        /*
            Deeper analysis beyond initial calculation
         */
        for (Round round : deeperAnalysis) {

        }

        if (debug) {
            long endTime = System.currentTimeMillis() - startTime;
            Logger.log("--- Evaluation end -- Time: "+endTime+"ms");
        }
    }

    private Trekk dypereAnalyseForSlagTrekk() {


        return null;
    }

    @Override
    public String lagetAv() {
        return "Håvard og Aleksander";
    }

    @Override
    public String navn() {
        return "42 hamsters & 1 drunk cat";
    }

    public static void main(String[] args) {
        if (debug) Logger.clean();
    	new AwesomeSjakkmotor().start();
    }


}