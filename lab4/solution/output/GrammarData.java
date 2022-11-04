import control.table.GrammarDataI;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

public class GrammarData implements GrammarDataI {
    public final Map<String, Function<Map<String, List<Object>>, Object>> rightPartConstructor = Map.ofEntries(
    	entry("E", RightPartE01::new),
    	entry("MorS", RightPartS2::new),
    	entry("SnotinE", RightPartE3::new),
    	entry("M", RightPartS1::new),
    	entry("N", RightPartM1::new),
    	entry("MxorS", RightPartS3::new),
    	entry("notT", RightPartN1::new),
    	entry("S", RightPartE1::new),
    	entry("T", RightPartM3::new),
    	entry("NandM", RightPartM2::new),
    	entry("a", RightPartT2::new),
    	entry("b", RightPartT3::new),
    	entry("c", RightPartT4::new),
    	entry("d", RightPartT5::new),
    	entry("e", RightPartT6::new),
    	entry("f", RightPartT7::new),
    	entry("TandM", RightPartM4::new),
    	entry("g", RightPartT8::new),
    	entry("h", RightPartT9::new),
    	entry("i", RightPartT10::new),
    	entry("SinE", RightPartE2::new),
    	entry("j", RightPartT11::new),
    	entry("k", RightPartT12::new),
    	entry("(E)", RightPartT1::new),
    	entry("l", RightPartT13::new),
    	entry("m", RightPartT14::new),
    	entry("n", RightPartT15::new),
    	entry("o", RightPartT16::new),
    	entry("p", RightPartT17::new),
    	entry("q", RightPartT18::new),
    	entry("r", RightPartT19::new),
    	entry("s", RightPartT20::new),
    	entry("t", RightPartT21::new),
    	entry("u", RightPartT22::new),
    	entry("v", RightPartT23::new),
    	entry("w", RightPartT24::new),
    	entry("x", RightPartT25::new),
    	entry("y", RightPartT26::new),
    	entry("z", RightPartT27::new)
    );


    @Override
    public Object reduceFromRightPart(Object rp) {
            switch (rp.getClass().getName()) {
                case "RightPartS1":
                    return new S((RightPartS1) rp);
                case "RightPartS2":
                    return new S((RightPartS2) rp);
                case "RightPartS3":
                    return new S((RightPartS3) rp);
                case "RightPartT1":
                    return new T((RightPartT1) rp);
                case "RightPartT2":
                    return new T((RightPartT2) rp);
                case "RightPartT3":
                    return new T((RightPartT3) rp);
                case "RightPartT4":
                    return new T((RightPartT4) rp);
                case "RightPartT5":
                    return new T((RightPartT5) rp);
                case "RightPartT6":
                    return new T((RightPartT6) rp);
                case "RightPartT7":
                    return new T((RightPartT7) rp);
                case "RightPartT8":
                    return new T((RightPartT8) rp);
                case "RightPartT9":
                    return new T((RightPartT9) rp);
                case "RightPartT10":
                    return new T((RightPartT10) rp);
                case "RightPartT11":
                    return new T((RightPartT11) rp);
                case "RightPartT12":
                    return new T((RightPartT12) rp);
                case "RightPartT13":
                    return new T((RightPartT13) rp);
                case "RightPartT14":
                    return new T((RightPartT14) rp);
                case "RightPartT15":
                    return new T((RightPartT15) rp);
                case "RightPartT16":
                    return new T((RightPartT16) rp);
                case "RightPartT17":
                    return new T((RightPartT17) rp);
                case "RightPartT18":
                    return new T((RightPartT18) rp);
                case "RightPartT19":
                    return new T((RightPartT19) rp);
                case "RightPartT20":
                    return new T((RightPartT20) rp);
                case "RightPartT21":
                    return new T((RightPartT21) rp);
                case "RightPartT22":
                    return new T((RightPartT22) rp);
                case "RightPartT23":
                    return new T((RightPartT23) rp);
                case "RightPartT24":
                    return new T((RightPartT24) rp);
                case "RightPartT25":
                    return new T((RightPartT25) rp);
                case "RightPartT26":
                    return new T((RightPartT26) rp);
                case "RightPartT27":
                    return new T((RightPartT27) rp);
                case "RightPartE1":
                    return new E((RightPartE1) rp);
                case "RightPartE2":
                    return new E((RightPartE2) rp);
                case "RightPartE3":
                    return new E((RightPartE3) rp);
                case "RightPartE01":
                    return new E0((RightPartE01) rp);
                case "RightPartM1":
                    return new M((RightPartM1) rp);
                case "RightPartM2":
                    return new M((RightPartM2) rp);
                case "RightPartM3":
                    return new M((RightPartM3) rp);
                case "RightPartM4":
                    return new M((RightPartM4) rp);
                case "RightPartN1":
                    return new N((RightPartN1) rp);

                default:
                    return null;
            }
    }

    @Override
    public Map<String, Function<Map<String, List<Object>>, Object>> getRightPartConstructor() {
        return rightPartConstructor;
    }

}