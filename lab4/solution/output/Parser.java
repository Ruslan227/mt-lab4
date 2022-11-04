import codegen.CodeGeneratorConstants;
import control.table.ControlTable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Parser {
    public final ControlTable controlTable = getControlTable();

    public Parser() {
        controlTable.setGrammarData(new GrammarData());
        controlTable.buildTable();
    }

    private ControlTable getControlTable() {
        ControlTable controlTable = null;

        try(var fileInputStream = new FileInputStream(CodeGeneratorConstants.OUTPUT_DIRECTORY + "controlTable.txt");
            var objectInputStream = new ObjectInputStream(fileInputStream)) {
            controlTable = (ControlTable) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return controlTable;
    }

    public E0 parse(String input) { // public Object parse(String input) {
        var r = (E0) controlTable.parse(input);
        controlTable.clearParsingState();
        return r;
    }

    public static void main(String[] args) {
        var p = new Parser();
//        S s = p.parse("( ( ) ) $");
//        System.out.println(1);
    }

}