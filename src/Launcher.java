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
        //System.out.println("Square diagonal is: " + rectangle.diagonal);
        System.out.println("Square of this rectangle is: " + rectangle.square());
    }
    private static void secondTask(){
        Rectangle firstRectangle = new Rectangle();
        Rectangle secondRectangle = new Rectangle();
        if (!isMess(firstRectangle, secondRectangle)) System.out.println("It's not an intersecting rectangles");

    }

    private static boolean isMess(Rectangle first, Rectangle second){
        if (first.getLeftGroundPoint()[0] < second.getLeftGroundPoint()[0]);
        //if (leftMess(first.getLeftX(), second.getLeftX()) && leftMess(first.getGroundY(), second.getGroundY()));
        return true;
    }

    private static boolean mess(int[] pointOne){
        return true;
    }

 /*   private static int leftMess(int[] edgeLeftFirst, int[] edgeLeftSecond){
        if (edgeLeftFirst[0] <= edgeLeftSecond[0])
            return {edgeLeftFirst[1] edgeLeftSecond[1]};
        else return
    }*/
}
