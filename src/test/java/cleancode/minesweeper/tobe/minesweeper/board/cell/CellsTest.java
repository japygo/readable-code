package cleancode.minesweeper.tobe.minesweeper.board.cell;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellsTest {

    @DisplayName("모든 셀을 확인하고 모든 지뢰에 깃발을 꽂으면 모든 셀이 확인되었다.")
    @Test
    void isAllCheckedToTrue() {
        // given
        EmptyCell emptyCell = new EmptyCell();
        emptyCell.open();
        EmptyCell emptyCell2 = new EmptyCell();
        emptyCell2.open();

        LandMineCell landMineCell = new LandMineCell();
        landMineCell.flag();
        LandMineCell landMineCell2 = new LandMineCell();
        landMineCell2.flag();

        NumberCell numberCell = new NumberCell(1);
        numberCell.open();
        NumberCell numberCell2 = new NumberCell(2);
        numberCell2.open();

        List<Cell> cellList = List.of(
            emptyCell, emptyCell2,
            landMineCell, landMineCell2,
            numberCell, numberCell2
        );

        Cells cells = Cells.of(cellList);

        // when
        boolean actual = cells.isAllChecked();

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("모든 셀을 확인하고 모든 지뢰에 깃발을 꽂지 못하면 모든 셀이 확인되지 않았다.")
    @Test
    void isAllCheckedToFalseByLandMineCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();
        emptyCell.open();
        EmptyCell emptyCell2 = new EmptyCell();
        emptyCell2.open();

        LandMineCell landMineCell = new LandMineCell();
        landMineCell.flag();
        LandMineCell landMineCell2 = new LandMineCell();
        landMineCell2.open();

        NumberCell numberCell = new NumberCell(1);
        numberCell.open();
        NumberCell numberCell2 = new NumberCell(2);
        numberCell2.open();

        List<Cell> cellList = List.of(
            emptyCell, emptyCell2,
            landMineCell, landMineCell2,
            numberCell, numberCell2
        );

        Cells cells = Cells.of(cellList);

        // when
        boolean actual = cells.isAllChecked();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("모든 빈 셀을 확인하지 않고 모든 지뢰에 깃발을 꽂으면 모든 셀이 확인되지 않았다.")
    @Test
    void isAllCheckedToFalseByEmptyCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();
        EmptyCell emptyCell2 = new EmptyCell();
        emptyCell2.open();

        LandMineCell landMineCell = new LandMineCell();
        landMineCell.flag();
        LandMineCell landMineCell2 = new LandMineCell();
        landMineCell2.flag();

        NumberCell numberCell = new NumberCell(1);
        numberCell.open();
        NumberCell numberCell2 = new NumberCell(2);
        numberCell2.open();

        List<Cell> cellList = List.of(
            emptyCell, emptyCell2,
            landMineCell, landMineCell2,
            numberCell, numberCell2
        );

        Cells cells = Cells.of(cellList);

        // when
        boolean actual = cells.isAllChecked();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("모든 숫자 셀을 확인하지 않고 모든 지뢰에 깃발을 꽂으면 모든 셀이 확인되지 않았다.")
    @Test
    void isAllCheckedToFalseByNumberCell() {
        // given
        EmptyCell emptyCell = new EmptyCell();
        emptyCell.open();
        EmptyCell emptyCell2 = new EmptyCell();
        emptyCell2.open();

        LandMineCell landMineCell = new LandMineCell();
        landMineCell.flag();
        LandMineCell landMineCell2 = new LandMineCell();
        landMineCell2.flag();

        NumberCell numberCell = new NumberCell(1);
        NumberCell numberCell2 = new NumberCell(2);
        numberCell2.open();

        List<Cell> cellList = List.of(
            emptyCell, emptyCell2,
            landMineCell, landMineCell2,
            numberCell, numberCell2
        );

        Cells cells = Cells.of(cellList);

        // when
        boolean actual = cells.isAllChecked();

        // then
        assertThat(actual).isFalse();
    }

}
