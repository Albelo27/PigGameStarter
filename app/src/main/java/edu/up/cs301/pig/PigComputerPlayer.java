package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    PigGameState gameState;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof PigGameState) {
            gameState = (PigGameState) info;
            if (gameState.getTurnId() != this.playerNum) {
                return;
            } else {
                if (Math.random() >= 0.5) { //ROLL ACTION
                    game.sendAction(new PigRollAction(this));
                } else { //HOLD ACTION
                    game.sendAction(new PigHoldAction(this));
                }
            }
        }
    }//receiveInfo

}
