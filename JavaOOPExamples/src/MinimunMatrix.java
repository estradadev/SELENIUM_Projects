public class MinimunMatrix {

    public static void main(String[] args) {

        int abc[][] = {{4,4,9},{5,39,7},{2,8,4}};
        int x = 0;
        int y = 0;
        int min = abc[0][0];

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

        //Maximun
        int max = abc[0][0];
        x=0;y=0;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (abc[i][j] > max){
                    max = abc[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("Maximun: " + max + ", Position (" + x + "," + y +")");

    }

}
