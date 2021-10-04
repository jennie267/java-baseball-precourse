package baseball.controller;

import baseball.domain.Game;
import baseball.view.GameView;

public class GameController {
	
	private GameView gameView = new GameView();
	
	public void start() {
		boolean onPlay = true;
		Game game = new Game();
		while (onPlay) {
			game.countAnswer(gameView.enterPlayerNumber());
			onPlay = gameView.printResult(game);
		}
		if (gameView.restartAnswer()) {
			start();
		}
	}

}
