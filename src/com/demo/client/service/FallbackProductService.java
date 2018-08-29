package com.demo.client.service;

import java.util.Collections;
import java.util.List;

import org.ironrhino.core.spring.configuration.Fallback;
import org.ironrhino.core.spring.configuration.StageConditional;
import org.ironrhino.core.util.AppInfo.Stage;

import com.demo.domain.Product;
import com.demo.service.ProductService;

@StageConditional(value = Stage.DEVELOPMENT)
@Fallback
public class FallbackProductService implements ProductService {

	@Override
	public List<Product> list() {
		return Collections.singletonList(getById("123"));
	}

	@Override
	public Product getById(String id) {
		Product product = new Product();
		product.setId(id);
		product.setName("name");
		product.setDescription("description");
		return product;
	}

}
