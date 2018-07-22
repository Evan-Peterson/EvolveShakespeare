package evolution;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;

import java.util.Date;


public class Tester {

	public static void main(String[] args) {
		
		// Generate Initial Population
		dna pop = new dna(.05);	

		
		JFrame frame = new JFrame();		
		frame.setSize(800, 200);
		frame.setTitle("Evolution");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel northPanel = new JPanel();
		
		
		Dnacomponent component = new Dnacomponent();
		frame.add(component);
		
		frame.setVisible(true);
		
		JLabel labelBest = new JLabel(pop.bestElement);
		frame.add(labelBest);
		
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
			//System.out.print(pop.matingPool.size() + "\n");
			
			//component.setText(pop.bestElement);
			//component.setGen(pop.generations);
			
			SwingUtilities.updateComponentTreeUI(frame);
			labelGen.setText("Generations: " + pop.generations + "");
			labelBest.setText(pop.bestElement);
			
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
		
		frame.getContentPane().setBackground(new Color(66, 244, 110));
		
	}
	
	

}
