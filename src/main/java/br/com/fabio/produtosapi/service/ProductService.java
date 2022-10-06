package br.com.fabio.produtosapi.service;

import br.com.fabio.produtosapi.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto update(Long id, ProductDto productDto);
    void delete(Long id);
    void validarProductDto(ProductDto productDto);

}
