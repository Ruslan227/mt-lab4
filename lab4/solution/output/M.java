public class M {
    public String l;
    public String r;
    public String res;

    public M(RightPartM1 rightPart) {
		res=rightPart.n0.res;
	}

    public M(RightPartM2 rightPart) {
		l=rightPart.n0.res;
		r=rightPart.m0.res;
		res = "(" + l + " and " + r + ")";
	}

    public M(RightPartM3 rightPart) {
		res=rightPart.t0.res;
	}

    public M(RightPartM4 rightPart) {
		l=rightPart.t0.res;
		r=rightPart.m0.res;
		res = "(" + l + " and " + r + ")";
	}
}