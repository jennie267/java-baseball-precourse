package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class TargetNumber {
	
	public static final int TOTAL_TARGET_NUMBER = 3;

	private List<String> targetNumbers;

	public TargetNumber() {
		Set<String> numbers = new LinkedHashSet<String>();
		while (numbers.size() <TargetNumber.TOTAL_TARGET_NUMBER) {
			numbers.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
		}
		this.targetNumbers = new ArrayList<>(numbers);
	}

	public List<String> getTargetNumbers() {
		return targetNumbers;
	}


}
