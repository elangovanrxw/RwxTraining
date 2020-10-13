
package com.reactiveworks.webservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.12
 * 2020-03-12T11:48:03.064+05:30
 * Generated source version: 3.2.12
 *
 */
public final class ProductOperation_ProductOperation_Client {

    private static final QName SERVICE_NAME = new QName("http://product.webservice.rwx.com", "ProductOperationService");

    private ProductOperation_ProductOperation_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ProductOperationService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        ProductOperationService ss = new ProductOperationService(wsdlURL, SERVICE_NAME);
        ProductOperation port = ss.getProductOperation();

        {
        System.out.println("Invoking createProductOperation...");
        com.reactiveworks.webservice.Product _createProductOperation_product = new com.reactiveworks.webservice.Product();
        _createProductOperation_product.setProductId("ProductId-798816753");
        _createProductOperation_product.setProductName("ProductName-1527080713");
        _createProductOperation_product.setProductCategory("ProductCategory-1878825047");
        _createProductOperation_product.setPrice("Price-816134525");
        java.util.List<java.lang.String> _createProductOperation_productAvailableCities = new java.util.ArrayList<java.lang.String>();
        java.lang.String _createProductOperation_productAvailableCitiesVal1 = "_createProductOperation_productAvailableCitiesVal-215311570";
        _createProductOperation_productAvailableCities.add(_createProductOperation_productAvailableCitiesVal1);
        _createProductOperation_product.getAvailableCities().addAll(_createProductOperation_productAvailableCities);
        try {
            java.lang.String _createProductOperation__return = port.createProductOperation(_createProductOperation_product);
            System.out.println("createProductOperation.result=" + _createProductOperation__return);

        } catch (ProductDAOException_Exception e) {
            System.out.println("Expected exception: ProductDAOException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getProductByNameOperation...");
        java.lang.String _getProductByNameOperation_productName = "_getProductByNameOperation_productName-1598065070";
        try {
            com.reactiveworks.webservice.Product _getProductByNameOperation__return = port.getProductByNameOperation(_getProductByNameOperation_productName);
            System.out.println("getProductByNameOperation.result=" + _getProductByNameOperation__return);

        } catch (ProductDAOException_Exception e) {
            System.out.println("Expected exception: ProductDAOException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateProductOperation...");
        com.reactiveworks.webservice.Product _updateProductOperation_product = new com.reactiveworks.webservice.Product();
        _updateProductOperation_product.setProductId("ProductId-1229271551");
        _updateProductOperation_product.setProductName("ProductName-1293463872");
        _updateProductOperation_product.setProductCategory("ProductCategory-1862723400");
        _updateProductOperation_product.setPrice("Price-1407121261");
        java.util.List<java.lang.String> _updateProductOperation_productAvailableCities = new java.util.ArrayList<java.lang.String>();
        java.lang.String _updateProductOperation_productAvailableCitiesVal1 = "_updateProductOperation_productAvailableCitiesVal-844843955";
        _updateProductOperation_productAvailableCities.add(_updateProductOperation_productAvailableCitiesVal1);
        _updateProductOperation_product.getAvailableCities().addAll(_updateProductOperation_productAvailableCities);
        try {
            java.lang.String _updateProductOperation__return = port.updateProductOperation(_updateProductOperation_product);
            System.out.println("updateProductOperation.result=" + _updateProductOperation__return);

        } catch (ProductDAOException_Exception e) {
            System.out.println("Expected exception: ProductDAOException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getProductByIdOperation...");
        java.lang.String _getProductByIdOperation_productId = "_getProductByIdOperation_productId-72573485";
        try {
            com.reactiveworks.webservice.Product _getProductByIdOperation__return = port.getProductByIdOperation(_getProductByIdOperation_productId);
            System.out.println("getProductByIdOperation.result=" + _getProductByIdOperation__return);

        } catch (ProductDAOException_Exception e) {
            System.out.println("Expected exception: ProductDAOException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking deleteProductOperation...");
        java.lang.String _deleteProductOperation_productId = "_deleteProductOperation_productId1629182155";
        try {
            java.lang.String _deleteProductOperation__return = port.deleteProductOperation(_deleteProductOperation_productId);
            System.out.println("deleteProductOperation.result=" + _deleteProductOperation__return);

        } catch (ProductDAOException_Exception e) {
            System.out.println("Expected exception: ProductDAOException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}