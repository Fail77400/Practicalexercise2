package fr.practicalexercise.board;

import org.junit.*;

public class BoardTest {
    private Board board = new Board(3,4);

    @Test
    public void setGetTest()
    {
        board.setHeight(5);
        Assert.assertEquals(5, board.getHeight());
        board.setWidth(1);
        Assert.assertEquals(1,board.getWidth());
    }

    @Test
    public void getListMountainTest()
    {
        Assert.assertTrue(board.getListMountain().isEmpty());
        board.addMountain(1,2);
        Assert.assertEquals(1,board.getListMountain().get(0).getX());
        Assert.assertEquals(2,board.getListMountain().get(0).getY());
    }

    @Test
    public void getListTreasureTest()
    {
        Assert.assertTrue(board.getListTreasure().isEmpty());
        board.addTreasure(1,2,3);
        Assert.assertEquals(1,board.getListTreasure().get(0).getX());
        Assert.assertEquals(2,board.getListTreasure().get(0).getY());
        Assert.assertEquals(3,board.getListTreasure().get(0).getNbT());
    }

    @Test
    public void getListAdventurerTest()
    {
        Assert.assertTrue(board.getListAdventurer().isEmpty());
        board.addAdventurer("Lara", 'S', 1, 2, "ADDAA");
        Assert.assertEquals("Lara",board.getListAdventurer().get(0).getName_());
        Assert.assertEquals('S',board.getListAdventurer().get(0).getOrientation_());
        Assert.assertEquals(1,board.getListAdventurer().get(0).getX());
        Assert.assertEquals(2,board.getListAdventurer().get(0).getY());
        Assert.assertEquals("ADDAA",board.getListAdventurer().get(0).getPath());
    }

    @Test
    public void addMountainTest()
    {
        board.addMountain(1,2);
        Assert.assertEquals(1,board.getListMountain().size());
    }

    @Test
    public void addAdventurerTest()
    {
        board.addAdventurer("Lara", 'S', 1, 2, "ADDAA");
        Assert.assertEquals(1,board.getListAdventurer().size());
    }

    @Test
    public void addTreasureTest()
    {
        board.addTreasure(0,0,4);
        Assert.assertEquals(1,board.getListTreasure().size());
    }

    @Test
    public void isNotMountainTest()
    {
        board.addMountain(0,0);
        Assert.assertTrue(board.isNotMountain(1,1));
        Assert.assertFalse(board.isNotMountain(0,0));
    }

    @Test
    public void isNotAdventurerTest()
    {
        board.addAdventurer("Lara", 'S', 1, 2, "ADDAA");
        Assert.assertTrue(board.isNotAdventurer(1,1));
        Assert.assertFalse(board.isNotAdventurer(1,2));
    }

    @Test
    public void isTreasureTest()
    {
        board.addTreasure(0,0,5);
        Assert.assertTrue(board.isTreasure(0,0));
        Assert.assertFalse(board.isTreasure(1,0));
    }
}
