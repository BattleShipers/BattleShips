public class MainClass {
    public static void main (String[] args ){
        String[][] Str_Character =  new String[8][8] ;
        System.out.print("BattleShip\n");

        BattleShipBoard battleShipBoard = new BattleShipBoard() ;
        battleShipBoard.Battle_Ship_Board(Str_Character);
        battleShipBoard.Create_Battle_ships(Str_Character,2);
        battleShipBoard.Battle_Ship_Board(Str_Character);
    }
}
