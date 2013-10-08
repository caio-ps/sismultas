package br.com.fiap.sismultas.core;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.domain.InfracaoGravidade;
import br.com.fiap.sismultas.domain.ItemCtb;
import br.com.fiap.sismultas.ws.vo.ItemCTBVO;

/**
 * Session Bean que representa um usuário
 */
@Stateless
@LocalBean
public class CodigoTransitoBrasileiroBean implements CodigoTransitoBrasileiro {

	private static final Logger LOGGER = Logger.getLogger(CodigoTransitoBrasileiro.class);

	@Override
	public ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO) {
		
		try {

			LOGGER.info("Iniciando processo de cadastro de item ctb. cod= " + itemCTBVO.getCodigoInfracao());

			// -----------------------------------------------------------------------------------------//
			// ------ Valida dados obrigatórios --------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			if (!itemCTBVO.valida()) {

				LOGGER.info("Falha no processo de cadastro de item ctb. cod= " + itemCTBVO.getCodigoInfracao());
				LOGGER.info("Dados obrigatórios não preenchidos.");

				ItemCTBVO retornoFalha = new ItemCTBVO("Erro. Dados obrigatórios não enviados.");

				return retornoFalha;

			}

			// -----------------------------------------------------------------------------------------//
			// ------ Verifica se existe a gravidade ---------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			InfracaoGravidade infracaoGravidade = InfracaoGravidade.find(itemCTBVO.getGravidade().getId());

			if (infracaoGravidade == null) {

				LOGGER.info("Falha no processo de cadastro de ctb. cod= " + itemCTBVO.getCodigoInfracao());
				LOGGER.info("Gravidade não encontrada.");

				ItemCTBVO retornoFalha = new ItemCTBVO("Gravidade não encontrada.");

				return retornoFalha;

			}
			
			// -----------------------------------------------------------------------------------------//
			// ------ Verifica se já existe o item -----------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			ItemCtb itemCTB = ItemCtb.buscaPorId(itemCTBVO.toEntityPk());

			if (itemCTB != null) {

				LOGGER.info("Falha no processo de cadastro de ctb. cod= " + itemCTBVO.getCodigoInfracao());
				LOGGER.info("Já existe o item cadastrado.");

				ItemCTBVO retornoFalha = new ItemCTBVO("Já existe o item cadastrado.");

				return retornoFalha;

			}
			
			// -----------------------------------------------------------------------------------------//
			// ------ Cria entidade ItemCTB e persiste na base de dados --------------------------------//
			// -----------------------------------------------------------------------------------------//
			itemCTB = itemCTBVO.toEntity();
			
			// -----------------------------------------------------------------------------------------//
			// ------ Persiste no banco de dados -------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			itemCTB.persist();

			LOGGER.info("ItemCTB cadastrado com sucesso. cod= " + itemCTBVO.getCodigoInfracao());
			return new ItemCTBVO(itemCTB);

		} catch (Exception ex) {

			LOGGER.error("Ocorreu um erro no cadastro de item ctb", ex);
			return new ItemCTBVO("Ocorreu um erro no cadastro de item ctb: " + ex.getMessage());

		}
		
	}

}
