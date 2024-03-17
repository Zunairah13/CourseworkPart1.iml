package ast;


import java.util.ArrayList;
import java.util.List;

    public class Block extends Stm {
        private List<Stm> statements;

        public Block(Stm... statements) {
            this.statements = new ArrayList<>();
            for (Stm stm : statements) {
                this.statements.add(stm);
            }
        }

        @Override
        public void compile() {
            for (Stm stm : statements) {
                stm.compile();
            }
        }
    }


