public class JogadorBean {
    private int idPessoa;
    private String posicao;
    private int numeroCamisa;
    
    public JogadorBean(int idPessoa, String posicao, int numeroCamisa) {
        this.idPessoa = idPessoa;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public int getIdPessoa() { return idPessoa; }
    public String getPosicao() { return posicao; }
    public int getNumeroCamisa() { return numeroCamisa; }
}