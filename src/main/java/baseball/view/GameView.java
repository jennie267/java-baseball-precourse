package baseball.view;

import baseball.common.Message;
import baseball.common.Number;
import baseball.domain.Game;
import nextstep.utils.Console;

public class GameView {
	
	public String enterPlayerNumber() {
		System.out.print(Message.INSERT_NUMBER);
		String playerNumbers = Console.readLine();
		if (new ValidationView().checkPlayerNumber(playerNumbers)) {
			return playerNumbers;
		}
		
		return enterPlayerNumber();
	}
	
	public boolean printResult(Game game) {
		if (game.getStrike() == 0 && game.getBall() == 0) {
			System.out.println(Message.NOTHING);
			return true;
		}
		
		if (game.getStrike() > 0) {
			System.out.print(game.getStrike()+Message.STRIKE + " ");
		}
		
		if (game.getBall() > 0) {
			System.out.print(game.getBall() + Message.BALL);
		}
		System.out.println();
		
		if (game.getStrike() == Number.TOTAL_TARGET_NUMBER) {
			System.out.println(Message.END_GAME);
			return false;
		}
		return true;
	}
	
	public boolean restartAnswer() {
		System.out.println(Message.RESTART_GAME);
		
		String restart = Console.readLine();
		
		if (Integer.toString(Number.RESTART_NUMBER).equals(restart)) {
			return true;
		}
		if (Integer.toString(Number.END_NUMBER).equals(restart)) {
			return false;
		}
		return restartAnswer();
	}

}
