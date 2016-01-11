package com.example.elise.rozenbergpicalculator;

public class PiCalculator {

	public double calculate(long iter) {
		double pi = 0;
		double num = 4;
		double denom = 1;
		boolean pos = true;

		for (long i = 0; i < iter; i++) {
			if (pos) {
				pi += num / denom;
			} else {
				pi -= num / denom;
			}
			denom += 2;
			pos = !pos;
		}
		return pi;
	}

}
