package gerenciadorclinica.extras;

import java.util.regex.Pattern;

import gerenciadorclinica.extras.exceptions.*;

public class Validacao {
	
	// Padrão regex para validação do e-mail
	public static final Pattern pattern_email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static void validaCpf(String CPF) throws CpfInvalidoException{
		if(CPF.length() != 11)
			throw new CpfTamanhoInvalidoException();
		try{
			Long.parseLong(CPF);
		}catch(Exception e){
			throw new CpfInvalidoException();
		}
	}
	
	public static void validaRg(String RG) throws RgInvalidoException {
			if(RG.length() < 8 && RG.length() > 10)
				throw new RgTamanhoInvalidoException();
			try{
				Long.parseLong(RG);
			}catch(Exception e){
				throw new RgInvalidoException();
			}
	}
	
	public static void validaEmail(String email) throws EmailInvalidoException{
		if(!Validacao.pattern_email.matcher(email).matches())
			throw new EmailInvalidoException();
	}
	
	public static void validaTelefone(String telefone) throws TelefoneInvalidoException{
		if(!telefone.contains(" "))
			throw new TelefoneInvalidoException();
		String[] split = telefone.split(" ");
		
		// Checa consistência do DDD (2 dígitos)
		if(split[0].length() != 2)
			throw new TelefoneDDDInvalidoException();
		try{
			Long.parseLong(split[0]);
		}catch(Exception e){
			throw new TelefoneDDDInvalidoException();
		}
		
		// Checa consistência do número de telefone
		if(split[1].length() < 8)
			throw new TelefoneInvalidoException();	
		try{
			Long.parseLong(split[1]);
		}catch(Exception e){
			throw new TelefoneInvalidoException();
		}
		
	}

}
