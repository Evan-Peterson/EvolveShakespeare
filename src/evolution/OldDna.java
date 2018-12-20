package evolution;

import java.util.ArrayList;
import java.util.Random;


public class OldDna {
	
	public String target = "We the People";
	public String bestElement = "";
	
	public char[] genes = new char[target.length()];
	public String[] pop = new String[1000];    
	
	public ArrayList<String> matingPool = new ArrayList<String>();	
	
	public double mutationRate;
	public double maxFitness = 0;
	public int generations = 0;
	
	/*
	 * Initializes Population with a set Mutation rate.
	 * 
	 * @param double initMutRate initial mutation rate
	 * @return none 
	 */
	
	public OldDna(double initMutRate) {
		for(int j = 0; j < pop.length; j++){
			for(int i = 0; i < genes.length; i++) {
				genes[i] = (char) (32 + (int)(Math.random() * 128));
			}
			String b = new String(genes);
			pop[j] = b;
		}
		
		mutationRate = initMutRate;
	}
	
	/*
	 * Calculates Fitness of given string.
	 * 
	 * @param String element string that it calculates the fitness of
	 * @return double the fitness of the element from 0 to 1 (1 being the target string)
	 * 
	 */
	
	public double getfitness(String element){
		double score = 0;		
		char[] charElement = element.toCharArray();
		
		for(int j = 0;j < target.length(); j++){	
			if(charElement[j] == target.charAt(j)) {
				score++;					
			}				
		}	
		return score/target.length();
	}	
	
	/*
	 * Generates new Mating Pool by putting elements into it dependent on their fitness.
	 * 
	 * @param none
	 * @return none
	 */
	public void genMating() {
		matingPool.clear();
		for(int i = 0; i < pop.length;i++) {
			double n = getfitness(pop[i]) * 100;
			for(int j = 0;j < n;j++) {				
				matingPool.add(pop[i]);				
			}
		}
	}
	
	/*
	 * Fills population with offspring from the mating pool and keeps track of how many generations have occurred.
	 * 
	 * @param none
	 * @return none
	 * 
	 */
	public void generate() {
		for(int j = 1; j < pop.length; j++){			
			pop[j] = selection();			
		}
		generations++;
	}
	
	/*
	 * Finds maximum fitness element in population.
	 * 
	 * @param none
	 * @return none
	 * 
	 */
	public void maxFitness() {		
		for(int i = 0;i < pop.length;i++) {
			if(getfitness(pop[i]) >= maxFitness) {				
				maxFitness = getfitness(pop[i]);
				bestElement = pop[i];
			}
		}
	}	
	
	
	/*
	 * Mating two elements from the mating pool to get an offspring
	 * 
	 * @param none
	 * @return String the product of merging two elements from the mating pool
	 * 
	 */
	public String selection() {
		Random generator = new Random();
		
		if(matingPool.size() <= 0) { // Makes sure matingPool is not empty
			return "";
		}
		
		String parent1 = matingPool.get(generator.nextInt(matingPool.size()));
		String parent2 = matingPool.get(generator.nextInt(matingPool.size()));
		
		if(parent1.equals(parent2)) {
			parent2 = matingPool.get(generator.nextInt(matingPool.size())); // Check to see if parents are the same
		}
		
		String child01 = parent1.substring(0, (int)Math.floor(parent1.length()/2)); 
		String child02 = parent2.substring((int)Math.floor(parent1.length()/2), parent2.length()); 
		String child = child01 + child02;		
		
		if (generator.nextInt(99) <= mutationRate * 100) { // Mutation
			char[] charParent = child.toCharArray();
			charParent[generator.nextInt(parent1.length())] = (char) (32 + (int)(Math.random() * 128));
			child = String.valueOf(charParent);
		}
		
		return child;
	}
}
