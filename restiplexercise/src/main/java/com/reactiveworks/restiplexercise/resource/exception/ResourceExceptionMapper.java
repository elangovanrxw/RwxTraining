package com.reactiveworks.restiplexercise.resource.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.reactiveworks.restiplexercise.resource.responseobj.ErrorMessage;

/**
 * A mapper class for the jersey which executes when {@link ResourceException} is thrown in
 * the application.
 * @author Elangovan
 *
 */
@Provider
public class ResourceExceptionMapper implements ExceptionMapper<ResourceException> {

	/**
	 * The implemented method form the {@link ExceptionMapper} which contains the 
	 * body of what response have to give when the exception is occured.
	 */
	@Override
	public Response toResponse(ResourceException exception) {

		ErrorMessage errorMsg = new ErrorMessage();
		errorMsg.setStatusCode(exception.getResponseStatusCode());
		errorMsg.setErrorMessage(exception.getMessage());		
		return Response.status(exception.getResponseStatusCode()).entity(errorMsg).build();
	}

}
