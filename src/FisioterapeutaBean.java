public class FisioterapeutaBean {
    private int idPessoa;
    private String registoCrefito;
    private String especialidade;

    public FisioterapeutaBean(int idPessoa, String registoCrefito, String especialidade){
        this.idPessoa = idPessoa;
        this.registoCrefito = registoCrefito;
        this.especialidade = especialidade;
    }

    public int getIdPessoa() { return idPessoa; }
    public String getRegistroCrefito(){ return registoCrefito; }
    public String getEspecialidade() { return especialidade; }
}
