package fr.solutions.kata;

import static org.junit.Assert.assertNotNull;

/**
 * Class to resolve the famous diamond problem.
 * @author Yassine Tair
 *
 */
public class Diamond {

	private static final String END_OF_LINE = "\\n";
	
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
    public String drawDiamond(Character letter) {
    	assertNotNull("la lettre passée en parametre ne doit pas etre nulle",letter);
    	StringBuilder diamond = new StringBuilder();
        int diamondSize =  letter - 'A' + 1;
        
        if (diamondSize == 1) return letter.toString();
        
		diamond.append( outsideSpace(diamondSize, 1) + "A" + outsideSpace(diamondSize, 1)).append(END_OF_LINE);
		        
		for (int depth = 2; depth < diamondSize * 2 - 1 ; depth ++) {
	        Character character = Character.toChars('A' + diamondSize - Math.abs(diamondSize - depth) - 1)[0];
	        StringBuilder builder = new StringBuilder();
	        String lineAtDepth = builder
	                .append(outsideSpace(diamondSize, depth)) 
	                .append(character)
	                .append(insideSpace(diamondSize, depth))
	                .append(character.toString())
	                .append(outsideSpace(diamondSize, depth))
	                .toString();
			diamond.append(lineAtDepth);
            diamond.append(END_OF_LINE);
        }
        
        diamond.append( outsideSpace(diamondSize, 1) + "A" + outsideSpace(diamondSize, 1));
       
            
        return diamond.toString();
    }

    
    /**
     * Calculate and add the required number of the inside spaces for each row.
     * @param size: the index of the character we would like to add.
     * @param depth: the depth of the character we would like to add
     * @return inside spaces to add.
     */
    private String insideSpace(int size, int depth) {
        StringBuilder builder = new StringBuilder();
        int width = size * 2 - 1;
        for (int i = 0; i < width - 2 - (2 * Math.abs(size - depth)); i++) {
            builder.append(" ");
        }
        
        return builder.toString();
    }

    /**
     * Calculate and add the required number of the outer spaces for each row.
     * @param size: the index of the character we would like to add.
     * @param depth: the depth of the character we would like to add
     * @return outside spaces to add.
     */
    private String outsideSpace(int size, int depth) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < Math.abs(size - depth); i++) {
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
}
