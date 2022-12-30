/* Copyright (c) 2022, Dźmitry Laŭčuk
   All rights reserved.

   Redistribution and use in source and binary forms, with or without
   modification, are permitted provided that the following conditions are met: 

   1. Redistributions of source code must retain the above copyright notice,
      this list of conditions and the following disclaimer.
   2. Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.

   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
   AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
   IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
   ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
   LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
   CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
   SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
   INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
   CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
   ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
   POSSIBILITY OF SUCH DAMAGE. */
package afc.util;

/**
 * Various functions, used by data structures.
 */
public class Util
{
	private Util()
	{
	}
	
	/**
	 * <p>Rounds a given value up to the closest integer value that
	 * is a power to two, as if the returned value is an unsigned
	 * 32-bit integer. That is, for value inputs which ceiling power
	 * of two would be {@code 1^31} exactly this value is returned.</p>
	 * 
	 * <p>For negative values the output is undefined. However, no
	 * exception is thrown.</p>
	 * 
	 * <p>Examples:</p>
	 * <table>
	 * <tr><th>Input</th><th>Output</th></tr>
	 * <tr><td>0</td><td>1</td></tr>
	 * <tr><td>1</td><td>1</td></tr>
	 * <tr><td>2</td><td>2</td></tr>
	 * <tr><td>5</td><td>8</td></tr>
	 * <tr><td>8</td><td>8</td></tr>
	 * <tr><td>530</td><td>1024</td></tr>
	 * <tr><td>1^30-1</td><td>1^30</td></tr>
	 * <tr><td>1^30</td><td>1^30</td></tr>
	 * <tr><td>1^30+1</td><td>1^31 (negative)</td></tr>
	 * <tr><td>1^31-1</td><td>1^31 (negative)</td></tr>
	 * <tr><td>-1..Integer.MIN_VALUE</td><td>undefined</td></tr>
	 * </table>
	 * 
	 * @param i the value to round up. It must be an unsigned integer.
	 * @return the closest power of two that is equal to or
	 * 		greater than {@code i}, as if the returned value is an
	 * 		unsigned integer.
	 */
	public static int ceilPow2(int i)
	{
		assert i >= 0;
		int x = 1;
		if (i != 0) {
			/* It could be 1 << (32 - Integer.numberOfLeadingZeros(i - 1))
			 * but non-intrinsic implementation of the numberOfLeadingZeros
			 * is slow. Choosing something in the middle.
			 */
			--i;
			i |= (i >>> x);
			x <<= 1;
			i |= (i >>> x);
			x <<= 1;
			i |= (i >>> x);
			x <<= 1;
			i |= (i >>> x);
			x <<= 1;
			i |= (i >>> x);
			return i + 1;
		}
		return x;
	}
}
