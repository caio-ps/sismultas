package br.com.fiap.sismultas.ws;

import java.util.List;

import br.com.fiap.sismultas.mule.car.ws.ModeloVO;
import br.com.fiap.sismultas.mule.car.ws.VeiculoVO;
import br.com.fiap.sismultas.mule.car.ws.VeiculoWS;
import br.com.fiap.sismultas.mule.car.ws.VeiculoWSBean;

public class VeiculoService implements Veiculo {

	@Override
	public List<ModeloVO> getModelos() throws Exception {
		
		VeiculoWSBean veiculoWSBean = new VeiculoWS().getVeiculoWSBeanPort();
		return veiculoWSBean.getModelos();
		
	}

	@Override
	public VeiculoVO cadastra(VeiculoVO veiculoVO) throws Exception {
		
		VeiculoWSBean veiculoWSBean = new VeiculoWS().getVeiculoWSBeanPort();
		return veiculoWSBean.cadastra(veiculoVO);
		
	}

}
