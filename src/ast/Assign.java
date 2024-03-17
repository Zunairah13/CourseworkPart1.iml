package ast;

    public class Assign extends Stm {
        private String name;
        private Exp expression;

        public Assign(String name, Exp expression) {
            this.name= name;
            this.expression = expression;
        }

        @Override
        public void compile() {
            expression.compile();
            // Emit assembly code for assignment to variable
            emit("push "+ name);
            emit("store");
            Program.names.add(name);
        }
    }
