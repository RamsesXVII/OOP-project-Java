package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
    private String nomeDirezione;
    private String nomeAttrezzo;

    public StanzaBloccata(String nome, String direzione, String attrezzo) {
        super(nome);
        this.nomeDirezione = direzione;
        this.nomeAttrezzo = attrezzo;
    }
    @Override
    public Stanza getStanzaAdiacente(String direzione) {
        if (this.nomeDirezione.equals(direzione) && !this.hasAttrezzo(nomeAttrezzo))
            return this;
        return super.getStanzaAdiacente(direzione);
    }
    @Override
    public String toString() {
        if (!this.hasAttrezzo(nomeAttrezzo)) {
            String s = "La stanza "+this.getNome()+" ha "
                        +"l'uscita "+this.nomeDirezione+" bloccata.\n";
            s+= "Ci vuole un qualcosa di nascosto sbloccare questa porta. ";
            return s += super.toString();
        }
        return super.getDescrizione();
    }

}