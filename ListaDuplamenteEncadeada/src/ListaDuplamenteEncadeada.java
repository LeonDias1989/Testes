public class ListaDuplamenteEncadeada {

	private Nodo begin;
	private Nodo end;

	private int totalElements = 0;

	public ListaDuplamenteEncadeada() {
		// Default Constructor
	}

	public void addInBegin(Object dado) {

		Nodo novo = new Nodo(dado);

		if (totalElements == 0) {

			begin = end = novo;
		}

		novo.setProximo(begin);
		begin.setAnterior(novo);
		begin = novo;

		totalElements++;
	}

	public void addInEnd(Object dado) {

		Nodo novo = new Nodo(dado);

		if (totalElements == 0) {
			begin = end = novo;
		}

		end.setProximo(novo);
		novo.setAnterior(end);
		end = novo;

		totalElements++;

	}

	public Object removeInEnd() {

		if (totalElements == 1) {
			Nodo aux = new Nodo();
			aux = end;

			begin = end = null;

			totalElements--;
			return aux;
		} else if (totalElements > 0) {
			Nodo aux = new Nodo();
			aux = end;
			end = end.getAnterior();
			totalElements--;
			return aux;
		} else
			return null;
	}

	public Nodo removeInBegin() {

		if (totalElements == 1) {

			Nodo aux = new Nodo();
			aux = begin;

			begin = end = null;
			totalElements--;
			return aux;
		} else if (totalElements > 0) {
			Nodo aux = new Nodo();
			aux = begin;
			begin = begin.getProximo();

			totalElements--;
			return aux;

		} else
			return null;
	}

	/**
	 * Inicialmente, devemos verificar se a posi��o est� ou n�o ocupada. Se n�o
	 * estiver devemos lan�ar uma exce��o. Caso contr�rio, devemos verificar se
	 * a remo��o � do come�o ou do fim da Lista se for um destes casos
	 * simplesmente chamamos os m�todos que j� fizemos.
	 * 
	 * Por fim, se a remo��o � no interior da Lista devemos atualizar as
	 * refer�ncias das c�lulas relacionadas a c�lula que vamos remover (anterior
	 * e pr�xima). A pr�xima da anterior deve ser a pr�xima e a anterior da
	 * pr�xima deve ser a anterior.
	 */

	public Nodo removePorIndice(int index) {

		if (!this.contemElemento(index)) {
			throw new IllegalArgumentException("Posi��o n�o existe");
		}

		if (index == 0) {
			this.removeInBegin();
		} else if (index == this.totalElements - 1) {
			this.removeInEnd();
		} else {
			Nodo anterior = this.getElemento(index - 1);
			Nodo atual = anterior.getProximo();
			Nodo proxima = atual.getProximo();

			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);

			this.totalElements--;
		}

		return null;
	}

	public Nodo getFirstElement() {
		return begin;
	}

	public Nodo getLastElement() {
		return end;
	}

	public int getTotalElements() {

		return this.totalElements;
	}

	@Override
	public String toString() {
		if (totalElements == 0)
			return ("[]");

		String s = "[";
		for (Nodo aux = begin; aux != end; aux = aux.getProximo()) {

			s += aux.getDado().toString() + ", ";
		}
		s += end.getDado() + "]";

		return s;
	}

	public boolean contemElemento(Object dado) {

		for (Nodo i = begin; i != null; i = i.getProximo()) {

			if (i.getDado().equals(dado)) {
				return true;
			}

		}
		return false;
	}

	private Nodo getElemento(int indice) {

		Nodo aux = begin;

		if (indice >= totalElements) {
			return null;
		}
		for (int i = 0; i < indice; i++) {

			aux = aux.getProximo();
		}
		return aux;
	}

	public void addForIndex(int indice, Object dado) {
		if (indice == 0) {
			addInBegin(dado);
		} else if (indice == totalElements) {
			addInEnd(dado);
		} else {

			Nodo novo = new Nodo(dado);

			Nodo anterior = this.getElemento(indice - 1);
			Nodo proxima = anterior.getProximo();

			novo.setProximo(anterior.getProximo());
			novo.setAnterior(anterior);
			anterior.setProximo(novo);
			proxima.setAnterior(novo);
			totalElements++;
		}
	}

	// /////////////////////M�TODOS ESPECIAIS///////////////////////////

	public ListaDuplamenteEncadeada bubbleSort() {

		ListaDuplamenteEncadeada listAux = new ListaDuplamenteEncadeada();

		for (Nodo i = begin; i != end; i = i.getProximo()) {

			listAux.addInEnd(i.getDado());
		}
		listAux.addInEnd(end.getDado());

		for (int i = 0; i < totalElements; i++) {
			for (int j = i + 1; j < totalElements; j++) {

				String a = listAux.getElemento(i).getDado().toString();
				String b = listAux.getElemento(j).getDado().toString();

				int result = a.compareTo(b);

				if (result > 0) {

					Object aux = listAux.getElemento(i).getDado();
					listAux.getElemento(i).setDado(
							listAux.getElemento(j).getDado());
					listAux.getElemento(j).setDado(aux);
				}

			}

		}
		return listAux;

	}

	public ListaDuplamenteEncadeada reverse() {

		ListaDuplamenteEncadeada listAux = new ListaDuplamenteEncadeada();

		for (Nodo i = end; i != begin; i = i.getAnterior()) {

			listAux.addInEnd(i.getDado());

		}
		listAux.addInEnd(begin.getDado());
		return listAux;

	}

	public ListaDuplamenteEncadeada subList(int primeiraPos, int ultimaPos)
			throws NullPointerException {
		ListaDuplamenteEncadeada cell = new ListaDuplamenteEncadeada();

		for (Nodo i = begin; i != end; i = i.getProximo()) {

			cell.addInEnd(i.getDado());

		}
		cell.addInEnd(end.getDado());

		if (ultimaPos >= totalElements) {

			System.out
					.println("ERRO, a posi�� final � maior do que o tamanho da lista !.");
		}
		ListaDuplamenteEncadeada novaSublista = new ListaDuplamenteEncadeada();

		for (int i = 0; i < primeiraPos; i++) {
			cell.begin = cell.begin.getProximo();
		}

		for (int j = primeiraPos; j <= ultimaPos; j++) {
			novaSublista.addInEnd(cell.begin.getDado());
			cell.begin = cell.begin.getProximo();
		}
		return novaSublista;
	}

}
