import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вы запустили игру!");
        boolean flag = false;
        while (!flag) {
            printMenu();
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Reader FileRd = new Reader("Result.txt");
                    int gameNumber = FileRd.findNumb() + 1;
                    Writer fileWr = new Writer("Result.txt");
                    Line comp = new Line();
                    comp.rand();
                    fileWr.writeStart(gameNumber, comp);
                    Scanner in = new Scanner(System.in);
                    Game game;
                    do {
                        game = new Game();
                        Line player = new Line(in.next());
                        game.compareStr(comp, player);
                        fileWr.writeGameStep(player, game);
                    } while (!game.checkRes());
                    fileWr.writeResult();
                    break;
                default:
                    flag = true;
                    System.out.println("Завершение программы!");
                    break;
            }
        }
    }
    public static void printMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Играть");
        System.out.println("2. Завершить программу");
    }
}