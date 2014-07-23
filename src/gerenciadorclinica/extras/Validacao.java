package gerenciadorclinica.extras;

import gerenciadorclinica.extras.exceptions.*;

public class Validacao {

	public static boolean validaCpf(String CPF) throws Exception{
		try{
			if(CPF.length() != 11)
				throw new CpfTamanhoErrado();
			if(CPF.contains(" "))
				throw new CpfContemEspaco();
			if(!(Long.parseLong(CPF) > 1000000000))
				throw new CpfContemLetra();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean validaRg(String RG){
		try{
			if(RG.length() != 9)
				throw new RgTamanhoErrado();
			if(RG.contains(" "))
				throw new RgContemEspaco();
			if(!(Long.parseLong(RG) > 100000000))
				throw new RgContemLetra();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void validaEmail(){
		// Faz esse ai blz
	}
	
	public static boolean validaTelefone(String telefone){
		try{
			if(telefone.length() != 10)
				throw new TelefoneTamanhoErrado();
			if(telefone.contains(" "))
				throw new TelefoneContemEspaco();
			if(!(Long.parseLong(telefone) > 1000000000))
				throw new TelefoneContemLetra();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
