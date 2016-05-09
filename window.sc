/*

a=PbindView().front;
a.nbLignes=7;
a.mel=[0,5,12,7,4]
*/

PbindView : View {

	var <nbLignes, <mel;
	
	var stream, action,
	s, // streamVal
	z, y, //
	x // tmpView
	;
	*new{ arg p, b, nbL=3, mel=[1,0,1,2];
		^super.new(p, b).init(nbL, mel)
	}
	nbLignes_{ arg v;
		nbLignes=v; this.action;
	}
	mel_{ arg v;
		mel=v; this.action;
	}
	makeRayures { arg p;
		var a=View(p, p.bounds.extent.asRect);
		a.layout_(
			VLayout()
			.margins_(0)
			.spacing_(0)
		);
		nbLignes.do{
			a.layout.add(
				View()
				.background_(Color.rand)
			)
		};
		^a}
	makePlot{ arg p;
		^Plotter(parent: p).value_(mel)
		.interactionView.addAction(
			{arg self,x, y, mod, but, nbCl;
				if(but==1){this.mouseDownAction.value(but:1)}},
			\mouseDownAction
		)}
	action{
		x=
		this.perform(
			[\makeRayures, \makePlot][s],
			this
		)
	}
	init{ arg n, m;
		nbLignes=n; mel=m;
		stream=Pseq([0,1], inf).asStream;
		this.mouseDownAction_{ arg self, xx, yy, mod,  but;
			if(but==1)
			{
				s=stream.next;
				this.action
			}
		}.onResize=
		{try{x.bounds=this.bounds}
		}
	}
}

