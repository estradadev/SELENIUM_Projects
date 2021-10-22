import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {

        //can accept duplicate valuess
        //ArrayList, LinkedList, vector - Implementating List interface
        /*Array have fixed size where as arraylist can grow dynamically
        you can access and insert any value in any index
         */

        ArrayList<String> a = new ArrayList<String>();

        a.add("Adrian");
        a.add("java");
        a.add("java");
        System.out.println(a);

        a.add(0,"hi");
        System.out.println(a);
        /*
        a.remove(1);
        a.remove("java");
        System.out.println(a);*/

        System.out.println(a.get(2));
        System.out.println(a.contains("testing"));
        System.out.println(a.indexOf("Adrian"));
        System.out.println(a.isEmpty());
        System.out.println(a.size());

    }
}
