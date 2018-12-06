package me.mafrans.adventofcode.day5;

import me.mafrans.adventofcode.general.MaUtil;

import java.io.IOException;
import java.nio.charset.Charset;

public class Puzzle1 {
    public static void main(String[] args) throws IOException {
        String stringInput = MaUtil.readResource("day5-input.txt", Charset.defaultCharset());

        System.out.println("Polymer Length After Reactions: " + destroyPolarOpposites(stringInput));
    }

    public static String destroyPolarOpposites(String in) {
        String out = in.replaceAll("(Aa)|(Bb)|(Cc)|(Dd)|(Ee)|(Ff)|(Gg)|(Hh)|(Ii)|(Jj)|(Kk)|(Ll)|(Mm)|(Nn)|(Oo)|(Pp)|(Qq)|(Rr)|(Ss)|(Tt)|(Uu)|(Vv)|(Ww)|(Xx)|(Yy)|(Zz)|(aA)|(bB)|(cC)|(dD)|(eE)|(fF)|(gG)|(hH)|(iI)|(jJ)|(kK)|(lL)|(mM)|(nN)|(oO)|(pP)|(qQ)|(rR)|(sS)|(tT)|(uU)|(vV)|(wW)|(xX)|(yY)|(zZ)", "");
        if(!out.equals(in)) {
            return destroyPolarOpposites(out);
        }
        return out;
    }
}
