package lab2.E12;
import java.util.List;

public interface Tree<T> {
	// List<T> depthFirst();
	// int height();
	// int nrOfValues();
	// String show(int level);
	T getValue();

	<R, A> R accept(TreeVisitor<T, R, A> visitor, A val);
}