package baseball.view;

import java.util.HashSet;
import java.util.Set;

import baseball.common.Message;
import baseball.common.Number;

public class ValidationView {
	
	public boolean checkPlayerNumber(String playerNumbers) {
		if (playerNumbers.length() == 0) {
			return false;
		}
		if (!checkNormalNumber(playerNumbers)) {
			return false;
		}
		if (!checkTotalNumberRange(playerNumbers)) {
			return false;
		}
		return true;
	}
	
	private boolean checkNumberLength(String playerNumbers) {
		if (playerNumbers.length() != Number.TOTAL_TARGET_NUMBER) {
			System.out.println(Message.ERROR_MAX_NUMBER);
			return false;
		}
		return true;
	}
	
	private boolean checkNumberRange(String playerNumbers) {
		String[] playNumbers = playerNumbers.split("");
		boolean checkResult = true;
		int cursor = 0;
		while (checkResult && cursor < playNumbers.length) {
			int number = Integer.parseInt(playNumbers[cursor]);
			checkResult = isInBetweenNumber(number);
			cursor++;
		}
		return checkResult;
	}
	
	private boolean isInBetweenNumber(int number) {
		if (number < Number.RANDOM_MIN_NUMBER || number > Number.RANDOM_MAX_NUMBER) {
			System.out.println(Message.ERROR_NUMBER_RANGE);
			return false;
		}
		return true;
	}
	
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
	
	private boolean checkNumeric(String playerNumbers) {
		try {
			Integer.parseInt(playerNumbers);
		} catch (NumberFormatException e) {
			System.out.println(Message.ERROR_ONLY_NUMBER);
			return false;
		}
		return true;
	}
	
	private boolean checkTotalNumberRange(String playerNumbers) {
		if (!checkNumberLength(playerNumbers)) {
			return false;
		}
		if (!checkNumberRange(playerNumbers)) {
			return false;
		}
		return true;
	}
	
	private boolean checkNormalNumber(String playerNumbers) {
		if (!checkNumeric(playerNumbers)) {
			return false;
		}
		if (!checkDuplicated(playerNumbers)) {
			return false;
		}
		return true;
	}

}
