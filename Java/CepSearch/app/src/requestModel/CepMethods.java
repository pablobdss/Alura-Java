package requestModel;

public class CepMethods {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    
    public CepMethods(){
    }

    public CepMethods(String cepUser){
        this.cep = cepUser;
    }

    public CepMethods(String logradouro, String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public CepMethods(CepRecord cepRecord) {
        this.cep = cepRecord.cep();
        this.logradouro = cepRecord.logradouro();
        this.bairro = cepRecord.bairro();
        this.localidade = cepRecord.localidade();
        this.uf = cepRecord.uf();
    }
    
    

    public String getCep() {
        return cep;
    }

    @Override
    public String toString(){
        return String.format("Cep: %s\nLogradouro: %s\nBairro: %s\nLocalidade: %s\nUF: %s", cep, logradouro, bairro, localidade, uf);
    }

}
