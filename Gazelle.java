import java.awt.Color;

public class Gazelle extends Animal {

	public Gazelle(Location l, World w) {
		super(l, w);
		myLifeSpan = 7;
		myColor = Color.black;
		hasEaten = true;
	}

	public void move() {
		System.out.println("in Gazelle move");
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		while (!locationFound) {
			if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
				newX=getMyLocation().getX()+(int) (Math.random() * 4) - (int) (Math.random() * 4);
				newY=getMyLocation().getY()+ (int) (Math.random() * 4) - (int) (Math.random() * 4);
			}
			loc.setX(newX);
			loc.setY(newY);
			for (LifeForm x : myWorld.getCreatureList()) {
				if (loc.sameLocation(x.myLocation)) {
					locationFound = false;
					break;
				} else {
					locationFound = true;
				}
			}
		}
		setMyLocation(loc);
		System.out.println("got through gazelle move");
	}

	public void reproduce() {
		System.out.println("in Gazelle repro");
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		int counter = 0;

		while (!locationFound) {
			newX=getMyLocation().getX()+(int) (Math.random() * 4) - (int) (Math.random() * 4);
			newY=getMyLocation().getY()+ (int) (Math.random() * 4) - (int) (Math.random() * 4);
			if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
				System.out.println("were here");
				loc.setX(newX);
				loc.setY(newY);
				System.out.println("were here2");
				for (LifeForm x : myWorld.getCreatureList()) {
					for (Location l : loc.getSurroundings()) {
						if (l.sameLocation(x.getMyLocation())&& x.myColor.equals(Color.black)) {
							counter++;
						}
					}
					if (loc.sameLocation(x.myLocation)) {
						locationFound = false;
						break;
					} else {
						locationFound = true;
					}
				}
				System.out.println("were here3");
			}
		}
		if (counter >= 2) {
			myWorld.getCreatureList().add(new Gazelle(loc, myWorld));
		}
	}

	public int checkNumberOfNeighbors() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.black)) {
						neighbors++;
					}
				}
			}
		}
		return neighbors;

	}

	public void eat() {
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.green)) {
						life.alive = false;
						hasEaten = true;
					}
				}
			}
		}

	}

}
