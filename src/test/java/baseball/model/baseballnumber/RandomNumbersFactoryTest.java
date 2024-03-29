package baseball.model.baseballnumber;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersFactoryTest {
    @Test
    @DisplayName("랜덤한 숫자를 생성했을 때, 숫자가 3개인지 확인한다.")
    void createRandomNumbersSizeTest() {
        //when
        RandomNumbersFactory randomNumbers = new RandomNumbersFactory();
        BaseballNumbers baseballNumbers = new BaseballNumbers(randomNumbers.create());
        //then
        Assertions.assertThat(baseballNumbers.getNumbers().size()).isEqualTo(3);
    }
}