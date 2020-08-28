package fr.practicalexercise.board;

public class Treasure {
    private int X;
    private int Y;
    private int nbT;

    public Treasure(int x, int y, int nbT) {
        X = x;
        Y = y;
        this.nbT = nbT;
    }

    //decrement the number of treasure
    public void treasureTaken()
    {
        if (nbT > 0) {
            nbT--;
        }
        else
        {
            System.out.println("no more treasure");
        }
    }

    //getters
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getNbT() {
        return nbT;
    }
}
