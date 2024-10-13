package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyCellTest {

    @DisplayName("빈 셀을 생성하면 지뢰가 아니고 주변 지뢰 개수를 가지고 있지 않다.")
    @Test
    void createEmptyCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();

        // when
        boolean isLandMine = emptyCell.isLandMine();
        boolean hasLandMineCount = emptyCell.hasLandMineCount();

        // then
        assertThat(isLandMine).isFalse();
        assertThat(hasLandMineCount).isFalse();
    }

    @DisplayName("빈 셀을 생성하면 확인 전 상태이다.")
    @Test
    void createEmptyCellUncheckedState() {
        // given
        EmptyCell emptyCell = new EmptyCell();

        // when
        CellSnapshot actual = emptyCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofUnchecked());
    }

    @DisplayName("빈 셀을 열면 빈 셀 상태이다.")
    @Test
    void openEmptyCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();

        // when
        emptyCell.open();

        CellSnapshot actual = emptyCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofEmpty());
    }

    @DisplayName("빈 셀에 깃발을 꽂으면 깃발 꽂힌 상태이다.")
    @Test
    void flagEmptyCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();

        // when
        emptyCell.flag();

        CellSnapshot actual = emptyCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofFlag());
    }

}
