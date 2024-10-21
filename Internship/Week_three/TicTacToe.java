import java.util.*;
class TicTacToe{
    static List<Integer> plapos = new ArrayList<>();
    static List<Integer> botpos = new ArrayList<>();
    public static void main(String[] args){
        char[][] gb = {{' ', '|', ' ', '|', ' '},
                       {'-', '+', '-', '+', '-'},
                       {' ', '|', ' ', '|', ' '},
                       {'-', '+', '-', '+', '-'},
                       {' ', '|', ' ', '|', ' '}};
        printgb(gb);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int pos = sc.nextInt();
            while(plapos.contains(pos) || botpos.contains(pos)){
                System.out.println("Position taken! Enter a valid position.");
                pos = sc.nextInt();
            }
            placed(gb, pos, "player");
            String result = winner();
            if(result.length() > 0){
                printgb(gb);
                System.out.println(result);
                break;
            }
            Random ran = new Random();
            pos = ran.nextInt(1, 10);
            while(plapos.contains(pos) || botpos.contains(pos)){
                pos = ran.nextInt(1, 10); 
            }
            placed(gb, pos, "bot");
            printgb(gb);
            result = winner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }
    public static void printgb(char[][] gb){
        for(char[] row : gb){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placed(char[][] gb, int pos, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            plapos.add(pos);
        } else {
            symbol = 'O';
            botpos.add(pos);
        }
        switch(pos){
            case 1: gb[0][0] = symbol; break;
            case 2: gb[0][2] = symbol; break;
            case 3: gb[0][4] = symbol; break;
            case 4: gb[2][0] = symbol; break;
            case 5: gb[2][2] = symbol; break;
            case 6: gb[2][4] = symbol; break;
            case 7: gb[4][0] = symbol; break;
            case 8: gb[4][2] = symbol; break;
            case 9: gb[4][4] = symbol; break;
            default: break;
        }
    }
    public static String winner(){
        List<List<Integer>> wincondition = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9),
            Arrays.asList(1, 4, 7),
            Arrays.asList(2, 5, 8),
            Arrays.asList(3, 6, 9),
            Arrays.asList(1, 5, 9),
            Arrays.asList(3, 5, 7)
        );
        for(List<Integer> condition : wincondition){
            if(plapos.containsAll(condition)){
                return "Congratulations, you won!";
            } else if(botpos.containsAll(condition)){
                return "Sorry, CPU wins!";
            } else if(plapos.size() + botpos.size() == 9){
                return "It's a tie!";
            }
        }
        return "";
    }
}
