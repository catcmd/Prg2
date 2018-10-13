package uebung01.aufgabe3;

/**
 * Created by Wolfgang Mühlbauer on 07.03.2016.
 */
public class Debugging {
    public static void main(String[] args) {
        int input[] = {3, 4, 48, 0};

        int a = input[2] - input[1];
        int b = input[1] * input[2];
        int c = b / a;
        int d = b % a;
        b = ++c * a++ + d--;

        int output[] = new int[4];
        output[2] = b;
    }
}
