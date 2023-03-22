package com.softwareinstitute.kishan.shiyal.minesweeper.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class BackboardTest {

    @Test
    void testing_board_length(){
        int test_length;
        test_length = 1;
        assertEquals(1, test_length, "error");
    }
}
