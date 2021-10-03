package baseball.controller;

import baseball.domain.TargetNumber;
import nextstep.utils.Console;

public class GameController {
	
	public void start() {
		TargetNumber targetNumber = new TargetNumber();
		
		System.out.println(this.enterPlayNumber());
	}
	
	private String enterPlayNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

}
