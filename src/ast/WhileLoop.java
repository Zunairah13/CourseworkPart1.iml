package ast;

import java.beans.Expression;

public class WhileLoop extends Stm {
    private Exp condition;
    private Stm body;

    public WhileLoop(Exp condition, Stm body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void compile() {
        // Generate a unique label for the beginning of the loop
        String loopStartLabel = AST.freshName("start");

        // Generate a unique label for the end of the loop
        String loopEndLabel = AST.freshName("end");

        // Emit assembly code to jump to the condition evaluation
        emit(loopStartLabel + ":");
        condition.compile();
        emit("push " + loopEndLabel);
        emit("jump_z");
        body.compile();

        // Emit assembly code for the beginning of the loop
        emit("push " + loopStartLabel);
        emit("jump");

        emit(loopEndLabel + ":");
    }
}



