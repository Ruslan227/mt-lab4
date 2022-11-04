import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HelloWorld {
    public static void main(String[] args) {
        var s = "123 input 321";
        var reg = "[0-9]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        int ind = 10;
        if (m.find(5) && m.start() == ind) {
            System.out.println(m.end());
            System.out.println(m.group(0));
        }
    }
}