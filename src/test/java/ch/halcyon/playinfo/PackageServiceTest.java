package ch.halcyon.playinfo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yansigner on 02.05.15.
 */
public class PackageServiceTest {

    static String packagename = "ch.halcyon.squareprogressbar.example";
    PackageInfo packageInfo;

    @Before
    public void setUp(){
        packageInfo = PackageService.getPackageInfoByPackageName(packagename);
    }

    @Test
    public void testTitle() throws Exception {
        assertTrue(packageInfo.getTitle().equals("squareprogressbar-example"));
    }

    @Test
    public void testCategory() throws Exception {
        assertTrue(packageInfo.getCategory().equals("Education"));
    }

    @Test
    public void testPrice() throws Exception {
        assertTrue(packageInfo.getPrice().equals("Free"));
    }

    @Test
    public void testUpdated() throws Exception {
        assertTrue(packageInfo.getUpdated().equals("29 April 2015"));
    }

    @Test
    public void testTotalInstalls() throws Exception {
        assertTrue(packageInfo.getTotalInstalls().equals("1 - 5"));
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(packageInfo.getSize().equals("413k"));
    }

    @Test
    public void testCurrentVersion() throws Exception {
        assertTrue(packageInfo.getCurrentVersion().equals("1.5.1"));
    }

    @Test
    public void testRequiresAndroid() throws Exception {
        assertTrue(packageInfo.getRequiresAndroid().equals("4.0 and up"));
    }

    @Test
    public void testContentRating() throws Exception {
        assertTrue(packageInfo.getContentRating().equals("Everyone"));
    }

    @Test
    public void testEmail() throws Exception {
        assertTrue(packageInfo.getEmail().equals("yannick@signer.pro"));
    }

    @Test
    public void testWebsite() throws Exception {
        assertTrue(packageInfo.getWebsite().equals("http://halcyon.ch"));
    }

    @Test
    public void testScore() throws Exception {
        assertTrue(packageInfo.getScore().equals(""));
    }

    @Test
    public void testVotes() throws Exception {
        assertTrue(packageInfo.getVotes().equals(""));
    }

    @Test
    public void testDeveloper() throws Exception {
        assertTrue(packageInfo.getDeveloper().equals("Yannick Signer"));
    }

    @Test
    public void testWhatsNew() throws Exception {
        assertTrue(packageInfo.getWhatsNew().equals("library updated to 1.5.1"));
    }

    @Test
    public void testDescription() throws Exception {
        assertTrue(packageInfo.getDescription().equals("This is the example application for the square-progressbar library. For more information check out the repository on GitHub here: https://github.com/mrwonderman/android-square-progressbar Get more information about the newest release here: http://www.signer.pro/android-square-progressbar-v-1-5-0/"));
    }
}
