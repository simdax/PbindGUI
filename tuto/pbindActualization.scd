(

a=Pbind(\io, 5);
b=PbindView(nil, 200@200).front;
b.onClose_{SkipJack.stop("bob")};

SkipJack({
	b.nbLignes=a.patternpairs.asDict.size;
	b.mel=a.getMel.degree
}, 0.8, name:"bob");

)

a=Pbind(\degree, Prand([0,1,2,4], inf))

