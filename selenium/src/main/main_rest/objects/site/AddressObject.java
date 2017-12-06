package main.main_rest.objects.site;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class AddressObject {

		//public @Getter @Setter String address;
		private @Getter @Setter String city;
		private @Getter @Setter String country;
		private @Getter @Setter String postalCode;
		private @Getter @Setter String state;
		private @Getter @Setter String street;
		private @Getter @Setter CoordinatesObject coordinates;		
}