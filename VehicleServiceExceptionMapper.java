package com.codetest.vis.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.codetest.vis.model.ErrorResponse;

@Provider
public class VehicleServiceExceptionMapper implements
		ExceptionMapper<VehicleServiceException> {

	public VehicleServiceExceptionMapper() {
	}
	@Override
	public Response toResponse(
			VehicleServiceException vehicleServiceException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorId(vehicleServiceException.getErrorId());
		errorResponse.setErrorCode(vehicleServiceException.getMessage());
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
				errorResponse).type(MediaType.APPLICATION_XML).build();
	}

}