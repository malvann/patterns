package patterns.structre.adaprer;

public class RoundHole {
    int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    public boolean fits(RoundPeg peg){
        return peg.getRadius()<radius;
    }
}
