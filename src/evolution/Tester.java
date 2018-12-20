package evolution;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;



public class Tester {

	public static void main(String[] args) {
		
		// Generate Initial Population
		OldDna pop = new OldDna(.05);	

		
		JFrame frame = new JFrame();		
		frame.setSize(800, 200);
		frame.setTitle("Evolution");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		frame.setVisible(true);	
		
		JLabel labelGen = new JLabel(pop.generations + "");
		frame.add(labelGen);		
		
		double time01 = System.currentTimeMillis();
		
		
		while(!(pop.bestElement.equals(pop.target))) {
			
			// Take Population and put into Mating Pool 
			// depending on fitness value
			pop.genMating();			
			
			// Generate a new population
			pop.generate();			
			
			// Find the max fitness and closest phrase
			pop.maxFitness();
			
			System.out.printf("Max Fitness: %.2f", pop.maxFitness);
			System.out.print(" Closest String: " + pop.bestElement);
			System.out.println();
			
			labelGen.setText("Generations: " + pop.generations + "");			
		}
		
		double finalTime = (System.currentTimeMillis() - time01) / 1000;
		int minutes = 0;
		while(true) {
			if(finalTime >= 60) {
				minutes++;
				finalTime -= 60;
			} else {
				break;
			}
		}
		
		System.out.println("Time Elapsed: " + minutes + "m "+ finalTime + "s");
		
		// Changes the panel background to green
		frame.getContentPane().setBackground(new Color(66, 244, 110));
		
	}
	
	

}
