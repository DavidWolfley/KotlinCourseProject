import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int answer = rand.nextInt(1, 2);
        System.out.println("1 or 2? ");
        int guess = parseInt(sc.nextLine());
        if (answer == guess) {
            System.out.println("You Win");
        } else {
            System.out.println("Try Again");
        }
    }
}