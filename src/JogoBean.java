public class JogoBean {
    private int idJogo;
    private int idCampeonato;
    private int idEstadio;
    private String dataHoraJogo;
    private String placar;

    public JogoBean(int idJogo, int idCampeonato, int idEstadio, String dataHoraJogo, String placar) {
        this.idJogo = idJogo;
        this.idCampeonato = idCampeonato;
        this.idEstadio = idEstadio;
        this.dataHoraJogo = dataHoraJogo;
        this.placar = placar;
    }

    public int getIdJogo() { return idJogo; }
    public int getIdCampeonato() { return idCampeonato; }
    public int getIdEstadio() { return idEstadio; }
    public String getDataHoraJogo() { return dataHoraJogo; }
    public String getPlacar() { return placar; }
}