
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.rxwwebservice.stubs;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.12
 * 2020-03-11T15:10:53.850+05:30
 * Generated source version: 3.2.12
 *
 */

@javax.jws.WebService(
                      serviceName = "UserOperationService",
                      portName = "UserOperationImplPort",
                      targetNamespace = "http://userdao.rxwwebservice.com",
                      wsdlLocation = "file:/G:/EclipseIDE/JAVA_RW/usercrudsoap/WebContent/wsdl/useroperationimpl.wsdl",
                      endpointInterface = "com.rxwwebservice.stubs.UserOperation")

public class UserOperationImplPortImpl implements UserOperation {

    private static final Logger LOG = Logger.getLogger(UserOperationImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.rxwwebservice.stubs.UserOperation#createNewUserOperation(com.rxwwebservice.stubs.User arg0)*
     */
    public java.lang.String createNewUserOperation(com.rxwwebservice.stubs.User arg0) throws UserDAOException_Exception   {
        LOG.info("Executing operation createNewUserOperation");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-1408879938";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserDAOException_Exception("UserDAOException...");
    }

    /* (non-Javadoc)
     * @see com.rxwwebservice.stubs.UserOperation#getUserByUserIdOperation(java.lang.String arg0)*
     */
    public com.rxwwebservice.stubs.User getUserByUserIdOperation(java.lang.String arg0) throws UserDAOException_Exception   {
        LOG.info("Executing operation getUserByUserIdOperation");
        System.out.println(arg0);
        try {
            com.rxwwebservice.stubs.User _return = new com.rxwwebservice.stubs.User();
            _return.setUserId("UserId-752300382");
            _return.setUsername("Username-1517098174");
            _return.setEmail("Email1144676614");
            _return.setPhone("Phone-135556566");
            _return.setCity("City152817912");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserDAOException_Exception("UserDAOException...");
    }

    /* (non-Javadoc)
     * @see com.rxwwebservice.stubs.UserOperation#deleteUserByUserIdOperation(java.lang.String arg0)*
     */
    public java.lang.String deleteUserByUserIdOperation(java.lang.String arg0) throws UserDAOException_Exception   {
        LOG.info("Executing operation deleteUserByUserIdOperation");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-144619418";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserDAOException_Exception("UserDAOException...");
    }

    /* (non-Javadoc)
     * @see com.rxwwebservice.stubs.UserOperation#getUserByUserNameOperation(java.lang.String arg0)*
     */
    public com.rxwwebservice.stubs.User getUserByUserNameOperation(java.lang.String arg0) throws UserDAOException_Exception   {
        LOG.info("Executing operation getUserByUserNameOperation");
        System.out.println(arg0);
        try {
            com.rxwwebservice.stubs.User _return = new com.rxwwebservice.stubs.User();
            _return.setUserId("UserId1700222997");
            _return.setUsername("Username1480774192");
            _return.setEmail("Email113953917");
            _return.setPhone("Phone-1858511955");
            _return.setCity("City-846196881");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserDAOException_Exception("UserDAOException...");
    }

    /* (non-Javadoc)
     * @see com.rxwwebservice.stubs.UserOperation#updateExistingUserOperation(com.rxwwebservice.stubs.User arg0)*
     */
    public java.lang.String updateExistingUserOperation(com.rxwwebservice.stubs.User arg0) throws UserDAOException_Exception   {
        LOG.info("Executing operation updateExistingUserOperation");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return874475387";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new UserDAOException_Exception("UserDAOException...");
    }

}