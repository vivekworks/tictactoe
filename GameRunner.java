package source.game;

import java.util.Scanner;

class GameRunner{
    int playerInput;
    Scanner scanInput = new Scanner(System.in);
    String position1 = " ",position2 = " ",position3 = " ",position4 = " ",position5 = " ",position6 = " ",position7 = " ",position8 = " ",position9 = " ";
    String player;
    Game game;
    String playerNext = "Player 1";
    public static void main(String[] args){
        GameRunner gameRunner = new GameRunner();
        gameRunner.startGame();
    }

    public void startGame(){
        game = new Game();
        System.out.println("Welcome to TicTacToe");
        System.out.println("Player 1 : X ; Player 2 : O");
        initiatePlayers();
        initiatePositions();
        displayGameMatrix();
        System.out.println();
        runGame();
    }

    public void getPlayerInput(){
        player = (player == null || player.equals("P2")) ? "P1" : "P2";
        try{
            playerInput = scanInput.nextInt();
        } catch(Exception e){
            System.out.println("Illegal position.");
            System.out.println(playerNext+" : Please enter a legal position from 1 to 9");
            scanInput.next();
            getPlayerInput();
        }
        validateInput();
        playerNext = player.equals("P1") ? "Player 2" : "Player 1";
    }

    public void validateInput(){
        if(playerInput <= 0 || playerInput > 9 ){
            System.out.println("Illegal position.");
            System.out.println();
            System.out.println(playerNext+" : Please enter a legal position from 1 to 9");
            getPlayerInput();
        }
    }

    public void runGame(){
        while(game.winner == null && game.gamePositionMap.size() < 9){
            System.out.println(playerNext+" : Please enter a legal position from 1 to 9");
            getPlayerInput();
            try{
                game.processGame(playerInput, player);
            } catch(Exception e){
                playerNext = player.equals("P1") ? "Player 1" : "Player 2";
                player = (player == null || player.equals("P2")) ? "P1" : "P2";
                continue;
            }
            refreshPositions();
            displayGameMatrix();
            System.out.println();
        }
        if(game.winner != null){
            System.out.println("Congratulations! "+(player.equals("P1") ? "Player 1" : "Player 2"));
            System.out.println("You win!");
        } else{
            System.out.println("It's a tie!");
            System.out.println("Well played both!");
        }
        System.out.println();
        System.out.println("Do you want to continue ? Y / N");
        String input = scanInput.next();
        if(input.trim().equalsIgnoreCase("Y")){
            System.out.println();
            startGame();
        }
        else {
            System.out.println();
            System.out.println("The End! ");
            System.out.println("Have a good day! ");
            System.out.println();
        }
    }

    public void displayGameMatrix(){
        System.out.println("-------------");
        System.out.println("| "+position1+" | "+position2+" | "+position3+" |");
        System.out.println("-------------");
        System.out.println("| "+position4+" | "+position5+" | "+position6+" |");
        System.out.println("-------------");
        System.out.println("| "+position7+" | "+position8+" | "+position9+" |");
        System.out.println("-------------");
    }

    public void refreshPositions(){
        position1 = game.gamePositionMap.get(1) != null ? (game.gamePositionMap.get(1).equals("P1") ? "X" : "O") : position1;
        position2 = game.gamePositionMap.get(2) != null ? (game.gamePositionMap.get(2).equals("P1") ? "X" : "O") : position2;
        position3 = game.gamePositionMap.get(3) != null ? (game.gamePositionMap.get(3).equals("P1") ? "X" : "O") : position3;
        position4 = game.gamePositionMap.get(4) != null ? (game.gamePositionMap.get(4).equals("P1") ? "X" : "O") : position4;
        position5 = game.gamePositionMap.get(5) != null ? (game.gamePositionMap.get(5).equals("P1") ? "X" : "O") : position5;
        position6 = game.gamePositionMap.get(6) != null ? (game.gamePositionMap.get(6).equals("P1") ? "X" : "O") : position6;
        position7 = game.gamePositionMap.get(7) != null ? (game.gamePositionMap.get(7).equals("P1") ? "X" : "O") : position7;
        position8 = game.gamePositionMap.get(8) != null ? (game.gamePositionMap.get(8).equals("P1") ? "X" : "O") : position8;
        position9 = game.gamePositionMap.get(9) != null ? (game.gamePositionMap.get(9).equals("P1") ? "X" : "O") : position9;
    }

    public void initiatePositions(){
        position1 = " ";position2 = " ";position3 = " ";position4 = " ";position5 = " ";position6 = " ";position7 = " ";position8 = " ";position9 = " ";
    }

    public void initiatePlayers(){
        playerNext = "Player 1";
        player = null;
    }
}