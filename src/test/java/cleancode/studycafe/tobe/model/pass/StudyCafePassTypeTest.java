package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassTypeTest {

    @DisplayName("카페 이용권이 1인 고정석일 경우 사물함을 이용할 수 있다.")
    @Test
    void isLockerTypeFixed() {
        // given
        StudyCafePassType studyCafePassType = StudyCafePassType.FIXED;

        // when
        boolean actual = studyCafePassType.isLockerType();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("카페 이용권이 시간 단위 이용권일 경우 사물함을 이용할 수 있다.")
    @Test
    void isLockerTypeHourly() {
        // given
        StudyCafePassType studyCafePassType = StudyCafePassType.HOURLY;

        // when
        boolean actual = studyCafePassType.isLockerType();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("카페 이용권이 주 단위 이용권일 경우 사물함을 이용할 수 있다.")
    @Test
    void isLockerTypeWeekly() {
        // given
        StudyCafePassType studyCafePassType = StudyCafePassType.WEEKLY;

        // when
        boolean actual = studyCafePassType.isLockerType();

        // then
        assertThat(actual).isFalse();
    }

}
