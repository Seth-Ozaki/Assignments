import java.util.ArrayList;
import java.util.Random;

public class Puzzle{


    public ArrayList<Integer> getTenRolls(){
        Random rng = new Random();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            output.add(rng.nextInt(20));
        }
        return output;
    }

    public char getRandomLetter(){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};
        Random rng = new Random();
        return alphabet[rng.nextInt(25)];
    }

    public String generatePassword(){
        Random rng = new Random();
        ArrayList<Character> charArr = new ArrayList<Character>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};
        for(int i = 0; i<8;i++){
            charArr.add( alphabet[rng.nextInt(25)]);
        }
        String output = new String();
        for(char letter:charArr){
            output = output+letter;
        }
        return output;
    }

    public ArrayList<String> generatePasswordSet(int amount){
        Random rng = new Random();
        ArrayList<Character> charArr = new ArrayList<Character>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};
        ArrayList<String> output = new ArrayList<String>();
        for(int j = 0; j<amount;j++){
        for(int i = 0; i<8;i++){
            charArr.add( alphabet[rng.nextInt(25)]);
        }
        String word = new String();
        for(char letter:charArr){
            word = word+letter;
        }
        output.add(word);
        charArr.clear();
        }
        return output;
    }
    }