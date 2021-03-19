package patterns.structre.flyweight.flyweight;

public class Tree {
    int x;
    int y;
    int height;

    public Tree(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public void draw() {
        System.out.println("[" +x + ","+y+","+height+"]");
    }
}
