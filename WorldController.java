import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
/* Right now this is buggy because World is missing some methods--was't sure how much you want to take right from starter
 * or make on our own. Right now aging and creating the actual creatures isn't included but I listed the method names at the
 * top of the new World if you want to copy from starter and edit from there.
 * 
 */
	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
//adds creatures from the list onto the board
	public void setUpWorld(){
		theWorld = new World(20,20);
		theWorld.getCreatureList().add( new ShortGrass( new Location(10,6), theWorld ));
		theWorld.getCreatureList().add( new ShortGrass( new Location(11,6), theWorld ));
		theWorld.getCreatureList().add( new ShortGrass( new Location(12,6), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(1,6), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(2,6), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(3,6), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(4,6), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(5,6), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(6,6), theWorld ));
		theWorld.getCreatureList().add( new ShortGrass( new Location(10,7), theWorld ));
		theWorld.getCreatureList().add( new ShortGrass( new Location(11,7), theWorld ));
		theWorld.getCreatureList().add( new ShortGrass( new Location(12,7), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(1,9), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(2,10), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(3,11), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(14,6), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(15,6), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(16,6), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(1,10), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(2,11), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(3,12), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(14,7), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(15,7), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(16,7), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(14,9), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(15,9), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(16,9), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(1,11), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(2,12), theWorld ));
		theWorld.getCreatureList().add( new Gazelle( new Location(3,13), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(14,8), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(15,8), theWorld ));
		theWorld.getCreatureList().add( new Tiger( new Location(16,8), theWorld ));
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		System.out.println("here1");
		drawWorld();
		System.out.println("here2");
		for(int i=0; i<20;i++){
			theWorld.letTimePass();
			System.out.println("here3");
			theWorld.creaturesGetOlder();
			System.out.println("here4");
			pause(1000);
			System.out.println("here5");
			drawWorld();
			System.out.println("here6");
		}
		System.out.println("here7");
	}	
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
