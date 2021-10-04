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
	
	private void addStrike() {
		strike++;
	}
	
	private void addBall() {
		ball++;
	}
	
	private void minusStrike() {
		strike--;
	}
	
	private void minusBall() {
		ball--;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
}
