package suites;

import Tasks.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        SearchTests.class,
        MyListsTests.class,
        getStartedTest.class,
        ArticleTests.class,
        ChangeAppConditionTests.class,
        EX2.class,
        EX3.class,
        EX5.class,
        EX6.class,
        EX11.class
}
)

public class TestSuite {
}
