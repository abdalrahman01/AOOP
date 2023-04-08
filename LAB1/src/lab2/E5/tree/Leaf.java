package lab2.E5.tree;

import java.util.*;

public class Leaf<T> implements Tree<T> {

	private T value;

	public Leaf(T v) {
		value = v;
	}

	public List<T> depthFirst() {
		List<T> lst = new ArrayList<T>();
		lst.add(value);
		return lst;
	}

	public int height() {
		return 0;
	}

	public int nrOfValues() {
		return 1;
	}

	public String show(int level) {
		String indent = "";
		for (int i = 0; i < level; i++) {
			indent += "    ";
		}
		return indent + value.toString();
	}

	public T getValue() {
		return value;
	}
}
