package baseball.domain;

public class Game {
	
	private int strike;
	private int ball;
	
	public Game() {
		this.strike = 0;
		this.ball = 0;
	}

	public Game(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	
}
