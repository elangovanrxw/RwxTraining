
package com.rxwwebservice.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rxwwebservice.stubs package. 
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

    private final static QName _CreateNewUserOperation_QNAME = new QName("http://userdao.rxwwebservice.com", "createNewUserOperation");
    private final static QName _CreateNewUserOperationResponse_QNAME = new QName("http://userdao.rxwwebservice.com", "createNewUserOperationResponse");
    private final static QName _DeleteUserByUserIdOperation_QNAME = new QName("http://userdao.rxwwebservice.com", "deleteUserByUserIdOperation");
    private final static QName _DeleteUserByUserIdOperationResponse_QNAME = new QName("http://userdao.rxwwebservice.com", "deleteUserByUserIdOperationResponse");
    private final static QName _GetUserByUserIdOperation_QNAME = new QName("http://userdao.rxwwebservice.com", "getUserByUserIdOperation");
    private final static QName _GetUserByUserIdOperationResponse_QNAME = new QName("http://userdao.rxwwebservice.com", "getUserByUserIdOperationResponse");
    private final static QName _GetUserByUserNameOperation_QNAME = new QName("http://userdao.rxwwebservice.com", "getUserByUserNameOperation");
    private final static QName _GetUserByUserNameOperationResponse_QNAME = new QName("http://userdao.rxwwebservice.com", "getUserByUserNameOperationResponse");
    private final static QName _UpdateExistingUserOperation_QNAME = new QName("http://userdao.rxwwebservice.com", "updateExistingUserOperation");
    private final static QName _UpdateExistingUserOperationResponse_QNAME = new QName("http://userdao.rxwwebservice.com", "updateExistingUserOperationResponse");
    private final static QName _User_QNAME = new QName("http://userdao.rxwwebservice.com", "user");
    private final static QName _UserDAOException_QNAME = new QName("http://userdao.rxwwebservice.com", "UserDAOException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rxwwebservice.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateNewUserOperation }
     * 
     */
    public CreateNewUserOperation createCreateNewUserOperation() {
        return new CreateNewUserOperation();
    }

    /**
     * Create an instance of {@link CreateNewUserOperationResponse }
     * 
     */
    public CreateNewUserOperationResponse createCreateNewUserOperationResponse() {
        return new CreateNewUserOperationResponse();
    }

    /**
     * Create an instance of {@link DeleteUserByUserIdOperation }
     * 
     */
    public DeleteUserByUserIdOperation createDeleteUserByUserIdOperation() {
        return new DeleteUserByUserIdOperation();
    }

    /**
     * Create an instance of {@link DeleteUserByUserIdOperationResponse }
     * 
     */
    public DeleteUserByUserIdOperationResponse createDeleteUserByUserIdOperationResponse() {
        return new DeleteUserByUserIdOperationResponse();
    }

    /**
     * Create an instance of {@link GetUserByUserIdOperation }
     * 
     */
    public GetUserByUserIdOperation createGetUserByUserIdOperation() {
        return new GetUserByUserIdOperation();
    }

    /**
     * Create an instance of {@link GetUserByUserIdOperationResponse }
     * 
     */
    public GetUserByUserIdOperationResponse createGetUserByUserIdOperationResponse() {
        return new GetUserByUserIdOperationResponse();
    }

    /**
     * Create an instance of {@link GetUserByUserNameOperation }
     * 
     */
    public GetUserByUserNameOperation createGetUserByUserNameOperation() {
        return new GetUserByUserNameOperation();
    }

    /**
     * Create an instance of {@link GetUserByUserNameOperationResponse }
     * 
     */
    public GetUserByUserNameOperationResponse createGetUserByUserNameOperationResponse() {
        return new GetUserByUserNameOperationResponse();
    }

    /**
     * Create an instance of {@link UpdateExistingUserOperation }
     * 
     */
    public UpdateExistingUserOperation createUpdateExistingUserOperation() {
        return new UpdateExistingUserOperation();
    }

    /**
     * Create an instance of {@link UpdateExistingUserOperationResponse }
     * 
     */
    public UpdateExistingUserOperationResponse createUpdateExistingUserOperationResponse() {
        return new UpdateExistingUserOperationResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link UserDAOException }
     * 
     */
    public UserDAOException createUserDAOException() {
        return new UserDAOException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewUserOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "createNewUserOperation")
    public JAXBElement<CreateNewUserOperation> createCreateNewUserOperation(CreateNewUserOperation value) {
        return new JAXBElement<CreateNewUserOperation>(_CreateNewUserOperation_QNAME, CreateNewUserOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewUserOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "createNewUserOperationResponse")
    public JAXBElement<CreateNewUserOperationResponse> createCreateNewUserOperationResponse(CreateNewUserOperationResponse value) {
        return new JAXBElement<CreateNewUserOperationResponse>(_CreateNewUserOperationResponse_QNAME, CreateNewUserOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByUserIdOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "deleteUserByUserIdOperation")
    public JAXBElement<DeleteUserByUserIdOperation> createDeleteUserByUserIdOperation(DeleteUserByUserIdOperation value) {
        return new JAXBElement<DeleteUserByUserIdOperation>(_DeleteUserByUserIdOperation_QNAME, DeleteUserByUserIdOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByUserIdOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "deleteUserByUserIdOperationResponse")
    public JAXBElement<DeleteUserByUserIdOperationResponse> createDeleteUserByUserIdOperationResponse(DeleteUserByUserIdOperationResponse value) {
        return new JAXBElement<DeleteUserByUserIdOperationResponse>(_DeleteUserByUserIdOperationResponse_QNAME, DeleteUserByUserIdOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserIdOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "getUserByUserIdOperation")
    public JAXBElement<GetUserByUserIdOperation> createGetUserByUserIdOperation(GetUserByUserIdOperation value) {
        return new JAXBElement<GetUserByUserIdOperation>(_GetUserByUserIdOperation_QNAME, GetUserByUserIdOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserIdOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "getUserByUserIdOperationResponse")
    public JAXBElement<GetUserByUserIdOperationResponse> createGetUserByUserIdOperationResponse(GetUserByUserIdOperationResponse value) {
        return new JAXBElement<GetUserByUserIdOperationResponse>(_GetUserByUserIdOperationResponse_QNAME, GetUserByUserIdOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserNameOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "getUserByUserNameOperation")
    public JAXBElement<GetUserByUserNameOperation> createGetUserByUserNameOperation(GetUserByUserNameOperation value) {
        return new JAXBElement<GetUserByUserNameOperation>(_GetUserByUserNameOperation_QNAME, GetUserByUserNameOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByUserNameOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "getUserByUserNameOperationResponse")
    public JAXBElement<GetUserByUserNameOperationResponse> createGetUserByUserNameOperationResponse(GetUserByUserNameOperationResponse value) {
        return new JAXBElement<GetUserByUserNameOperationResponse>(_GetUserByUserNameOperationResponse_QNAME, GetUserByUserNameOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExistingUserOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "updateExistingUserOperation")
    public JAXBElement<UpdateExistingUserOperation> createUpdateExistingUserOperation(UpdateExistingUserOperation value) {
        return new JAXBElement<UpdateExistingUserOperation>(_UpdateExistingUserOperation_QNAME, UpdateExistingUserOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateExistingUserOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "updateExistingUserOperationResponse")
    public JAXBElement<UpdateExistingUserOperationResponse> createUpdateExistingUserOperationResponse(UpdateExistingUserOperationResponse value) {
        return new JAXBElement<UpdateExistingUserOperationResponse>(_UpdateExistingUserOperationResponse_QNAME, UpdateExistingUserOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDAOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://userdao.rxwwebservice.com", name = "UserDAOException")
    public JAXBElement<UserDAOException> createUserDAOException(UserDAOException value) {
        return new JAXBElement<UserDAOException>(_UserDAOException_QNAME, UserDAOException.class, null, value);
    }

}
