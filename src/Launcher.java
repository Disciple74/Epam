import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
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
        Rectangle rectangle = new Rectangle();
        System.out.println("Square of this rectangle is: " + rectangle.square());
    }
    private static void secondTask(){
        Rectangle firstRectangle = new Rectangle();
        Rectangle secondRectangle = new Rectangle();
        int [] mess = isMess(firstRectangle, secondRectangle);
        if (mess[0] == 0){
            System.out.println("It's not an intersecting rectangles");
            return;
        }
        System.out.print("Square of intersecting = ");
        switch (mess[0]){
            case 4:
                System.out.println(firstRectangle.square());
                break;
            case 2:
                if (mess[1] == 1){
                    System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), new int[] {firstRectangle.getRectangle()[1][1], secondRectangle.getRightHighPoint()[0]}));
                } else if (mess[1] == 5){
                    System.out.println(messSquare(new int[] {secondRectangle.getLeftGroundPoint()[0], firstRectangle.getRectangle()[3][1]}, firstRectangle.getRightHighPoint()));
                } else if (mess[1] == 3){
                    if (firstRectangle.getLeftGroundPoint()[1] < secondRectangle.getLeftGroundPoint()[1])
                        System.out.println(messSquare(new int[] {firstRectangle.getLeftGroundPoint()[0], secondRectangle.getLeftGroundPoint()[1]}, firstRectangle.getRightHighPoint()));
                    else System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), new int[] {firstRectangle.getRightHighPoint()[0], secondRectangle.getRightHighPoint()[1]}));
                }
                break;
            case 1:
                if (mess[1] == 0){
                    System.out.println(messSquare(firstRectangle.getLeftGroundPoint(), secondRectangle.getRightHighPoint()));
                } else if (mess[1] == 1){
                    System.out.println(messSquare(firstRectangle.getRectangle()[1], secondRectangle.getRectangle()[3]));
                } else if (mess[1] == 2){
                    System.out.println(messSquare(secondRectangle.getLeftGroundPoint(), firstRectangle.getRightHighPoint()));
                } else System.out.println(messSquare(secondRectangle.getRectangle()[1], firstRectangle.getRectangle()[3]));
                break;
            default:
                System.out.println("Wtf how did you get here?");
                break;
        }
    }

    private static int[] isMess(Rectangle first, Rectangle second){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < 4; i++){
            int[] point = first.getRectangle()[i];
            int[] leftGroundPoint = second.getLeftGroundPoint();
            int[] rightHighPoint = second.getRightHighPoint();
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
        return new Rectangle(pointOne, pointTwo).square();
    }
}
