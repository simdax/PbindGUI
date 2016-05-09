
+ Pbind{
	getMel { arg dur=20;
		var res=this.nextNsec(dur).collect({|x|
			x.degree.isNil.if {(x.degree=0)};
			x.dur.isNil.if {(x.dur=1)};
			x
		}).flopDict;
		^(degree:res[\degree])++(dur:res[\dur])
	}
}

/*

Pbind(
	\degree, Pwhite(0, 10),
	\dur, Pwhite(0.31, 1.5)
).getMel

*/