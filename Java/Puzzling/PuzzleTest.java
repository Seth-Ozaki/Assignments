import java.util.Random;
import java.util.ArrayList;
public class PuzzleTest{

    public static void main(String[] args){

        Puzzle gen = new Puzzle();

        // ArrayList<Integer> randomRolls = gen.getTenRolls();
        // System.out.println(randomRolls);
        
        // System.out.println(gen.getRandomLetter());

        // System.out.println(gen.generatePassword());

        System.out.println(gen.generatePasswordSet(3));

    }
}