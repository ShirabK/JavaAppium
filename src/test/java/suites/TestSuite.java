package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SearchTests.class,
        MyListsTests.class,
        getStartedTest.class,
        FirstTest.class,
        ChangeAppConditionTests.class
}
)

public class TestSuite {
}
