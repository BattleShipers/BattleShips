package BattleShips;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = "";//string for input "E2", "Exit"
        int k = 0;
        int k1 = 1;
        Scanner scanner  = new Scanner (System.in);
        System.out.println("*****Battle Ships*****");
        /*
        Pseudocode---------
        Make Object table
        Make Objekt Ship(name, lenght)
        table.add.(x,y,orentacion);
        table.shoot(x,y)
        table.draw
        while (

         10X10
        A
        B
        C
        D |X|O|+|*|#|
        F   ~ - clear | X - dead  | O - emty  | + - hit | # - shot | * - leave
        G
        H 1234567890
          1 2 3 4 5 6 7
         */
        //****New ideas
        //line by line all koordinats check in ships(as object)


        Table table1 = new Table("Player1");
        Table table2 = new Table("Player2");


        table1.Show();
        s = "";
        do {
            System.out.print("Enter a Coordinats[E2] or EXIT : ");
            s = scanner.next();             //"E2"
            if (!s.equalsIgnoreCase("exit")) {
                table1.Soot(s);
                table1.Show();
            }
        } while (!s.equalsIgnoreCase("exit"));


    }
}
