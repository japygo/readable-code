package cleancode.minesweeper.tobe.minesweeper.io;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cleancode.minesweeper.tobe.minesweeper.exception.GameException;

class BoardIndexConverterTest {

    @DisplayName("선택한 셀의 rowIndex를 가져온다.")
    @Test
    void getSelectedRowIndex() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // when
        int actual = boardIndexConverter.getSelectedRowIndex("a1");

        // then
        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("선택한 셀의 colIndex를 가져온다.")
    @Test
    void getSelectedColIndex() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // when
        int actual = boardIndexConverter.getSelectedColIndex("b1");

        // then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("선택한 셀의 rowIndex가 잘못될 경우 에러가 발생한다.")
    @Test
    void getSelectedRowIndexException() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // when // then
        assertThatThrownBy(() -> boardIndexConverter.getSelectedRowIndex("a0"))
            .isInstanceOf(GameException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @DisplayName("선택한 셀의 colIndex가 잘못될 경우 에러가 발생한다.")
    @Test
    void getSelectedColIndexException() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // when // then
        assertThatThrownBy(() -> boardIndexConverter.getSelectedColIndex("!1"))
            .isInstanceOf(GameException.class)
            .hasMessage("잘못된 입력입니다.");
    }

}
