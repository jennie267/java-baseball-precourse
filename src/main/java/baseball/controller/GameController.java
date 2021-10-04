package baseball.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.Game;
import baseball.domain.TargetNumber;
import nextstep.utils.Console;

public class GameController {
	
	/**
	 * 게임 시작
	 */
	public void start() {
		TargetNumber targetNumber = new TargetNumber();
		
		while (true) {
			String playerNumber = enterPlayerNumber();
			Game game = countAnswer(targetNumber, playerNumber);
			printResult(game);
		}
	}
	
	/**
	 * 사용자 숫자 입력
	 * @return
	 */
	private String enterPlayerNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		String playerNumbers = Console.readLine().replaceAll(" ", "");
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
		if (playerNumbers.length() != TargetNumber.TOTAL_TARGET_NUMBER) {
			System.out.println("[ERROR] " + TargetNumber.TOTAL_TARGET_NUMBER + "개의 숫자만 입력하세요");
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
		if (playerNumbers.contains("0")) {
			System.out.println("[ERROR] 1~9까지의 숫자만 입력하세요");
			return false;
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
		if (deleteDuplicatedNumber.size() != TargetNumber.TOTAL_TARGET_NUMBER) {
			System.out.println("[ERROR] 중복된 숫자는 입력할 수 없습니다");
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
			System.out.println("[ERROR] 숫자만 입력 가능합니다");
			return false;
		}
		return true;
	}
	
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
	
	private void printResult(Game game) {
		if (game.getStrike() == TargetNumber.TOTAL_TARGET_NUMBER) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			return;
		}
		
		if (game.getStrike() == 0 && game.getBall() == 0) {
			System.out.println("낫싱");
			return;
		}
		
		if (game.getStrike() > 0) {
			System.out.print(game.getStrike()+"스트라이크 ");
		}
		
		if (game.getBall() > 0) {
			System.out.print(game.getBall() + "볼");
		}
		System.out.println();
		
	}
	

}
