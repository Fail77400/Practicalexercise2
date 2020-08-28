package fr.practicalexercise.board;

import org.junit.*;

public class AdventurerTest {
    private static Board board;
    private Adventurer lara = new Adventurer("Lara", 'S', 1, 2, "ADDAA");

    @BeforeClass
    public static void setup()
    {
        board = new Board(3,4);
        board.addMountain(1,0);
        board.addMountain(2,1);
        board.addTreasure(0,3,2);
        board.addTreasure(1,3,3);
        board.addAdventurer("Lara", 'S', 1, 2, "ADDAA");
    }

    @Test
    public void getNbTreasure()
    {
        Assert.assertEquals(0, lara.getNbTreasure());
        lara.addTreasure();
        Assert.assertEquals(1, lara.getNbTreasure());
    }

    @Test
    public void rotateTest()
    {
        lara.rotate('D');
        Assert.assertEquals('O',lara.getOrientation_());
        lara.rotate('D');
        Assert.assertEquals('N',lara.getOrientation_());
        lara.rotate('D');
        Assert.assertEquals('E',lara.getOrientation_());
        lara.rotate('D');
        Assert.assertEquals('S',lara.getOrientation_());
        lara.rotate('G');
        Assert.assertEquals('E',lara.getOrientation_());
        lara.rotate('G');
        Assert.assertEquals('N',lara.getOrientation_());
        lara.rotate('G');
        Assert.assertEquals('O',lara.getOrientation_());
        lara.rotate('G');
        Assert.assertEquals('S',lara.getOrientation_());
    }

    @Test
    public void moveTest()
    {
        Adventurer adv = board.getListAdventurer().get(0);
        adv.move(board);
        Assert.assertEquals(3, adv.getY());
        Assert.assertEquals(1, adv.getX());

        adv.rotate('G');
        adv.move(board);
        Assert.assertEquals(2, adv.getX());

        adv.rotate('G');
        adv.move(board);
        Assert.assertEquals(2, adv.getY());

        adv.rotate('G');
        adv.move(board);
        Assert.assertEquals(1, adv.getX());

        adv.rotate('G');
        board.addMountain(1,3);
        Assert.assertEquals(1, adv.move(board));
        adv.rotate('D');
        board.addMountain(0,2);
        Assert.assertEquals(1, adv.move(board));
        adv.rotate('D');
        board.addMountain(1,1);
        Assert.assertEquals(1, adv.move(board));
        adv.rotate('D');
        board.addMountain(2,2);
        Assert.assertEquals(1, adv.move(board));
    }



}
