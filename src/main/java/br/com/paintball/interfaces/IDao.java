package br.com.paintball.interfaces;

import java.util.List;

public interface IDao<T> {

	Object findById(Long id);
	List<T> list();
	void insert(T obj);
	void update(T obj);
	void remove(T obj);
	
}
