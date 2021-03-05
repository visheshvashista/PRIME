package com.number.prime.vo;

public class PrimeNumber {
	String primeNumbers;

	public PrimeNumber(String primeNumbers) {
		super();
		this.primeNumbers = primeNumbers;
	}

	public String getPrimeNumber() {
		return primeNumbers;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("bbb");
		if (!(obj instanceof PrimeNumber)) {
			System.out.println("ccc");
			return false;
		}
		if (obj == this)
			return true;
		return this.primeNumbers.equals(((PrimeNumber) obj).primeNumbers);

	}

	@Override
	public final int hashCode() {
		int result = 17;
		if (primeNumbers != null) {
			result = 31 * result + primeNumbers.hashCode();
		}

		return result;
	}

}
