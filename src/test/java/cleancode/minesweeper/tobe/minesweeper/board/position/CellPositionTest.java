package cleancode.minesweeper.tobe.minesweeper.board.position;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellPositionTest {

    @DisplayName("좌표가 음수일 경우 올바르지 않은 셀 좌표이다.")
    @Test
    void negativeIndex() {
        // given
        int rowIndex = -1;
        int colIndex = -1;

        // when // then
        assertThatThrownBy(() -> CellPosition.of(rowIndex, colIndex))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 좌표입니다.");
    }

    @DisplayName("셀 좌표와 관계된 좌표의 합이 0보다 크면 계산이 가능하다.")
    @Test
    void canCalculatePositionTrue() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition relativePosition = RelativePosition.of(1, 1);

        // when
        boolean actual = cellPosition.canCalculatePositionBy(relativePosition);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("셀 좌표와 관계된 좌표의 합이 0보다 작으면 계산이 불가능하다.")
    @Test
    void canCalculatePositionFalse() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition relativePosition = RelativePosition.of(-1, -1);

        // when
        boolean actual = cellPosition.canCalculatePositionBy(relativePosition);

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("셀 좌표와 관계된 좌표를 계산한다.")
    @Test
    void calculatePosition() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition relativePosition = RelativePosition.of(1, 1);

        // when
        CellPosition actual = cellPosition.calculatePositionBy(relativePosition);

        // then
        assertThat(actual).isEqualTo(CellPosition.of(1, 1));
    }

    @DisplayName("셀 좌표와 관계된 좌표를 계산할 수 없으면 에러가 발생한다.")
    @Test
    void calculatePositionException() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition relativePosition = RelativePosition.of(-1, -1);

        // when // then
        assertThatThrownBy(() -> cellPosition.calculatePositionBy(relativePosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("움직일 수 있는 좌표가 아닙니다.");
    }

}
