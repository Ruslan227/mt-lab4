package base;

import java.util.List;

public class BasicOperations {

    // contract: lexeme is not empty
    public static boolean isNonTerminal(String lexeme) {
        return Character.isUpperCase(lexeme.charAt(0));
    }
    public static boolean isTerminal(String lexeme) {
        return !isNonTerminal(lexeme);
    }
    public static boolean isRightPartEpsilon(List<String> rightPart) {
        return rightPart.size() == 1 && rightPart.contains(Constants.EPS);
    }
    public static boolean isEpsilon(String token) {
        return token.equals(Constants.EPS);
    }
}
