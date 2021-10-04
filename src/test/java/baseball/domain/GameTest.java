package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import baseball.common.Number;
import nextstep.utils.Randoms;

public class GameTest {
	@DisplayName("컴퓨터 임의의 숫자가 만들어지는지 확인")
	@Test
	void 컴퓨터_임의의_수_생성() {
		Game game = new Game();
		assertThat(game.getTargetNumbers().size()).isEqualTo(Number.TOTAL_TARGET_NUMBER);
	}
	
	@DisplayName("컴퓨터 임의의 수 유효성 검사 (중복없는 3자리 숫자)")
	@Test
	void 컴퓨터_임의의_수_유효성_검사() {
		Game game = new Game();
		Set<String> numbers = new HashSet<String>(game.getTargetNumbers());
		
		assertThat(numbers.size()).isEqualTo(Number.TOTAL_TARGET_NUMBER);
	}
	
	@DisplayName("스트라이스 카운트 검사")
	@Test
	void 스트라이크_카운트_검사() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            Game game = new Game();
            game.countAnswer("178");
            assertThat(game.getStrike()).isEqualTo(1);
        }
	}
	
	@DisplayName("볼 카운트 검사")
	@Test
	void 볼_카운트_검사() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            Game game = new Game();
            game.countAnswer("531");
            assertThat(game.getBall()).isEqualTo(2);
        }
	}

}
