public class S {
    public String l;
    public String r;
    public String res;

    public S(RightPartS1 rightPart) {
		res=rightPart.m0.res;
	}

    public S(RightPartS2 rightPart) {
		l=rightPart.m0.res;
		r=rightPart.s0.res;
		res = "(" + l + " or " + r + ")";
	}

    public S(RightPartS3 rightPart) {
		l=rightPart.m0.res;
		r=rightPart.s0.res;
		res = "(" + l + " xor " + r + ")";
	}
}