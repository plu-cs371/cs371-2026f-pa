package mult;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BigInt implements Comparable<BigInt> {

    /**
     * The list of digits (base 10).  The digits are stored in the order of least significant to
     * most significant.
     */
    private LinkedList<Integer> digits;

    /**
     * Creates a BigInt from a String representation of an integer.  The String must only contain
     * the characters '0' through '9'.  If any other characters are found, an IllegalArgumentException
     * is thrown.
     *
     * @param s the String representing the value of this integer.
     * @throws IllegalArgumentException when the String does not contain digits.
     */
    public BigInt(String s) {
        digits = new LinkedList<>();

        // Remove leading zeros
        s = s.replaceFirst("\\A0+","");

        for( int i = s.length() - 1; i >= 0; i-- ) {
            char c = s.charAt(i);
            if( Character.isDigit(c) ) {
                digits.add(c - '0');
            } else {
                throw new IllegalArgumentException("String must contain digits only.");
            }
        }
        if( digits.isEmpty() ) { digits.add(0); }
    }

    /**
     * Constructs a BigInt from a primitive integer.  The value provided must not be negative.
     *
     * @param v the value for this BigInt
     * @throws IllegalArgumentException if v is negative
     */
    public BigInt(int v ) {
        digits = new LinkedList<>();
        if(v < 0)
            throw new IllegalArgumentException("Negative numbers are not supported.");
        if( v == 0 ) {
            digits.add(0);
        }
        while( v > 0 ) {
            digits.add(v % 10);
            v = v / 10;
        }
    }

    public BigInt(BigInt other) {
        this.digits = new LinkedList<>(other.digits);
    }

    public BigInt() {
        this(0);
    }

    /**
     * Returns a new BigInt containing the sum of this and rhs.
     *
     * @param rhs a BigInt
     * @return a new BigInt containing the sum of this and rhs.
     */
    public BigInt add(BigInt rhs) {
        BigInt result = new BigInt(0);
        result.digits.clear();

        ListIterator<Integer> leftIter = digits.listIterator();
        ListIterator<Integer> rightIter = rhs.digits.listIterator();
        int carry = 0;
        while( leftIter.hasNext() || rightIter.hasNext() ) {
            int sum = carry;
            if(leftIter.hasNext()) sum += leftIter.next();
            if(rightIter.hasNext()) sum += rightIter.next();

            carry = sum / 10;
            result.digits.add(sum % 10);
        }
        if( carry > 0 ) result.digits.add(carry);
        if( result.digits.isEmpty() ) result.digits.add(0);
        return result;
    }

    /**
     * Returns a new BigInt containing the difference: this - rhs.  this is not modified.
     * A negative result is not allowed, so it must be true that this >= rhs, otherwise zero
     * is returned.
     *
     * @param rhs the right hand side of the operation, must be less than or equal to this.
     * @return the result of this - rhs or zero if this < rhs
     */
    public BigInt sub(BigInt rhs) {
        if( this.compareTo(rhs) < 0 ) return new BigInt(0);

        BigInt result = new BigInt(0);
        result.digits.clear();
        ListIterator<Integer> leftIter = this.digits.listIterator();
        ListIterator<Integer> rightIter = rhs.digits.listIterator();

        int borrow = 0;
        while(rightIter.hasNext() || leftIter.hasNext()) {
            int leftDigit = leftIter.next() + borrow;
            int rightDigit = 0;
            if( rightIter.hasNext() ) rightDigit = rightIter.next();
            int diff = leftDigit - rightDigit;
            if( diff < 0 ) {
                borrow = -1;
                diff += 10;
            } else {
                borrow = 0;
            }
            result.digits.add(diff);
        }

        result.removeLeadingZeros();
        return result;
    }

    /**
     * @return a String representation of this BigInt.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListIterator<Integer> iter = digits.listIterator(digits.size());
        while( iter.hasPrevious() ) {
            sb.append(iter.previous());
        }
        return sb.toString();
    }

    /**
     * Compares this to o and returns a negative value when this < o, a positive value when this > 0
     * and zero when they are equal.
     *
     * @param o BigInt to compare with this
     * @return negative, positive or zero value
     */
    @Override
    public int compareTo(BigInt o) {
        if(this.digits.size() < o.digits.size() )  return -1;
        else if (this.digits.size() > o.digits.size() ) return 1;

        ListIterator<Integer> leftIter = this.digits.listIterator(this.digits.size());
        ListIterator<Integer> rightIter = o.digits.listIterator(o.digits.size());

        while( leftIter.hasPrevious() && rightIter.hasPrevious() ) {
            int left = leftIter.previous();
            int right = rightIter.previous();
            if( left > right ) return 1;
            else if( left < right ) return -1;
        }

        return 0;
    }

    /**
     * Removes any leading zeros in this number.  If all digits are zero (or there are no digits), it is
     * replaced with a single digit 0.
     */
    private void removeLeadingZeros() {
        ListIterator<Integer> iter = digits.listIterator(digits.size());
        while( iter.hasPrevious() && iter.previous() == 0 ) iter.remove();
        if( this.digits.isEmpty() ) digits.add(0);
    }

    /**
     * Returns a new BigInt that is the product of this * rhs using the algorithm described in Section 5.4.
     * Does not modify this.
     *
     * @param rhs the right hand side of the multiplication operation.
     * @return the product of this and rhs
     */
    public BigInt mult(BigInt rhs ) {

        // Implement this method

        return null;
    }

}
