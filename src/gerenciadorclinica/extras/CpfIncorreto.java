package gerenciadorclinica.extras;

@SuppressWarnings("serial")
public class CpfIncorreto extends Exception {
	
	public CpfIncorreto(){
		super("CPF Incorreto!");
	}
	
}
