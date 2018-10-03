package source.game;

import java.util.HashMap;

class Game {
    HashMap<Integer, String> gamePositionMap = new HashMap<>();
    String winner;

    public void processGame(int position, String player) throws Exception {
        if (gamePositionMap.get(position) != null) {
            System.out.println("Position already occupied.");
            throw new Exception();
        }
        gamePositionMap.put(position, player);
        if(gamePositionMap.size() >= 5)
            computePosition(position, player);
    }

    public void computePosition(int position, String player){
        int v1=0,v2=0,v3=0;
        //Horizontal Check
        if(position%3 == 1){
            v1 = position;
            v2 = position+1;
            v3 = position+2;
        } else if(position%3 == 2){
            v1 = position-1;
            v2 = position;
            v3 = position+1;
        } else if(position%3 == 0){
            v1 = position-2;
            v2 = position-1;
            v3 = position;
        } 
        if((gamePositionMap.get(v1) != null && gamePositionMap.get(v2) != null && gamePositionMap.get(v3) != null)
            && (gamePositionMap.get(v1).equals(gamePositionMap.get(v2)) && gamePositionMap.get(v3).equals(gamePositionMap.get(v2)))){
            winner = player;
        }

        //Vertical Check
        v1=0;v2=0;v3=0;
        if(winner == null){
            if(position-3 <= 0){
                v1 = position;
                v2 = position+3;
                v3 = position+6;
            } else if((position-3 > 0) && (position+3 <= 9)){
                v1 = position-3;
                v2 = position;
                v3 = position+3;
            } else if(position+3 > 9){
                v1 = position-6;
                v2 = position-3;
                v3 = position;
            }
            if((gamePositionMap.get(v1) != null && gamePositionMap.get(v2) != null && gamePositionMap.get(v3) != null)
                && (gamePositionMap.get(v1).equals(gamePositionMap.get(v2)) && gamePositionMap.get(v3).equals(gamePositionMap.get(v2)))){
                winner = player;
            }
        }

        //Diagonal Check
        v1=0;v2=0;v3=0;
        if(winner == null){
            if(position+4 == 5 || position-4 == 5){
                if(position+4 == 5){
                    v1 = position;
                    v2 = position+4;
                    v3 = position+8;
                } else{
                    v1 = position-8;
                    v2 = position-4;
                    v3 = position;
                }
            } else if(position+2 == 5 || position-2 == 5){
                if(position+2 == 5){
                    v1 = position;
                    v2 = position+2;
                    v3 = position+4;
                } else{
                    v1 = position-4;
                    v2 = position-2;
                    v3 = position;
                }
            }
            if((gamePositionMap.get(v1) != null && gamePositionMap.get(v2) != null && gamePositionMap.get(v3) != null)
                && (gamePositionMap.get(v1).equals(gamePositionMap.get(v2)) && gamePositionMap.get(v3).equals(gamePositionMap.get(v2)))){
                winner = player;
            }
        }

        if(position == 5 && winner == null){
            if(((gamePositionMap.get(3) != null && gamePositionMap.get(5) != null && gamePositionMap.get(7) != null)
            && (gamePositionMap.get(3).equals(gamePositionMap.get(5)) && gamePositionMap.get(7).equals(gamePositionMap.get(5)))) || ((gamePositionMap.get(1) != null && gamePositionMap.get(5) != null && gamePositionMap.get(9) != null)
            && (gamePositionMap.get(1).equals(gamePositionMap.get(5)) && gamePositionMap.get(9).equals(gamePositionMap.get(5))))){
                winner = player;
            }
        }

    }
}
