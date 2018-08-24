package main.main_ios.objects;

import org.inferred.freebuilder.FreeBuilder;

import com.google.common.base.Optional;

import lombok.Builder;

@FreeBuilder
	
	public abstract class Test{
	
	public static final String TEST = "1";
	
	public abstract Optional<String> TEST();
	
	public abstract Builder toBuilder();
	
	public static class Builder extends Test_Builder{}

}
