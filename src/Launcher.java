import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);//Choose the side...
        System.out.println("Choose a task: (1 for first/2 for second)");
        switch (menu.nextInt()){
            case 1:
                firstTask();
                break;
            case 2:
                secondTask();
                break;
            default:
                System.out.println("Wrong! You can't just type a right number?");
                break;
        }
    }
    private static void firstTask(){
        Rectangle rectangle = new Rectangle(); // it was easy
        System.out.println("Square of this rectangle is: " + rectangle.square());
    }
    private static void secondTask(){//but this...
        Rectangle firstRectangle = new Rectangle();
        Rectangle secondRectangle = new Rectangle();
        int [] mess = isMess(firstRectangle, secondRectangle); // let's see, is there an intersection
        if (mess[0] == 0){
            System.out.println("It's not an intersecting rectangles");//if there's not - good bye
            return;
        }
        System.out.print("Square of intersecting = ");// but if there is...
        switch (mess[0]){
            case 4:
                System.out.println(firstRectangle.square());// if all 4 points of rectangle are in the second rectangle - the square is all first rectangle
                break;
            case 2: // if only 2 of them - let's check, which two is
                if (mess[1] == 1){ // if it is a right Xs - square of rectangle between 2nd AB anb 1st CD
                    System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), new int[] {firstRectangle.getRectangle()[1][1], secondRectangle.getRightHighPoint()[0]}));
                } else if (mess[1] == 5){ // if left - between 1st AB and 2nd CD
                    System.out.println(messSquare(new int[] {secondRectangle.getLeftGroundPoint()[0], firstRectangle.getRectangle()[3][1]}, firstRectangle.getRightHighPoint()));
                } else if (mess[1] == 3){ // if it's Ys - let's see which two... again
                    if (firstRectangle.getLeftGroundPoint()[1] < secondRectangle.getLeftGroundPoint()[1]) // if high Ys - between 1st BC and 2nd AD
                        System.out.println(messSquare(new int[] {firstRectangle.getLeftGroundPoint()[0], secondRectangle.getLeftGroundPoint()[1]}, firstRectangle.getRightHighPoint()));
                    else System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), new int[] {firstRectangle.getRightHighPoint()[0], secondRectangle.getRightHighPoint()[1]}));
                }//else - 1st AD and 2nd BC
                break;
            case 1:// in the case if there only one point
                if (mess[1] == 0){ // if it is an A point
                    System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), secondRectangle.getRightHighPoint()));
                } else if (mess[1] == 1){ //B point
                    System.out.println(messSquare(firstRectangle.getRectangle()[1], secondRectangle.getRectangle()[3]));
                } else if (mess[1] == 2){// C
                    System.out.println(messSquare(secondRectangle.getLeftGroundPoint(), firstRectangle.getRightHighPoint()));
                } else System.out.println(messSquare(secondRectangle.getRectangle()[1], firstRectangle.getRectangle()[3]));//D
                break;
            default:
                System.out.println("Wtf how did you get here?");//just to get any errors
                break;
        }
    }

    private static int[] isMess(Rectangle first, Rectangle second){
        int count = 0;//to count points that interfering other rectangle
        int sum = 0;//'trick' to get the points that intersecting
        for (int i = 0; i < 4; i++){
            int[] point = first.getRectangle()[i];//get the point of 1st rectangle
            int[] leftGroundPoint = second.getLeftGroundPoint();//intersecting point must be between A
            int[] rightHighPoint = second.getRightHighPoint();// and C
            if ((point[0] >= leftGroundPoint[0]
                    && point[0] <= rightHighPoint[0])
                    && (point[1] >= leftGroundPoint[1]
                    && point[1] <= rightHighPoint[1])) {
                count++;
                sum += i;
            }
        }
        return new int[] {count, sum};
    }

    private static double messSquare(int[] pointOne, int[] pointTwo){
        return new Rectangle(pointOne, pointTwo).square();//get a new rectangle and count it's square
    }
}
