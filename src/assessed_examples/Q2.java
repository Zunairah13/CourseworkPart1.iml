package assessed_examples;

import ast.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This example outputs 9.
 */
public class Q2 {

    public static void main(String[] args) throws IOException {
        String exampleName = MethodHandles.lookup().lookupClass().getSimpleName();
        Path outpath = Paths.get("ssma/"+ exampleName + ".ssma");

        // Note: the / operator is integer division
        //
        // begin
        //  x := 72;
        //  y := (6 + (x - 9)) / 7;
        //  println y;
        // end
        // ============================================================
        Program p = new Program(

                new Assign("x", new ExpInteger(72)),
                new Assign("y", new Divide(
                        new Plus(new ExpInteger(6), new Minus(new ExpVariable("x"), new ExpInteger(9))),
                        new ExpInteger(7)
                )),
                new StmPrintln(new ExpVariable("y"))
        );


        // ============================================================

        System.out.println("Compiling " + exampleName + "...");
        p.compile();
        System.out.println("Writing...");
        AST.write(outpath);
        System.out.println("... SSM assembly code written to " + outpath);
    }
}
