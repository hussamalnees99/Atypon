import stanford.karel.SuperKarel;


public class Homework extends SuperKarel {


    int rows=0 ,column=1,moves=0;
    int x=1,y=1;
    int Drow,Dcol,DrowE,DcolE=0;
        public void run() {

            setBeepersInBag(2000);
            cleanMap();
            divide();
            reset_dimensions();

        }
        private void cleanRow(){
            while (frontIsClear()){

                if (beepersPresent()){
                    pickBeeper();
                }
                if (rows==0){
                    column++;


                }

                move();
                movesCounter();
            }
                if (beepersPresent())
                    pickBeeper();
                rows++;

                moveUp();

        }
        private void moveUp(){
            if(facingEast()) {
                turnLeft();
                if (frontIsClear()) {
                    move();
                   movesCounter();
                    turnLeft();
                    cleanRow();
                }
                }

            else{
                turnRight();
                if (frontIsClear()) {
                    move();
                    movesCounter();
                    turnRight();
                    cleanRow();
                }
            }
        }
        private void moveDown(){
            if (frontIsBlocked() & facingNorth() & leftIsBlocked()) {
                turnAround();
                while (frontIsClear()){
                    move();
                    movesCounter();

                }

            }
            if (frontIsBlocked() & facingNorth() & rightIsBlocked()){
                turnLeft();
                while (frontIsClear()){
                    move();
                    moves++;
                    System.out.println(moves);
                }
                if (frontIsBlocked()){
                    turnLeft();
                    while (frontIsClear()){
                        move();
                        moves++;
                        System.out.println(moves);
                    }
                }

            }
            if (facingEast() & leftIsBlocked()){
                turnAround();
                while (frontIsClear()){
                    move();
                    moves++;
                    System.out.println(moves);
                }
                if (frontIsBlocked()){
                    turnLeft();
                    while (frontIsClear()){
                        move();
                        moves++;
                        System.out.println(moves);
                    }
                }
            }
            if (facingEast() & rightIsBlocked()) {
                turnAround();
                while (frontIsClear()){
                    move();
                    moves++;
                    System.out.println(moves);
                }
                turnLeft();
            }
            turnLeft();

        }
        private void cleanMap(){

            cleanRow();
            moveDown();

        }
        public void reset_dimensions(){
            column=1;
            rows=0;
        }
        public boolean isEven(int num){
            if (num%2==0)
                return true;
            else return false;
        }
        public void divide(){
            x=1; y=1;
            Drow=(int) Math.ceil( (double) rows/2);
            Dcol=(int) Math.ceil( (double) column/2);
            if (isEven(rows)){
                DrowE = Drow+1;
                DcolE = Dcol+1;

            }
            while (frontIsClear() & x<Dcol ){
                move();
                moves++;
                System.out.println(moves);
                x++;
            }

            if (isEven(column) && column != 2){
                turnLeft();
                beeperCol();
                move();
                moves++;
                System.out.println(moves);
                turnRight();
                beeperCol();
                moveDown();
            }
            if (!isEven(column) && column != 1) {
                turnLeft();
                beeperCol();
                moveDown();
            }
            turnLeft();
            while (frontIsClear() & y<Drow){
                move();
                moves++;
                System.out.println(moves);
                y++;
            }
            if (isEven(rows) && rows != 2){
                turnRight();
                beeperRow();
                move();
                moves++;
                System.out.println(moves);
                turnLeft();
                beeperRow();
            }
            if (!isEven(rows) && rows != 1){
                turnRight();
                beeperRow();
            }
        }
        public void beeperCol(){
            while (frontIsClear()){
                if (!beepersPresent())
                putBeeper();
                move();

            }
            if (!beepersPresent())
            putBeeper();
            if (facingNorth()){
               turnRight();

            } else if (facingSouth()) {
                turnLeft();
            }
        }
    public void beeperRow(){
        while (frontIsClear()){
            if (!beepersPresent())
            putBeeper();
            move();
            moves++;
            System.out.println(moves);

        }
        if (!beepersPresent())
        putBeeper();
        if (facingEast()){
            turnLeft();

        } else if (facingWest()) {
            turnRight();
        }
    }
    public void movesCounter(){
            moves++;
            System.out.println(moves);
    }
    }


