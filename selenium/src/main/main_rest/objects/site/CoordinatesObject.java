package main.main_rest.objects.site;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CoordinatesObject {

	private @Getter String lat;
	private @Getter String lng;
}