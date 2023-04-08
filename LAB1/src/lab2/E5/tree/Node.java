package lab2.E5.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> implements Tree<T> {

	private T value;
	private List<Tree<T>> children;

	public Node(T v, List<Tree<T>> trees) {
		value = v;
		children = trees;
	}

	
	public List<T> depthFirst() {
		List<T> lst = new ArrayList<T>();
		lst.add(value);
		for (Tree<T> t : children)
			lst.addAll(t.depthFirst());
		return lst;
	}

	
	public int height() {
		int h = 0;
		for (Tree<T> t : children) {
			int x = t.height();
			if (x > h)
				h = x;
		}
		return h + 1;
	}

	
	public int nrOfValues() {
		int n = 1;
		for (Tree<T> t : children)
			n += t.nrOfValues();
		return n;
	}

	
	public String show(int level) {
		String result = "";
		for (Tree<T> t : children)
			result += t.show(level + 1) + "\n";
		String indent = "";
		for (int i = 0; i < level; i++) {
			indent += "    ";
		}
		return indent + value.toString() + "\n" + result;
	}

	
	public T getValue() {
		return value;
	}

}
