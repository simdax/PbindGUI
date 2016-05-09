+ Pbind {

	gui{ arg p, bounds;
		var b=PbindView(p, bounds);
		p ?? {b.front};
		b.onClose_{SkipJack.stop(this.hash)};
		SkipJack({
			b.nbLignes=this.patternpairs.asDict.size;
			b.mel=this.getMel.degree
		}, 0.8, name:this.hash);
	}
}


