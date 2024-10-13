package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberCellTest {

    @DisplayName("숫자 셀을 생성하면 지뢰가 아니고 주변 지뢰 개수를 가지고 있다.")
    @Test
    void createNumberCell() {
        // given
        NumberCell numberCell = new NumberCell(1);

        // when
        boolean isLandMine = numberCell.isLandMine();
        boolean hasLandMineCount = numberCell.hasLandMineCount();

        // then
        assertThat(isLandMine).isFalse();
        assertThat(hasLandMineCount).isTrue();
    }

    @DisplayName("숫자 셀을 생성하면 확인 전 상태이다.")
    @Test
    void createNumberCellUncheckedState() {
        // given
        NumberCell numberCell = new NumberCell(1);

        // when
        CellSnapshot actual = numberCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofUnchecked());
    }

    @DisplayName("숫자 셀을 열면 숫자 셀 상태이다.")
    @Test
    void openNumberCell() {
        // given
        NumberCell numberCell = new NumberCell(1);

        // when
        numberCell.open();

        CellSnapshot actual = numberCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofNumber(1));
    }

    @DisplayName("숫자 셀에 깃발을 꽂으면 깃발 꽂힌 상태이다.")
    @Test
    void flagNumberCell() {
        // given
        NumberCell numberCell = new NumberCell(1);

        // when
        numberCell.flag();

        CellSnapshot actual = numberCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofFlag());
    }

}
