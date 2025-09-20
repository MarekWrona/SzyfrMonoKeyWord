import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String alphabet = "";

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            alphabet = alphabet.concat(String.valueOf((char) (97 + i)));
        }
        System.out.println(alphabet);

        String userChoice;
        do {
            printMenu();
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1" -> {
                    String phrase = getReducedPhrase(alphabet, "zaszyfrowania");
                    String keyWord = getKeyWord();
                    String codeAlphabet = makeCodeAlphabet(keyWord);
                    String encryptedText = encryptText(phrase, codeAlphabet);
                    System.out.println("\nZaszyfrowana fraza: \n" + encryptedText);
                }
                case "2" -> {
                    String phrase = getReducedPhrase(alphabet, "rozszyfrowania");
                    String keyWord = getKeyWord();
                    String codeAlphabet = makeCodeAlphabet(keyWord);
                    String decryptedText = decryptText(phrase, codeAlphabet);
                    System.out.println("\nRozszyfrowana fraza to: \n" + decryptedText);
                }
                default -> System.out.println("Do zobaczenia!");
            }
        } while (userChoice.equals("1") || userChoice.equals("2"));

    }

    public static String getReducedPhrase(String alphabet, String option) {
        System.out.println("Podaj zdanie do " + option);
        String phrase = scanner.nextLine().toLowerCase();
        String reducedPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (alphabet.contains(String.valueOf(phrase.charAt(i))))
                reducedPhrase = reducedPhrase.concat(String.valueOf(phrase.charAt(i)));
        }
        return reducedPhrase;
    }

    public static String getKeyWord() {
        System.out.println("Podaj klucz");
        return scanner.nextLine().toLowerCase();
    }

    private static String makeCodeAlphabet(String keyWord) {
        String keyWordReduced = "";
        for (int i = 0; i < keyWord.length(); i++) {
            if (!keyWordReduced.contains(String.valueOf(keyWord.charAt(i))) && alphabet.contains(String.valueOf(keyWord.charAt(i)))) {
                keyWordReduced = keyWordReduced.concat(String.valueOf(keyWord.charAt(i)));
            }
        }
        String codeAlphabet = keyWordReduced;
        if (alphabet.length() > keyWordReduced.length()) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (!keyWordReduced.contains(String.valueOf(alphabet.charAt(i)))) {
                    codeAlphabet = codeAlphabet.concat(String.valueOf(alphabet.charAt(i)));
                }
            }
        }
        return codeAlphabet;
    }

    public static String encryptText(String phrase, String codeAlphabet) {
        String result = "";
        for (int i = 0; i < phrase.length(); i++) {
            int place = alphabet.indexOf(phrase.charAt(i));
            result = result.concat(String.valueOf(codeAlphabet.charAt(place)));
        }
        return result;
    }

    public static String decryptText(String encryptedPhrase, String codeAlphabet) {
        String result = "";
        for (int i = 0; i < encryptedPhrase.length(); i++) {
            int place = codeAlphabet.indexOf(encryptedPhrase.charAt(i));
            result = result.concat(String.valueOf(alphabet.charAt(place)));
        }
        return result;
    }

    private static void printMenu() {
        System.out.println("\nWybierz opcję");
        System.out.println("1 - Kodowanie tekstu");
        System.out.println("2 - Dekodowanie tekstu");
        System.out.println("Dowolny znak - Wyjście z programu");
    }
}
