package drawing;

import javax.swing.*;

import drawing.Observer;

import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes;
	public Vector<Observer> observers = new Vector<>();
	int compteur=0;
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * ImplŽmentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		compteur++;
		this.notifyObservers();
		this.repaint();
	}
	
	
	public void addObserver(Observer obs){
		observers.add(obs);
	}
	
	public void removeObserver(Observer obs){
		observers.remove(obs);
	}
	
	private void notifyObservers(){
		for (Observer obs : observers) {
			obs.update(compteur
					);
		}
	}
	
	/** 
	 * RedŽfinition de la mŽthode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enlve toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		this.repaint();
	}
	
}
