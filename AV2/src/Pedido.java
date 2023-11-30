import java.util.ArrayList;
import java.util.Date;
class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = new Date();
        this.precoTotal = 0;
        this.statusPedido = 1;
        this.itensPedido = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<PedidoItem> itensPedido) {
        this.itensPedido = itensPedido;
    }



    public void inserirItensPedido(PedidoItem item) {
        if (Evento.buscarEvento(new Evento(item.getNomeEvento(), null, 0, null, 0, null), Main.eventos)) {
            this.itensPedido.add(item);
            item.atualizaEstoqueIngresso();
            this.statusPedido = 2;
            calculaTotalPagar();
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    public void excluirItensPedido(PedidoItem item) {
        if (this.itensPedido.contains(item)) {
            this.itensPedido.remove(item);
            item.atualizaEstoqueIngresso();
            calculaTotalPagar();
        } else {
            System.out.println("Item não encontrado no pedido.");
        }
    }

    public boolean consultarPedido(Pedido pedidoConsulta) {
        return this.numeroPedido == pedidoConsulta.getNumeroPedido();
    }

    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    public void calculaTotalPagar() {
        this.precoTotal = 0;
        for (PedidoItem item : this.itensPedido) {
            this.precoTotal += item.getPrecoIngresso() * item.getQtdeIngresso();
        }
    }
}