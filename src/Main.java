import entities.Produto;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto("Playstation 5", 3285.89, 0.13);

        Function<Produto, Double> desconto = x -> x.getPreco() * (1 - x.getDesconto());

        UnaryOperator<Double> impostoMunicipal = x -> x >= 2500 ? x * 1.085 : x;

        UnaryOperator<Double> frete = x -> x >= 3000 ? x + 100 : x + 50;

        Double precoFinal = desconto.andThen(impostoMunicipal).andThen(frete).apply(produto);

        System.out.printf("Preço final R$ %.2f", precoFinal);

    }
}