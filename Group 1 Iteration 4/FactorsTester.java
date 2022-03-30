import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FactorsTester {

	@Test
	void testPerfect1()
	{	
		// TEST 1: should throw the exception because the parameter value is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.perfect(0));
	}
	
	@Test
	void testPerfect2()
	{	
		// TEST 2: should succeed because 1 is a valid parameter value, but is not a perfect number
		assertFalse(FactorsUtility.perfect(1));
	}
	
	@Test
	void testPerfect3()
	{	
		// TEST 3: should succeed because 6 is a valid parameter value, and is a perfect number
		assertTrue(FactorsUtility.perfect(6));
	}
	
	@Test
	void testPerfect4()
	{	
		// TEST 4: should succeed because 7 is a valid parameter value, but is not a perfect number
		// I've coded this using assertEquals to show that there's often more than one way to write a test 
		boolean expected = false;
		assertEquals(expected, FactorsUtility.perfect(7));
	}
	
	@Test
	void testGetFactors1()
	{	
		// TEST 5: Should equal to an ArrayList of [1] as that is the only factor of 2 
		ArrayList<Integer> expected= new ArrayList<Integer>();
		expected.add(1);
		assertEquals(expected, FactorsUtility.getFactors(2));
	}
	
	@Test
	void testGetFactors2()
	{	
		// TEST 6: Should equal to an ArrayList of [] as there are no factors of 1
		ArrayList<Integer> expected= new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(1));
	}
	
	@Test
	void testGetFactors3()
	{
		// TEST 7: Should equal to an ArrayList of [] as there are no factors of 0
		ArrayList<Integer> expected= new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(0));
	}
	
	@Test
	void testGetFactors4()
	{
		// TEST 8: Should throw an exception as parameter is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-1));
	}
	
	@Test
	void testGetFactors5()
	{	
		// TEST 9: Should equal to an ArrayList of [1,2,3,4,6] as there are 5 factors of 12
		ArrayList<Integer> expected= new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		assertEquals(expected, FactorsUtility.getFactors(12));
	}
	
	@Test
	void testFactor1()
	{	
		// TEST 10: Should throw an exception as parameter a is less than 0 and parameter b is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1,0));
	}

	@Test
	void testFactor2()
	{
		// TEST 11: Should throw an exception as parameter a is greater than 0 but parameter b is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(1,0));
	}
	
	@Test
	void testFactor3()
	{
		// TEST 12: Should throw an exception as parameter b is greater than 1 but parameter a is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1,1));
	}
	
	@Test
	void testFactor4()
	{	
		// TEST 13: Should return true as 2 modulus 1 is 0 (and thus equal to 0)
		assertTrue(FactorsUtility.factor(2,1));
	}
	
	@Test
	void testFactor5()
	{	
		// TEST 15: Should return false as 3 modulus 2 is 1 (and thus not equal to 0)
		assertFalse(FactorsUtility.factor(3,2));
	}
}
