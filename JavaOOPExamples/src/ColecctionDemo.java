import java.util.ArrayList;

public class ColecctionDemo {

    public static void main(String[] args) {

        int a[] = {4,4,5,5,5,2,6,6,4,12,7,3,3,5,7,9,2,3,4,5,5};
        int c=0;
        int size=0;

        ArrayList<Integer> ab = new ArrayList<Integer>();
        ArrayList<Integer> counter = new ArrayList<Integer>();

        for (int i=0; i<a.length; i++){

            c=0;
            size=0;

            if(!ab.contains(a[i])){

                ab.add(a[i]);
                c++;

                for (int j=i+1; j<a.length; j++) {

                    if (a[i] == a[j]){
                        c++;
                    }
                }
                counter.add(size,c);
                size++;

                System.out.print(a[i] + ", ");
                System.out.println(c);

            }

        }

        System.out.println();

        for (int i=0; i<ab.size(); i++){
            System.out.println(ab.get(i) + " n= " + counter.get((ab.size()-1) - i) + ", ");
        }

    }
}
