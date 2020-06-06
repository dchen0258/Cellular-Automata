import java.awt.Color;

public class ShortGrass extends Plant {

	public ShortGrass(Location l, World w) {
		super(l, w);
		myLifeSpan = 10;
		hasEaten = true;
	}

	public void reproduce() {
		System.out.println("in grass repro");
		int newX = 0;
		int newY = 0;
		boolean locationFound = false;
		Location loc = new Location(0, 0);
		int counter = 0;

		if (checkNumberOfNeighbors() > 7) {
			locationFound = true;
		} else {
			while (!locationFound) {
				newX = getMyLocation().getX() + (int) (Math.random() * 2) - (int) (Math.random() * 2);
				newY = getMyLocation().getY() + (int) (Math.random() * 2) - (int) (Math.random() * 2);
				if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
					System.out.println("were here");
					loc.setX(newX);
					loc.setY(newY);
					System.out.println("were here2");
					for (LifeForm x : myWorld.getCreatureList()) {
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
			myWorld.getCreatureList().add(new ShortGrass(new Location(newX, newY), myWorld));
		}
	}

	public int checkNumberOfNeighbors() {
		int neighbors = 0;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				Location loc = new Location(myLocation.getX() + x, myLocation.getY() + y);
				for (LifeForm life : myWorld.getCreatureList()) {
					if (loc.sameLocation(life.myLocation) && life.myColor.equals(Color.green)) {
						neighbors++;
					}
				}
			}
		}
		return neighbors;

	}

	public void eat() {

	}

	public void move() {

	}

}
