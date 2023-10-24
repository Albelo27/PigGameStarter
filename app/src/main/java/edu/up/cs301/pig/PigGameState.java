package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    int turnId;
    int player0Score;
    int player1Score;
    int runningTotal;
    int currentDieValue;

    public PigGameState() {
        turnId = 0;
        player0Score = 0;
        player1Score = 0;
        runningTotal = 0;
        currentDieValue = 0;
    }

    /**
     * copy constructor for the PigGameState class
     *
     * @param copy the instance of PigGameState that should be copied into the new instance
     */
    public PigGameState( PigGameState copy) {
        this.turnId = copy.turnId;
        this.player1Score = copy.player1Score;
        this.player0Score = copy.player0Score;
        this.runningTotal = copy.runningTotal;
        this.currentDieValue = copy.currentDieValue;
    }

    public int getTurnId() {
        return turnId;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getCurrentDieValue() {
        return currentDieValue;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setCurrentDieValue(int currentDieValue) {
        this.currentDieValue = currentDieValue;
    }


}
