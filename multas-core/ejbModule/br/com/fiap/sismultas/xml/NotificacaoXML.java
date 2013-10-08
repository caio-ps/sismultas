package br.com.fiap.sismultas.xml;

import java.util.Calendar;

import br.com.fiap.sismultas.domain.Notificacao;

public class NotificacaoXML {

	private Long id;
	private CondutorXML condutor;
	private VeiculoXML veiculo;
	private InfracaoXML infracao;
	private CobrancaXML cobranca;

	public NotificacaoXML(Notificacao notificacao) {
		
		this.id = notificacao.getId();
		this.condutor = new CondutorXML(notificacao.getInfracao().getVeiculo().getPessoa().getNome());
		this.veiculo = new VeiculoXML(notificacao.getInfracao().getVeiculo().getPlaca(), 
				notificacao.getInfracao().getVeiculo().getVeiculoModelo().getDescricao());
		this.infracao = new InfracaoXML(notificacao.getInfracao().getId(),
				notificacao.getInfracao().getDataOcorrencia(), notificacao.getInfracao().getCepLocalOcorrencia(),
				notificacao.getInfracao().getItemCtb().getDescricaoResumida(),
				notificacao.getInfracao().getItemCtb().getInfracaoGravidade().getDescricao());
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(notificacao.getInfracao().getDataOcorrencia());
		calendario.add(Calendar.MONTH, 1);
		
		this.cobranca = new CobrancaXML(notificacao.getInfracao().getItemCtb().getValorMulta(),
				calendario.getTime());
		
	}
	
	public NotificacaoXML() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CondutorXML getCondutor() {
		return condutor;
	}

	public void setCondutor(CondutorXML condutor) {
		this.condutor = condutor;
	}

	public VeiculoXML getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoXML veiculo) {
		this.veiculo = veiculo;
	}

	public InfracaoXML getInfracao() {
		return infracao;
	}

	public void setInfracao(InfracaoXML infracao) {
		this.infracao = infracao;
	}

	public CobrancaXML getCobranca() {
		return cobranca;
	}

	public void setCobranca(CobrancaXML cobranca) {
		this.cobranca = cobranca;
	}

}
