package baseball.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.common.Message;
import baseball.common.Number;
import baseball.domain.Game;
import baseball.domain.TargetNumber;
import nextstep.utils.Console;

public class GameController {
	
	private boolean onPlay = false;
	
	/**
	 * 게임 시작
	 */
	public void start() {
		onPlay = true;
		TargetNumber targetNumber = new TargetNumber();
		while (onPlay) {
			String playerNumber = enterPlayerNumber();
			Game game = countAnswer(targetNumber, playerNumber);
			printResult(game);
		}
		restartAnswer();
	}
	
	/**
	 * 사용자 숫자 입력
	 * @return
	 */
	private String enterPlayerNumber() {
		System.out.print(Message.INSERT_NUMBER);
		String playerNumbers = Console.readLine();
		if (checkPlayerNumber(playerNumbers)) {
			return playerNumbers;
		}
		
		return enterPlayerNumber();
	}
	
	/**
	 * 사용자 입력 숫자 유효성 체크
	 * @param playerNumbers
	 * @return
	 */
	private boolean checkPlayerNumber(String playerNumbers) {
		if (!checkNumeric(playerNumbers)) {
			return false;
		}
		
		if (!checkNumberLength(playerNumbers)) {
			return false;
		}
		
		if (!checkNumberRange(playerNumbers)) {
			return false;
		}
		
		if (!checkDuplicated(playerNumbers)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 숫자 개수 검사
	 * @param playerNumbers
	 * @return
	 */
	private boolean checkNumberLength(String playerNumbers) {
		if (playerNumbers.length() != Number.TOTAL_TARGET_NUMBER) {
			System.out.println(Message.ERROR_MAX_NUMBER);
			return false;
		}
		return true;
	}
	
	/**
	 * 숫자 범위 검사
	 * @param playerNumbers
	 * @return
	 */
	private boolean checkNumberRange(String playerNumbers) {
		String[] playNumbers = playerNumbers.split("");
		for (int i = 0; i < playNumbers.length; i++) {
			int number = Integer.parseInt(playNumbers[i]);
			if (number < Number.RANDOM_MIN_NUMBER || number > Number.RANDOM_MAX_NUMBER) {
				System.out.println(Message.ERROR_NUMBER_RANGE);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 숫자 중복 검사
	 * @param playerNumbers
	 * @return
	 */
	private boolean checkDuplicated(String playerNumbers) {
		Set<String> deleteDuplicatedNumber = new HashSet<String>();
		for (String number : playerNumbers.split("")) {
			deleteDuplicatedNumber.add(number);
		}
		if (deleteDuplicatedNumber.size() != Number.TOTAL_TARGET_NUMBER) {
			System.out.println(Message.ERROR_DUPLICATE_NUMBER);
			return false;
		}
		return true;
	}
	
	/**
	 * 숫자만 들어왔는지 검사
	 * @param playerNumbers
	 * @return
	 */
	private boolean checkNumeric(String playerNumbers) {
		try {
			int number = Integer.parseInt(playerNumbers);
		} catch (NumberFormatException e) {
			System.out.println(Message.ERROR_ONLY_NUMBER);
			return false;
		}
		return true;
	}
	
	/**
	 * 스트라이크/볼/낫싱 판정
	 * @param targetNumber
	 * @param playerNumber
	 * @return
	 */
	private Game countAnswer(TargetNumber targetNumber, String playerNumber) {
		List<String> targetNumbers = targetNumber.getTargetNumbers();
		
		int strike = 0;
		int ball = 0;
		
		String[] playNumbers = playerNumber.split("");
		for (int i = 0; i < playNumbers.length; i++) {
			if (targetNumbers.contains(playNumbers[i])) {
				ball++;
			}
			
			if (targetNumbers.get(i).equals(playNumbers[i])) {
				strike++;
				ball--;
			}
		}
		
		return new Game(strike, ball);
	}
	
	/**
	 * 결과 출력
	 * @param game
	 */
	private void printResult(Game game) {
		if (game.getStrike() > 0) {
			System.out.print(game.getStrike()+Message.STRIKE + " ");
		}
		
		if (game.getBall() > 0) {
			System.out.print(game.getBall() + Message.BALL);
		}
		System.out.println();
		
		if (game.getStrike() == Number.TOTAL_TARGET_NUMBER) {
			System.out.println(Message.END_GAME);
			onPlay = false;
			return;
		}
		
		if (game.getStrike() == 0 && game.getBall() == 0) {
			System.out.println(Message.NOTHING);
			return;
		}
		
	}
	
	/**
	 * 재시작 질문
	 */
	private void restartAnswer() {
		System.out.println(Message.RESTART_GAME);
		
		String restart = Console.readLine();
		
		if ("1".equals(restart)) {
			start();
			return;
		}
		if ("2".equals(restart)) {
			return;
		}
		restartAnswer();
	}
	

}
