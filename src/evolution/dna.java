package evolution;

/**
 * Individual elements of the population 
 * 
 * @author Evan Peterson
 */

public class Dna {
	
	/**
	 * Collection of chars that represent 
	 */
	private char[] genes;
	
	/**
	 *  Constructs a Dna with a char array filled with random chars
	 */
	public Dna() {
		
	}
	
	/**
	 * Calculates the fitness of the genes in relation to the target phrase
	 *  
	 * @return double percentage of the target phrase
	 */
	public double getFitness() {
		return 0;
	}
	
	/**
	 * Returns the phrase of this dna
	 * 
	 * @return phrase of this dna
	 */
	public String getPhrase() {
		return "";
	}
}
