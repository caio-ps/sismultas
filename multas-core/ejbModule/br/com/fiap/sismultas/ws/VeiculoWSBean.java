package br.com.fiap.sismultas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.core.Veiculo;
import br.com.fiap.sismultas.domain.VeiculoModelo;
import br.com.fiap.sismultas.ws.vo.ModeloVO;
import br.com.fiap.sismultas.ws.vo.VeiculoVO;

/**
 * Session Bean que hospeda os serviços relativos às operações com veículos.
 * 
 * @author caio-pereira
 * 
 */
@Stateless
@WebService(serviceName = "VeiculoWS")
public class VeiculoWSBean implements VeiculoWS {

	private static final Logger LOGGER = Logger.getLogger(VeiculoWS.class);
	
	@EJB
	private Veiculo veiculo;
	
	@Override
	public List<ModeloVO> getModelos() throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de consulta de modelos de veículos.");

			// -----------------------------------------------------------------------------------------//
			// ------ Consulta modelos -----------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<VeiculoModelo> modelos = VeiculoModelo.buscaTodos();
			
			// -----------------------------------------------------------------------------------------//
			// ------ Converte objeto de retorno -------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<ModeloVO> modelosVO = new ArrayList<ModeloVO>();
			
			for (VeiculoModelo modelo : modelos) {
				
				ModeloVO modeloVO = new ModeloVO(modelo);
				modelosVO.add(modeloVO);
				
			}
			
			return modelosVO;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de consulta de modelos de veículo.", ex);
			throw ex;
		}
		
	}

	@Override
	public VeiculoVO cadastra(VeiculoVO veiculoVO) throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de cadastro de veículo. Placa = " + veiculoVO.getPlaca());

			// -----------------------------------------------------------------------------------------//
			// ------ Cadastra veiculo -----------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			VeiculoVO veiculoCadastrado = this.veiculo.cadastra(veiculoVO);
			
			return veiculoCadastrado;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de cadastro de veículo.", ex);
			throw ex;
		}
		
	}


}
