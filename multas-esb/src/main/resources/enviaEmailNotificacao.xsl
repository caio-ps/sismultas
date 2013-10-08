<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:ns2="http://ws.sismultas.fiap.com.br/"
	xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	<xsl:template match="/">
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
			xmlns:ws="http://ws.sismultas.fiap.com.br/">
			<soapenv:Header />
			<soapenv:Body>
				<ws:enviaEmailNotificacao>
					<relatorio>
						<caminhoArquivo>
							<xsl:value-of
								select="soap:Envelope/soap:Body/ns2:geraArquivoNotificacaoResponse/return/caminhoArquivo" />
						</caminhoArquivo>
						<id>
							<xsl:value-of
								select="soap:Envelope/soap:Body/ns2:geraArquivoNotificacaoResponse/return/id" />
						</id>
						<tipoRelatorio>
							<xsl:value-of
								select="soap:Envelope/soap:Body/ns2:geraArquivoNotificacaoResponse/return/tipoRelatorio" />
						</tipoRelatorio>
					</relatorio>
				</ws:enviaEmailNotificacao>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
</xsl:stylesheet>