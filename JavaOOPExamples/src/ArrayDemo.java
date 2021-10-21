public class ArrayDemo {

    public static void main(String[] args) {

        int a[] = new int [5];//Declares an array and allocates memory for the varible
        int b[] = {1,2,8,9,65};

        a[0] = 2;
        a[1] = 7;
        a[2] = 56;
        a[3] = 22;
        a[4] = 32;

        for (int i=0; i<5; i++){
            System.out.println(a[i]);
        }

        //multidimensional array
        int ad[][] = new int [2][2];
        ad[0][0] = 1;
        ad[0][1] = 3;
        ad[1][0] = 15;
        ad[1][1] = 7;

        int dd[][] = {{1,4},{24,7}};

        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                System.out.println(ad[i][j]);
            }
        }

    }

}
