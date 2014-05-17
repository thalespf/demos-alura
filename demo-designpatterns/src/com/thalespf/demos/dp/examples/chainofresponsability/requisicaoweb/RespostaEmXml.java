package com.thalespf.demos.dp.examples.chainofresponsability.requisicaoweb;

import com.thalespf.demos.dp.domain.Conta;

class RespostaEmXml implements Resposta {
	private Resposta outraResposta;

	public RespostaEmXml(Resposta outraResposta) {
		this.outraResposta = outraResposta;
	}

	@Override
	public String responde(Conta conta, Requisicao req) {
		if (req.getFormato() == Formato.XML) {
			return ("<conta><titular>" + conta.getTitular()
					+ "</titular><saldo>" + conta.getSaldo()
					+ "</saldo></conta>");
		} else {
			return outraResposta.responde(conta, req);
		}
	}


}