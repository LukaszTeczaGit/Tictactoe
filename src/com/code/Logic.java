package com.code;

import java.util.Arrays;

public class Logic {
    int deactivatedButtons;
    int[][] takenButtons;
    int status; //3 - draw,1 - 0's win, -1 x's win, 0 in play
    int currentPlayer;
    boolean playing;

    Logic(){
        deactivatedButtons = 0;
        takenButtons = new int[3][3];
        currentPlayer = 1;
        playing = true;
        status = 0;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(takenButtons[i],0);
        }
    }
    void click(int x, int y){
        deactivatedButtons++;
        takenButtons[x][y] = currentPlayer;
        currentPlayer *= (-1);
    }
    int gameStatus(){
        status = 0;
        if(deactivatedButtons == 9){
            status = 3;
        }
        for(int i = 0; i < 3; i++){
            if(takenButtons[i][0]!=0 && takenButtons[i][0]==takenButtons[i][1] && takenButtons[i][0]==takenButtons[i][2]){
                status=currentPlayer;
            }
        }
        for(int i = 0; i < 3; i++){
            if(takenButtons[0][i]!=0 && takenButtons[0][i]==takenButtons[1][i] && takenButtons[0][i]==takenButtons[2][i]){
                status=currentPlayer;
            }
        }
        if(takenButtons[0][0]!=0 && takenButtons[0][0]==takenButtons[1][1] && takenButtons[0][0]==takenButtons[2][2]){
            status = currentPlayer;
        }
        if(takenButtons[0][2]!=0 && takenButtons[0][2]==takenButtons[1][1] && takenButtons[0][2] == takenButtons[2][0]){
            status = currentPlayer;
        }
        return status;
    }
}
