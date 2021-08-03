/*
 * This program belongs to Eduardo A. Sosa Torres
 * WakkoTheWarner
 * https://github.com/wakkoTheWarner
 * Created in 8/2/2021
 * Version: 1.0
 */

public class passwordChecker {
    String password;

    public passwordChecker(String password) {
        this.password = password;
    }

    public boolean findComplexity() {
        // variable
        String[] capitalizedAlphabet = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
        String[] uncapitalizedAlphabet = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
        String[] specialCharacters = {"~","`","!","@","#","$","%","^","&","*","(",")","_","+","-","="};
        String[] numberCharacters = {"1","2","3","4","5","6","7","8","9","0"};
        int passwordLenght = this.password.length();
        boolean result;
        boolean capAlpha;
        boolean uncapAlpha;
        boolean numAlpha;
        boolean specAlpha;

        // code
        capAlpha = capitalLetters(capitalizedAlphabet);
        uncapAlpha = uncapitalLetters(uncapitalizedAlphabet);
        numAlpha = numberLetters(numberCharacters);
        specAlpha = specialLetters(specialCharacters);

        if (capAlpha == true && uncapAlpha == true && numAlpha == true && specAlpha == true && passwordLenght >= 6){
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public boolean capitalLetters(String[] capitalizedAlphabet) {
        boolean capAlpha;
        boolean result = true;
        for (int i = 0; i <= 25; i++){
            capAlpha = this.password.contains(capitalizedAlphabet[i]);
            if (capAlpha == true){
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }

    public boolean uncapitalLetters(String[] uncapitalizedAlphabet) {
        boolean capAlpha;
        boolean result = true;
        for (int i = 0; i <= 25; i++){
            capAlpha = this.password.contains(uncapitalizedAlphabet[i]);
            if (capAlpha == true){
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }

    public boolean numberLetters(String[] numberCharacters) {
        boolean capAlpha;
        boolean result = true;
        for (int i = 0; i <= 9; i++){
            capAlpha = this.password.contains(numberCharacters[i]);
            if (capAlpha == true){
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }

    public boolean specialLetters(String[] specialCharacters) {
        boolean capAlpha;
        boolean result = true;
        for (int i = 0; i <= 15; i++){
            capAlpha = this.password.contains(specialCharacters[i]);
            if (capAlpha == true){
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }
}
