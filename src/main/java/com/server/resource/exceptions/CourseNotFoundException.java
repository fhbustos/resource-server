package com.server.resource.exceptions;

public class CourseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7704784510964647542L;

	public CourseNotFoundException(Long id) {
		super("Could not find course " + id);
	}
}
