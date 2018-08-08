import java.util.Scanner;

public class Rectangle {
    private final int X = 0, Y = 1;
    private int[][] rectangle = new int[4][];
    {
        for (int i = 0; i < rectangle.length; i++){
            rectangle[i] = new int[2];
        }
    }
    double diagonal;
    int[][] getRectangle(){
        return this.rectangle;
    }
    Rectangle(){
        initRectangle(initDiagonal());
        this.diagonalLength();
    }

    private int[] initDiagonal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! \r\n Please, type here the coordinates of a diagonal: ");
        int[] points = new int[4];
        for (int i = 0; i < points.length; i++) {
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
        return points;
    }
    private void initRectangle(int[] coordinates){
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

    private void diagonalLength(){
        diagonal = Math.sqrt(Math.pow(rectangle[0][Y] - rectangle[2][Y], 2) + Math.pow(rectangle[0][X] - rectangle[2][X], 2));
    }
    private int sideLength(int[] pointOne, int[] pointTwo){
        if (pointOne[X] == pointTwo[X]){
            return Math.abs(pointOne[Y] - pointTwo[Y]);
        } else {
            return Math.abs(pointOne[X] - pointTwo[X]);
        }
    }

    int[] getLeftGroundPoint(){
        return new int[]{getLeftX()[X], getGroundY()[Y]};
    }
    private int[] getLeftX(){
        if (rectangle[0][X] < rectangle[2][X])
            return rectangle[0];
        else return rectangle[2];
    }
    private int[] getGroundY(){
        if (rectangle[0][Y] < rectangle[1][Y])
            return rectangle[1];
        else return rectangle[0];
    }

    int[] getRightHighPoint(){
        return new int[]{getRightX()[X], getHighY()[Y]};
    }
    private int[] getRightX(){
        if (rectangle[0][X] > rectangle[2][X])
            return rectangle[0];
        else return rectangle[2];
    }
    private int[] getHighY(){
        if (rectangle[0][Y] > rectangle[1][Y])
            return rectangle[1];
        else return rectangle[0];
    }
    double square(){
        return sideLength(rectangle[0], rectangle[1]) * sideLength(rectangle[0], rectangle[3]);
    }
}
