package it.uniroma3.diadia.ambienti;



public class StanzaBuia extends Stanza {
    private String nomeAttrezzo;

    public StanzaBuia(String nome,String nomeAttrezzo) {
        super(nome);
        this.nomeAttrezzo = nomeAttrezzo;
    }
    
    @Override
    public String toString() {
       if (this.hasAttrezzo(this.nomeAttrezzo))
           return super.toString();
       else
       return "Qui c'è un buio pesto";
    }
}