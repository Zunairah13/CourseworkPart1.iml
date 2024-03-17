package ast;

public class Newline extends Stm{

        @Override
        public void compile() {

            emit( "push 2", "sysc");
        }
    }
