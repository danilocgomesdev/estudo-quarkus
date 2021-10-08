package fieg.modulos.cadastros.pessoaFisica.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tb_enderecopessoafisica")
public class EnderecoPessoaFisica {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoaId")
    private PessoaFisica enderecosPf;

    public PessoaFisica getEnderecosPf() {
        return enderecosPf;
    }

    public void setEnderecosPf(PessoaFisica enderecosPf) {
        this.enderecosPf = enderecosPf;
    }

    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone1;
    private String telefone2;
    private String complemento;
    private String numero;
    private String cep;
    private Integer idSistemaCadastro;
    private Integer idSistemaAlteracao;
    private Integer idOperadorCadastro;
    private Integer idOperadorAlteracao;
    private Integer tipoEndereco;

   public EnderecoPessoaFisica(){
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public Integer getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(Integer tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnderecoPessoaFisica)) return false;
        EnderecoPessoaFisica that = (EnderecoPessoaFisica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public EnderecoPessoaFisica(Long id, PessoaFisica enderecosPf,
                                String endereco, String bairro,
                                String cidade, String estado,
                                String telefone1, String telefone2,
                                String complemento, String numero,
                                String cep, Integer idSistemaCadastro,
                                Integer idSistemaAlteracao, Integer idOperadorCadastro,
                                Integer idOperadorAlteracao, Integer tipoEndereco) {
        this.id = id;
        this.enderecosPf = enderecosPf;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.idSistemaCadastro = idSistemaCadastro;
        this.idSistemaAlteracao = idSistemaAlteracao;
        this.idOperadorCadastro = idOperadorCadastro;
        this.idOperadorAlteracao = idOperadorAlteracao;
        this.tipoEndereco = tipoEndereco;


    }
}
