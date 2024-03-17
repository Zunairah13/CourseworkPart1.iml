package ast;

public class Print extends Stm {
    private Exp expression;

    public Print(Exp expression) {
        this.expression = expression;
    }

    @Override
    public void compile() {
        // Emit assembly code for print statement
        expression.compile();
        emit("push 3", "sysc");
    }
    }

