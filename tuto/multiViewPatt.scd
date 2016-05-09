(
a={ arg p, nbL;
	var a=View(p, p.bounds.extent.asRect);
	a.layout_(
		VLayout()
		.margins_(0)
		.spacing_(0)
	);
nbL.do{
	a.layout.add(
		View()
		.background_(Color.rand)
	)
}; a}
; 
b={arg p, value=[0,1,2];
	Plotter(parent: p).value_(value)
.interactionView.addAction(
	{arg self,x, y, mod, but, nbCl;
		if(but==1){w.mouseDownAction.value(but:1)}},
	\mouseDownAction
); b};

~makeGUI={ arg nbLignes=3, mel=[0,1,2];
	w=View(nil, Rect(0, 0, 400, 100)).front;
	~stream=Pseq([0,1], inf).asStream;
	z=	[a, b];
	y=	[nbLignes, mel];
	~action=		{ x=z[s].(w, y[s])};
w.mouseDownAction_{ arg self, xx, yy, mod,  but;
	if(but.postln==1)
	{
		s=~stream.next;
		~action.(s)
	}
};
w.onResize=
{try{x.bounds=w.bounds}
}
};

~changeVar={ arg nbLignes=3, mel=[0,1,2];
	y=[nbLignes, mel]; ~action.(s)
}
)

~makeGUI.(5);
~changeVar.(nbLignes:10, mel:[0,1,2,64,1])