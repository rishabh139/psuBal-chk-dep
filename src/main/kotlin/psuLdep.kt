package psupacksummer

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

//  author: Rishabh Tiwari

fun mainDep() {

    val chromeOptions = ChromeOptions()
    chromeOptions.addArguments("--headless")

    val dp = ChromeDriver(chromeOptions)
    dp.get("https://www.absecom.psu.edu/ONLINE_CARD_OFFICE_NON_AUTH/NON_AUTH_PAGES/GET_ACCNT_HOLDER_INFO_FOR_DEPOSIT_WIN.CFM?v=1")

    dp.findElementByName("txt_Campus_ID").sendKeys("906558520")
    dp.findElementByName("txt_L_NAME").sendKeys("Tiwari")
    dp.findElementByName("txt_USER_ID").sendKeys("rpt5177")

    dp.findElementByName("btn_submit").submit()

    dp.findElementByName("cmb_PLAN_NUM").sendKeys("LionCash+")
    dp.findElementByName("txt_CC_HOLDER_EMAIL").sendKeys("rishabhtiwari1399@gmail.com")
    dp.findElementByName("rad_AMOUNT").sendKeys("-1")
    dp.findElementByName("txt_DOLLAR_OTHER").sendKeys("5")
    dp.findElementByName("txt_CENTS_OTHER").sendKeys("01")
    dp.findElementByName("SUBMIT_AND_RE_AUTHENICATE").click()

    dp.switchTo().alert().accept()

    dp.findElementByName("ssl_first_name").sendKeys("Rishabh")
    dp.findElementByName("ssl_last_name").sendKeys("Tiwari")
    dp.findElementByName("psu_card_brand").sendKeys("Visa")
    dp.findElementByName("ssl_account_data").sendKeys("4430-18")
    dp.findElementByName("ssl_exp_date").sendKeys("0820")
    dp.findElementByName("ssl_cvv2cvc2").sendKeys("537")

    //dp.findElementByName("btnProcess").click()

    dp.quit()

}