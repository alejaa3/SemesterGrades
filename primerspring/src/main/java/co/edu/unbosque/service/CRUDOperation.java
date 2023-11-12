package co.edu.unbosque.service;

import java.util.List;

public interface CRUDOperation<T> {

	// 0 creado con exito
	// 1 no se pudo crear
	// 2 el usuarioname ya existe
	public int create(T data);

	public List<T> getAll();

	public int deleteById(Long id);

	//public int upDateById(Long id, T newData);

	public long count();

	public boolean exists(Long id);

}
