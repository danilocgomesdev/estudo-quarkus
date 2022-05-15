package fieg.modulos.dto;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class Arquivo {

    @FormParam("arquivo")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private byte[] arquivo;

    @FormParam("nomeUsuario")
    private String nomeUsuario;
    @FormParam("emailUsuario")
    private String emailUsuario;

    public Arquivo(){}

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
