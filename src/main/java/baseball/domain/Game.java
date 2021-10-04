package baseball.domain;

import java.util.List;

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

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
	
	public Game countBall(List<String> target, String number) {
		if (target.contains(number)) {
			ball++;
		}
		return this;
	}
	
	public Game countStrike(String target, String number) {
		if (target.equals(number)) {
			strike++;
			ball--;
		}
		return this;
	}
}
