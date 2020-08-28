package fr.practicalexercise.parser;

import fr.practicalexercise.board.Adventurer;
import fr.practicalexercise.board.Board;
import fr.practicalexercise.board.Mountain;
import fr.practicalexercise.board.Treasure;

import java.io.*;
import java.util.ArrayList;

public class Parser {
    public Parser(String filename)
    {
        name_ = filename;
    }

    String name_;

    //method that read the input file, fill the objects, make the moves of adventurer
    public void parse()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(name_));
            String line;
            Board board = new Board(5,5);
            while ((line = br.readLine()) != null) {
                String[] token = line.split(" - ");
                if (token[0].equals("C")) {
                    board.setWidth(Integer.parseInt(token[1]));
                    board.setHeight(Integer.parseInt(token[2]));
                }
                if (token[0].equals("M")) {
                    board.addMountain(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                }
                if (token[0].equals("T")) {
                    board.addTreasure(Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]));
                }
                if (token[0].equals("A")) {
                    board.addAdventurer(token[1], token[4].charAt(0), Integer.parseInt(token[2]), Integer.parseInt(token[3]), token[5]);
                }
            }

            int nbmove = 0;
            int maxmove = max(board.getListAdventurer());
            while (nbmove < maxmove) {
                for (Adventurer adv : board.getListAdventurer()) {
                    if (nbmove < adv.getPath().length()) {
                        if (adv.getPath().charAt(nbmove) == 'A') {
                            int moved = adv.move(board);
                            if (board.isTreasure(adv.getX(), adv.getY()) && moved == 0) {
                                adv.addTreasure();
                            }
                        } else {
                            adv.rotate(adv.getPath().charAt(nbmove));
                        }

                    }
                }
                nbmove++;
            }

            br.close();
            write(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method that write the information after the adventurer's moves
    public void write(Board board)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write("C - " + board.getWidth() + " - " + board.getHeight() + "\n");
            for (Mountain mountain : board.getListMountain())
            {
                bw.write("M - " + mountain.getX() + " - " + mountain.getY() + "\n");
            }
            bw.write("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}\n");
            for (Treasure treasure : board.getListTreasure())
            {
                if (treasure.getNbT() > 0)
                    bw.write("T - " + treasure.getX() + " - " + treasure.getY() + " - " + treasure.getNbT() + "\n");
            }
            bw.write("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés} \n");
            for (Adventurer adv : board.getListAdventurer())
            {
                bw.write("A - " + adv.getName_() + " - " + adv.getX() + " - " + adv.getY() + " - " + adv.getOrientation_() + " - " + adv.getNbTreasure() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method that return the length max between path of each adventurer
    public int max(ArrayList<Adventurer> advs)
    {
        if (advs != null && !advs.isEmpty()) {
            int i = advs.get(0).getPath().length();

            for (Adventurer adv : advs) {
                if (i < adv.getPath().length()) {
                    i = adv.getPath().length();
                }
            }
            return i;
        }
        return 0;
    }
}
