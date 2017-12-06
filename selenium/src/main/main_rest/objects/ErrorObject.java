package main.main_rest.objects;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorObject {

	   public @Getter @Setter String message;
	   public @Getter @Setter String name;
	   public @Getter @Setter String stack;
	   public @Getter @Setter String statusCode;
}
