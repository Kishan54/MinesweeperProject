package com.softwareinstitute.kishan.shiyal.minesweeper.tests;

import com.softwareinstitute.kishan.shiyal.minesweeper.Backboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class BackboardTest {

    @Test
    void testing_board_length(){
        Backboard test_backboard = new Backboard();
        test_backboard.setBackboard_length(1);
        assertEquals(1, test_backboard.getBackboard_length(), "error");
    }
}
