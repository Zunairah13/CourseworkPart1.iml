package ast;

import java.util.*;

/**
 * Abstract Syntax Trees for programs.
 */
public class Program extends AST {

    public final List<Stm> statements;

    public Program(List<Stm> statements) {
        this.statements = Collections.unmodifiableList(statements);
    }

    public Program(Stm ...stms) {
        this(Arrays.asList(stms));
    }

    /**
     * Emit SSM assembly code which implements this program.
     */

   protected static Set<String> names = new HashSet<>();
    public void compile() {
        for(Stm stm: statements) {
            stm.compile();
        }
        emit("halt");
        emit(".data");


        // SSM code to allocate statically allocated variables
        // should be emitted here, if needed

        for (String name:names)
            emit(name+ ":"+0);
    }
}
