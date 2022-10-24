package ru.appline.framework.basetestsclass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;
import ru.appline.framework.utils.MyAllureListener;

import static ru.appline.framework.managers.DriverManager.getDriver;
import static ru.appline.framework.utils.PropConst.APP_URL;

@ExtendWith(MyAllureListener.class)
public class BaseTests {

    /**
     * Менеджер страничек
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
