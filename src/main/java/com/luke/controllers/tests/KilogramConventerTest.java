package com.luke.controllers.tests;

import org.junit.Test;

import com.luke.controllers.conventers.weight.ContextWeigh;
import com.luke.controllers.conventers.weight.ConversionWeighResults;
import com.luke.controllers.conventers.weight.KilogramConventer;


public class KilogramConventerTest {
	@Test
	public static void main(String[] args) {
		int value = 5;
		
		ContextWeigh context = new ContextWeigh(new KilogramConventer());
		ConversionWeighResults results = context.convert(value);
		System.out.println(results.toString());
	}

}
