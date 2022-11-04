public class N {
    public String res;

    public N(RightPartN1 rightPart) {
		res=rightPart.t0.res;
		res = "(not " + res + ")";
	}
}