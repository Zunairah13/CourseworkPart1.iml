package ast;

public class ExpVariable extends Exp {
    private String name;

    public ExpVariable(String name) {
        this.name = name;
    }

    @Override
    public void compile() {
emit("push "+ name);
        emit("load");
    }

}

