package fr.solutions.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Implementation of TDD design for diamond class.
 * @author Yassine Tair
 *
 */
class DiamondTest {

	@ParameterizedTest
	@CsvSource({"A,A", "B,A \\nB B\\n A", "C,A  \\n B B \\nC   C\\n B B \\n  A"})
	void drawDiamondTest(Character input, String expected) {
		String result = Diamond.drawDiamond(input);
		assertEquals(expected, result.trim());
	}

}
