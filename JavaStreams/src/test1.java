import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

    //Count the number of names starting with alphabet A in list
    //@Test
    public void regular(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Dona");
        names.add("Alan");
        names.add("Andres");
        names.add("Ram");

        int count = 0;
        String actual;
        for (int i=0; i < names.size(); i++){
            actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }

    }

    //@Test
    public void streamFile(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Dona");
        names.add("Alan");
        names.add("Andres");
        names.add("Ram");
        //there is no life for intermediate op if there is no terminal op
        //terninal operation will execute only if inter op (filter) return true
        //we can create stream
        //how to use in Stream API
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        long d = Stream.of("Adam","Dona","Alan","Andres","Ram").filter(s->{
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all names of ArrayList
        names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
        //print just the first name finned
        names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));

    }

    //map
    //@Test
    public void steamMap(){

        ArrayList<String> names = new ArrayList<>();
        names.add("Man");
        names.add("Dom");
        names.add("women");

        //print names which last letter as "a" with Uppercase
        Stream.of("Adam","Dona","Alan","Andres","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        //print names which have first letter as a with uppercase and sorted
        List<String> names1 = Arrays.asList("Azdam","Dona","Alan","Andres","Rama");
        names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        //merge ArrayList
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(s-> System.out.println(s));
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Alan"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect(){

        //take a list, convert in stream, do manipulation, convert the final result back to list

        List<String> ls =
        Stream.of("Adam","Dona","Alan","Andres","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
        //printing the first element
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        //print unique number from this array
        //sort the array - 3er index 1,2,3,5,7,,9
        values.stream().distinct().forEach(s-> System.out.println(s));
        List<Integer> li =
        values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));

    }


}
