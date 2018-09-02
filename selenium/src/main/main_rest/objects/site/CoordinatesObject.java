package main.main_rest.objects.site;

import org.inferred.freebuilder.FreeBuilder;
import com.google.common.base.Optional;

@FreeBuilder
public abstract class CoordinatesObject {

	public abstract Optional<String> lat();
	public abstract Optional<String> lng();
	
	public abstract Builder toBuilder();
    public static class Builder extends CoordinatesObject_Builder{}
}