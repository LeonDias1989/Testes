public class Test {

	public static void main(String[] args) {
		//
		// Contato contato0 = new Contato("Leon ", "51-34699970");
		// Contato contato1 = new Contato("Vanessa ", "51-84377952");
		// Contato contato2 = new Contato("Leon Celular ", "51-85314027");

		int a = new Integer(1);
		int b = new Integer(2);
		int c = new Integer(3);
		int d = new Integer(4);

		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

		// lista.addInBegin(contato2);
		// lista.addInBegin(contato0);
		// lista.addInBegin(contato1);
		// lista.addInBegin(contato2);
		// lista.addInBegin(contato0);

		lista.addInBegin(100);
		lista.addInBegin(a);
		lista.addInBegin("B");
		lista.addInEnd(d);
		lista.addForIndex(2, "X");
		lista.addForIndex(2, b);
		lista.addForIndex(3, c);

		System.out.println(lista.toString());

	}

}
