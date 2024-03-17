package ast;

    public class IfElse extends Stm {
        private Exp condition;
        private Stm thenBranch;
        private Stm elseBranch;

        public IfElse(Exp condition, Stm thenBranch, Stm elseBranch) {
            this.condition = condition;
            this.thenBranch = thenBranch;
            this.elseBranch = elseBranch;
        }

        @Override
        public void compile() {
            // Generate unique labels for the then and else branches
            String elseLabel = AST.freshName("else");
            String thenLabel = AST.freshName("then");



            // Compile the condition expression
            condition.compile();

            // Jump to else label if condition is false
            emit("push "+elseLabel);
            emit("jump_z ");

            // Compile then branch

            thenBranch.compile();

            emit("push " + thenLabel);
            emit("jump");
            emit(elseLabel+ ":");

            elseBranch.compile();

            // End label
            emit(thenLabel+":");
        }
    }


