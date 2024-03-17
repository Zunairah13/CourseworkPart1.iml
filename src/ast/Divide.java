package ast;

public class Divide extends Exp{
        public Exp left;
        public Exp right;

        public Divide(Exp left, Exp right) {
            this.left = left;
            this.right = right;
        }
        @Override
        public void compile() {
            left.compile();
            right.compile();
            emit("div");
        }
    }


