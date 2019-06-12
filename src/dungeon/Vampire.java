package dungeon;

import java.util.Random;

public class Vampire {
    int xPos;
    int yPos;
    int maxX;
    int maxY;
    Random rand;

    public Vampire(int dungeonLength, int dungeonHeight) {
        rand = new Random();
        xPos = rand.nextInt(dungeonLength);
        yPos = rand.nextInt(dungeonHeight);
        maxX = dungeonLength;
        maxY = dungeonHeight;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public String toString() {
        return "v " + xPos + " " + yPos;
    }

    public void move() {
        int roll = rand.nextInt(4);
        if (roll == 0 && yPos < maxY) {
            yPos++;
        } else if (roll == 1 && xPos > 0) {
            xPos--;
        } else if (roll == 2 && yPos > 0) {
            yPos--;
        } else if (roll == 3 && xPos < maxX) {
            xPos++;
        }
    }
}
