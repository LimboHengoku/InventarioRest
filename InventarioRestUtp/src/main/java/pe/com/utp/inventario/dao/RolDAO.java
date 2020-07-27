package pe.com.utp.inventario.dao;

import java.util.List;

import pe.com.utp.inventario.entities.TipoLogueo;

public interface RolDAO {
	public List<TipoLogueo> listarRoles(String idTrans);
}
