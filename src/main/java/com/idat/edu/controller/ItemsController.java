package com.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.edu.model.Items;
import com.idat.edu.service.ItemsService;

@Controller
@RequestMapping("item/v1")
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Items>> listar(){
		return new ResponseEntity<List<Items>>(service.listarItems(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Items items){
		service.guardarItems(items);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Items i = service.obtenerItemsId(id);
		if(i != null) {
			service.eliminarItems(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		service.eliminarItems(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Items items){
		
		Items i = service.obtenerItemsId(items.getIdItem());
		
		if(i != null) {
			service.actualizarItems(items);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Items> obtenerId(@PathVariable Integer id){
		
		Items i = service.obtenerItemsId(id);
		
		if(i != null) {
			return new ResponseEntity<Items>(service.obtenerItemsId(id), HttpStatus.OK);
		}
		return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
	}
	
}
