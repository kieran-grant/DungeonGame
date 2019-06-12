package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
    private int length;
    private int height;
    private int moves;
    private boolean vampiresMove;
    private List<Vampire> vampires;
    private Player player;

    public Dungeon(int length, int height, int vampires,
                   int moves, boolean vampiresMove) {

        this.length = length;
        this.height = height;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player(length -1 , height-1, moves);
        this.vampires = new ArrayList<>();

        for (int i=0 ; i < vampires ; i++) {
            this.vampires.add(new Vampire(length-1, height-1));
        }
    }

    public void run() {
        Scanner reader = new Scanner(System.in);
        while (player.getBattery() != 0 && vampires.size() != 0) {
            ArrayList<Vampire> toRemove = new ArrayList<>();

            printDungeon();
            System.out.print("Please enter some steps: ");
            String input = reader.nextLine();

            for (int i=0 ; i<input.length() ; i++) {
                Character current = input.charAt(i);
                player.move(current);

                if (vampiresMove == true) {
                    for (Vampire vampire : vampires) {
                        vampire.move();
                        if (player.getYPos() == vampire.getYPos()
                                && player.getXPos() == vampire.getXPos()) {
                            toRemove.add(vampire);
                        }
                    }
                } else {
                    for (Vampire vampire : vampires) {
                        if (player.getYPos() == vampire.getYPos()
                                && player.getXPos() == vampire.getXPos()) {
                            toRemove.add(vampire);
                        }
                    }
                }
            }

            vampires.removeAll(toRemove);
            player.blink();
        }

        if (vampires.size() == 0) {
            System.out.println("YOU WON!");
        } else {
            System.out.println("YOU LOST!");
        }


    }

    public void printDungeon() {
        System.out.println(player.getBattery());
        System.out.println("");
        System.out.println(player);
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
        System.out.println("");
        printMap();
        System.out.println("");
    }

    public void printMap() {

        ArrayList<ArrayList> map = new ArrayList<>();
        ArrayList<Character> rows = new ArrayList<>();

        for (int i=0 ; i<height ; i++) {
            for (int j=0 ; j < length ; j++) {
                rows.add('.');
            }
            map.add(rows);
            rows = new ArrayList<>();
        }

        map.get(player.getYPos()).set(player.getXPos(), '@');
        for (Vampire vampire : vampires) {
            map.get(vampire.getYPos()).set(vampire.getXPos(), 'v');
        }

        for (ArrayList<Character> columns : map) {
            for (Character character : columns) {
                System.out.print(character);
            }
            System.out.print("\n");
        }
    }
}
