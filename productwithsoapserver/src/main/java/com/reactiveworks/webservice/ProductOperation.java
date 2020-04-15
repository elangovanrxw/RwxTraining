package com.reactiveworks.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.reactiveworks.productwithsoapserver.dao.exception.ProductDAOException;
import com.reactiveworks.productwithsoapserver.model.Product;

@WebService(targetNamespace = "http://product.webservice.rwx.com", name = "ProductOperation")
public interface ProductOperation {

	@WebMethod
    @WebResult(name = "create-result", targetNamespace = "http://product.webservice.rwx.com")
    public java.lang.String createProductOperation(
        @WebParam(name = "product", targetNamespace = "http://product.webservice.rwx.com")
        Product product
    ) throws ProductDAOException;

    @WebMethod
    @WebResult(name = "product", targetNamespace = "http://product.webservice.rwx.com")
    public Product getProductByNameOperation(
        @WebParam(name = "product-name", targetNamespace = "http://product.webservice.rwx.com")
        java.lang.String productName
    ) throws ProductDAOException;

    @WebMethod
    @WebResult(name = "udpate-result", targetNamespace = "http://product.webservice.rwx.com")
    public java.lang.String updateProductOperation(
        @WebParam(name = "product", targetNamespace = "http://product.webservice.rwx.com")
        Product product
    ) throws ProductDAOException;

    @WebMethod
    @WebResult(name = "product", targetNamespace = "http://product.webservice.rwx.com")
    public Product getProductByIdOperation(
        @WebParam(name = "product-id", targetNamespace = "http://product.webservice.rwx.com")
        java.lang.String productId
    ) throws ProductDAOException;

    @WebMethod
    @WebResult(name = "delete-result", targetNamespace = "http://product.webservice.rwx.com")
    public String deleteProductOperation(
        @WebParam(name = "product-id", targetNamespace = "http://product.webservice.rwx.com")
        java.lang.String productId
    ) throws ProductDAOException;
	
}
