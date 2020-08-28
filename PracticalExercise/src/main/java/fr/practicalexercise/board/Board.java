package fr.practicalexercise.board;


import java.util.ArrayList;

//class that contains every information that input file gives
public class Board {
    private int width;
    private int height;
    private ArrayList<Mountain> listMountain;
    private ArrayList<Treasure> listTreasure;
    private ArrayList<Adventurer> listAdventurer;

    public Board(int x, int y) {
        width = x;
        height = y;
    }

    //method called at each M in the input file that add a mountain
    public void addMountain(int x, int y)
    {
        if (listMountain == null) {
            listMountain = new ArrayList<Mountain>();
        }
        listMountain.add(new Mountain(x,y));
    }

    //method called at each T in the input file that add a treasure
    public void addTreasure(int x, int y, int treasure)
    {
        if (listTreasure == null)
        {
            listTreasure = new ArrayList<Treasure>();
        }
        listTreasure.add(new Treasure(x,y,treasure));

    }

    //method called at each A in the input file that add an adventurer
    public void addAdventurer(String name_, char orientation_, int x, int y, String path)
    {
        if (listAdventurer == null) {
            listAdventurer = new ArrayList<Adventurer>();
        }
        listAdventurer.add(new Adventurer(name_,orientation_,x,y,path));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int y) {
        height = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int x) {
        width = x;
    }

    public ArrayList<Mountain> getListMountain() {
        if (listMountain != null)
            return listMountain;
        return new ArrayList<Mountain>();
    }

    public ArrayList<Treasure> getListTreasure() {
        if (listTreasure != null)
            return listTreasure;
        return new ArrayList<Treasure>();
    }

    public ArrayList<Adventurer> getListAdventurer() {
        if (listAdventurer != null)
            return listAdventurer;
        return new ArrayList<Adventurer>();
    }

    //test if the case where the adventurer want to go is not a mountain
    public boolean isNotMountain(int x, int i) {
        if (listMountain != null && !listMountain.isEmpty()) {
            for (Mountain elt : listMountain) {
                if (x == elt.getX() && i == elt.getY()) {
                    return false;
                }
            }
        }
        return true;
    }

    //test if the case where the adventurer want to go is a treasure case
    public boolean isTreasure(int x, int i) {
        if (listTreasure != null && !listTreasure.isEmpty()) {

            for (Treasure elt : listTreasure) {
                if (x == elt.getX() && i == elt.getY() && elt.getNbT() > 0) {
                    elt.treasureTaken();
                    return true;
                }
            }
        }
        return false;
    }

    //test if the case where the adventurer want to go don't contain an adventurer
    public boolean isNotAdventurer(int x, int y)
    {
        if (listAdventurer != null && !listAdventurer.isEmpty())
        {
            for (Adventurer adv : listAdventurer)
            {
                if (x == adv.getX() && y == adv.getY())
                    return false;
            }
        }
        return true;
    }
}