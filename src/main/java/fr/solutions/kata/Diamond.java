package fr.solutions.kata;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to resolve the famous diamond problem.
 * @author Yassine Tair
 *
 */
public class Diamond {
	
	private static final Logger LOGGER = LogManager.getLogger(Diamond.class);
	private static final String END_OF_LINE = "\\n";
	private static final String BLANC_SPACE_SEPRATOR = " ";
	
	/**
	 * We pass a character to this method and we should draw the corresponding diamond.
	 * for example the corresponding diamond to 'C' is:  
	 *   A
	 *  B B
	 * C   C
	 *  B B
	 *   A
	 * @param charactere: must not be null
	 * @return the diamond we should draw
	 */
    public static String drawDiamond(Character letter) {
        int diamondSize = diamondSizeForChar(letter);
        
        if (diamondSize == 1) return letter.toString();
        String diamondResult = buildDiamond(diamondSize);
        LOGGER.info("diamond of letter [{}] is {}", letter, diamondResult);
        return diamondResult;
    }

    /**
     * Build diamond based on size
     * @param diamondSize
     * @return
     */
    private static String buildDiamond(int diamondSize) {
        StringBuilder diamond = new StringBuilder();
        
        diamond.append(drawFirstLine(diamondSize)).append(END_OF_LINE);
        
        for (int depth = 2; depth < diamondWidth(diamondSize) ; depth ++) {
            diamond.append(buildLineAtDepth(diamondSize, depth));
            diamond.append(END_OF_LINE);
        }
        
        diamond.append(drawFirstLine(diamondSize));
        
        return diamond.toString();
    }

    /**
     * Calculate the size of the input letter.
     * @param letter: the input letter
     * @return size integer
     */
    private static int diamondSizeForChar(Character letter) {
    	int size = letter - 'A' + 1;
    	LOGGER.info("the size of the given letter [{}] is : [{}]", letter, size);
        return size;
    }
    
    /**
     * Draw first line containing 'A' character.
     * @param diamondSize
     * @return first line of the diamond
     */
    private static String drawFirstLine(int diamondSize) {
        return addOutsideSpaces(diamondSize, 1) + "A" + addOutsideSpaces(diamondSize, 1);
    }
    
    
    /**
     * Draw the other lines based on character entered.
     * @param diamondSize
     * @param depth
     * @return
     */
    private static String buildLineAtDepth(int diamondSize, int depth) {
        Character character = getCharacterAtDepth(diamondSize, depth);
        StringBuilder builder = new StringBuilder();
        return builder
                .append(addOutsideSpaces(diamondSize, depth)) 
                .append(character)
                .append(addInsideSpaces(diamondSize, depth))
                .append(character.toString())
                .append(addOutsideSpaces(diamondSize, depth))
                .toString();
    }

    /**
     * 
     * @param diamondSize
     * @param depth
     * @return
     */
    private static Character getCharacterAtDepth(int diamondSize, int depth) {
        return Character.toChars('A' + diamondSize - numberOfOutsideSpaces(diamondSize, depth) - 1)[0];
    }

    /**
     * 
     * @param size
     * @return
     */
    private static int diamondWidth(int size) {
        return size * 2 - 1;
    }

    /**
     * 
     * @param size
     * @param depth
     * @return
     */
    private static int numberOfOutsideSpaces(int size, int depth) {
        return Math.abs(size - depth);
    }

    
    /**
     * Calculate and add the required number of the inside spaces for each row.
     * @param size: the index of the character we would like to add.
     * @param depth: the depth of the character we would like to add
     * @return inside spaces to add.
     */
    private static String addInsideSpaces(int size, int depth) {
        StringBuilder builder = new StringBuilder();
        int width = size * 2 - 1;
        for (int i = 0; i < width - 2 - (2 * numberOfOutsideSpaces(size, depth)); i++) {
            builder.append(BLANC_SPACE_SEPRATOR);
        }
        
        return builder.toString();
    }

    /**
     * Calculate and add the required number of the outer spaces for each row.
     * @param size: the index of the character we would like to add.
     * @param depth: the depth of the character we would like to add
     * @return outside spaces to add.
     */
    private static String addOutsideSpaces(int size, int depth) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < numberOfOutsideSpaces(size, depth); i++) {
            builder.append(BLANC_SPACE_SEPRATOR);
        }
        
        return builder.toString();
    }
    
}
