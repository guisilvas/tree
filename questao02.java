
boolean pesquisar(String nome){
	boolean resp = pesquisar(nome, raiz);
}

boolean pesquisar(String nome, No i){
	boolean resp = false;

	if(i==nul){
		// ERROOOOO Nao existe caractere
	} if(nome.charAt(0) < i.caracter){
		resp = pesquisar(nome, i.esq);

	}else if(nome.charAt(0) > i.caracter){
		resp = pesquisar(nome, i.dir);

	} else {
		// Aqui eu tenho T1;
		char lastCaracter = nome.charAt(nome.length-1);

		int pos = hashT1(lastCaracter);
		if(i.t1.palavras[pos].compareTo(NULO) != 0){
			if(i.t1.palavras[pos].compareTo(nome) == 0){
				resp = true;

			} else { // rehash T1
				int pos2 = rehashT1(lastCaracter);
				if(i.t1.palavras[pos2].compareTo(NULO) != 0){
					if(i.t1.palavras[pos2].compareTo(nome) == 0){
						resp = true;

					} else { // vai para T2
						resp = buscaT2(i, palavra)
					}
				}
			}
		} 
	}
	return resp;
}

boolean buscaT2(no i, String palavra){
	int tam = nome.length;
	int posT2 = hashT2(tam);
	int resp = false;
	Celula temp = i.t1.t2.celulast2[posT2].inicio;
	
	while(temp != null){
		if(nome.compareTo(temp.palavra) == 0){
			resp = true;
			temp = null;
		} else {
			temp = temp.prox;
		}
	}
	return resp;	
}