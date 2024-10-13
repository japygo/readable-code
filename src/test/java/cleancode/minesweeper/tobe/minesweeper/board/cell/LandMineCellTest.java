package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LandMineCellTest {

    @DisplayName("지뢰 셀을 생성하면 지뢰가 이고 주변 지뢰 개수를 가지고 있지 않다.")
    @Test
    void createLandMineCell() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        boolean isLandMine = landMineCell.isLandMine();
        boolean hasLandMineCount = landMineCell.hasLandMineCount();

        // then
        assertThat(isLandMine).isTrue();
        assertThat(hasLandMineCount).isFalse();
    }

    @DisplayName("지뢰 셀을 생성하면 확인 전 상태이다.")
    @Test
    void createLandMineCellUncheckedState() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        CellSnapshot actual = landMineCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofUnchecked());
    }

    @DisplayName("지뢰 셀을 열면 지뢰 셀 상태이다.")
    @Test
    void openLandMineCell() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        landMineCell.open();

        CellSnapshot actual = landMineCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofLandMine());
    }

    @DisplayName("지뢰 셀에 깃발을 꽂으면 깃발 꽂힌 상태이다.")
    @Test
    void flagLandMineCell() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        landMineCell.flag();

        CellSnapshot actual = landMineCell.getSnapshot();

        // then
        assertThat(actual).isEqualTo(CellSnapshot.ofFlag());
    }

}
