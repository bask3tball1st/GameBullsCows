import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Line comp = new Line();
        comp.rand();
        Scanner in = new Scanner(System.in);
        System.out.println(comp);
        Game game = new Game();
        Writer file = new Writer("Result.txt");
        int count = 0;
        do {
            Line player = new Line(in.next());
            game.compareStr(comp, player);
            game.write(player);
            //file.write(player, c);
            count++;
        } while (game.bulls != 4);
        System.out.println("Строка была угадана за " + count + " попыток.");

    }
}