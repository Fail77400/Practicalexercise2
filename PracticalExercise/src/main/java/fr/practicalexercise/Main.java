package fr.practicalexercise;

import fr.practicalexercise.parser.Parser;

public class Main {
    //used to run your example
    public static void main(String[] args) {
        Parser p = new Parser("input.txt");
        p.parse();
    }
}
