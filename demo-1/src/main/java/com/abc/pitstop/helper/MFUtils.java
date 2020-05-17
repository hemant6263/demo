package com.abc.pitstop.helper;

import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class MFUtils {

	public static MapperFacade mapperFacade;

	public static MapperFacade getMapperFacade() {
		if (mapperFacade == null) {
			mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
		}
		return mapperFacade;
	}

	public static Object map(Object sourceObject, Class destinationClass) {
		return getMapperFacade().map(sourceObject, destinationClass);
	}
}