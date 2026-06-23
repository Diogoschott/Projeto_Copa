public class ConsultaBean {
    private int idConsulta;
    private int idFisioterapeuta;
    private int idJogador;
    private int idLesao;
    private String dataConsulta;
    private String procedimentoRealizado;
    private String observacoesMedicas;

    public ConsultaBean(int idConsulta, int idFisioterapeuta, int idJogador, int idLesao, String dataConsulta, String procedimentoRealizado, String observacoesMedicas) {
        this.idConsulta = idConsulta;
        this.idFisioterapeuta = idFisioterapeuta;
        this.idJogador = idJogador;
        this.idLesao = idLesao;
        this.dataConsulta = dataConsulta;
        this.procedimentoRealizado = procedimentoRealizado;
        this.observacoesMedicas = observacoesMedicas;
    }

    public int getIdConsulta() { return idConsulta; }
    public int getIdFisioterapeuta() { return idFisioterapeuta; }
    public int getIdJogador() { return idJogador; }
    public int getIdLesao() { return idLesao; }
    public String getDataConsulta() { return dataConsulta; }
    public String getProcedimentoRealizado() { return procedimentoRealizado; }
    public String getObservacoesMedicas() { return observacoesMedicas; }
}