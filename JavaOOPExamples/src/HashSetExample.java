import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

    /*HashSet treeset, LinkedHashSet implements Set interface
    does not duplicate values
    there is not guarantee elements stored in sequential order ... random order

     */

    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<String>();
        hs.add("Adrian");
        hs.add("UK");
        //hs.add("UK");
        hs.add("México");
        hs.add("he");
        hs.add("she");
        System.out.println(hs);

        System.out.println(hs.remove("UK"));
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());

        //interface Iterator
        Iterator<String> is = hs.iterator();
        while (is.hasNext()) {
            System.out.println(is.next());
        }

    }

}
