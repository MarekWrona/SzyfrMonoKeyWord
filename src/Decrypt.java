public class Decrypt {

    public String decryptText(String encryptedPhrase, String alphabet, String codeAlphabet) {
        String result = "";
        for (int i = 0; i < encryptedPhrase.length(); i++) {
            int place = codeAlphabet.indexOf(encryptedPhrase.charAt(i));
            result = result.concat(String.valueOf(alphabet.charAt(place)));
        }
        return result;
    }
}
