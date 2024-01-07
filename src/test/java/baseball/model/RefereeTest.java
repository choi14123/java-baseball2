package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class RefereeTest {
    @Test
    @DisplayName("컴퓨터와 사용자의 숫자를 비교하여 볼 갯수 반환한다.")
    void countBall() {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 3, 2);

        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(computerNumbers);
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userNumbers);

        Referee referee = new Referee();
        //when
        //then
        Assertions.assertThat(referee.countBall(computerBaseballNumbers, userBaseballNumbers)).isEqualTo(2);
    }

    @Test
    @DisplayName("컴퓨터와 사용자의 숫자를 비교하여 스트라이크 갯수 반환한다.")
    void countStrike() {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 3, 2);

        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(computerNumbers);
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userNumbers);

        Referee referee = new Referee();
        //when
        //then
        Assertions.assertThat(referee.countStrike(computerBaseballNumbers, userBaseballNumbers)).isEqualTo(1);
    }
}