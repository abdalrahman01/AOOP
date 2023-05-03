package lab2.E12;
public class Leaf<T> implements Tree<T> {

	private T value;

	public Leaf(T value) {
		this.value = value;
	}

	
	public T getValue() {
		return value;
	}

	
	public <R, A> R accept(TreeVisitor<T, R, A> visitor, A val) {
		return visitor.visit(this, val);
	}

	/*
	 * @Override
	 * public List<T> depthFirst() {
	 * List<T> result = new ArrayList<T>();
	 * result.add(value);
	 * return result;
	 * }
	 * 
	 * @Override
	 * public int height() {
	 * return 0;
	 * }
	 * 
	 * @Override
	 * public int nrOfValues() {
	 * return 1;
	 * }
	 * 
	 * @Override
	 * public String show(int level) {
	 * String indent = "";
	 * for(int i=0; i<level; i++) {
	 * indent += "\t";
	 * // indent += "    ";
	 * }
	 * return indent+value.toString();
	 * }
	 */

	/*
	 * public String toString() {
	 * return show(0);
	 * }
	 */

}
