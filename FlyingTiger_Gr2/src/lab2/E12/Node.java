package lab2.E12;
import java.util.List;

public class Node<T> implements Tree<T> {

	private T value;
	private List<Tree<T>> children;

	public Node(T value, List<Tree<T>> trees) {
		this.value = value;
		this.children = trees; // possibly a copy
	}

	public T getValue() {
		return value;
	}

	public List<Tree<T>> getChildred() {
		return children;
	}

	public <R, A> R accept(TreeVisitor<T, R, A> visitor, A val) {
		return visitor.visit(this, val);
	}

	/*
	 * @Override
	 * public List<T> depthFirst() {
	 * List<T> result = new ArrayList<T>();
	 * result.add(value);
	 * for(Tree<T> t : children) {
	 * result.addAll(t.depthFirst());
	 * }
	 * return result;
	 * }
	 * 
	 * @Override
	 * public int height() {
	 * int h = 0;
	 * for(Tree<T> t : children) {
	 * int x = t.height();
	 * if(x > h)
	 * h = x;
	 * }
	 * return h + 1;
	 * }
	 * 
	 * @Override
	 * public int nrOfValues() {
	 * int n = 1;
	 * for(Tree<T> t : children) {
	 * n += t.nrOfValues();
	 * }
	 * return n;
	 * }
	 * 
	 * @Override
	 * public String show(int level) {
	 * String result = "";
	 * for(Tree<T> t : children) {
	 * result += t.show(level+1) + "\n";
	 * }
	 * String indent = "";
	 * for(int i=0; i<level; i++) {
	 * indent += "\t";
	 * // indent += "    ";
	 * }
	 * return indent+value.toString()+"\n"+result;
	 * 
	 * 
	 * }
	 */

	/*
	 * public String toString() {
	 * return show(0);
	 * }
	 */

}
