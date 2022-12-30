package afc.util;

import junit.framework.TestCase;

public class UtilTest extends TestCase
{
	public void testCeilPow2()
	{
		assertEquals(1, Util.ceilPow2(0));
		assertEquals(1, Util.ceilPow2(1));
		assertEquals(2, Util.ceilPow2(2));
		assertEquals(4, Util.ceilPow2(3));
		assertEquals(4, Util.ceilPow2(4));
		assertEquals(8, Util.ceilPow2(5));
		assertEquals(8, Util.ceilPow2(6));
		assertEquals(8, Util.ceilPow2(7));
		assertEquals(8, Util.ceilPow2(8));
		assertEquals(16, Util.ceilPow2(9));
		assertEquals(32, Util.ceilPow2(20));
		assertEquals(32, Util.ceilPow2(31));
		assertEquals(32, Util.ceilPow2(32));
		assertEquals(64, Util.ceilPow2(33));
		assertEquals(1 << 30, Util.ceilPow2((1<<30) - 2));
		assertEquals(1 << 30, Util.ceilPow2((1<<30) - 1));
		assertEquals(1 << 30, Util.ceilPow2((1<<30)));
		assertEquals(1 << 31, Util.ceilPow2(Integer.MAX_VALUE - 1));
		assertEquals(1 << 31, Util.ceilPow2(Integer.MAX_VALUE));
	}
}
