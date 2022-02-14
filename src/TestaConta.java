import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestaConta {


    public static void main(String [] args) {

        Cliente cli1 = new Cliente("Fabiano", true, "abc", 10);
        Cliente cli2 = new Cliente("Mentorama", true, "iop", 30);
        Cliente cli3 = new Cliente("Brasil", false, "qwe", 50);
        Cliente cli4 = new Cliente("André", true, "adr", 20);
        Cliente cli5 = new Cliente("Beatriz", false, "btz", 40);
        Cliente cli6 = new Cliente("Carlos", true, "cls", 60);
        Cliente cli7 = new Cliente("Denise", true, "dns", 70);
        Cliente cli8 = new Cliente("Felipe", true, "flp", 80);
        Cliente cli9 = new Cliente("Gabriela", false, "grl", 90);
        Cliente cli10 = new Cliente("Henrique", true, "hrq", 5);

        List<Cliente> clientes = Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6, cli7, cli8 ,cli9,cli10);
        //clientes.forEach(cli->System.out.println(cli.getCompras()));

        Stream<Cliente> stream = clientes.stream().filter(cliente -> cliente.getCompras()>0);

        List<Cliente> selecionados = stream.collect(Collectors.toList());
        selecionados.forEach(cliente -> System.out.println(cliente.getNome() + " - " + cliente.getCompras()));

        Cliente maxCompra = clientes.stream().max(Comparator.comparing(Cliente::getCompras)).orElseThrow();
        System.out.println("===========================================");
        System.out.println("Quem fez MAIS compras ?");
        System.out.println(maxCompra.getNome()+ " - " + maxCompra.getCompras());

        Cliente minCompra = clientes.stream().min(Comparator.comparing(Cliente::getCompras)).orElseThrow();
        System.out.println("===========================================");
        System.out.println("Quem fez MENOS compras ?");
        System.out.println(minCompra.getNome()+ " - " + minCompra.getCompras());

        double media = clientes.stream().mapToInt(cliente -> cliente.getCompras()).average().getAsDouble();
        System.out.println("===========================================");
        System.out.println("Qual foi a MÉDIA das compras ?");
        System.out.println("Média é de: " + media);
        System.out.println("===========================================");
    }
}
