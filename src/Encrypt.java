public class Encrypt {
    public String encryptText(String phrase, String alphabet, String codeAlphabet) {
        String result = "";
        for (int i = 0; i < phrase.length(); i++) {
            int place = alphabet.indexOf(phrase.charAt(i));
            result = result.concat(String.valueOf(codeAlphabet.charAt(place)));
        }
        return result;
    }
}
