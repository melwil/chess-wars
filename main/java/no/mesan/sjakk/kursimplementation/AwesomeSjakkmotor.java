package no.mesan.sjakk.kursimplementation;

import no.mesan.sjakk.motor.AbstraktSjakkmotor;
import no.mesan.sjakk.motor.Posisjon;

public class AwesomeSjakkmotor extends AbstraktSjakkmotor {

    @Override
    protected void finnBesteTrekk(Posisjon posisjon) {

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
    	new AwesomeSjakkmotor().start();
    }
}