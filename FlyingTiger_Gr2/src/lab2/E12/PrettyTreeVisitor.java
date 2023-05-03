package lab2.E12;

public class PrettyTreeVisitor<T> implements TreeVisitor<T, String, Integer> {

    public String visit(Leaf<T> leaf, Integer val) {

        String indent = "";
        for (int i = 0; i < val; i++) {
            indent += "\t";
            // indent += " ";
        }
        return indent + leaf.getValue();
    }

    public String visit(Node<T> node, Integer val) {
        // return "";

        String result = "";
        for (Tree<T> t : node.getChildred()) {
            result += t.accept(this, val + 1) + "\n";
        }
        String indent = "";
        for (int i = 0; i < val; i++) {
            indent += "\t";
        }
        return indent + node.getValue() + " \n " + result;

    }
}