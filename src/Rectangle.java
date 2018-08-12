import java.util.Scanner;

class Rectangle {
    private final int X = 0, Y = 1;//i thought it would be more visual this way...
    private int[][] rectangle = new int[4][];
    {
        for (int i = 0; i < rectangle.length; i++){
            rectangle[i] = new int[2];
        }
    }
    //private double diagonal;
    int[][] getRectangle(){
        return this.rectangle;
    }//getter
    Rectangle(){//1st init
        initRectangle(initDiagonal());
        //this.diagonalLength();
    }
    Rectangle(int[] pointOne, int[] pointTwo){//second one
        int[] coordinates = new int[pointOne.length+pointTwo.length];
        for (int i = 0; i < pointOne.length; i++){
            coordinates[i] = pointOne[i];
            coordinates[i+pointOne.length] = pointTwo[i];
        }
        initRectangle(coordinates);
    }

    private int[] initDiagonal(){//why did I place it here? thought it should be more logical - to put initialization in the class
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! \r\n Please, type here the coordinates of a diagonal: ");
        int[] points = new int[4];
        for (int i = 0; i < points.length; i++) {//get diagonal points
            System.out.print("Here comes the ");
            switch (i){
                case 0:
                    System.out.print("1st point's x coordinate: ");
                    break;
                case 1:
                    System.out.print("1st point's y coordinate: ");
                    break;
                case 2:
                    System.out.print("2nd point's x coordinate: ");
                    break;
                case 3:
                    System.out.print("2nd point's y coordinate: ");
                    break;
            }
            points[i] = sc.nextInt();
        }
        return points;// return coordinates to constructor
    }
    private void initRectangle(int[] coordinates){//creating the rectangle by two points
        int[] pointOne = new int[2];
        int[] pointTwo = new int[2];
        int[] pointThree = new int[2];
        int[] pointFour = new int[2];
        pointOne[X] = coordinates[0];//firstX;
        pointOne[Y] = coordinates[1]; //firstY;
        pointTwo[X] = coordinates[0]; //firstX;
        pointTwo[Y] = coordinates[3]; //secondY;
        pointThree[X] = coordinates[2]; //secondX;
        pointThree[Y] = coordinates[3]; //secondY;
        pointFour[X] = coordinates[2]; //secondX;
        pointFour[Y] = coordinates[1]; //firstY;
        for (int i = 0; i < rectangle.length; i++)
            switch (i) {
                case 0:
                    rectangle[i] = pointOne;
                    break;
                case 1:
                    rectangle[i] = pointTwo;
                    break;
                case 2:
                    rectangle[i] = pointThree;
                    break;
                case 3:
                    rectangle[i] = pointFour;
                    break;
            }
    }

    /*private void diagonalLength(){
        diagonal = Math.sqrt(Math.pow(rectangle[0][Y] - rectangle[2][Y], 2) + Math.pow(rectangle[0][X] - rectangle[2][X], 2));
    }*/
    private int sideLength(int[] pointOne, int[] pointTwo){
        if (pointOne[X] == pointTwo[X]){
            return Math.abs(pointOne[Y] - pointTwo[Y]);
        } else {
            return Math.abs(pointOne[X] - pointTwo[X]);
        }
    }//get length of the side
    double square(){//count a square. A Math stuff, you know.
        return sideLength(rectangle[0], rectangle[1]) * sideLength(rectangle[0], rectangle[3]);
    }

    int[] getLeftGroundPoint(){//here comes dark magic
        return new int[]{getLeftX()[X], getGroundY()[Y]};//get A
    }
    private int[] getLeftX(){//get left Xs of the rectangle
        if (rectangle[0][X] < rectangle[2][X])
            return rectangle[0];
        else return rectangle[2];
    }
    private int[] getGroundY(){//get lowest Ys of rectangle
        if (rectangle[0][Y] > rectangle[1][Y])
            return rectangle[1];
        else return rectangle[0];
    }

    int[] getRightHighPoint(){//get C
        return new int[]{getRightX()[X], getHighY()[Y]};
    }
    private int[] getRightX(){//right X
        if (rectangle[0][X] > rectangle[2][X])
            return rectangle[0];
        else return rectangle[2];
    }
    private int[] getHighY(){//Highest Y
        if (rectangle[0][Y] < rectangle[1][Y])
            return rectangle[1];
        else return rectangle[0];
    }
}
