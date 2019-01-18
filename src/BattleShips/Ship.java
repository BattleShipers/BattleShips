package BattleShips;

import static BattleShips.ShipStatus.*;

public abstract class Ship {

    private String name;
    private int row;
    private int colum;
    private int length;
    private boolean horizontal;
    private ShipStatus shotStatus;
    private String[] live = new String[4];
    public String[] be = new String[4];

    public Ship(String _name, int _row, int _colum, boolean _horizontal, int _length) {//Constractor - one of the form to create Object
        this.name = _name;
        this.row = _row;
        this.colum = _colum;
        this.horizontal = _horizontal;
        this.length = _length;
        this.shotStatus = ShipStatus.Save;
        if (_horizontal) {              //horizontal - change digit
            for (int i = 0; i < _length; i++) {
                char r = (char) ((int) 'A' + _row);
                this.live[i] = String.valueOf(r) + (int) (_colum + i);
                this.be[i] = this.live[i];
            }
        } else {                        //change letter
            for (int i = 0; i < _length; i++) {
                char r = (char) ((int) 'A' + _row + i);
                this.live[i] = String.valueOf(r) + _colum;
                this.be[i] = this.live[i];
            }
        }
    }

    public int getLength() {
        return this.length;
    }

    //ideas --* aroud and all + to X
    public int CheckStatus(String coords) {
        for (int i = 0; i < this.length; i++) {                     //for lenght of ship
            if (coords.equalsIgnoreCase(this.be[i])) {     //"E2" vs be("E5", "F5"...)
                if (this.shotStatus == ShipStatus.Hit) return 2; //2 - Hit
                if (this.shotStatus == ShipStatus.Douwn) return 3;
                if (this.shotStatus == ShipStatus.Save) return 0;
            }
        }
        return 0;
    }

        public int Shoot (String coords, boolean report){ //Method - Do has save coordin change
            boolean dead = true;
            boolean hit = false;
            int index = 1;//for return
            if (this.shotStatus != ShipStatus.Douwn) {           //chenge only live ships
                for (int i = 0; i < this.length; i++) {                     //for lenght of ship
                    if (coords.equalsIgnoreCase(this.live[i])) {     //"E2" vs live("E5", "F5"...)
                        this.live[i] = "";
                        this.shotStatus = ShipStatus.Hit;
                        hit = true;
                    }
                }
                //Cheking status dead
                for (int i = 0; i < this.length; i++) {                     //for lenght of ship
                    if (this.live[i] != "") {
                        dead = false;
                    }           //do line saves coords
                }
                if (hit) index = 2; //2 - Hit
                if (dead) {
                    index = 3; //3 -dead
                    this.shotStatus = ShipStatus.Douwn;
                }
                if (report) {
                    System.out.print(this.getName() + " : " + this.shotStatus + " shoot : ");
                    switch (index) {
                        case 1:
                            System.out.println("save");
                            break;
                        case 2:
                            System.out.println("hited");
                            break;
                        case 3:
                            System.out.println("killed");
                            break;
                        default:
                            System.out.println("samthing wrong");
                            break;
                    }                       //from swich
                }                           //report
            }                               // for douwn ships
            return index;           //1 - emty
        }

        public String getName () {      //Shows Name of Ship
            return this.name;
        } //shows name

    }
