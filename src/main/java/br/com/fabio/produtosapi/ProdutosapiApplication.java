package br.com.fabio.produtosapi;

import br.com.fabio.produtosapi.resource.model.Product;
import br.com.fabio.produtosapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProdutosapiApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProdutosapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(1L,"Bola",15.0,32.00);
		Product p2 = new Product(2L,"Meião",15.0,32.00);
		Product p3 = new Product(3L,"Colete",15.0,32.00);
		Product p4 = new Product(4L,"Caneleira",15.0,32.00);
		Product p5 = new Product(5L,"Camisa",15.0,32.00);
		Product p6 = new Product(6L,"Camiseta",15.0,32.00);
		Product p7 = new Product(7L,"Chuteira",15.0,32.00);
		Product p8 = new Product(8L,"Peteca",15.0,32.00);
		Product p9 = new Product(9L,"Calção",15.0,32.00);
		Product p10 = new Product(10L,"Munhequeira",15.0,32.00);
		Product p11 = new Product(11L,"Tornozeleira",15.0,32.00);
		Product p12 = new Product(12L,"Joelheira",15.0,32.00);
		Product p13 = new Product(13L,"Rede",15.0,32.00);

		productRepository.saveAll(List.of(
				p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13
		));

	}
}
