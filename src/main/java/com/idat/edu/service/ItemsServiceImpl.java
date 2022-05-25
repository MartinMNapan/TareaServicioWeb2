package com.idat.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.Items;
import com.idat.edu.repository.ItemsRepository;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsRepository repository;

	@Override
	public void guardarItems(Items items) {
		// TODO Auto-generated method stub
		repository.save(items);

	}

	@Override
	public void actualizarItems(Items items) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(items);

	}

	@Override
	public void eliminarItems(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<Items> listarItems() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Items obtenerItemsId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
