//package Tests;
//
//import DataTypes.NewUserSignup;
//import Pages.LoginPage;
//import Utils.HelperClass;
//import io.qameta.allure.*;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
////import MyListeners.CustomListener;
//
//
//
//
//@Listeners(MyListeners.CustomListener.class)
//public class Class_1 {
//
//
//
//
//    @DataProvider(name = "InvalidNamesProvider")
//    public NewUserSignup[] DataDrivenTest(){
//
//        NewUserSignup[] TestUser = HelperClass.readJson
//                ("src\\main\\java\\TestData\\InvalidCredentialsData.JSON" , NewUserSignup[].class ) ;
//
//        return TestUser ;
//
//    }
//    @Description("This Test  is to validate  that system correctly catches invalid username")
//    @Owner("Edges for Training")
//    @Severity(SeverityLevel.CRITICAL)
//    @Link(name = "Test documentation" , url ="https://www.google.com")
//    @Issue("https://www.google.com")
//    @TmsLink("https://www.google.com")
//    @Epic("Login")
//    @Feature("IncorrectLoginHandling")
//    @Story("InvalidUserNameHandling")
//    @Test(dataProvider = "InvalidNamesProvider")
//    public void TC01_InvalidLogin( NewUserSignup TestUser ){
//
//        LoginPage login = new LoginPage("Edge" , "https://the-internet.herokuapp.com/login") ;
//
//        String ActualMessage = login.PerformNegative(TestUser).ReadErrorMessage();
//        String ExpectedMessage = "Your username is invalid!";
//
//        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
//
//        login.CloseDriver() ;
//
//    }
//
//
//
//}
