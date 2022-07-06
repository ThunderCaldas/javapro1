package br.com.exercicio.exercicio2pt1;

public class DadosCont {

    private Integer Id;
    private String Nome;
    private Integer Idade;

    public DadosCont(Integer id, String nome, Integer idade) {
        Id = id;
        Nome = nome;
        Idade = idade;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }
}
