package com.demo.client.action;

import java.util.List;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.domain.Product;
import com.demo.service.ProductService;

@AutoConfig
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 7363154295606991023L;

	@Autowired
	private ProductService productService;

	private Product product;

	private List<Product> productList;

	public Product getProduct() {
		return product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public String execute() {
		String id = getUid();
		if (id != null) {
			product = productService.getById(id);
			return VIEW;
		} else {
			productList = productService.list();
			return LIST;
		}
	}

}
