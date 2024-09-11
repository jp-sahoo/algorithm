package graph.bfs;

public class NumberOfLake {
    public static void main(String[] args) {
        int[][] input =
                {       {0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                        {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

        findNumberOfLakes(input);
    }

    private static void findNumberOfLakes(int[][] input) {
        for (int i=0;i<input.length;i++){
            for (int j=0;j<input[0].length;j++){
                if((i==0 || j==0) && input[i][j]==0){
                    input[i][j]=2;
                }
                if(input[i][j]==0){
                    markIfSaltWater(i,j,input);
                }
            }
        }

        int numberOfLakes=0;

        for (int i=0;i<input.length;i++){
            for (int j=0;j<input[0].length;j++){
                if(input[i][j]==0){
                    markLakes(i,j,input);
                    numberOfLakes++;
                }
            }
        }
        //printing the matrix in the end to test
        printmatrix(input);

        System.out.println("Number Of Lakes - "+numberOfLakes);
    }

    private static void markLakes(int i, int j, int[][] input) {
        
        if(i<0 ||i>=input.length||j<0||j>=input[0].length|| input[i][j]!=0){
            return;
        }
        input[i][j]=3; // Here using number 3 to mark lake so that we wont repeatedly count it
        markLakes(i+1,j,input);
        markLakes(i,j+1,input);
        markLakes(i-1,j,input);
        markLakes(i,j-1,input);
    }


    private static void markIfSaltWater(int i, int j, int[][] input) {
        if(input[i-1][j]==2 || input[i][j-1]==2 || input[i-1][j-1]==2){
            input[i][j]=2;
        }
    }

    private static void printmatrix(int[][] input) {
        for (int i=0;i<input.length;i++){
            for (int j=0;j<input[0].length;j++){
                System.out.print(input[i][j]+ " ");
            }
            System.out.println();
        }
    }
}