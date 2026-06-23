public class PessoaBean {
    private int idPessoa;
    private String nome;
    private String cpf;
    private String dataNascimento; // Guardamos como String aqui para facilitar
    
    public PessoaBean(int id, String nome, String cpf, String dataNascimento) {
        this.idPessoa = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getIdPessoa() { return idPessoa; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }
}