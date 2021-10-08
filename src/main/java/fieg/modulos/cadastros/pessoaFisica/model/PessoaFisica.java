package com.estudo.cadastros.pessoaFisica.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_pessoafisica")
public class PessoaFisica implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataNascimento;
    private String nome;
    private String escolaridade;
    private String observacao;
    private String sexo;
    private String email;
    private String dataInscricao;
    private String dataCadastro;
    private String dataAlteracao;
    private String profissao;
    private String cpf;
    private String identidade;
    private String orgaoExpedidor;
    private String uf;
    private String unidade;
    private String status;
    private String cursando;
    private Integer idSistemaCadastro;
    private Integer idSistemaAlteracao;
    private Integer idOperadorCadastro;
    private Integer idOperadorAlteracao;
    private String dataExpedicaoRG;
    private String ufOrgaoExpedidor;
    @JsonIgnore
    @OneToMany(mappedBy = "enderecosPf")
    private List<EnderecoPessoaFisica> enderecos  = new ArrayList<>();

    public PessoaFisica() {
    }

    public PessoaFisica(Long id, String dataNascimento,
                        String nome, String escolaridade,
                        String observacao, String sexo,
                        String email, String dataInscricao,
                        String dataCadastro, String dataAlteracao,
                        String profissao, String cpf, String identidade,
                        String orgaoExpedidor, String uf, String unidade,
                        String status, String cursando, Integer idSistemaCadastro,
                        Integer idSistemaAlteracao, Integer idOperadorCadastro,
                        Integer idOperadorAlteracao, String dataExpedicaoRG,
                        String ufOrgaoExpedidor, List<EnderecoPessoaFisica> enderecos) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.escolaridade = escolaridade;
        this.observacao = observacao;
        this.sexo = sexo;
        this.email = email;
        this.dataInscricao = dataInscricao;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.profissao = profissao;
        this.cpf = cpf;
        this.identidade = identidade;
        this.orgaoExpedidor = orgaoExpedidor;
        this.uf = uf;
        this.unidade = unidade;
        this.status = status;
        this.cursando = cursando;
        this.idSistemaCadastro = idSistemaCadastro;
        this.idSistemaAlteracao = idSistemaAlteracao;
        this.idOperadorCadastro = idOperadorCadastro;
        this.idOperadorAlteracao = idOperadorAlteracao;
        this.dataExpedicaoRG = dataExpedicaoRG;
        this.ufOrgaoExpedidor = ufOrgaoExpedidor;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCursando() {
        return cursando;
    }

    public void setCursando(String cursando) {
        this.cursando = cursando;
    }

    public Integer getIdSistemaCadastro() {
        return idSistemaCadastro;
    }

    public void setIdSistemaCadastro(Integer idSistemaCadastro) {
        this.idSistemaCadastro = idSistemaCadastro;
    }

    public Integer getIdSistemaAlteracao() {
        return idSistemaAlteracao;
    }

    public void setIdSistemaAlteracao(Integer idSistemaAlteracao) {
        this.idSistemaAlteracao = idSistemaAlteracao;
    }

    public Integer getIdOperadorCadastro() {
        return idOperadorCadastro;
    }

    public void setIdOperadorCadastro(Integer idOperadorCadastro) {
        this.idOperadorCadastro = idOperadorCadastro;
    }

    public Integer getIdOperadorAlteracao() {
        return idOperadorAlteracao;
    }

    public void setIdOperadorAlteracao(Integer idOperadorAlteracao) {
        this.idOperadorAlteracao = idOperadorAlteracao;
    }

    public String getDataExpedicaoRG() {
        return dataExpedicaoRG;
    }

    public void setDataExpedicaoRG(String dataExpedicaoRG) {
        this.dataExpedicaoRG = dataExpedicaoRG;
    }

    public String getUfOrgaoExpedidor() {
        return ufOrgaoExpedidor;
    }

    public void setUfOrgaoExpedidor(String ufOrgaoExpedidor) {
        this.ufOrgaoExpedidor = ufOrgaoExpedidor;
    }

    public List<EnderecoPessoaFisica> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoPessoaFisica> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaFisica)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


