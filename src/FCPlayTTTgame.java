import java.util.*;


public class FCPlayTTTgame {


    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {' ', '|', ' ', '|', ' '},
                {' ', '|', ' ', '|', ' '}  };

        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Pic your symbol (between 1-9):");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("The position is taken, Pic your symbol (between 1-9):");
                playerPos = scan.nextInt();
            }

            placeYourSymbol(gameBoard, playerPos, "player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                //printGameBoard(gameBoard);
                break;
            }

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("The position is taken, Pic your symbol (between 1-9):");
                cpuPos = scan.nextInt();
            }

            placeYourSymbol(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                //printGameBoard(gameBoard);
                break;
            }
        }
    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for(List l : winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations you won!";
            }else if(cpuPositions.containsAll(l)){
                return "CPU wins! sorry :(";
            }else if (playerPositions.size() + cpuPositions.size() == 9){
                return "Game is tied";
            }
        }

        return "";
    }


    public static void placeYourSymbol(char[][] gb, int pos, String user)
    {
        char symbol = ' ';
        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }


        switch(pos){
            case 1: gb[0][0] = symbol; break;
            case 2: gb[0][2] = symbol; break;
            case 3: gb[0][4] = symbol; break;
            case 4: gb[1][0] = symbol; break;
            case 5: gb[1][2] = symbol; break;
            case 6: gb[1][4] = symbol; break;
            case 7: gb[2][0] = symbol; break;
            case 8: gb[2][2] = symbol; break;
            case 9: gb[2][4] = symbol; break;
            default:
                break;
        }

    }

    public static void printGameBoard(char[][] gb){
        for(char[] row : gb ){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
