
    public class Assessment1 {
        public static void main(String[] args)
        {
            int a = 10, b = 10;

            //initializing the grid
            int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
            };

            System.out.println("Original Generation");      // Display grid
            for (int i = 0; i < a; i++)
            {
                for (int j = 0; j < b; j++)
                {
                    if (grid[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
            nextGeneration(grid, a, b);
        }

        // to print next generation
        static void nextGeneration(int grid[][], int a, int b)
        {
            int[][] future = new int[a][b];

            // Loop through every cell
            for (int l = 1; l < a - 1; l++)
            {
                for (int o = 1; o < b - 1; o++)
                {
                    // finding no Of Neighbours
                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            aliveNeighbours += grid[l + i][o + j];

                    aliveNeighbours -= grid[l][o];

                    // Cell is lonely and dies
                    if ((grid[l][o] == 1) && (aliveNeighbours < 2))
                        future[l][o] = 0;

                        // Cell dies due to over population
                    else if ((grid[l][o] == 1) && (aliveNeighbours > 3))
                        future[l][o] = 0;

                        //cell is born
                    else if ((grid[l][o] == 0) && (aliveNeighbours == 3))
                        future[l][o] = 1;
                    else
                        future[l][o] = grid[l][o]; //no change
                }
            }

            System.out.println("Next Generation");
            for (int i = 0; i < a; i++)
            {
                for (int j = 0; j < b; j++)
                {
                    if (future[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
        }
    }
