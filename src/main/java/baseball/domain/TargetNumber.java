package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class TargetNumber {
	
	protected static final int TOTAL_TARGET_NUMBER = 3;

	private List<Integer> targetNumbers;

	public TargetNumber() {
		Set<Integer> numbers = new LinkedHashSet<Integer>();
		while (numbers.size() <TargetNumber.TOTAL_TARGET_NUMBER) {
			numbers.add(Randoms.pickNumberInRange(0, 9));
		}
		this.targetNumbers = new ArrayList<>(numbers);
	}

	public List<Integer> getTargetNumbers() {
		return targetNumbers;
	}


}
