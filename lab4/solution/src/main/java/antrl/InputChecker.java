package antrl;

public class InputChecker { // TODO: проверка синтезируемых атрибутов - чтобы совпадали аргументы
    private final OwnInputListener listener;

    public InputChecker(OwnInputListener listener) {
        this.listener = listener;
        check();
    }

    private void check() {
        checkNonTerminalsInRightPartToHaveRules();
    }


    private void checkNonTerminalsInRightPartToHaveRules() {
        var nonTerminalsInRightPart = listener.getNonTerminalsInRightPart();
        var nonTerminals = listener.getNonTerminals();

        nonTerminalsInRightPart.forEach(nonTerminal -> {
            if (!nonTerminals.contains(nonTerminal)) {
                throw new IllegalArgumentException("no rule for non-terminal [" + nonTerminal + "]");
            }
        });
    }




}
