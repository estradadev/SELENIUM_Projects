public class ReverseString {

    public static void main(String[] args) {

        String n = "Ana";
        String name = n.toLowerCase();
        String auxName = "";

        for (int i=name.length()-1; i>=0; i--){
            System.out.print(name.charAt(i));
            auxName = auxName + name.charAt(i);
        }

        System.out.println("");
        System.out.println(name);
        System.out.println(name.length());
        System.out.println(auxName);
        System.out.println(auxName.length());

        if (name == auxName){
            System.out.println("Son palindromas");
        }

    }

}
