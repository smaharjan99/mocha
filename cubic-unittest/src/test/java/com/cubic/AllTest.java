package com.cubic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cubic.math.NameUtilTest;
import com.cubic.math.SimpleCalcTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ NameUtilTest.class, SimpleCalcTest.class })

public class AllTest {

}
