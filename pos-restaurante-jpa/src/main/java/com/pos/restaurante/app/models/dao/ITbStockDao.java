package com.pos.restaurante.app.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.restaurante.app.models.entity.TbStock;

public interface ITbStockDao extends JpaRepository<TbStock, Long>{
	
    @Query("SELECT a FROM TbStock a  WHERE a.tbSucursal1.sucId = ?1 AND a.tbProveedor1.provId = ?2 AND a.tbProducto1.prodId= ?3")
	TbStock findBySucursalAndProveedorAndProducto(Long sucId, Long  provId, Long  prodId);
    
    @Query("SELECT a FROM TbStock a  WHERE a.tbProducto1.prodId= ?1")
	List<TbStock> findByStockProductoId(Long  prodId);
    


}
