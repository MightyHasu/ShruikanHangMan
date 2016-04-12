import java.io.*;
import java.util.*;

public class Word {
    public static String Word(int choise){
        File citys = new File("Citys.txt");
        File countries = new File("Countries.txt");
        File movies = new File("Movies");
        File dragons = new File("Funny");
        List<String> words = new ArrayList<>();
        switch (choise){
            case 1: try (BufferedReader reader = new BufferedReader(new FileReader("Citys.txt"))){
                int i = 0;
                while (true){
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }else{
                        words.add(line);
                    }
                }
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Citys.txt is missing.");
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;
            case 2: try (BufferedReader reader = new BufferedReader(new FileReader("Countries.txt"))){
                int i = 0;
                while (true){
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }else{
                        words.add(line);
                    }
                }
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Countries.txt is missing.");
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;
            case 3: try (BufferedReader reader = new BufferedReader(new FileReader("Rivers.txt"))){
                int i = 0;
                while (true){
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }else{
                        words.add(line);
                    }
                }
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Rivers.txt is missing.");
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;
            case 4: try (BufferedReader reader = new BufferedReader(new FileReader("Funny.txt"))){
                int i = 0;
                while (true){
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }else{
                        words.add(line);
                    }
                }
                reader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Funny.txt is missing.");
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;


            default:break;
        }
        Random random = new Random();
        int randomWord = random.nextInt(words.size() + 0 );
        return words.get(randomWord);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Изберете жанр!");
        System.out.println("1 - Градове в България.");
        System.out.println("2 - Държави.");
        System.out.println("3 - Реки.");
        System.out.println("4 - Забавни.");
        int choise = 0;
        while (true){
            try {
                choise = Integer.parseInt(sc.nextLine());
                if (choise<1||choise>4){
                    System.out.println("Invalid input!");
                }else
                    break;
            }catch (IllegalArgumentException iae){
                System.out.println("Invalid input!");
            }
        }
        String word = Word(choise).toUpperCase().trim();
        List<Character> wordToGuess = new ArrayList<>();
        String hint;
        if (choise == 4 ) {
            String[] arr = word.split("-");
            for (int i = 0; i <arr[0].length() ; i++) {
                wordToGuess.add(arr[0].charAt(i));
            }
            hint = arr[1];

        }else{
            for (int i = 0; i <word.length() ; i++) {
                wordToGuess.add(word.charAt(i));
            }

        }
    }
}
