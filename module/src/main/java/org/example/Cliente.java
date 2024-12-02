package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable, Comparable<Cliente> {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String sobrenome;
    private String endereco;
    private String telefone;
    private int creditScore;


    // Construtor da classe
    public Cliente (String nome, String sobrenome, String endereco, String telefone, int creditScore) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.telefone = telefone;
        setCreditScore(creditScore);
    }

    ////////////// Getters e Setters //////////////

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        if (creditScore < 0 || creditScore > 100) {
            throw new IllegalArgumentException("Credit score deve ser entre 0 e 100.");
        }

        this.creditScore = creditScore;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return creditScore == cliente.creditScore &&
                nome.equals(cliente.nome) &&
                sobrenome.equals(cliente.sobrenome) &&
                telefone.equals(cliente.telefone) &&
                endereco.equals(cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, telefone, endereco, creditScore);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome());
    }
}
