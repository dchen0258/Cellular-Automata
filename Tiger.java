import java.awt.Color;

public class Tiger extends Animal {
	public Tiger(Location l, World w) {
		super(l, w);
		myLifeSpan = 5;
		myColor = Color.orange;
		hasEaten = true;
	}

	public void move() {
		System.out.println("in tiger move");
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		while (!locationFound) {
			if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
				newX=getMyLocation().getX()+(int) (Math.random() * 6) - (int) (Math.random() * 6);
				newY=getMyLocation().getY()+ (int) (Math.random() * 6) - (int) (Math.random() * 6);
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
		System.out.println("got through tiger move");
	}
	

	public void reproduce() {
		System.out.println("in tiger repro");
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		int counter = 0;

		while (!locationFound) {
			newX=getMyLocation().getX()+(int) (Math.random() * 6) - (int) (Math.random() * 6);
			newY=getMyLocation().getY()+ (int) (Math.random() * 6) - (int) (Math.random() * 6);

			if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
				System.out.println("were here");
				loc.setX(newX);
				loc.setY(newY);
				System.out.println("were here2");
				for (LifeForm x : myWorld.getCreatureList()) {
					for (Location l : loc.getSurroundings()) {
						if (l.sameLocation(x.getMyLocation())&& x.myColor.equals(Color.orange)) {
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
			myWorld.getCreatureList().add(new Tiger(loc, myWorld));
		}
	}

	public int checkNumberOfNeighbors() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.orange)) {
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
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.black)) {
						life.alive = false;
						hasEaten = true;
					}
				}
			}
		}

	}
	
	

}
