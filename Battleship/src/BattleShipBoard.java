public class BattleShipBoard {

    // this is the Battleship Ships placements

    public static void Create_Battle_ships( String[][] border ,int amountofships){
        // ships should 2 , 3 , 4
        // shipes with 2 are 3
        // ships with 3 are 2
        // ships with 4 are 1
        if(Math.random()<0.5) {
            int row = (int) Math.random() * border.length;
            int column = (int) Math.random() * border.length;
            for (int i = 0; i < amountofships; i++) {
                border[row][column]="S";
            }
        }
        else {
            int row = (int) Math.random() * border.length;
            int column = (int) Math.random() * border.length;
            for (int i = 0; i < amountofships; i++) {
                border[row][column]="S";
            }


        }

    }



   // Thi is the BATLESHIP table structure
    static void Border_Horizontal (){

        System.out.print(".....................\n");

    }

    static void Border_Vertical(int b){

    }

    public static void  Battle_Ship_Board(String[][] boardtable){
        Border_Horizontal();

        for (int r=0 ;r<boardtable.length;r++){

            for(int c = 0 ;c<boardtable.length;c++){

                boardtable[r][c] = "-";
                System.out.print(" "+boardtable[r][c]);

            }
            System.out.println(" ");




        }

        Border_Horizontal();


    }
}
