package BattleShips;

import static BattleShips.ShipStatus.*;
import static BattleShips.Ship.*;

public class Table {

    private String name; //fields private
    int[][] matrix = new int[10][10];
    Ship[] ships = {
            new Battlecruiser("Charlie", 0, 0, true, 4),
            new Battleship("Betty", 5, 3, true, 3),
            new Battleship("Spark", 7, 3, true, 3),
            new Frigate("Love", 6, 0, true, 2),
            new Frigate("Whitty", 9, 1, true, 2)};


    public Table(String name) {//Constractor - form to create Object
        this.name = name;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.matrix[i][j] = 0;
            }
        }
       /* Ship[] ships = {
                new Battlecruiser("Charlie", 0, 0, true, 4),
                new Battleship("Betty", 5, 3, true, 3),
                new Battleship("Spark", 7, 3, true, 3),
                new Frigate("Love", 6, 0, true, 2),
                new Frigate("Whitty", 9, 1, true, 2)};*/
    }

    public void Show() {
        char a = 'A';
        System.out.println("    " + this.name);
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ((int) a + i) + " ");
            for (int j = 0; j < 10; j++) {
                switch (matrix[i][j]) {
                    case 0:
                        System.out.print("~ "); //~ - clear(0) |  |   |   |
                        break;
                    case 1:
                        System.out.print("O ");//O - emty(1) | # - shot(1)
                        break;
                    case 2:
                        System.out.print("+ "); //+ - hit(2)
                        break;
                    case 3:
                        System.out.print("X "); //X - dead(3)
                        break;
                    case 4:
                        System.out.print("* "); //* - leave
                        break;
                    default:
                        System.out.print("? ");
                        break;
                }
            }
            System.out.println(" ");// new line
        }
        System.out.print("  ");     //start digits
        a = '0';
        for (int j = 0; j < 10; j++) { //digits at buttom
            System.out.print((char) ((int) a + j) + " ");
        }
        System.out.println(" ");    //end of matrix
    }

    int row(String _coor) {                         //make "E2" to digit -> "E" = 4
        return (int) _coor.charAt(0) - (int) 'A';
    }

    int colum(String _coor) {                       //make "E0" -> 0
        return (int) _coor.charAt(1) - (int) '0';
    }


    public void Soot(String _coor) { //Method
        int k = 1;
        int k1 = 1;
        int row = row(_coor);
        int colum = colum(_coor);
        for (Ship d : this.ships) {      // chack all ships
            k = d.Shoot(_coor, true);         //shoot current ship whith report
            if (k != 1){
                this.matrix[row][colum] = k;       //set new simbol
                if (k == 3){                    // show in table douwn Ship
                    for(int i = 0; i < d.getLength(); i++) {
                        this.matrix[row(d.be[i])][colum(d.be[i])] = k;
                    }
                }
                k1 =k;                      //save if changed
            }
        }                                   //from for loop
        this.matrix[row][colum] = k1;

        //if == dead {add * extra -??


    }



}
