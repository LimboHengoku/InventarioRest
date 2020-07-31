package pe.com.utp.inventario.dao;

import java.util.List;
import java.util.Map;

import pe.com.utp.inventario.entities.Antivirus;
import pe.com.utp.inventario.entities.SistemaOperativo;

public interface AntivirusDAO {
	public List<Antivirus> listarAntivirus();

	public List<SistemaOperativo> listarSO();

	public Map<String, String> registrarAntivirus(Antivirus a);

	public Map<String, String> registrarSO(SistemaOperativo so);

	public Map<String, String> actualizarAntivirus(Antivirus a);

	public Map<String, String> actualizarSO(SistemaOperativo so);

}
