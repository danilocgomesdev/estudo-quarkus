package fieg.core.tool.email;

public class ResultadoEmail {
	private String mensagem;
	private boolean enviado;
	private Throwable throwable;
	private Object dados;

	public ResultadoEmail(Throwable e, String msgErro) {
		throwable = e;
		mensagem = msgErro;
	}

	public ResultadoEmail(String msgSucesso) {
		enviado = true;
		mensagem = msgSucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public Object getDados() {
		return dados;
	}

	public void setDados(Object dados) {
		this.dados = dados;
	}

	public boolean isEnviado() {
		return enviado;
	}

	@Override
	public String toString() {
		return "ResultadoEmail{"
				+ "mensagem='" + mensagem
				+ '\''
				+ ", enviado=" + enviado
				+ ", throwable=" + throwable
				+ ", dados=" + dados
				+ '}';
	}
}
