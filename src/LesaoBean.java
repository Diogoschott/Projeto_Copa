public class LesaoBean {
    private int idLesao;
    private int idPessoaJogador;
    private String tipoLesao;
    private String dataOcorrencia;
    private String gravidade;

    public LesaoBean(int idLesao, int idPessoaJogador, String tipoLesao, String dataOcorrencia, String gravidade) {
        this.idLesao = idLesao;
        this.idPessoaJogador = idPessoaJogador;
        this.tipoLesao = tipoLesao;
        this.dataOcorrencia = dataOcorrencia;
        this.gravidade = gravidade;
    }

    public int getIdLesao() { return idLesao; }
    public int getIdPessoaJogador() { return idPessoaJogador; }
    public String getTipoLesao() { return tipoLesao; }
    public String getDataOcorrencia() { return dataOcorrencia; }
    public String getGravidade() { return gravidade; }
}