package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.common.Number;

public class TargetNumberTest {

	@DisplayName("컴퓨터 임의의 숫자가 만들어지는지 확인")
	@Test
	void 컴퓨터_임의의_수_생성() {
		TargetNumber targetNumber = new TargetNumber();
		assertThat(targetNumber.getTargetNumbers().size()).isEqualTo(Number.TOTAL_TARGET_NUMBER);
	}
	
	@DisplayName("컴퓨터 임의의 수 유효성 검사 (중복없는 3자리 숫자)")
	@Test
	void 컴퓨터_임의의_수_유효성_검사() {
		TargetNumber targetNumber = new TargetNumber();
		Set<String> numbers = new HashSet<String>(targetNumber.getTargetNumbers());
		
		assertThat(numbers.size()).isEqualTo(Number.TOTAL_TARGET_NUMBER);
	}


}
