//  author: Rishabh Tiwari
//  this code was made to chk proficiency in Kotlin
//  lets see if kotlin > py for selenium func.   ??
//  in next ---->>>> .kt

package psupacksummer

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.io.File
import java.util.regex.Pattern

fun get_info(): String {

    // to get rid of window

    val chromeOptions = ChromeOptions()
    chromeOptions.addArguments("--headless")

    // initialize instance of browser $ submit forms

    val wb  = ChromeDriver(chromeOptions)
    wb.get("https://webaccess.psu.edu/?cosign-www.absecom.psu.edu&https://www.absecom.psu.edu/ONLINE_CARD_OFFICE/USER_PAGES/PSU_USER_MENU_WIN.cfm")
    wb.findElementById("login").sendKeys("rpt5177")
    wb.findElementById("password").sendKeys("")
    wb.findElementByName("thebutton").submit()

    // export page source code

    val pg_Src = wb.pageSource
    File("pgSrc.txt").writeText(wb.pageSource)
    wb.quit()

    return pg_Src

}

fun mainChk() {

    // get src code of idcard page

    val pg = get_info()

    // find all re

    val pattern1 = ">$"
    val pattern2 = "</"
    val p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2))
    val m = p.matcher(pg)

    var ctr = 0

    while (m.find()) {

        when(ctr){

            0 -> {
                    println("MealPlan          : $" + m.group(1))
                    val mp = m.group(1)
            }

            1 -> {
                    println("Commuter MealPlan : $"+m.group(1))
                    val cmp = m.group(1)
            }

            2 -> {
                    println("LionCash+         : $"+m.group(1))
                    val lc = m.group(1)
            }

        }

        ctr++
    }

    //return lc.toDouble()
}

