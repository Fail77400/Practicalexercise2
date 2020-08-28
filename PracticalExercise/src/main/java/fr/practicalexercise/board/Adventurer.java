package fr.practicalexercise.board;

//class that contains information about adventurer
public class Adventurer {
    private String name_;
    private char orientation_;
    private int X;
    private int Y;
    private String path;
    private int nbTreasure = 0;

    public Adventurer(String name_, char orientation_, int x, int y, String path) {
        this.name_ = name_;
        this.orientation_ = orientation_;
        X = x;
        Y = y;
        this.path = path;
    }

    public String getName_() {
        return name_;
    }

    public char getOrientation_() {
        return orientation_;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    //method to to rotate the adventurer
    public void rotate(char c)
    {
        if (c == 'D')
        {
            if (this.orientation_ == 'S')
            {
                orientation_ = 'O';
            }
            else if (this.orientation_ == 'O')
            {
                orientation_ = 'N';
            }
            else if (this.orientation_ == 'N')
            {
                orientation_= 'E';
            }
            else if (this.orientation_ == 'E')
            {
                orientation_ = 'S';
            }
        }
        if (c == 'G')
        {
            if (this.orientation_ == 'S')
            {
                orientation_ = 'E';
            }
            else if (this.orientation_ == 'O')
            {
                orientation_ = 'S';
            }
            else if (this.orientation_ == 'N')
            {
                orientation_= 'O';
            }
            else if (this.orientation_ == 'E')
            {
                orientation_ = 'N';
            }
        }
    }

    //class to move the adventurer
    public int move(Board board)
    {
        if (orientation_ == 'S') {
            if (Y < board.getHeight() - 1 && board.isNotMountain(X,Y + 1) && board.isNotAdventurer(X, Y + 1)) {
                Y++;
                return 0;
            }
            else
            {
                System.out.println(name_ + " can't move south");
                return 1;
            }
        }
        if (orientation_ == 'N')
        {
            if (Y > 0 && board.isNotMountain(X,Y - 1) && board.isNotAdventurer(X, Y - 1))
            {
                Y--;
                return 0;
            }
            else
            {
                System.out.println(name_ + " can't move north");
                return 1;
            }
        }
        if (orientation_ == 'O')
        {
            if (X > 0 && board.isNotMountain(X - 1, Y) && board.isNotAdventurer(X - 1, Y))
            {
                X--;
                return 0;
            }
            else
            {
                System.out.println(name_ + " can't move west");
                return 1;
            }
        }
        if (orientation_ == 'E')
        {
            if (X < board.getWidth() - 1 && board.isNotMountain(X + 1, Y) && board.isNotAdventurer(X + 1, Y ))
            {
                X++;
                return 0;
            }
            else
            {
                System.out.println(name_ + " can't move east");
                return 1;
            }
        }
        return 1;
    }

    public String getPath() {
        return path;
    }

    public int getNbTreasure() {
        return nbTreasure;
    }

    public void addTreasure() {
        nbTreasure++;
    }
}
