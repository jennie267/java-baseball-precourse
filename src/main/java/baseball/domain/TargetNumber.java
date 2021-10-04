package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.common.Number;
import nextstep.utils.Randoms;

public class TargetNumber {
	
	private List<String> targetNumbers;

	public TargetNumber() {
		Set<String> numbers = new LinkedHashSet<String>();
		while (numbers.size() < Number.TOTAL_TARGET_NUMBER) {
			numbers.add(Integer.toString(Randoms.pickNumberInRange(Number.RANDOM_MIN_NUMBER, Number.RANDOM_MAX_NUMBER)));
		}
		this.targetNumbers = new ArrayList<>(numbers);
	}

	public List<String> getTargetNumbers() {
		return targetNumbers;
	}


}
