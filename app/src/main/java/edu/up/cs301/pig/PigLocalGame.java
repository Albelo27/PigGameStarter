package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState gameState;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        gameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == gameState.getTurnId()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigRollAction) {
            gameState.setCurrentDieValue((int) (Math.ceil(Math.random()*6)));
            if (gameState.getCurrentDieValue() != 1) {
                gameState.setRunningTotal(gameState.getRunningTotal() + gameState.getCurrentDieValue());
            } else {
                gameState.setRunningTotal(0);
                if (this.playerNames.length > 1) {
                    if (gameState.getTurnId() == 1) {
                        gameState.setTurnId(0);
                    } else {
                        gameState.setTurnId(1);
                    }
                }
            }
            return true;
        } else if (action instanceof PigHoldAction) {
            if (gameState.getTurnId() == 0) {
                gameState.setPlayer0Score(gameState.getRunningTotal() + gameState.getPlayer0Score());
            } else if (gameState.getTurnId() ==1) {
                gameState.setPlayer1Score(gameState.getRunningTotal() + gameState.getPlayer1Score());
            }
            gameState.setRunningTotal(0);
           if (this.playerNames.length > 1) {
               if (gameState.getTurnId() == 1) {
                   gameState.setTurnId(0);
               } else {
                   gameState.setTurnId(1);
               }
           }
            return true;
        } else {
             return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(gameState));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (gameState.getPlayer1Score() >= 50) {
            return this.playerNames[1] + " wins!";
        }
        if (gameState.getPlayer0Score() >= 50) {
            return this.playerNames[0] + " wins!";
        }
        return null;
    }

}// class PigLocalGame
