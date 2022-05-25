package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.Items;

public interface ItemsService {
	void guardarItems(Items items);
	void actualizarItems(Items items);
	void eliminarItems(Integer id);
	List<Items> listarItems();
	Items obtenerItemsId(Integer id);
}
