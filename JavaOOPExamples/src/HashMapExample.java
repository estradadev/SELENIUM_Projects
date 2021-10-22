import java.util.*;

public class HashMapExample {

    public static void main(String[] args) {

        //Hash Map
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(0,"hi");
        hm.put(1,"Goodbye");
        hm.put(42,"morning");
        hm.put(3,"evening");
        System.out.println(hm.get(42));

        hm.remove(42);
        System.out.println(hm.get(42));

        Set sn = hm.entrySet();
        Iterator it = sn.iterator();

        //hashtable - pass table set collection

        while (it.hasNext()){
            //System.out.println(it.next());//Error we need separate key and value
            Map.Entry map= (Map.Entry)it.next();
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }

        //Hash Table
        Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
        ht.put(0,"Hello");

    }
}
