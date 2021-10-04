package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.common.Number;
import nextstep.utils.Randoms;

public class Game {
	
	private List<String> targetNumbers;
	
	private int strike;
	private int ball;
	
	public Game() {
		Set<String> numbers = new LinkedHashSet<String>();
		while (numbers.size() < Number.TOTAL_TARGET_NUMBER) {
			numbers.add(Integer.toString(Randoms.pickNumberInRange(Number.RANDOM_MIN_NUMBER, Number.RANDOM_MAX_NUMBER)));
		}
		this.targetNumbers = new ArrayList<>(numbers);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
	
	private void countBall(List<String> target, String number) {
		if (target.contains(number)) {
			ball++;
		}
	}
	
	private void countStrike(String target, String number) {
		if (target.equals(number)) {
			strike++;
			ball--;
		}
	}
	
	public void resetHint() {
		this.strike = 0;
		this.ball = 0;
	}
	
	public void countAnswer(String playerNumber) {
		resetHint();
		String[] playNumbers = playerNumber.split("");
		for (int i = 0; i < playNumbers.length; i++) {
			countBall(targetNumbers, playNumbers[i]);
			countStrike(targetNumbers.get(i), playNumbers[i]);
		}
	}
	
	public List<String> getTargetNumbers() {
		return targetNumbers;
	}
}
