public class DisputaBean {
    private int idJogador;
    private int idJogo;
    private int minutosEmQuadra;
    private int pontosMarcados;

    public DisputaBean(int idJogador, int idJogo, int minutosEmQuadra, int pontosMarcados) {
        this.idJogador = idJogador;
        this.idJogo = idJogo;
        this.minutosEmQuadra = minutosEmQuadra;
        this.pontosMarcados = pontosMarcados;
    }

    public int getIdJogador() { return idJogador; }
    public int getIdJogo() { return idJogo; }
    public int getMinutosEmQuadra() { return minutosEmQuadra; }
    public int getPontosMarcados() { return pontosMarcados; }
}