package patterns.structre.adaprer;

public class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg){
        this.peg = peg;
    }

    public int getRadius(){
        return (int) (peg.getWidth() * Math.sqrt(2) / 2);
    }
}
