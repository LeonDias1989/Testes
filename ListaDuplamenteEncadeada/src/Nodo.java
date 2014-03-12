public class Nodo {

	private Nodo proxima;
	private Nodo anterior;
	private Object dado;

	public Nodo(Object dado) {
		this.dado = dado;
	}

	public Nodo() {
		// Default Constructor
	}

	public Object getDado() {
		return dado;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public void setProximo(Nodo proxima) {
		this.proxima = proxima;
	}

	public Nodo getProximo() {
		return proxima;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}

	@Override
	public String toString() {

		return "" + dado;
	}

}
