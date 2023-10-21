import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] tokens = input.split(" ");
        long A = Long.parseLong(tokens[0]);
        long B = Long.parseLong(tokens[1]);

        long result = (A + B) * (A - B);

        System.out.println(result);
    }
}
