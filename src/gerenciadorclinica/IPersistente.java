package gerenciadorclinica;

public interface IPersistente {
	void salvar(DB db) throws Exception;
	void carregar(DB db) throws Exception;
	void remover(DB db) throws Exception;
}
