package cleancode.studycafe.tobe.model.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

class StudyCafePassOrderTest {

    @DisplayName("카페 이용권 주문 할인 금액을 가져온다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100)
        );

        // when
        int actual = passOrder.getDiscountPrice();

        // then
        assertThat(actual).isEqualTo(10);
    }

    @DisplayName("카페 이용권 주문 총 금액을 가져온다.")
    @Test
    void getTotalPrice() {
        // given
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 1, 100, 0.1),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 100)
        );

        // when
        int actual = passOrder.getTotalPrice();

        // then
        assertThat(actual).isEqualTo(190);
    }

}
