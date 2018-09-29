package main.java.main.main_rest.objects.site;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;


@FreeBuilder
public abstract class AddressObject {

	   public abstract Optional<String> address();
	   public abstract Optional<String> city();
	   public abstract Optional<String> country();
	   public abstract Optional<String> postalCode();
	   public abstract Optional<String> state();
	   public abstract Optional<String> street();
	   public abstract Optional<CoordinatesObject> coordinates();
	   
	   public abstract Builder toBuilder();
	   public static class Builder extends AddressObject_Builder{}
}