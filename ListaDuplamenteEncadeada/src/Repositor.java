public class Repositor {

	private ListaDuplamenteEncadeada listaTelefonica;

	public Repositor() {

		listaTelefonica = new ListaDuplamenteEncadeada();

	}

	public void add(Contato contato) {

		listaTelefonica.addInEnd(contato);

	}

	@Override
	public String toString() {

		return listaTelefonica.toString();

	}

	public static void main(String[] args) {

		Contato a = new Contato("C", "123");
		Contato b = new Contato("A", "456");
		Contato c = new Contato("B", "124");

		Repositor repos = new Repositor();

		repos.add(b);
		repos.add(a);
		repos.add(c);
		repos.add(a);

		System.out.println(repos.toString());

	}

}
