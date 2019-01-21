package com.demo.client.action;

import java.util.List;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.domain.Product;

import lombok.Getter;

@AutoConfig
public class ProductAction extends BaseAction {

	private static final long serialVersionUID = 7363154295606991023L;

	@Autowired
	private Logger logger;

	@Autowired
	// private com.demo.service.ProductService productService;
	private com.demo.api.ProductService productService;

	@Getter
	private Product product;

	@Getter
	private List<Product> productList;

	public String execute() {
		String id = getUid();
		if (id != null) {
			logger.info("try find product {}", id);
			product = productService.getById(id);
			if (product == null)
				return NOTFOUND;
			return VIEW;
		} else {
			productList = productService.list();
			return LIST;
		}
	}

}
