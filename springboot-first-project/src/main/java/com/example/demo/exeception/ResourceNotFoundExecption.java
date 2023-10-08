package com.example.demo.exeception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExecption extends RuntimeException{
	
	String resurceName;
	String fieldName;
	long  fieldValue;
	public ResourceNotFoundExecption(String resurceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resurceName,fieldName, fieldValue));
		this.resurceName = resurceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
