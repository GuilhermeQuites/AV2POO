import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static ArrayList<Evento> eventos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;

        do {
            exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    eventos.add(criarEvento());
                    break;
                case 2:
                    pedidos.add(criarPedido());
                    break;
                case 3:
                    validarPedidoItemExistente();
                    break;
                case 4:
                    validarAtualizacaoQtdeIngresso();
                    break;
                case 5:
                    validarAtualizacaoStatusPedido();
                    break;
                case 6:
                    validarCalculoTotalPagar();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n====== Menu ======");
        System.out.println("1. Inserir Evento");
        System.out.println("2. Inserir Pedido");
        System.out.println("3. Validar PedidoItem Existente");
        System.out.println("4. Validar Atualização de Qtde Ingresso");
        System.out.println("5. Validar Atualização de Status do Pedido");
        System.out.println("6. Validar Cálculo Total a Pagar");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Evento criarEvento() {
        System.out.println("Informe os detalhes do evento:");
        System.out.print("Nome: ");
        String nomeEvento = scanner.next();
        System.out.print("Data (yyyy-MM-dd): ");
        Date dataEvento = lerData();
        System.out.print("Preço: ");
        double precoEvento = scanner.nextDouble();
        System.out.print("Descrição: ");
        String descEvento = scanner.next();
        System.out.print("Quantidade de Ingressos: ");
        int qtdeIngresso = scanner.nextInt();
        System.out.print("Categoria: ");
        Categoria categoria = new Categoria(scanner.next());

        return new Evento(nomeEvento, dataEvento, precoEvento, descEvento, qtdeIngresso, categoria);
    }

    private static Date lerData() {
        Date dataEvento = null;
        try {
            String dataString = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dataEvento = dateFormat.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataEvento;
    }

    private static Pedido criarPedido() {
        System.out.println("Informe os detalhes do pedido:");
        System.out.print("Número do Pedido: ");
        int numeroPedido = scanner.nextInt();
        Pedido pedido = new Pedido(numeroPedido);

        for (int i = 0; i < 3; i++) {
            System.out.println("Informe os detalhes do item " + (i + 1) + ":");
            PedidoItem item = criarPedidoItem();
            pedido.inserirItensPedido(item);
        }

        return pedido;
    }

    private static PedidoItem criarPedidoItem() {
        System.out.print("Nome do Evento: ");
        String nomeEvento = scanner.next();
        System.out.print("Quantidade de Ingressos: ");
        int qtdeIngresso = scanner.nextInt();
        System.out.print("Preço do Ingresso: ");
        double precoIngresso = scanner.nextDouble();

        return new PedidoItem(nomeEvento, qtdeIngresso, precoIngresso);
    }

    private static void validarPedidoItemExistente() {
        System.out.println("Validando PedidoItem Existente:");
        PedidoItem itemInvalido = criarPedidoItem();
        Pedido pedidoInvalido = criarPedido();
        pedidoInvalido.inserirItensPedido(itemInvalido);  // Deve exibir "Evento não encontrado."
    }

    private static void validarAtualizacaoQtdeIngresso() {
        System.out.println("Validando Atualização de Qtde Ingresso:");
        int qtdeInicial = eventos.get(0).getQtdeIngresso();
        PedidoItem item = criarPedidoItem();
        Pedido pedido = criarPedido();
        pedido.inserirItensPedido(item);
        int qtdeFinal = eventos.get(0).getQtdeIngresso();
        System.out.println("Qtde Ingresso Antes: " + qtdeInicial + ", Após: " + qtdeFinal);
    }

    private static void validarAtualizacaoStatusPedido() {
        System.out.println("Validando Atualização de Status do Pedido:");
        Pedido pedido = criarPedido();
        int statusFinal = pedido.getStatusPedido();
        System.out.println("Status do Pedido: " + statusFinal);  // Deve exibir "2"
    }

    private static void validarCalculoTotalPagar() {
        System.out.println("Validando Cálculo Total a Pagar:");
        Pedido pedido = criarPedido();
        double totalPagar = pedido.getPrecoTotal();
        System.out.println("Total a Pagar: " + totalPagar);  // Deve exibir o valor total calculado
    }
}
