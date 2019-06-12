package dungeon;

public class Player {
    int xPos;
    int yPos;
    int maxX;
    int maxY;
    Torch torch;

    public Player(int maxX, int maxY, int moves) {
        xPos = 0;
        yPos = 0;
        this.maxX = maxX;
        this.maxY = maxY;
        torch = new Torch(moves);
    }

    public int getBattery() {
        return torch.getBattery();
    }

    public void blink() {
        torch.blink();
    }

    public void move(Character inst) {
        if (inst.equals('w') && yPos > 0) {
            yPos--;
        } else if (inst.equals('a') && xPos > 0) {
            xPos--;
        } else if (inst.equals('s') && yPos < maxY) {
            yPos++;
        } else if (inst.equals('d') && xPos < maxX) {
            xPos++;
        }
    }

    public String toString() {
        return "@ " + xPos + " " + yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
