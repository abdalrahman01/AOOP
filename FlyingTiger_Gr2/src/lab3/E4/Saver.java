package lab3.E4;
/*import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Saver {
    public String save(Object o) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
        String a = "";
        Class<?> c = o.getClass();
        for(Method m:c.getDeclaredMethods()){
            SubElements selement = m.getAnnotation(SubElements.class);
            ElementField efield = m.getAnnotation(ElementField.class);
            Object []  help	= null;
            if(selement != null){
                help = (Object[]) m.invoke(o);
            }
            if(efield != null){
                a = "<node value=" + '"' + m.invoke(o) + '"' + "> \n";
            }
            if(help != null){
                a = a + "	" + "</subnodes>" + "\n";
                for(Object child : help){
                    a = a + "		" + save(child);
                }
                a = a +"	"+ "</subnodes>" + "\n" + "</node>";
            }
        }
        return a;
    }




    public static void main(String[] args1) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Tree<String> t =
                new Tree<String>("top",
                        new Tree[] {
                                new Tree("sub1"),
                                new Tree("sub2"),
                        });
        Saver s = new Saver();
        String r = s.save(t);
        System.out.println(r);
    }
}*/
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Saver {
    // The save method generates an XML representation of the given object
    public String save(Object o) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
        // Use a StringBuilder to build the result string more efficiently
        StringBuilder resultBuilder = new StringBuilder();
        Class<?> c = o.getClass();
        // Iterate over all the methods of the object's class
        for(Method m : c.getDeclaredMethods()) {
            // Check if the method has a SubElements annotation
            SubElements selement = m.getAnnotation(SubElements.class);
            // Check if the method has an ElementField annotation
            ElementField efield = m.getAnnotation(ElementField.class);
            // Initialize help as null
            Object[]  help = null;
            // If the method has a SubElements annotation, invoke the method to get its return value (an array of objects)
            if(selement != null) {
                help = (Object[]) m.invoke(o);
            }
            // If the method has an ElementField annotation, add the node to the result string
            if(efield != null) {
                resultBuilder.append("<node value=\"").append(m.invoke(o)).append("\"> \n");
            }
            // If the help array is not null, add the subnodes and recursively call the save method on each child
            if(help != null) {
                resultBuilder.append("	<subnodes>\n");
                for(Object child : help) {
                    resultBuilder.append("		").append(save(child));
                }
                resultBuilder.append("	</subnodes>\n").append("</node>");
            }
        }
        // Return the final result string
        return resultBuilder.toString();
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Create a Tree object with some children
        Tree<String> t =
                new Tree<String>("top",
                        new Tree[] {
                                new Tree("sub1"),
                                new Tree("sub2"),
                        });
        // Create a Saver object and use it to generate the XML representation of the Tree object
        Saver s = new Saver();
        String r = s.save(t);
        System.out.println(r);
    }
}
