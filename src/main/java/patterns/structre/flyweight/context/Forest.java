package patterns.structre.flyweight.context;

import patterns.structre.flyweight.flyweight.Tree;

import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees = new ArrayList<>();

    public void setTree (Tree tree) {
        trees.add(tree);
    }

    public void removeTree(Tree tree){
        trees.remove(tree);
    }

    public int countTrees(){
        return trees.size();
    }
}
