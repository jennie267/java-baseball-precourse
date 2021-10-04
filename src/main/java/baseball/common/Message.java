package baseball.common;

public class Message {
	
	public static final String INSERT_NUMBER = "숫자를 입력해주세요 : ";
	public static final String END_GAME = Number.TOTAL_TARGET_NUMBER+"개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String RESTART_GAME = "게임을새로시작하려면"+Number.RESTART_NUMBER+",종료하려면"+Number.END_NUMBER+"를입력하세요";
	
	// ERROR
	public static final String ERROR_MAX_NUMBER = "[ERROR] " + Number.TOTAL_TARGET_NUMBER + "개의 숫자만 입력하세요";
	public static final String ERROR_NUMBER_RANGE = "[ERROR] "+Number.RANDOM_MIN_NUMBER+"~"+Number.RANDOM_MAX_NUMBER+"까지의 숫자만 입력하세요";
	public static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 중복된 숫자는 입력할 수 없습니다";
	public static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다";
	
	public static final String STRIKE = "스트라이크";
	public static final String BALL = "볼";
	public static final String NOTHING = "낫싱";

}
