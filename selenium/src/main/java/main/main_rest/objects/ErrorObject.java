package main.java.main.main_rest.objects;


import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

@FreeBuilder
public abstract class ErrorObject {
	  
	   public abstract Optional<String> message();
	   public abstract Optional<String> name();
	   public abstract Optional<String> stack();
	   public abstract Optional<String> statusCode();
		
	   public abstract Builder toBuilder();
	   public static class Builder extends ErrorObject_Builder{}
}
