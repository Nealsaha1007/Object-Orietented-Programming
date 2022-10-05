package syr.edu.hw5;
import java.util.HashSet;
import java.util.Set;

public class Rational {
    private int numer;
    private int denom;
    private static int g;
    private static int size = 10;
    private static Set<Rational> cache = new HashSet<>(size); //set data structure used for cache (size 10).

    
    private Rational(int n, int d) { //populate the cache
    	
        numer = n;
        denom = d;
        if(cache.size() <= size) {
        	cache.add(this);
        }

    }

	private Rational(int n) {
        this(n, 1);
    }
	
	public static Rational getNumeratorDenominator(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator can't be 0!");
        }
    	g = gcd(n,d);
    	n = n/g;
    	d = d/g;
    	
    	for(Rational i : cache) { // check numerator & denominator to find relation between two rational objects
    		if(i.numer == n && i.denom ==d) {
    			return i;
    		}
    	}
    	return new Rational(n,d);
    }
    public static Rational getNumerator(int n) {
    	for(Rational i : cache) {
    		if(i.numer == n && i.denom == 1) {
    			return i;
    		}
    	}
    	return new Rational(n);
    }

    private static int gcd(int n, int d) {
        return d==0 ? n : gcd(d, n%d);
    }

    @Override
    public String toString() {
        return denom==1 ? numer +"" : numer + "/" + denom;
    }

    public Rational add(Rational that) {
        return new Rational(numer * that.denom + denom * that.numer, denom * that.denom);
    }

    public Rational add(int that) {
        return add(new Rational(that));
    }

    public boolean lessThan(Rational that) {
        return this.numer * that.denom < that.numer * this.denom;
    }

    public boolean lessThan(int that) {
        return lessThan(new Rational(that));
    }

    public Rational max(Rational that) {
        return this.lessThan(that) ? that : this;
    }

    public Rational max(int that) {
        return max(new Rational(that));
    } 
    
 // A new rational is stored in the static cache until exhausted.
 // Once cache is exhausted we can .equals() overloaded for Rational class 
 // to check for two objects of this type.
      
    public static void main(String[] args) {
        Rational half = Rational.getNumeratorDenominator(1, 2);
        Rational third = Rational.getNumeratorDenominator(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        Rational fiveSixths = Rational.getNumeratorDenominator(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths ));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = Rational.getNumerator(1);
        Rational oneAndHalf = one.add(half);
        System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = Rational.getNumeratorDenominator(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denom;
		result = prime * result + numer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rational other = (Rational) obj;
		if (denom != other.denom) {
			return false;
		}
		if (numer != other.numer) {
			return false;
		}
		return true;
	}
}
