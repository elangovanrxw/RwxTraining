
package com.reactiveworks.webservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.reactiveworks.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.reactiveworks.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateProductOperation }
     * 
     */
    public CreateProductOperation createCreateProductOperation() {
        return new CreateProductOperation();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link CreateProductOperationResponse }
     * 
     */
    public CreateProductOperationResponse createCreateProductOperationResponse() {
        return new CreateProductOperationResponse();
    }

    /**
     * Create an instance of {@link UpdateProductOperation }
     * 
     */
    public UpdateProductOperation createUpdateProductOperation() {
        return new UpdateProductOperation();
    }

    /**
     * Create an instance of {@link UpdateProductOperationResponse }
     * 
     */
    public UpdateProductOperationResponse createUpdateProductOperationResponse() {
        return new UpdateProductOperationResponse();
    }

    /**
     * Create an instance of {@link DeleteProductOperation }
     * 
     */
    public DeleteProductOperation createDeleteProductOperation() {
        return new DeleteProductOperation();
    }

    /**
     * Create an instance of {@link DeleteProductOperationResponse }
     * 
     */
    public DeleteProductOperationResponse createDeleteProductOperationResponse() {
        return new DeleteProductOperationResponse();
    }

    /**
     * Create an instance of {@link GetProductByIdOperation }
     * 
     */
    public GetProductByIdOperation createGetProductByIdOperation() {
        return new GetProductByIdOperation();
    }

    /**
     * Create an instance of {@link GetProductByIdOperationResponse }
     * 
     */
    public GetProductByIdOperationResponse createGetProductByIdOperationResponse() {
        return new GetProductByIdOperationResponse();
    }

    /**
     * Create an instance of {@link GetProductByNameOperation }
     * 
     */
    public GetProductByNameOperation createGetProductByNameOperation() {
        return new GetProductByNameOperation();
    }

    /**
     * Create an instance of {@link GetProductByNameOperationResponse }
     * 
     */
    public GetProductByNameOperationResponse createGetProductByNameOperationResponse() {
        return new GetProductByNameOperationResponse();
    }

    /**
     * Create an instance of {@link ProductDAOException }
     * 
     */
    public ProductDAOException createProductDAOException() {
        return new ProductDAOException();
    }

}
