package pl.whattoeat.whattoeat_spring.model;

public class MatchPercent {
    private static int matchPercent = 50;

    public static int getMatchPercent() {
        return matchPercent;
    }

    public static void setMatchPercent(int matchPercent) {
        MatchPercent.matchPercent = matchPercent;
    }
}
