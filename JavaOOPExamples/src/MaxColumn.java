public class MaxColumn {

    public static void main(String[] args) {

        int abc[][] = { {4,3,9},
                        {5,39,1},
                        {2,8,44}};
        int x = 0;
        int y = 0;
        int min = abc[0][0];
        int max = abc[0][0];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (abc[i][j] < min){
                    min = abc[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Minimun: " + min + ", Position (" + x + "," + y +")");

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (abc[i][j] > max && j == y){
                    max = abc[i][j];
                    x = i;
                }
            }
        }

        System.out.println("Maximum number in the column " + y +": " + max + ", Position (" + x + "," + y +")");

    }

}
