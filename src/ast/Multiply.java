package ast;

public class Multiply extends Exp {
    public Exp left;
    public Exp right;

    public Multiply(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public void compile() {
        left.compile();
        right.compile();
        emit("mul");
    }
}

