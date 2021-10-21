public class Triangul {

    public static void main(String[] args) {

        int num = 0;

        //Decrement
        for (int i =0 ; i<4; i++){

            for (int j=0; j<(4-i); j++){
                num++;
                System.out.print(num + " ");

            }

            System.out.println(" ");

        }

        //Increase
        num =0;
        for (int i =0 ; i<4; i++){

            for (int j=0; j<(1+i); j++){
                num++;
                System.out.print(num + " ");

            }

            System.out.println(" ");

        }

        int numr=0;
        for (int i =0 ; i<4; i++){

            for (int j=0; j<(1+i); j++){
                numr++;
                System.out.print(numr + " ");

            }
            numr=0;
            System.out.println(" ");

        }

        num =0;
        for (int i =0 ; i<4; i++){

            for (int j=0; j<(1+i); j++){
                num = num +3;
                System.out.print(num + " ");

            }

            System.out.println(" ");

        }

    }

}
