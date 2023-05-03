package lab2.E12;
import java.util.*;

public class ListLeavesVisitor<T> implements TreeVisitor<T, List<T>, List<T>> {

	// private List<T> result = new ArrayList<T>();

	
	public List<T> visit(Leaf<T> leaf, List<T> currResult) {
		currResult.add(leaf.getValue());
		return currResult;
		// This is not really needed, the result is collected
		// in the instance variable
		// unless the Lead is the only thing in the structure and it returns
		// the final result from here
	}

	
	public List<T> visit(Node<T> node, List<T> currResult) {
		for (Tree<T> c : node.getChildred()) {
			c.accept(this, currResult);
		}
		return currResult;
	}

}
