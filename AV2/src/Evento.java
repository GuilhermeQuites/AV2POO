import java.util.ArrayList;
import java.util.Date;

class Evento {
    private String nomeEvento;
    private Date dataEvento;
    private double precoEvento;
    private String descEvento;
    private int qtdeIngresso;
    private Categoria categoria;

    public Evento(String nomeEvento, Date dataEvento, double precoEvento, String descEvento, int qtdeIngresso, Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.descEvento = descEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.categoria = categoria;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static boolean buscarEvento(Evento eventoBusca, ArrayList<Evento> eventos) {
        for (Evento evento : eventos) {
            if (evento.getNomeEvento().equals(eventoBusca.getNomeEvento())) {
                return true;
            }
        }
        return false;
    }
}