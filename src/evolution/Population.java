package evolution;

import java.util.ArrayList;

/**
 * This class simulates a population of creatures that breed and evolve to a singular form. In this case the 
 * creatures are Strings evolving to find a target phrase
 * 
 * @author Evan Peterson
 */
public class Population {
	
	/**
	 * Population of Dna objects
	 */
	private Dna[] pop;
	
	/**
	 * 
	 */
	private ArrayList<Dna> matingPool = new ArrayList<Dna>();
	
	/**
	 * Number of generations 
	 */
	private int generations;
	
	/**
	 * Rate of mutation in the dna
	 */
	private double mutationRate;
	
	/**
	 * Target phrase to be reached
	 */
	private String target;
	
	/**
	 * Constructs a population with a given target phrase, rate of mutation, and size of population and filles
	 * population with Dna
	 * 
	 * @param target target phrase to evolve to
	 * @param mutationRate rate of mutation
	 * @param popSize size of the population
	 */
	public Population(String target, double mutationRate, int popSize) {
		
	}
	
	/**
	 * Fills mating pool with dna elements depending on their fitness values
	 */
	public void fillMatingPool() {
		
	}
	
	
}
