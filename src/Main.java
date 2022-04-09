import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {
    public static void main(String[] args) throws IOException {
        String source = "test.txt";
        CharStream cs = fromFileName(source);
        gLexer lexer = new gLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gParser parser = new gParser(tokens);

        ParseTree tree = parser.prule();
        MyVisitor visitor = new MyVisitor();

        visitor.visit(tree);


    }
}
