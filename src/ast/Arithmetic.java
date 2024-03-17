package ast;

public class Arithmetic extends Exp{
        public Exp left;
        public Exp right;
        public String operator;

        public Arithmetic(Exp left, Exp right, String operator) {
            this.left = left;
            this.right = right;
            this.operator = operator;
        }

        @Override
    public void compile() {
        left.compile();
        right.compile();
        if (operator.equals("+")) {
            emit("add");
        } else if (operator.equals("-")) {
            emit("sub");
        } else if (operator.equals("*")) {
            emit("mul");
        } else if (operator.equals("/")) {
            emit("div");
        }
    }

}
