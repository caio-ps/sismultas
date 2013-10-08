Sistema de automatização de multas
=========

Este é o TCC que apresentei na FIAP para concluir meu MBA em Desenvolvimento de Aplicações JAVA/SOA.

É um sistema de automatização do processo de emissão de multas de trânsito. A ideia foi criar um modelo
onde um guarda de trânsito conseguisse aplicar uma multa a um motorista infrator em poucos segundos,
através de uma interface mobile.

O sistema então processaria e enviaria a multa por e-mail ao infrator em poucas horas. Basicamente você
tomaria uma multa, e ao chegar em casa já teria o boleto em seu e-mail para pagamento.

A arquitetura foi toda feita seguindo o modelo de Arquitetura Orientada a Serviços (SOA), e as implementações
feitas em Java.

O ESB utilizado foi o MuleESB.

Nesta época eu ainda não tinha expertise para criar o projeto com maven, portanto os projetos estão no padrão
do Eclipse.

O servidor de aplicação utilizado foi o JBoss versão 6.

Abaixo a descrição dos módulos:

 - multas-core: A implementação de todos os serviços está neste módulo
 - multas-esb: Diagramas dos fluxos de serviços do ESB.
 - multas-mobile: Interface Android de aplicação de multas
 - multas-web: Portal WEB para gerenciamento, emissão de relatórios e cadastros.
 
PS: Nota do trabalho: 9.5
