
package com.reactiveworks.webservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.12
 * 2020-03-12T11:48:03.328+05:30
 * Generated source version: 3.2.12
 */

@WebFault(name = "ProductDAOException", targetNamespace = "http://product.webservice.rwx.com")
public class ProductDAOException_Exception extends Exception {

    private com.reactiveworks.webservice.ProductDAOException productDAOException;

    public ProductDAOException_Exception() {
        super();
    }

    public ProductDAOException_Exception(String message) {
        super(message);
    }

    public ProductDAOException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ProductDAOException_Exception(String message, com.reactiveworks.webservice.ProductDAOException productDAOException) {
        super(message);
        this.productDAOException = productDAOException;
    }

    public ProductDAOException_Exception(String message, com.reactiveworks.webservice.ProductDAOException productDAOException, java.lang.Throwable cause) {
        super(message, cause);
        this.productDAOException = productDAOException;
    }

    public com.reactiveworks.webservice.ProductDAOException getFaultInfo() {
        return this.productDAOException;
    }
}
