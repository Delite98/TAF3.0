package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureHW {
    @Test (description = "Homework")
    public void hwTest(){
            Assert.assertTrue(true);
    }


    @Step("Test examination")
    @Test (description = "Homework_2")
    public void hwTest2(){
        Assert.assertTrue(true);
    }

    @Attachment(value = "screen", type = "image")
    @Test (description = "Homework_3")
    public void hwTest3(){
        Assert.assertTrue(true);
    }

}