package ast;

public class Minus extends Exp {
        public Exp left;
        public Exp right;

        public Minus(Exp left, Exp right) {
            this.left = left;
            this.right = right;
        }
        @Override
        public void compile() {
            left.compile();
            right.compile();
            emit("sub");
        }
    }


