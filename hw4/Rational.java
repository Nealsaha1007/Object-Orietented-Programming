package syr.edu.hw4;
public class Rational {
    private int numer;
    private int denom;
    private int g;
    
    private static int gcd(int m, int n) { //calculate gcd 
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    
    public Rational(int n, int d) { 

    	this.g = gcd(n,d);
    	this.numer = n / g;
    	this.denom = d / g;
    	
    }

    public Rational(int n) {
    	this.numer = n;
    	this.denom = 1;
    }
    
    

    @Override
	public String toString() {
    	if(denom == 1) return numer + " ";
    	else {
    		return numer + "/" + denom ;
    	}
	}
 

    public Rational add(Rational that) {
    	Rational temp  = new Rational(numer, denom);
    	temp.numer = ((numer * that.denom) + (denom * that.numer));
    	temp.denom = denom * that.denom;
		return temp;
    	
    	
    }

    public Rational add(int that) {
    	return this.add(that);
    }

    public boolean lessThan(Rational that) {
    	return (numer * that.denom < denom * that.numer);
    }

    public boolean lessThan(int that) {
    	return this.lessThan(new Rational(that));
    }

    public Rational max(Rational that) {
    	return (numer * that.denom < denom * that.numer) ? that : this;
    }

    public Rational max(int that) {
    	return this.max(new Rational(that));
    }

    public static void main(String[] args) {
        Rational half = new Rational(1, 2);
        Rational third = new Rational(1, 3);
        System.out.println(half.max(third)); // returns half; prints "1/2"
        System.out.println(third.max(half)); // returns half; prints "1/2"
        Rational result = half.add(third);
        System.out.println(result);
        Rational fiveSixths = new Rational(5, 6);
        System.out.println("are they the same object? " + (result == fiveSixths));
        System.out.println(fiveSixths.lessThan(result)); // false
        System.out.println(result.lessThan(fiveSixths)); // false
        Rational one = new Rational(1);
        Rational oneAndHalf = one.add(half);
		System.out.println(oneAndHalf); // prints "3/2";
        Rational fifteenOverTen = new Rational(15, 10);
        System.out.println(fifteenOverTen); // prints "3/2"
    }

	
}
