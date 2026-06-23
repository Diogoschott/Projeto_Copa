public class EstadioBean {
    private int idEstadio;
    private String nomeEstadio;
    private int capacidade;
    private String cidade;
    
    public EstadioBean(int idEstadio, String nomeEstadio, int capacidade, String cidade) {
        this.idEstadio = idEstadio;
        this.nomeEstadio = nomeEstadio;
        this.capacidade = capacidade;
        this.cidade = cidade;
    }

    // Getters
    public int getIdEstadio() { return idEstadio; }
    public String getNomeEstadio() { return nomeEstadio; }
    public int getCapacidade() { return capacidade; }
    public String getCidade() { return cidade; }

    // Setters
    public void setIdEstadio(int idEstadio) { this.idEstadio = idEstadio; }
    public void setNomeEstadio(String nomeEstadio) { this.nomeEstadio = nomeEstadio; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    @Override
    public String toString() {
        return "ID: " + idEstadio + " | Estádio: " + nomeEstadio + 
               " | Capacidade: " + capacidade + " | Cidade: " + cidade;
    }
}