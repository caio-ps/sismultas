package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;
import br.com.fiap.sismultas.ws.vo.MultaVO;


/**
 * The persistent class for the infracao database table.
 * 
 */
@Entity
@Table(name="infracao")
public class Infracao extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = -2835439329055498047L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="cep_local_ocorrencia")
	private String cepLocalOcorrencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ocorrencia")
	private Date dataOcorrencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_processamento")
	private Date dataProcessamento;

	@ManyToOne
	@JoinColumns(value={
		@JoinColumn(name="codigo_infracao_ctb"),
		@JoinColumn(name="desdobramento_ctb")
	})	
	private ItemCtb itemCtb;

	@ManyToOne
	@JoinColumn(name="id_fiscal")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name="chassi_veiculo")
	private Veiculo veiculo;

	@OneToMany(mappedBy="infracao")
	private List<Notificacao> notificacaos;
	
	@OneToMany(mappedBy="infracao")
	private List<StatusInfracao> statusInfracao;

	//------ Métodos da entidade ------//
	
	/**
	 * Busca uma infracao pelo Id.
	 * 
	 * @param id
	 * @return
	 */
	public static Infracao find(Long id) {
		
		return getEntityManager().find(Infracao.class, id);
		
	}
	
	/**
	 * Persiste os dados de uma infracao
	 * 
	 * @param infracao
	 */
	public void persist() {
	
		super.persist();
		
		if (this.getStatusInfracao() != null) {
			
			for (StatusInfracao statusInfracao : this.getStatusInfracao()) {
				statusInfracao.setInfracao(this);
				statusInfracao.persist();
			}
			
		}
		
	}
	
	public static List<Infracao> getByFilter(MultaVO filtro) {
		
		//Entity Manager
		EntityManager entityManager = getEntityManager();
		//Criteria Builder
		CriteriaBuilder critBuilder = entityManager.getCriteriaBuilder();
		//Query formato Criteria para consulta
		CriteriaQuery<Infracao> critQuery = critBuilder.createQuery(Infracao.class);
		//Mapa de parâmetros
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		//Mapa de predicados
		Map<String, Predicate> mapPredicados = new HashMap<String, Predicate>();
		//Entidade principal
		Root<Infracao> rootEntity = critQuery.from(Infracao.class);
		
		//--- Tratando cada um dos filtros ---//
		if (filtro.getPlacaVeiculo() != null && !filtro.getPlacaVeiculo().equals("")) {
			
			//Join
			Join<Infracao, Veiculo> joinVeiculo = rootEntity.join("veiculo");
			
			//Adiciona no mapa de predicados
			mapPredicados.put("placa", 
							  critBuilder.equal(
									  joinVeiculo.get("placa"),
									  critBuilder.parameter(String.class, "placa")));
			
			//Armazena valor do parâmetro no mapa de parâmetros
			mapParametros.put("placa", filtro.getPlacaVeiculo());
			
		}
		
		if (filtro.getDataOcorrencia() != null) {
			
			//Data inicio = 00:00:00:0
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(filtro.getDataOcorrencia());
			
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			//Objeto data início
			Date dataInicio = calendar.getTime();
			
			//Data fim = 23:59:59:9
			calendar.setTime(filtro.getDataOcorrencia());
			
			calendar.set(Calendar.HOUR, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 9);
			
			//Objeto data fim
			Date dataFim = calendar.getTime();
			
			ParameterExpression<Date> dataInicioParam = critBuilder.parameter(Date.class, "dataInicio");
			ParameterExpression<Date> dataFimParam = critBuilder.parameter(Date.class, "dataFim");
			
			Expression<Date> data = rootEntity.get("dataOcorrencia");

			//Armazena sentença no mapa de predicados
			mapPredicados.put("dataOcorrencia", critBuilder.between(data, dataInicioParam, dataFimParam));
			
			//Armazena valores no mapa de parâmetros
			mapParametros.put("dataInicio", dataInicio);
			mapParametros.put("dataFim", dataFim);
			
		}
		
		if (filtro.getCepLocalOcorrencia() != null && !filtro.getCepLocalOcorrencia().equals("")) {
			
			//Armazena sentença no mapa de predicados
			mapPredicados.put("cepLocalOcorrencia",
							  critBuilder.equal(
									  rootEntity.get("cepLocalOcorrencia"),
									  critBuilder.parameter(String.class, "cepLocalOcorrencia")));
			
			//Armazena valores no mapa de parâmetros
			mapParametros.put("cepLocalOcorrencia", filtro.getCepLocalOcorrencia());
			
		}
		
		if (filtro.getIdFiscal() != null) {
			
			//Join
			Join<Infracao, Pessoa> joinPessoa = rootEntity.join("pessoa");
			
			//Adiciona no mapa de predicados
			mapPredicados.put("fiscal", 
							  critBuilder.equal(
									  joinPessoa.get("id"),
									  critBuilder.parameter(Long.class, "fiscal")));
			
			//Armazena valor do parâmetro no mapa de parâmetros
			mapParametros.put("fiscal", filtro.getIdFiscal().longValue());
			
		}
		
		if (filtro.getCodigoInfracaoCtb() != null && !filtro.getCodigoInfracaoCtb().equals("")) {

			//Join
			Join<Infracao, ItemCtb> joinItemCtb = rootEntity.join("itemCtb");
			
			//Adiciona no mapa de predicados
			mapPredicados.put("codigoInfracao", 
							  critBuilder.equal(
									  joinItemCtb.get("pk").get("codigoInfracao"),
									  critBuilder.parameter(String.class, "codigoInfracao")));
			
			//Armazena valor do parâmetro no mapa de parâmetros
			mapParametros.put("codigoInfracao", filtro.getCodigoInfracaoCtb());
			
		}
		
		if (filtro.getDesdobramentoCtb() != null) {
			
			//Join
			Join<Infracao, ItemCtb> joinItemCtb = rootEntity.join("itemCtb");
			
			//Adiciona no mapa de predicados
			mapPredicados.put("desdobramento", 
							  critBuilder.equal(
									  joinItemCtb.get("pk").get("desdobramento"),
									  critBuilder.parameter(Integer.class, "desdobramento")));
			
			//Armazena valor do parâmetro no mapa de parâmetros
			mapParametros.put("desdobramento", filtro.getDesdobramentoCtb().intValue());
			
		}

		//Array de predicados
		Predicate[] predicados = null;
		//Contador
		int count = 0;
		
		//Predicados
		for (String key : mapPredicados.keySet()) {
			if (predicados == null) {
				predicados = new Predicate[mapPredicados.size()];
			}
			predicados[count++] = mapPredicados.get(key);
		}

		//Predicado geral
		Predicate predicadoGeral = null;
		
		//Há filtros
		if (count != 0) {
			predicadoGeral = critBuilder.and(predicados);
			critQuery.where(predicadoGeral);
		}
		
		//Query tipificada do criteria
		TypedQuery<Infracao> typedQuery = entityManager.createQuery(critQuery);
		
		//Parâmetros
		for (String key : mapParametros.keySet()) {
			typedQuery.setParameter(key, mapParametros.get(key));
		}
		
		//Retorno
		return typedQuery.getResultList();
		
	}
	
	//---------------------------------//
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCepLocalOcorrencia() {
		return this.cepLocalOcorrencia;
	}

	public void setCepLocalOcorrencia(String cepLocalOcorrencia) {
		this.cepLocalOcorrencia = cepLocalOcorrencia;
	}

	public Date getDataOcorrencia() {
		return this.dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public Date getDataProcessamento() {
		return this.dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public ItemCtb getItemCtb() {
		return this.itemCtb;
	}

	public void setItemCtb(ItemCtb itemCtb) {
		this.itemCtb = itemCtb;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Notificacao> getNotificacaos() {
		return this.notificacaos;
	}

	public void setNotificacaos(List<Notificacao> notificacaos) {
		this.notificacaos = notificacaos;
	}

	public List<StatusInfracao> getStatusInfracao() {
		return statusInfracao;
	}

	public void setStatusInfracao(List<StatusInfracao> statusInfracao) {
		this.statusInfracao = statusInfracao;
	}

	@Override
	public String toString() {
		return "Infracao [id=" + id + ", cepLocalOcorrencia="
				+ cepLocalOcorrencia + ", dataOcorrencia=" + dataOcorrencia
				+ ", dataProcessamento=" + dataProcessamento + ", itemCtb="
				+ itemCtb + ", pessoa=" + pessoa + ", veiculo=" + veiculo
				+ ", notificacaos=" + notificacaos + ", statusInfracao="
				+ statusInfracao + "]";
	}

}