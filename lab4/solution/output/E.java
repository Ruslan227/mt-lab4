public class E {
    public String l;
    public String r;
    public String res;

    public E(RightPartE1 rightPart) {
		res=rightPart.s0.res;
	}

    public E(RightPartE2 rightPart) {
		l=rightPart.s0.res;
		r=rightPart.e0.res;
		res = "(" + l + " in " + r + ")";
	}

    public E(RightPartE3 rightPart) {
		l=rightPart.s0.res;
		r=rightPart.e0.res;
		res = "(" + l + " not in " + r + ")";
	}
}