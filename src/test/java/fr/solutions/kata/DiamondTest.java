package fr.solutions.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Implementation of TDD design for diamond class.
 * @author Yassine Tair
 *
 */
class DiamondTest {

	@ParameterizedTest
	@CsvSource({"A,A", "B, A \\nB B\\n A ", "C,  A  \\n B B \\n C   C\\n B B \\n  A  "})
	void drawDiamondTest(char input, String expected) {
		Diamond diamond = new Diamond();
		String result = diamond.drawDiamond(input);
		assertEquals(expected, result);
	}

}
