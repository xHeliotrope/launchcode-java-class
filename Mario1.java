
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Mario1 {

    public static int inputReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please enter an integer between 0 and "
                    + "23(inclusive).");
            try {
                int inputInt = parseInt(br.readLine());
                if (inputInt >= 0 && inputInt <= 23) {
                    return inputInt;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void stepBuilder(int input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= input; i++) {
            int j = i, k = i;
            while (k > 0) {
                sb.append("#");
                k--;
            }
            while (input - j != 0) {
                sb.append(" ");
                j++;
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        stepBuilder(inputReader());
    }
}
