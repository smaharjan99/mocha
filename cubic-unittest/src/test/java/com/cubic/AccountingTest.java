package com.cubic;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cubic.math.NameUtilTest;
import com.cubic.math.SimpleCalcTest;

@RunWith(Categories.class)
@IncludeCategory(Accounting.class)
@Suite.SuiteClasses({ NameUtilTest.class, SimpleCalcTest.class })
public class AccountingTest {

}
