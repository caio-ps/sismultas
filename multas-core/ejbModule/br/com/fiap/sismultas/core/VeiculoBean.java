package br.com.fiap.sismultas.core;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.domain.Veiculo;
import br.com.fiap.sismultas.domain.VeiculoModelo;
import br.com.fiap.sismultas.ws.vo.VeiculoVO;

/**
 * Session Bean que representa um usuário
 */
@Stateless
@LocalBean
public class VeiculoBean implements br.com.fiap.sismultas.core.Veiculo {

	private static final Logger LOGGER = Logger.getLogger(Veiculo.class);

	@Override
	public VeiculoVO cadastra(VeiculoVO veiculoVO) {
		
		try {

			LOGGER.info("Iniciando processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());

			// -----------------------------------------------------------------------------------------//
			// ------ Valida dados obrigatórios --------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			if (!veiculoVO.valida()) {

				LOGGER.info("Falha no processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());
				LOGGER.info("Dados obrigatórios não preenchidos.");

				VeiculoVO retornoFalha = new VeiculoVO("Erro. Dados obrigatórios não enviados.");

				return retornoFalha;

			}

			// -----------------------------------------------------------------------------------------//
			// ------ Verifica se existe o usuário -----------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			Pessoa usuario = Pessoa.buscaPorUsuario(veiculoVO.getUsuario());

			if (usuario == null) {

				LOGGER.info("Falha no processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());
				LOGGER.info("Usuário não encontrado.");

				VeiculoVO retornoFalha = new VeiculoVO("Usuário não encontrado.");

				return retornoFalha;

			}
			
			// -----------------------------------------------------------------------------------------//
			// ------ Verifica se existe o modelo ------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			VeiculoModelo modelo = VeiculoModelo.find(veiculoVO.getModeloVO().getId());

			if (modelo == null) {

				LOGGER.info("Falha no processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());
				LOGGER.info("Modelo de veículo não encontrado.");

				VeiculoVO retornoFalha = new VeiculoVO("Modelo de veículo não encontrado.");

				return retornoFalha;

			}
			
			// -----------------------------------------------------------------------------------------//
			// ------ Verifica se já existe o veículo --------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			Veiculo veiculo = Veiculo.find(veiculoVO.getChassi());

			if (veiculo != null) {

				LOGGER.info("Falha no processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());
				LOGGER.info("Já existe um veículo com este chassi.");

				VeiculoVO retornoFalha = new VeiculoVO("Já existe um veículo com este chassi.");

				return retornoFalha;

			}
			
			veiculo = Veiculo.buscaPorPlaca(veiculoVO.getPlaca());

			if (veiculo != null) {

				LOGGER.info("Falha no processo de cadastro de veículo. Placa = " + veiculoVO.getPlaca());
				LOGGER.info("Já existe um veículo com esta placa.");

				VeiculoVO retornoFalha = new VeiculoVO("Já existe um veículo com esta placa.");

				return retornoFalha;

			}

			// -----------------------------------------------------------------------------------------//
			// ------ Cria entidade Veiculo e persiste na base de dados --------------------------------//
			// -----------------------------------------------------------------------------------------//
			veiculo = veiculoVO.toEntity();
			veiculo.setPessoa(usuario);
			veiculo.setVeiculoModelo(modelo);
			
			// -----------------------------------------------------------------------------------------//
			// ------ Persiste no banco de dados -------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			veiculo.persist();

			LOGGER.info("Veiculo cadastrado com sucesso. Placa = " + veiculo.getPlaca());
			return new VeiculoVO(veiculo);

		} catch (Exception ex) {

			LOGGER.error("Ocorreu um erro no cadastro de veiculo", ex);
			return new VeiculoVO("Ocorreu um erro no cadastro de veiculo: " + ex.getMessage());

		}
	}

}
