public class CampeonatoBean {
    private int idCampeonato;
    private String nomeCampeonato;
    private int anoEdicao;
   
    public CampeonatoBean(int id, String nome, int ano) {
        this.idCampeonato = id;
        this.nomeCampeonato = nome;
        this.anoEdicao = ano;
    }

    public int getIdCampeonato() { return idCampeonato; }
    public String getNomeCampeonato() { return nomeCampeonato; }
    public int getAnoEdicao() { return anoEdicao; }
}