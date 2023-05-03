package lab2.E12;
import java.util.*;

public class TestTree {

	public static void main(String[] args) {

		List<Tree<String>> leaves1 = new ArrayList<Tree<String>>();

		leaves1.add(new Leaf<String>("one"));
		leaves1.add(new Leaf<String>("two"));
		leaves1.add(new Leaf<String>("three"));

		List<Tree<String>> leaves2 = new ArrayList<Tree<String>>();
		leaves2.add(new Leaf<String>("four"));
		leaves2.add(new Leaf<String>("five"));
		leaves2.add(new Leaf<String>("six"));

		List<Tree<String>> leaves3 = new ArrayList<Tree<String>>();
		leaves3.add(new Leaf<String>("seven"));
		leaves3.add(new Leaf<String>("eight"));
		leaves3.add(new Leaf<String>("nine"));

		Tree<String> t1 = new Node<String>("node1", leaves1);
		Tree<String> t2 = new Node<String>("node2", leaves2);
		Tree<String> t3 = new Node<String>("node3", leaves3);

		List<Tree<String>> rootNodes = new ArrayList<Tree<String>>();
		rootNodes.add(t1);
		rootNodes.add(t2);
		rootNodes.add(t3);

		Tree<String> t = new Node<String>("root", rootNodes);

		// List<String> dfs = t.depthFirst();
		// for (String s : dfs)
		// System.out.print(s + " ");
		// System.out.println(dfs);

		NumLeavesVisitor<String> visitor1 = new NumLeavesVisitor<String>();
		ListLeavesVisitor<String> visitor2 = new ListLeavesVisitor<String>();
		PrettyTreeVisitor<String> visitor3 = new PrettyTreeVisitor<String>();
		// System.out.println("Leaves#: " + visitor1.visitNode((Node<String>)t));
		System.out.println("Leaves#: " + t.accept(visitor1, 0));
		System.out.println("Leaves: " + t.accept(visitor2, new ArrayList<String>()));
		System.out.println(t.accept(visitor3, 0));

		// System.out.println("Height: " + t.height());

	}
}
