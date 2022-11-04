package utils;

import java.io.Serializable;
import java.util.*;

public class LookaheadUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Set<String> nonTerminalsWithEpsilonRules;
    private final Map<String, Set<String>> grammarTokenFirst;

    public LookaheadUtils(Set<String> nonTerminalsWithEpsilonRules, Map<String, Set<String>> grammarTokenFirst) {
        this.nonTerminalsWithEpsilonRules = nonTerminalsWithEpsilonRules;
        this.grammarTokenFirst = grammarTokenFirst;
    }

    public Set<String> getLookahead(List<String> tailRightPart, Set<String> lookahead) {
        var res = new HashSet<String>();
        String lexeme;

        if (tailRightPart.isEmpty()) {
            res.addAll(lookahead);
            return res;
        }

        do {
            lexeme = tailRightPart.get(0);
            Set<String> additionalLookahead = grammarTokenFirst.get(lexeme);

            assert additionalLookahead != null;

            res.addAll(additionalLookahead);
            tailRightPart = tailRightPart.subList(1, tailRightPart.size());
        } while (wasThereEpsilonRule(tailRightPart, lexeme));


        if (nonTerminalsWithEpsilonRules.contains(lexeme)) {
            res.addAll(lookahead);
        }

        return res;
    }

    private boolean wasThereEpsilonRule(List<String> tailRightPart, String lexeme) {
        return !tailRightPart.isEmpty() && nonTerminalsWithEpsilonRules.contains(lexeme);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LookaheadUtils that = (LookaheadUtils) o;
        return Objects.equals(nonTerminalsWithEpsilonRules, that.nonTerminalsWithEpsilonRules) && Objects.equals(grammarTokenFirst, that.grammarTokenFirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonTerminalsWithEpsilonRules, grammarTokenFirst);
    }
}
