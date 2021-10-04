package baseball.controller;

import baseball.domain.Game;
import baseball.view.PrintView;

public class GameController {
	
	private PrintView printView = new PrintView();
	
	public void start() {
		boolean onPlay = true;
		Game game = new Game();
		while (onPlay) {
			String playerNumber = printView.enterPlayerNumber();
			game.countAnswer(playerNumber);
			onPlay = printView.printResult(game);
		}
		if (printView.restartAnswer()) {
			start();
		}
	}

}
