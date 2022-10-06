package br.com.fabio.produtosapi.repository;

import br.com.fabio.produtosapi.resource.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
