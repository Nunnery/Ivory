package net.nunnerycode.bukkit.libraries.ivory.utils;

import org.apache.commons.lang.math.DoubleRange;
import org.apache.commons.lang.math.LongRange;
import org.junit.Assert;
import org.junit.Test;

public class RandomRangeUtilsTest {

	@Test
	public void testRandomRangeLongExclusiveOne() throws Exception {
		long min = 1;
		long max = 5;

		long result = RandomRangeUtils.randomRangeLongExclusive(min, max);

		Assert.assertTrue(result >= min && result < max);
	}

	@Test
	public void testRandomRangeLongInclusiveOne() throws Exception {
		long min = 1;
		long max = 5;

		long result = RandomRangeUtils.randomRangeLongInclusive(min, max);

		Assert.assertTrue(result >= min && result <= max);
	}

	@Test
	public void testRandomLongFromLongRangeExclusiveOne() throws Exception {
		long min = 1;
		long max = 5;

		long result = RandomRangeUtils.randomLongFromLongRangeExclusive(new LongRange(min, max));

		Assert.assertTrue(result >= min && result < max);
	}

	@Test
	public void testRandomLongFromLongRangeInclusiveOne() throws Exception {
		long min = 1;
		long max = 5;

		long result = RandomRangeUtils.randomLongFromLongRangeInclusive(new LongRange(min, max));

		Assert.assertTrue(result >= min && result <= max);
	}

	@Test
	public void testRandomRangeDoubleExclusiveOne() throws Exception {
		double min = 1;
		double max = 5;

		double result = RandomRangeUtils.randomRangeDoubleExclusive(min, max);

		Assert.assertTrue(result >= min && result < max);
	}

	@Test
	public void testRandomRangeDoubleInclusiveOne() throws Exception {
		double min = 1;
		double max = 5;

		double result = RandomRangeUtils.randomRangeDoubleInclusive(min, max);

		Assert.assertTrue(result >= min && result <= max);
	}

	@Test
	public void testRandomDoubleFromDoubleRangeExclusiveOne() throws Exception {
		double min = 1;
		double max = 5;

		double result = RandomRangeUtils.randomDoubleFromDoubleRangeExclusive(new DoubleRange(min, max));

		Assert.assertTrue(result >= min && result < max);
	}

	@Test
	public void testRandomDoubleFromDoubleRangeInclusiveOne() throws Exception {
		double min = 1;
		double max = 5;

		double result = RandomRangeUtils.randomDoubleFromDoubleRangeInclusive(new DoubleRange(min, max));

		Assert.assertTrue(result >= min && result <= max);
	}

}
