package model.dao;

public interface BaseDAO<T> {
	
	public T cadastrar(T novaEntidade);

	public T consultar(T novaEntidade);

	public boolean alterar(T novaEntidade);

	public boolean deletar(int id);

}
