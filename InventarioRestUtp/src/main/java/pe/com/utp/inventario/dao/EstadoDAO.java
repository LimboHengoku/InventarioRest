package pe.com.utp.inventario.dao;

import java.util.List;

import pe.com.utp.inventario.entities.Estado;

public interface EstadoDAO {

	public List<Estado> listarEstados(String idTrans);
}
