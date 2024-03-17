package ast;

    public class Plus extends Exp {
        public Exp left;
        public Exp right;

        public Plus(Exp left, Exp right) {
            this.left = left;
            this.right = right;
        }
        @Override
        public void compile() {
            left.compile();
            right.compile();
            emit("add");
        }
    }

