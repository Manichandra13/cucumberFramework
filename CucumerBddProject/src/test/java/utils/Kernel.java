package utils;

import org.testng.annotations.Test;
import static org.junit.Assume.assumeTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.SequencedHashMap;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.pyt.pages.ActivityPage;
import com.pyt.pages.AdminPage;
import com.pyt.pages.BlockCardPage;
import com.pyt.pages.BlockingDatesPage;
import com.pyt.pages.BookingReviewPage;
import com.pyt.pages.Cbrpage;
import com.pyt.pages.CoreWebVitalsPage;
import com.pyt.pages.CustomizePage;
import com.pyt.pages.DiscountPricingPage;
import com.pyt.pages.DurationPage;
import com.pyt.pages.EditRoutePage;
import com.pyt.pages.FerryPage;
import com.pyt.pages.FlightsPage;
import com.pyt.pages.GCMSignupPage;
import com.pyt.pages.HomePage;
import com.pyt.pages.HotelsPage;
import com.pyt.pages.InclusionPage;
import com.pyt.pages.InclusionsPage;
import com.pyt.pages.InterestPage;
import com.pyt.pages.IternaryPage;
import com.pyt.pages.Iternarycostmodel;
import com.pyt.pages.LoginPage;
import com.pyt.pages.PDGEurTrendingCombos;
import com.pyt.pages.PackagesPage;
import com.pyt.pages.PassengerDetailsPage;
import com.pyt.pages.PayUPage;
import com.pyt.pages.PaymentPage;
import com.pyt.pages.PdgFlowPage;
import com.pyt.pages.PostcardPage;
import com.pyt.pages.RazorPayPaymentPage;
import com.pyt.pages.RentalCarPage;
import com.pyt.pages.SandunePage;
import com.pyt.pages.SignupPage;
import com.pyt.pages.SpeedBaliLandingPage;
import com.pyt.pages.SpeedBaliListingPage;
import com.pyt.pages.SpeedboatCostedDetailsPage;
import com.pyt.pages.SpeedboatLandingPage;
import com.pyt.pages.SpeedboatListingPage;
import com.pyt.pages.SpeedboatUncostedDetailsPage;
import com.pyt.pages.T20WorldCupPage;
import com.pyt.pages.TestimonialsPage;
import com.pyt.pages.TrainsPage;
import com.pyt.pages.VisaPage;
import com.pyt.pages.YourAccountPage;
import com.pyt.pages.YourVacationsPage;
import com.pyt.pages.PayUPage;
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import utils.SeWrappers;
import gluecode.Hooks;
import gluecode.PackagesPageValidation;
import gluecode.SpeedboatGlue;

public class Kernel extends SeWrappers {

	protected PdgFlowPage pdgflowp = new PdgFlowPage();
	protected RazorPayPaymentPage razorpaypage = new RazorPayPaymentPage();
	protected LoginPage lp = new LoginPage();
	protected HomePage hp = new HomePage(driver);
	protected CustomizePage cp = new CustomizePage();
	protected DurationPage dp = new DurationPage();
	protected BlockingDatesPage bdp = new BlockingDatesPage();
	protected InterestPage ip = new InterestPage();
	protected Iternarycostmodel icm = new Iternarycostmodel();
	protected IternaryPage intpag = new IternaryPage();
	protected InclusionsPage inclusion = new InclusionsPage();
	protected InclusionPage inclusionNew = new InclusionPage();
	// Utility util;
	protected SignupPage sp = new SignupPage();
	protected GCMSignupPage gcm = new GCMSignupPage();
	protected PDGEurTrendingCombos pdgtreco = new PDGEurTrendingCombos();
	protected PackagesPage packagesPage = new PackagesPage();
	protected PostcardPage postCard = new PostcardPage();
	protected PassengerDetailsPage psp = new PassengerDetailsPage();
	protected TestimonialsPage testimonials = new TestimonialsPage();
	protected YourVacationsPage yourVacation = new YourVacationsPage();
	protected YourAccountPage ac = new YourAccountPage();
	protected BookingReviewPage booingReview = new BookingReviewPage();
	protected PaymentPage paymentPage = new PaymentPage();
	protected HotelsPage hotelPage = new HotelsPage();
	protected AdminPage adminPage = new AdminPage();
	protected ActivityPage activityPage = new ActivityPage();
	protected FlightsPage flightPage = new FlightsPage();
	protected VisaPage visaPage = new VisaPage();
	protected EditRoutePage ed = new EditRoutePage();
	protected FerryPage ferryPage = new FerryPage();
	protected TrainsPage trainsPage = new TrainsPage();
	protected Cbrpage cbr = new Cbrpage();
	protected RentalCarPage rentalCarPage = new RentalCarPage();
	protected PayUPage payUPage =new PayUPage();
	protected SandunePage dubaiPage =new SandunePage();
	protected BlockCardPage blockCard =new BlockCardPage();
	protected SpeedboatLandingPage sbLand = new SpeedboatLandingPage();
	protected SpeedboatListingPage sbList = new SpeedboatListingPage();
	protected SpeedboatUncostedDetailsPage sbUncost = new SpeedboatUncostedDetailsPage();
	protected SpeedboatCostedDetailsPage sbCost = new SpeedboatCostedDetailsPage();
    protected T20WorldCupPage t20 =new T20WorldCupPage();
    protected SpeedBaliLandingPage sbaliLanding = new SpeedBaliLandingPage();
	protected SpeedBaliListingPage sbaliListing = new SpeedBaliListingPage();
	protected DiscountPricingPage adminPrice = new DiscountPricingPage();
	protected CoreWebVitalsPage webVitals= new CoreWebVitalsPage();
	

    int noOfItineraryCards = 0;
	int invalidImageCount = 0;
	int randomNumber = 0;
	int passportTempNum = 12346789;
	int itineraryRandomNumber = 12346789;
	String passportNum = "";
	String packagesUrl, vacationsUrl = "";

	List<WebElement> packagesLogo = new ArrayList<WebElement>();
	List<WebElement> vacationsLogo = new ArrayList<WebElement>();
	List<WebElement> requestCallBack = new ArrayList<WebElement>();
	List<WebElement> regionFilter = new ArrayList<WebElement>();
	List<WebElement> ratingRecentFilter = new ArrayList<WebElement>();
	List<WebElement> allVacations = new ArrayList<WebElement>();
	List<WebElement> allSlugIntineraries = new ArrayList<WebElement>();

	List<String> europe = new ArrayList<String>();
	List<String> southEastAsia = new ArrayList<String>();
	List<String> ausNewzealand = new ArrayList<String>();
	List<String> africa = new ArrayList<String>();
	List<String> islandDestinations = new ArrayList<String>();
	List<String> allDestinations = new ArrayList<String>();

	protected Map<String, String> departureCities = new HashMap<String, String>();

	public static String travellerData = "";
	public static String regionText, sortFilterText, filterTextAfterClick = "";
	public static WebElement region;

	public static StringBuilder html = new StringBuilder();
	public StringBuilder html1 = new StringBuilder();
	public static String timeStamp = "";

	public Kernel() {
		razorpaypage = PageFactory.initElements(driver, RazorPayPaymentPage.class);
		booingReview = PageFactory.initElements(driver, BookingReviewPage.class);
		pdgflowp = PageFactory.initElements(driver, PdgFlowPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
		cp = PageFactory.initElements(driver, CustomizePage.class);
		bdp = PageFactory.initElements(driver, BlockingDatesPage.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		dp = PageFactory.initElements(driver, DurationPage.class);
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		inclusionNew = PageFactory.initElements(driver, InclusionPage.class);
		intpag = PageFactory.initElements(driver, IternaryPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		sp = PageFactory.initElements(driver, SignupPage.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		packagesPage = PageFactory.initElements(driver, PackagesPage.class);
		cbr = PageFactory.initElements(driver, Cbrpage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);
		psp = PageFactory.initElements(driver, PassengerDetailsPage.class);
		testimonials = PageFactory.initElements(driver, TestimonialsPage.class);
		yourVacation = PageFactory.initElements(driver, YourVacationsPage.class);
		ac = PageFactory.initElements(driver, YourAccountPage.class);
		paymentPage = PageFactory.initElements(driver, PaymentPage.class);
		hotelPage = PageFactory.initElements(driver, HotelsPage.class);
		adminPage = PageFactory.initElements(driver, AdminPage.class);
		activityPage = PageFactory.initElements(driver, ActivityPage.class);
		flightPage = PageFactory.initElements(driver, FlightsPage.class);
		visaPage = PageFactory.initElements(driver, VisaPage.class);
		ed = PageFactory.initElements(driver, EditRoutePage.class);
		ferryPage = PageFactory.initElements(driver, FerryPage.class);
		trainsPage = PageFactory.initElements(driver, TrainsPage.class);
		payUPage = PageFactory.initElements(driver, PayUPage.class);
		rentalCarPage = PageFactory.initElements(driver, RentalCarPage.class);
		dubaiPage =  PageFactory.initElements(driver,SandunePage.class);
		blockCard =PageFactory.initElements(driver,BlockCardPage.class);
		sbLand = PageFactory.initElements(driver, SpeedboatLandingPage.class);
		sbList = PageFactory.initElements(driver, SpeedboatListingPage.class);
		sbUncost = PageFactory.initElements(driver, SpeedboatUncostedDetailsPage.class);
		sbCost = PageFactory.initElements(driver, SpeedboatCostedDetailsPage.class);
        t20 = PageFactory.initElements(driver,T20WorldCupPage.class);
		sbaliLanding = PageFactory.initElements(driver, SpeedBaliLandingPage.class);
		sbaliListing = PageFactory.initElements(driver, SpeedBaliListingPage.class);
		adminPrice = PageFactory.initElements(driver, DiscountPricingPage.class);
		webVitals= PageFactory.initElements(driver, CoreWebVitalsPage.class);


		departureCities.put("Chennai", "MAA");
		departureCities.put("Jaipur", "JAI");
		departureCities.put("Coimbatore", "CJB");
		departureCities.put("Kochi", "COK");
		departureCities.put("Bengaluru", "BLR");
		departureCities.put("Mumbai", "BOM");
		departureCities.put("Kolkata", "CCU");
		departureCities.put("Hyderabad", "HYD");
		departureCities.put("Delhi", "DEL");
		departureCities.put("Trichy", "TRZ");
		departureCities.put("Ahmedabad", "AMD");
		departureCities.put("Amritsar", "ATQ");
		departureCities.put("Trivandrum", "TRV");
		departureCities.put("Lucknow", "LKO");
		departureCities.put("Bhubaneshwar", "BBI");
		departureCities.put("Pune", "PNQ");
		departureCities.put("Madurai", "IXM");
		departureCities.put("Varanasi", "VNS");
		departureCities.put("Goa", "GOI");
		departureCities.put("Chandigarh", "IXC");
		departureCities.put("Vadodara", "BDQ");
		departureCities.put("Guwahati", "GAU");
		departureCities.put("Visakhapatnam", "VTZ");
		departureCities.put("Aurangabad", "IXU");
		departureCities.put("Mangalore", "IXE");
		departureCities.put("Udaipur", "UDR");
		departureCities.put("Ranchi", "IXR");
		departureCities.put("Nagpur", "NAG");
	}

	public void homePagelinksValidation() throws Exception {
		// //////////extentTest.log(LogStatus.INFO, "Validating all the links in Home
		// Page");
		String parentWindow = null;
		hp = PageFactory.initElements(driver, HomePage.class);
		// System.out.println("In home page validation class ::");
		clickAction(hp.getTestimonials(), "testinmonal link");
		////////// extentTest.log(LogStatus.PASS, "Step details");
		verifyExistence(hp.getPytLogo(), "Logo", true);
		parentWindow = switchWindows();
		verifyExistence(hp.getPytLogo(), "Logo", true);
		clickAction(hp.getPytLogo(), "Logo");
		clickAction(hp.getBlog(), "Blog");
		clickAction(hp.getPytLogo(), "Logo");

	}

	public void loginFunctionalityTest(String user) {

		try {
			// lp = PageFactory.initElements(driver, LoginPage.class);
			Thread.sleep(5000);
			// System.out.println("Login....");
			if (elementDisplayed(lp.getLogin())) {
				clickAction(lp.getLogin());
				// System.out.println("user:"+user);
				if (user.toLowerCase().contentEquals("admin")) {
					System.out.println(prop.getProperty("Admin_User"));
					typeText(lp.getUserName(), prop.getProperty("Admin_User"));
					typeText(lp.getPassword(), prop.getProperty("Admin_Password"));
				} else if (user.toLowerCase().contentEquals("registered_user")) {
					typeText(lp.getUserName(), username);
					typeText(lp.getPassword(), pass);
				}
				Thread.sleep(1000);
				clickAction(lp.getLoginButton());
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			// System.out.println("Problem while logging");
			ex.printStackTrace();
		}
	}

	public void loginFunctionalityGCM(String user) {
		try {
			// lp = PageFactory.initElements(driver, LoginPage.class);
			Thread.sleep(1000);
			// System.out.println("Login....");
			if (elementDisplayed(sbaliListing.getLoginGCM())) {

				// System.out.println("user:"+user);
				if (user.toLowerCase().contentEquals("admin")) {
					System.out.println(prop.getProperty("Admin_User"));
					typeText(lp.getUserName(), prop.getProperty("Admin_User"));
					typeText(lp.getPassword(), prop.getProperty("Admin_Password"));
				} else if (user.toLowerCase().contentEquals("registered_user")) {
					typeText(lp.getUserName(), username);
					typeText(lp.getPassword(), pass);
				}
				Thread.sleep(1000);
				clickAction(lp.getLoginButton());
				Thread.sleep(3000);
			}
		} catch (Exception ex) {
			// System.out.println("Problem while logging");
			ex.printStackTrace();
		}
	}

	public boolean newUserSignupFromLandingPage() {
		Boolean actionResult = false;
		sp = PageFactory.initElements(driver, SignupPage.class);
		try {
			if (elementDisplayed(sp.getLandingPageLogin())) {
				clickAction(sp.getLandingPageLogin());
				clickAction(sp.getInitSignup());
				typeText(sp.getUsername(), newuser);
				typeText(sp.getEmail(), newemail);
				typeText(sp.getMobileNumber(), newmobile);

				if (elementDisplayed(sp.getSignup())) {
					clickAction(sp.getSignup());
					if (!(getCurrentUrl().contains("signup"))) {
						actionResult = true;
					}
				}

				else if (elementDisplayed(sp.getcreateMyAcc())) {
					clickAction(sp.getcreateMyAcc());
					// boolean accountExists=verifyPartialText(sp.getAccountExists(), "Account
					// Exists");
					if (!(getCurrentUrl().contains("signup"))) {
						actionResult = true;
					}
				}
			}

			// actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean newUserSignupFromItineraryPage() {
		Boolean actionResult = false;
		sp = PageFactory.initElements(driver, SignupPage.class);
		try {
			if (elementDisplayed(intpag.getItnLogin())) {
				clickAction(intpag.getItnLogin());
				clickAction(sp.getInitSignup());
				typeText(sp.getUsername(), newuser);
				typeText(sp.getEmail(), newemail);
				typeText(sp.getMobileNumber(), newmobile);
				clickAction(sp.getcreateMyAcc());
			}
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean existingUserSignupFromLandingPage(String oldParams) {
		Boolean actionResult = false;
		sp = PageFactory.initElements(driver, SignupPage.class);
		try {
			if (elementDisplayed(sp.getLandingPageLogin())) {
				clickAction(sp.getLandingPageLogin());
				clickAction(sp.getInitSignup());
				if (oldParams == "All") {
					typeText(sp.getUsername(), regname);
					typeText(sp.getEmail(), regemail);
					typeText(sp.getMobileNumber(), username);
				} else if (oldParams == "Email") {
					typeText(sp.getUsername(), newuser);
					typeText(sp.getEmail(), regemail);
					typeText(sp.getMobileNumber(), newmobile);
				} else if (oldParams == "Mobile") {
					typeText(sp.getUsername(), newuser);
					typeText(sp.getEmail(), newemail);
					typeText(sp.getMobileNumber(), username);
				}
				if (elementDisplayed(sp.getSignup())) {
					clickAction(sp.getSignup());
					if (getCurrentUrl().contains("signup")) {
						actionResult = true;
					}
				} else if (elementDisplayed(sp.getcreateMyAcc())) {
					clickAction(sp.getcreateMyAcc());
					if (getCurrentUrl().contains("signup")) {
						actionResult = true;
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean chooseAnyPackage() {
		boolean actionResult = false;
		try {
			hp = PageFactory.initElements(driver, HomePage.class);
			packagesPage = PageFactory.initElements(driver, PackagesPage.class);
			String currentUrl = driver.getCurrentUrl();
			packagesUrl = currentUrl + "packages/australia";
			driver.navigate().to(packagesUrl);
			Thread.sleep(5000);
			String window = switchWindows();
			// clickAction(packagesPage.getCustomizeCta());
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLogin(String uName, String passwd) {
		boolean actionResult = false;
		try {
			waitForMe(lp.getUserName());
			typeText(lp.getUserName(), uName);
			waitForMe(lp.getPassword());
			typeText(lp.getPassword(), passwd);
			if (elementDisplayed(lp.getpackCtaLogin())) {
				clickAction(lp.getpackCtaLogin());
				actionResult = true;
			} else if (elementDisplayed(lp.getLoginButton())) {
				Thread.sleep(1000);
				clickAction(lp.getLoginButton());
				actionResult = true;
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		System.out.println(actionResult);
		return actionResult;
	}

	public boolean doLoginWithInvalidUsername() {
		boolean actionResult = false;
		try {
			typeText(lp.getUserName(), invalidUser);
			typeText(lp.getPassword(), pass);
			clickAction(sp.getLoginButton());
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLoginWithInvalidPassword() {
		boolean actionResult = false;
		try {
			typeText(lp.getUserName(), username);
			typeText(lp.getPassword(), invalidPassword);
			clickAction(sp.getLoginButton());
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLoginWithInvalidCredentials() {
		boolean actionResult = false;
		try {
			typeText(lp.getUserName(), invalidUser);
			typeText(lp.getPassword(), invalidPassword);
			clickAction(sp.getLoginButton());
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLoginFromLandingPage(String uName, String passwd, String testScenario, String pageName) {
		boolean actionResult = false;
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			if (pageName == "Packages") {
				clickAction(lp.getLogin());
			}
			boolean loginResult = doLogin(uName, passwd);
			if (loginResult == true) {
				if (testScenario == "Valid") {
					if (elementDisplayed(hp.getPytLogo())) {
						actionResult = true;
					}
				} else if (testScenario == "InvalidUser") {
					if (elementDisplayed(lp.getInvalidUserAlert())) {
						actionResult = true;
					}
				} else if (testScenario == "InvalidPassword") {
					if (elementDisplayed(lp.getInvalidPasswordAlert())) {
						actionResult = true;
					}
				} else if (testScenario == "InvalidCredentials") {
					if (elementDisplayed(lp.getInvalidUserAlert())) {
						actionResult = true;
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLoginFromGCM(String uName, String passwd, String testScenario) {
		boolean actionResult = false;
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			clickAction(sp.getAlreadyGotAccount());
			boolean loginResult = doLogin(uName, passwd);
			if (loginResult == true) {
				if (testScenario == "Valid") {
					actionResult = true;
				} else if (testScenario == "InvalidUser") {
					if (elementDisplayed(lp.getInvalidUserAlert())) {
						actionResult = true;
					}
				} else if (testScenario == "InvalidPassword") {
					if (elementDisplayed(lp.getInvalidPasswordAlert())) {
						actionResult = true;
					}
				} else if (testScenario == "InvalidCredentials") {
					if (elementDisplayed(lp.getInvalidUserAlert())) {
						actionResult = true;
					}
				}
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doSignupAsOldUser() {
		boolean result = false;
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			waitForMe(sp.getUsername());
			typeText(sp.getUsername(), regname);
			waitForMe(sp.getEmail());
			typeText(sp.getEmail(), regemail);
			Thread.sleep(1000);
			waitForMe(sp.getMobileNumber());
			typeText(sp.getMobileNumber(), username);
			Thread.sleep(1000);

			try {

				if (elementDisplayed(sp.getSignup())) {
					clickAction(sp.getSignup());
					result = true;
				} else if (elementDisplayed(sp.getcreateMyAcc())) {
					clickAction(sp.getcreateMyAcc());
					result = true;
				} else if (elementDisplayed(lp.getvacCtaLogin())) {
					clickAction(lp.getvacCtaLogin());
					result = true;
				}

			} catch (Exception e) {
				clickAction(sp.getGCMSignup());
				result = true;
			}

			typeText(lp.getPassword(), pass);
			clickAction(lp.getpackCtaLogin());
			Thread.sleep(3000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public boolean doSignupWithOldUserInLandingPage() {
		boolean result = false;
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			if (elementDisplayed(lp.getGCMHeaderLogin())) {
				clickAction(lp.getGCMHeaderLogin());
			} else if (elementDisplayed(lp.getLogin())) {
				clickAction(lp.getLogin());
			}
			clickAction(sp.getLoginFromSignup());
			Boolean signupresult = doSignupAsOldUser();
			if (signupresult == true) {
				result = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean doSignupAsOldUserGCMPage() {
		boolean result = false;
		try {
			Boolean signupresult = doSignupAsOldUser();
			if (signupresult == true) {
				pollingWait(inclusion.getBookNow(), 100);
				String currentUrl = getCurrentUrl();
				if (signupresult == true && currentUrl.contains("inclusions")) {
					result = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean doSignupFromGCMHeaderLogin() {
		boolean result = false;
		try {
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			Boolean signupresult = newUserSignupFromItineraryPage();
			if (signupresult == true) {
				result = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean doSignupAsOldUserGCMSignup(boolean vFlag) {
		boolean result = false;
		try {
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			lp = PageFactory.initElements(driver, LoginPage.class);
			// clickAction(gcm.goToLogin());
			if (vFlag == false) {
				clickAction(sp.getAlreadyGotAccount());
				clickAction(sp.getLoginFromSignup());
			}
			waitForMe(sp.getUsername());
			typeText(sp.getUsername(), regname);
			waitForMe(sp.getEmail());
			typeText(sp.getEmail(), regemail);
			waitForMe(sp.getMobileNumber());
			typeText(sp.getMobileNumber(), username);
			if (vFlag == false) {
				if (elementDisplayed(sp.getcreateMyAcc())) {
					clickAction(sp.getcreateMyAcc());
				}
			}
			waitForMe(lp.getPassword());
			typeText(lp.getPassword(), pass);
			clickAction(lp.getpackCtaLogin());
			result = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean SignupFromGCMPageHeaderLink(String region) {
		boolean testResult = false;
		boolean signup = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		try {
			boolean costing = iternaryFlow(region);
			// if(elementDisplayed(icm.getcalculateTripCostButton())) {
			// clickAction(icm.getcalculateTripCostButton());
			// }
			if (costing == true) {
				// clickAction(gcm.closeGcmModal());
				signup = doSignupFromGCMHeaderLogin();
				if (signup == true) {
					waitForMe(pdgtreco.waitForCosting());
					String currentUrl = getCurrentUrl();
					if (currentUrl.contains("inclusions")) {
						testResult = true;
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return testResult;
	}

	public boolean SignupFromLandingPageTest(String testScenario) {
		Boolean signupResult = false;
		Boolean actionResult = false;
		try {
			// System.out.println("Trying to launch signup from landing page");
			sp = PageFactory.initElements(driver, SignupPage.class);
			if (testScenario == "NewUser") {
				actionResult = newUserSignupFromLandingPage();
			} else if (testScenario == "ExistingCredentials") {
				actionResult = existingUserSignupFromLandingPage("All");
			} else if (testScenario == "ExistingMobile") {
				actionResult = existingUserSignupFromLandingPage("Mobile");
			} else if (testScenario == "ExistingEmail") {
				actionResult = existingUserSignupFromLandingPage("Email");
			}
			if (sp.getLoginModal() != null && actionResult == true) {
				signupResult = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return signupResult;
	}

	public boolean chooseHeaderLoginAlreadyGotAcc(String pageName, String testScenario) {
		boolean result = false;
		try {
			lp = PageFactory.initElements(driver, LoginPage.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			if (pageName == "Packages" && testScenario == "ExistingAccount") {
				clickAction(lp.getLogin());
			}
			if (testScenario == "ExistingAccount") {
				clickAction(sp.getLoginFromSignup());
				clickAction(sp.getAlreadyGotAccount());
			}
			if (doLogin(username, pass)) {
				Thread.sleep(3000);
				result = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean chooseVacation() {
		boolean result = false;
		try {
			hp = PageFactory.initElements(driver, HomePage.class);
			packagesPage = PageFactory.initElements(driver, PackagesPage.class);
			clickAction(hp.getExploreFamilyVacations());
			// Thread.sleep(5000);
			String window = switchWindows();
			clickAction(packagesPage.getFamilyVacationPackage());
			result = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean choosePaidCampaign() {
		boolean result = false;
		try {
			hp = PageFactory.initElements(driver, HomePage.class);
			packagesPage = PageFactory.initElements(driver, PackagesPage.class);
			String currentUrl = driver.getCurrentUrl();
			vacationsUrl = currentUrl + "vacations/australia";
			driver.navigate().to(vacationsUrl);
			Thread.sleep(5000);
			String window = switchWindows();
			clickAction(packagesPage.getVacationsCustomizeCta());
			result = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean doLoginFromGCMFooter(String uName, String passwd) {
		boolean result = true;
		try {
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			lp = PageFactory.initElements(driver, LoginPage.class);
			clickAction(gcm.goToLogin());
			typeText(lp.getUserName(), uName);
			typeText(lp.getPassword(), passwd);
			if (elementDisplayed(lp.getpackCtaLogin())) {
				clickAction(lp.getpackCtaLogin());
			} else if (elementDisplayed(packagesPage.getPackageGetCost())) {
				clickAction(packagesPage.getPackageGetCost());
			}
			result = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean SignupFromGCMPageTest(String testCase, String region) {
		boolean retVal = false;
		try {
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			boolean actionResult = iternaryFlow(region);
			if (elementDisplayed(icm.getcalculateTripCostButton())) {
				clickAction(icm.getcalculateTripCostButton());
			}
			if (actionResult == true) {
				if (fillMandatoryInfoInGCM()) {
					typeText(sp.getUsername(), newuser);
					typeText(sp.getEmail(), newemail);
					Thread.sleep(1000);
					typeText(sp.getMobileNumber(), newmobile);
					Thread.sleep(1000);
					clickAction(gcm.doGetCost());
					List<WebElement> whichUser = driver
							.findElements(By.xpath("//*/h5[contains(text(),'Welcome back!')]"));
					if (whichUser.size() < 1 && testCase == "GCMSignup") {
						waitForMe(pdgtreco.waitForCosting());
						String currentUrl = getCurrentUrl();
						if (currentUrl.contains("inclusions")) {
							retVal = true;
						}
					} else if (whichUser.size() > 0 && testCase == "ExistingUserModal") {
						clickAction(pdgtreco.doSignupFromOldUserModal());
						typeText(sp.getUsername(), addluser);
						typeText(sp.getEmail(), addlemail);

						typeText(sp.getMobileNumber(), addlmobile);
						{
							if (elementDisplayed(sp.getSignup())) {
								clickAction(sp.getSignup());
							} else if (elementDisplayed(sp.getcreateMyAcc())) {
								clickAction(sp.getcreateMyAcc());
							}
						}
						waitForMe(pdgtreco.waitForCosting());
						String currentUrl = getCurrentUrl();
						if (currentUrl.contains("inclusions")) {
							retVal = true;
						}
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		// System.out.println("Retval is " + retVal);
		return retVal;
	}

	public boolean ItineraryPageModals(String pageName, String region) {
		boolean result = false;
		try {

			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			boolean costing = iternaryFlow(region);
			if (costing == true) {
				if (pageName == "GCM") {
					clickAction(icm.getcalculateTripCostButton());
					result = true;
				} else if (pageName == "CTC")
					clickAction(intpag.getCalculateCost());
				result = true;
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean signupThroughPage(String pageName, String region) {
		boolean retVal = false;
		boolean actionResult = true;
		hp = PageFactory.initElements(driver, HomePage.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		sp = PageFactory.initElements(driver, SignupPage.class);
		intpag = PageFactory.initElements(driver, IternaryPage.class);
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		try {
			if (pageName == "Vacations") {
				actionResult = chooseVacation();
			} else if (pageName == "Packages") {
				actionResult = chooseAnyPackage();
			} else if (pageName == "GCM") {
				actionResult = ItineraryPageModals(pageName, region);
			} else if (pageName == "CTC") {
				actionResult = ItineraryPageModals(pageName, region);
			}

			if (actionResult == true) {
				if (fillMandatoryInfoInGCM()) {
					typeText(sp.getUsername(), newuser);
					typeText(sp.getEmail(), newemail);
					Thread.sleep(1000);
					typeText(sp.getMobileNumber(), newmobile);
					Thread.sleep(1000);
					clickAction(gcm.getSignUpCta());
					waitForMe(pdgtreco.waitForCosting());
					String currentUrl = getCurrentUrl();
					if (currentUrl.contains("inclusions")) {
						retVal = true;
					}

				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		// System.out.println("Retval is " + retVal);
		return retVal;
	}

	public boolean SignupFromPackagesPageHeaderLink(String region) {
		boolean testResult = false;
		boolean signup = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getAdventureTripsPackages());
			signup = doSignupFromGCMHeaderLogin();
			if (signup == true) {
				waitForMe(pdgtreco.waitForCosting());
				String currentUrl = getCurrentUrl();
				if (currentUrl.contains("inclusions")) {
					testResult = true;
				}
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return testResult;
	}

	public boolean LoginThroughPage(String pageName, String testScenario, String region) {
		boolean retFlag = false;
		boolean actionResult = true;
		boolean loginResult = false;
		boolean isModalShown = false;
		hp = PageFactory.initElements(driver, HomePage.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		sp = PageFactory.initElements(driver, SignupPage.class);
		intpag = PageFactory.initElements(driver, IternaryPage.class);
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		try {
			if (pageName == "Vacations") {
				actionResult = chooseVacation();
			} else if (pageName == "Packages") {
				actionResult = chooseAnyPackage();
			} else if (pageName == "PaidCampaign") {
				actionResult = choosePaidCampaign();
			}
			if (actionResult == true) {
				if (pageName == "PaidCampaign" || pageName == "Packages" || pageName == "GCM" || pageName == "CTC") {
					if (pageName == "GCM" || pageName == "CTC") {
						if (elementDisplayed(hp.getstartPlanningNowButton()))
							iternaryFlow(region);
						if (elementDisplayed(icm.getcalculateTripCostButton())) {
							clickAction(icm.getcalculateTripCostButton());
						}
						if (pageName == "CTC") {
							clickAction(gcm.closeGcmModal());
							// Thread.sleep(3000);
							clickAction(intpag.getCalculateCost());
						}
					}
					if (pageName == "Packages") {
						scrollTo(500);
						clickAction(packagesPage.getCustomizeCta());
					}
					if (fillMandatoryInfoInGCM()) {
						// if (testScenario == "GCMFooterLogin") {
						// loginResult = doLoginFromGCMFooter(username, pass);}
						if (testScenario == "GCMSignup") {
							loginResult = doSignupAsOldUserGCMPage();
							retFlag = loginResult;
						} else if (testScenario == "ChooseSignup") {
							loginResult = doSignupAsOldUserGCMSignup(false);
							retFlag = loginResult;
						} else if (testScenario == "GCMLogin") {
							loginResult = doLoginFromGCM(username, pass, "Valid");
							pollingWait(inclusion.getBookNow(), 150);
							String currentUrl = getCurrentUrl();
							if (loginResult == true && currentUrl.contains("inclusions")) {
								retFlag = true;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		return retFlag;
	}

	public boolean LoginThroughHeader(String pageName, String testScenario, String region) {
		boolean loginResult = false;
		boolean retFlag = false;
		boolean actionResult = false;
		try {
			if (pageName == "ItineraryPage") {
				actionResult = chooseItineraryHeader(region);
			} else if (pageName == "Packages") {
				actionResult = chooseAnyPackage();
			}
			if(actionResult == true){	
				if(pageName == "Packages" || pageName == "ItineraryPage") {
					if(testScenario == "HeaderLogin") {
						loginResult = doLoginFromLandingPage(username, pass, "Valid",pageName);
						Thread.sleep(5000);
						String currentUrl = getCurrentUrl();
						if (loginResult == true && (currentUrl.contains("packages") || currentUrl.contains("view"))) {
							retFlag = true;
						}

					} else if (testScenario == "HeaderSignup") {
						loginResult = doSignupWithOldUserInLandingPage();
						Thread.sleep(5000);
						if (elementDisplayed(hp.getUserLoggedInitial()) && loginResult == true) {
							retFlag = true;
						}
					} else if (testScenario == "ExistingAccount") {
						loginResult = chooseHeaderLoginAlreadyGotAcc(pageName, testScenario);
						Thread.sleep(2000);
						String currentUrl1 = getCurrentUrl();
						if (loginResult == true && (currentUrl1.contains("packages") || currentUrl1.contains("view"))) {
							retFlag = true;
						}

					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete login", "FAIL");
			ex.printStackTrace();
		}
		System.out.println("=========" + retFlag);
		return retFlag;
	}

	public boolean chooseItineraryHeader(String region) {
		boolean actionResult = false;
		try {
			hp = PageFactory.initElements(driver, HomePage.class);
			if (elementDisplayed(hp.getstartPlanningNowButton())) {
				if (iternaryFlow(region)) {
					clickAction(lp.getGCMHeaderLogin());
					actionResult = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Unable to complete signup", "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean doLoginFromSignupModal(String uName, String passwd, String formState, String testScenario) {
		Boolean loginResult = false;
		try {
			sp = PageFactory.initElements(driver, SignupPage.class);
			hp = PageFactory.initElements(driver, HomePage.class);
			lp = PageFactory.initElements(driver, LoginPage.class);
			String pageUrl = "";
			if (elementDisplayed(lp.getLogin())) {
				clickAction(lp.getLogin());
				clickAction(sp.getInitSignup());
				if (formState == "CleanSignupForm") {
					waitForMe(sp.getAlreadyGotAccount());
					clickAction(sp.getAlreadyGotAccount());
					if (testScenario == "ValidCredentials") {
						boolean result = doLogin(uName, passwd);
						if (elementDisplayed(hp.getUserLoggedInitial()) && result == true) {
							loginResult = true;
						}
					} else if (testScenario == "InvalidPassword") {
						boolean result = doLoginWithInvalidPassword();
						if (elementDisplayed(lp.getInvalidPasswordAlert()) && result == true) {
							loginResult = true;
						}
					} else if (testScenario == "InvalidUsername") {
						boolean result = doLoginWithInvalidUsername();
						if (elementDisplayed(lp.getInvalidUserAlert()) && result == true) {
							loginResult = true;
						}
					} else if (testScenario == "InvalidCredentials") {
						boolean result = doLoginWithInvalidCredentials();
						if (elementDisplayed(lp.getInvalidUserAlert()) && result == true) {
							loginResult = true;
						}
					}
				} else if (formState == "InputUserData") {
					boolean result = doSignupAsOldUser();
					if (elementDisplayed(hp.getUserLoggedInitial()) && result == true) {
						loginResult = true;

					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Login from sign up modal failed", "FAIL");
			ex.printStackTrace();
		}
		System.out.println("==========" + loginResult);
		return loginResult;
	}

	public boolean getBetterCost() {
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		boolean result = false;
		String alert = "";
		try {
			clickAction(inclusion.getBookTripDropdown());
			clickAction(inclusion.getBetterCost());
			alert = getText(inclusion.getBetterCostAlert());
			if (alert == "Email will be sent with shuffled cost soon...") {
				clickAction(inclusion.acceptBetterCostAlert());
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Get better cost failed", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean shareItinerary() {
		boolean result = false;
		String alert = "";
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		try {
			// clickAction(inclusion.getBookTripDropdown());
			clickAction(inclusion.getShareItinerary());
			typeText(inclusion.inputCustMobileNo(), username);
			clickAction(inclusion.getFetchAccounts());
			clickAction(inclusion.selectUserAccount());
			typeText(inclusion.setEmailSubject(), "Automation itinerary");
			clickAction(inclusion.getTravelerDropdown());
			clickAction(inclusion.chooseTravelerType());
			clickAction(inclusion.getTravelPurposeOpt());
			clickAction(inclusion.chooseTravelPurpose());
			clickAction(inclusion.getLeadStatusOpt());
			clickAction(inclusion.chooseLeadStatus());
			clickAction(inclusion.getContinue());
			alert = getText(inclusion.getShareConfirmation());
			if (alert.equalsIgnoreCase("Your itinerary is on its way to your inbox.")) {
				clickAction(inclusion.exitShareAlert());
				result = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Share itinerary failed", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean sendToPlato() {
		boolean result = false;
		String alert = "";
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		try {
			clickAction(inclusion.getBookTripDropdown());
			clickAction(inclusion.chooseSendToPlato());
			alert = getText(inclusion.getPlatoStatus());
			if (alert.equalsIgnoreCase("success!")) {
				clickAction(inclusion.exitPlatoAlert());
				result = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Send to plato failed", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean customerSplitPrice(String action) {
		boolean result = false;
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		try {
			// clickAction(inclusion.getBookTripDropdown());
			clickAction(inclusion.getSplitPriceOpt());
			if (action == "Enable") {

			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Get better cost failed", "FAIL");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean adminFlowValidations(String testScenario) {
		boolean retFlag = false;
		boolean gcmResult = false;
		boolean validationRes = false;
		String alert = "";
		hp = PageFactory.initElements(driver, HomePage.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);
		sp = PageFactory.initElements(driver, SignupPage.class);
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);

		try {
			if (testScenario == "GCMValidation" || testScenario == "GetBetterCost" || testScenario == "ShareItinerary"
					|| testScenario == "SendToPlato" || testScenario == "EnableSplitPrice") {

				if (testScenario.contentEquals("GCMValidation")) {
					retFlag = true;
				} else if (testScenario.contentEquals("GetBetterCost")) {
					if (getBetterCost()) {
						retFlag = true;
					}
				} else if (testScenario.contentEquals("ShareItinerary")) {
					if (shareItinerary()) {
						retFlag = true;
					}
				} else if (testScenario.contentEquals("SendToPlato")) {
					if (sendToPlato()) {
						retFlag = true;
					}
				} else if (testScenario.contentEquals("EnableSplitPrice")) {
					if (customerSplitPrice("Enable")) {
						retFlag = true;
					}
				}
			}

			else if (testScenario == "GetCost") {
				if (costPDGItinerary()) {
					if (fillMandatoryInfoInGCM()) {
						if (doLoginFromGCMFooter(adminUser, adminPassword)) {
							waitForMe(pdgtreco.waitForCosting());
							clickAction(gcm.getEditTrip());
							clickAction(gcm.getIntlFlights());
							clickAction(gcm.getUpdateCost());
							waitForMe(pdgtreco.waitForCosting());
							if (validateAdminComponents()) {
								retFlag = true;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("ERROR : Admin feature validation failed", "FAIL");
			ex.printStackTrace();
		}
		return retFlag;
	}

	public boolean validateAdminComponents() {
		boolean result = false;
		inclusion = PageFactory.initElements(driver, InclusionsPage.class);
		if (inclusion.getFlightSplit() != null && inclusion.getActivitySplit() != null
				&& inclusion.getHotelSplit() != null && inclusion.getTransferSplit() != null) {
			result = true;
		}
		return result;
	}

	public void login() {
		try {
			waitForMe(lp.getLogin());
			clickAction(lp.getLogin());
			// System.out.println("Logged in");
		} catch (Exception ex) {
			System.out.println("Problem while logging");
		}
	}

	public void homepageLanding() throws Exception {

		hp = PageFactory.initElements(driver, HomePage.class);

		try {
			waitUntil(hp.getPytLogo(), 30);
			clickAction(hp.getPytLogo());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while landing on Home page", "FAIL");
		}

	}

	public void logout() throws Exception {
		clickAction(lp.getmenuButton(), "menu");
		clickAction(lp.getlogoutButton(), "Logout Button");
		////////// extentTest.log(LogStatus.INFO, "Logged OUT to PYT.com");
	}

	// Recently Booked itinerary
	public void rbItineraryValidations() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getrecentlyBookedItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Recently Booked Itinerary",
			// "FAIL");
		}
	}

	// visa on arrival card
	public void visaOnArrivalitinerary() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getvisaOnArrivalItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Visa on Arrival Itinerary",
			// "FAIL");
		}
	}

	// Great family 👪 holidays
	public void familyItinerary() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getfamilVacationItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Great Family Holidays Itinerary",
			// "FAIL");
		}
	}

	// romanticHolidaysItinerary
	public void romanticHolidayItinerary() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getromanticHolidaysItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Romantic Holidays Itinerary",
			// "FAIL");
		}
	}

	// adventureTripsItinerary
	public void adventureItinerary() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getadventureTripsItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Adventure Trips Itinerary",
			// "FAIL");
		}
	}

	// beachVacationItinerary
	public void beachVacationItinerary() throws Exception {
		hp = PageFactory.initElements(driver, HomePage.class);
		try {
			clickAction(hp.getbeachVacationItinerary());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem in clicking Beach Vacation Itinerary", "FAIL");
		}
	}

	public boolean iternaryFlow(String region) throws Exception {
		boolean actualResult = false;

		Thread.sleep(2000);
		waitForMe(hp.getstartPlanningNowButton());
		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		 Thread.sleep(5000);
		typeText(cp.getlandingSearchBox(), region);

		if (elementDisplayed(cp.getregionSelection())) {
			{
				 Thread.sleep(2000);

				clickAction(cp.getregionSelection(), "Region selection");
				Thread.sleep(2000);

				clickAction(bdp.getMonth(), "Month Selection");
				
				try {
					if(bdp.getDate().isDisplayed()) {
						clickAction(bdp.getDate(), "Date Selection");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Date selection not available for this region");
				}

				clickAction(dp.getDurationDur1(), "Duration Selection");
				Thread.sleep(2000);
				try {
					if(ip.getTraveelingWith().isDisplayed()) {
						clickAction(ip.getTraveelingWith(), "Couple Selected");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Travelling with selection not available for this region");
				}
				// Thread.sleep(2000);
				clickAction(ip.getAbitOfEverything(), "Interest Selected");
				Thread.sleep(2000);

				// if (elementDisplayed(ip.getviewCitiesButton())) {
				if (driver.findElements(By.xpath("(//a[contains(text(),'Choose cities')])[1]")).size() > 0) {
					clickAction(ip.getviewCitiesButton(), "Select Cities Selected");
					Thread.sleep(1000);
					clickAction(ip.getselect1City(), "Selected 1st city");
					Thread.sleep(1000);

					clickAction(ip.getselect1City(), "Selected 2nd city");
					Thread.sleep(1000);

					clickAction(ip.getselect1City(), "Selected 3rd city");
					Thread.sleep(1000);
					clickAction(ip.getselect1City(), "Selected 4th city");
					// clickAction(ip.getselect1City(), "Selected 5th city");
					// clickAction(ip.getselect1City(), "Selected 6th city");
					// clickAction(ip.getselect1City(), "Selected 7th city");

					clickAction(ip.getbuildItineraryButton(), "Clicked Build Itinerary");
				}
				// else if (elementDisplayed(ip.getIternaryButton()))
				else if (driver.findElements(By.xpath("//span[contains(text(),'Get a Pickyourtrail itinerary')]"))
						.size() > 0) {
					clickAction(ip.getIternaryButton(), "Iternary Button");

				}
				// else if (elementDisplayed(ip.getviewPytIternaryButton()))
				else if (driver
						.findElements(By.xpath("//span[contains(text(),'View your Pickyourtrail personalized')]"))
						.size() > 0) {
					clickAction(ip.getviewPytIternaryButton(), "View only Iternary Button");
				}
			}
			try {

				Thread.sleep(2000);

				waitForMe(ip.getgotItPopup());
				// clickJavaScriptElement(ip.getgotItPopup());

				if (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					// ReporteraddStepLog("PopUp was clicked Successfully in Itinerary Page");

				}
				actualResult = true;
			} catch (NoSuchElementException ex) {
				// ReporteraddStepLog("No PopUp displayed in Itinerary Page");
				actualResult = true;
			} catch (Exception e) {
				System.out.println("No Got it popup");

			}

		}
		return actualResult;
		
		

		// if (elementDisplayed(ip.gettellusMore())) {
		// clickAction(ip.gettellusMore(), "Navigating to Post card");
		// clickAction(hp.getPytLogo(), "logo");
		// }
		// //////////extentTest.log(null, driver.getCurrentUrl(), "");

	}
	
	public boolean iternaryFlowPdgCities(String region,String cities) throws Exception {
		boolean actualResult = false;

		Thread.sleep(2000);
		waitForMe(hp.getstartPlanningNowButton());
		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		 Thread.sleep(5000);
		typeText(cp.getlandingSearchBox(), region);

		if (elementDisplayed(cp.getregionSelection())) {
			{
				 Thread.sleep(2000);

				clickAction(cp.getregionSelection(), "Region selection");
				Thread.sleep(2000);

				clickAction(bdp.getMonth(), "Month Selection");
				
				try {
					if(bdp.getDate().isDisplayed()) {
						clickAction(bdp.getDate(), "Date Selection");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Date selection not available for this region");
				}

				clickAction(dp.getDurationDur1(), "Duration Selection");
				Thread.sleep(2000);
				try {
					if(ip.getTraveelingWith().isDisplayed()) {
						clickAction(ip.getTraveelingWith(), "Couple Selected");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Travelling with selection not available for this region");
				}
				// Thread.sleep(2000);
				clickAction(ip.getAbitOfEverything(), "Interest Selected");
				Thread.sleep(2000);

				// if (elementDisplayed(ip.getviewCitiesButton())) {
				if (driver.findElements(By.xpath("(//a[contains(text(),'Choose cities')])[1]")).size() > 0) {
					
					clickAction(ip.getviewCitiesButton(), "Select Cities Selected");
					Thread.sleep(2000);

					
					String[] oneCity = cities.split(",");
					Thread.sleep(2000);
					for(String city : oneCity){
						System.out.println(city);
						Thread.sleep(2000);
						typeText(ip.getCitySearchText(), city);
						Thread.sleep(2000);
						clickAction(ip.getselect1City(), "Selected 1st city");
						}
					
					Thread.sleep(2000);
					clickAction(ip.getbuildItineraryButton(), "Clicked Build Itinerary");
				}
				// else if (elementDisplayed(ip.getIternaryButton()))
				else if (driver.findElements(By.xpath("//span[contains(text(),'Get a Pickyourtrail itinerary')]"))
						.size() > 0) {
					clickAction(ip.getIternaryButton(), "Iternary Button");

				}
				// else if (elementDisplayed(ip.getviewPytIternaryButton()))
				else if (driver
						.findElements(By.xpath("//span[contains(text(),'View your Pickyourtrail personalized')]"))
						.size() > 0) {
					clickAction(ip.getviewPytIternaryButton(), "View only Iternary Button");
				}
			}
			try {

				Thread.sleep(2000);

				waitForMe(ip.getgotItPopup());
				// clickJavaScriptElement(ip.getgotItPopup());

				if (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					// ReporteraddStepLog("PopUp was clicked Successfully in Itinerary Page");

				}
				actualResult = true;
			} catch (NoSuchElementException ex) {
				// ReporteraddStepLog("No PopUp displayed in Itinerary Page");
				actualResult = true;
			} catch (Exception e) {
				System.out.println("No Got it popup");

			}

		}
		return actualResult;
	}

	public void pdgFlow(String region, String monthOfTravel, String duration, String interest, String departureCity,
			String depDate, String passengers) throws Exception {
		homepageLanding();
		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		// Thread.sleep(2000);

		typeText(cp.getlandingSearchBox(), region);

		if (region.contentEquals("Maldives")) {
			clickAction(cp.getregionSelection(), "Region selection");
			Thread.sleep(2000);
			clickAction(ip.getMaldivesHotel(), "Hotel selected");

		}

		else if (elementDisplayed(cp.getregionSelection())) {
			{
				// Thread.sleep(2000);
				waitUntil(cp.getregionSelection(), 20);
				clickAction(cp.getregionSelection(), "Region selected");
				// Thread.sleep(2000);
				// If-Case for Month of travel
				if (monthOfTravel.contentEquals("January")) {
					clickAction(bdp.getJanuary(), "January Month selected");
				}

				if (monthOfTravel.contentEquals("Feburary")) {
					clickAction(bdp.getFebruary(), "Feburary Month selected");
				}
				if (monthOfTravel.contentEquals("March")) {
					clickAction(bdp.getMarch(), "March Month selected");
				}

				if (monthOfTravel.contentEquals("April")) {
					clickAction(bdp.getApril(), "April Month selected");
				}
				if (monthOfTravel.contentEquals("May")) {
					clickAction(bdp.getMay(), "May Month selected");
				}
				if (monthOfTravel.contentEquals("June")) {
					clickAction(bdp.getJune(), "June Month selected");
				}

				if (monthOfTravel.contentEquals("July")) {
					clickAction(bdp.getJuly(), "July Month selected");
				}
				if (monthOfTravel.contentEquals("August")) {
					clickAction(bdp.getAugust(), "August Month selected");
				}

				if (monthOfTravel.contentEquals("September")) {
					clickAction(bdp.getSeptember(), "September Month selected");
				}

				if (monthOfTravel.contentEquals("October")) {
					clickAction(bdp.getOctober(), "October Month selected");
				}

				if (monthOfTravel.contentEquals("November")) {
					clickAction(bdp.getNovember(), "November Month selected");
				}

				if (monthOfTravel.contentEquals("December")) {
					clickAction(bdp.getDecember(), "December Month selected");
				}

				// If-Case for duration

				if (duration.contentEquals("3-5")) {
					clickAction(dp.getDurationDur1(), "3-5 days selected");
				}
				if (duration.contentEquals("6-8")) {
					clickAction(dp.getDurationDur2(), "6-8 days selected");
				}
				if (duration.contentEquals("9-11")) {
					clickAction(dp.getDurationDur3(), "9-11 days selected");
				}
				if (duration.contentEquals("12-15")) {
					clickAction(dp.getDurationDur3(), "12-15 days selected");
				}

				// If-Case for Interest

				if (interest.contentEquals("Adventure & Outdoor")) {
					clickAction(ip.getAdventureOutdoors(), "selected Adventure & Outdoor");
				}
				if (interest.contentEquals("Art & Culture")) {
					clickAction(ip.getArtAndCulture(), "selected Art & Culture");
				}
				if (interest.contentEquals("Shopping & leisure")) {
					clickAction(ip.getShoppingAndLeisure(), "selected Shopping & leisure");
				}

				if (interest.contentEquals("A bit of everything")) {
					clickAction(ip.getAbitOfEverything(), "selected A bit of everything");
				}

				if (elementDisplayed(ip.getIternaryButton())) {
					clickAction(ip.getIternaryButton(), "Iternary Button");
				}
				if (elementDisplayed(ip.getviewPytIternaryButton())) {
					clickAction(ip.getviewPytIternaryButton(), "View only Iternary Button");
				} else if (elementDisplayed(ip.getviewCitiesButton())) {
					clickAction(ip.getviewCitiesButton(), "Select Cities Selected");
					// Thread.sleep(2000);
					clickAction(ip.getselect1City(), "Selected 1st city");
					// Thread.sleep(2000);

					clickAction(ip.getselect1City(), "Selected 2nd city");
					// Thread.sleep(2000);

					clickAction(ip.getselect1City(), "Selected 3rd city");
					// Thread.sleep(2000);
					clickAction(ip.getselect1City(), "Selected 4th city");
					clickAction(ip.getselect1City(), "Selected 5th city");
					clickAction(ip.getselect1City(), "Selected 6th city");
					clickAction(ip.getselect1City(), "Selected 7th city");

					clickAction(ip.getbuildItineraryButton(), "Clicked Build Itinerary");
				}
			}
			waitUntil(inclusion.getitineraryTab(), 10);

			String currentUrl = driver.getCurrentUrl();
			String expurl = "/view/";
			if (currentUrl.contains(expurl)) {
				System.out.println(expurl);
				System.out.println(currentUrl);
				System.out.println("Region passed " + region + "");
				// pass("comparison of page ");
				// Assert.assertEquals("pass", "pass", "Cpmarison of page ");
				System.out.println(expurl);
				System.out.println(currentUrl);
				System.out.println("Region passed " + region + "");
			} else {
				// Thread.sleep(2000);
				// clickaction(hp.getPytLogo(), "Logo");
				System.out.println(expurl);
				System.out.println(currentUrl);
				// Assert.fail("Region is " + region + "");
				// System.out.println("Region failes " + region + "");

			}

		}

		if (elementDisplayed(ip.gettellusMore())) {
			clickAction(ip.gettellusMore(), "Navigating to Post card");
			clickAction(hp.getPytLogo(), "logo");
		}
		// //////////extentTest.log(null, driver.getCurrentUrl(), "");

	}

	// Search Box Validation
	public void searchBoxValidation() throws Exception {
		clickAction(hp.getstartPlanningNowButton(), "clicked Planning now button");
	}

	// SEO Itinerary Validation
	public void seoItineraryHomePageValidation() throws Exception {
		// clickaction(hp.getrecentlyBookedItinerary(),"Click recently booked SEO
		// Itinerary");
		clickAction(hp.getromanticHolidaysItinerary(), "Click romantic holiday SEO Itinerary");
		Thread.sleep(3000);

		switchWindows();
		clickAction(intpag.getCalculateCost(), "Get Calculate button click");
		clickAction(icm.getDepartingCity(), "CBE");
		clickAction(icm.getdepartingFromCoimbatore(), "Leaving from Coimbatore");
		clickAction(icm.getcalculateTripCostButton(), "trip cost button");
		waitUntil(inclusion.getinclusionsTab(), 50);
		// Thread.sleep(13000);
		clickAction(inclusion.getinclusionsTab(), "Clicking Inclucions Tab");
	}

	public void seoItineraryvalidation() throws Exception {

		icm = PageFactory.initElements(driver, Iternarycostmodel.class);

		try {

			Thread.sleep(2000);
			switchWindows();
			clickAction(icm.getDepartingCity());
			clickAction(icm.getdepartingOutsideindia());
			Thread.sleep(1000);
			clickAction(icm.getDepartingOnCitydate());
			Thread.sleep(2000);
			clickAction(icm.getDepartingOnCitydate20());
			// if (elementDisplayed(icm.getFirstName()))
			if ((driver.findElements(By.xpath("//input[@placeholder = 'Your name']"))).size() > 0) {
				typeText(icm.getFirstName(), cbrName);
				typeText(icm.getUserEmail(), cbrMail);
				typeText(icm.getPhoneNumber(), cbrMobile);
			}
			Thread.sleep(2000);
			clickAction(icm.getcalculateTripCostButton());
			if (elementDisplayed(icm.getPasssword())) {
				typeText(icm.getPasssword(), pass);
				clickAction(icm.getLogin());
				if (waitForMe(icm.getCostingDelay()) != null) {
					waitUntil(inclusion.getinclusionsTab(), 3000);
					// Reports.//Reportstep("Costed the Itinerary successfully", "PASS");
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while Costing Packages Itineraries","FAIL");
		}
	}

	// Calculating the Trip Cost for an Itinerary from Inclusion page
	public boolean inclusionsPageFlow() throws Exception {
		boolean retVal = false;
		// Initializing the webelements from icm page
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		try {
			// Reports.//Reportstep("Itinerary URL: "+driver.getCurrentUrl(), "PASS");
			// Clicking on Get Trip cost and entering the data in the Get Cost modal
			waitUntil(icm.getTripCostButton(), 9000);
			clickAction(icm.getTripCostButton());
			if (validateCostPassengerDetails()) {
				retVal = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Package Itineraries", "FAIL");
		}
		return retVal;

	}

	// For SEO packages flow
	public boolean inclusionsPagePackageFlow(String window) throws Exception {
		boolean retVal = false;
		// Initializing the webelements from icm page
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		try {
			// Reports.//Reportstep("Itinerary URL: "+driver.getCurrentUrl(), "PASS");
			// Clicking on Get Trip cost and entering the data in the Get Cost modal
			waitUntil(icm.getTripCostButton(), 9000);
			clickAction(icm.getTripCostButton());

			if (validateCostPassengerDetails()) {
				retVal = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Package Itineraries", "FAIL");
		}
		return retVal;
	}

	public void changeFlightValidation() throws Exception {

		clickAction(inclusion.getFlightChangeButton(), "Click change Flight button");
	}

	public void changeHotelValidation() throws Exception {

		clickAction(inclusion.gethotelChangeButton(), "Click change HOTTEL button");
		clickAction(inclusion.getChangehotel(), "Click change HOTTEL button");
		clickAction(inclusion.getChooseHotel(), "Click Choose hotel button");
	}

	public void urlValidation_itinerary() {
		// Assert.assertTrue(driver.getCurrentUrl().contains("view"));
	}

	public void packagesPageValidation() throws Exception {
		packagesPage = PageFactory.initElements(driver, PackagesPage.class);
		try {
			scrolltoElement(packagesPage.getCityDropdown());
			moveTo(driver, packagesPage.getCityDropdown());
			clickAction(packagesPage.getCityDropdown());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while clicking on Destination Filter","FAIL");
		}
	}

	public void themesPageValidation() throws Exception {
		packagesPage = PageFactory.initElements(driver, PackagesPage.class);
		try {
			scrolltoElement(packagesPage.getPackagesPageThemesDropdown());
			moveTo(driver, packagesPage.getPackagesPageThemesDropdown());
			clickAction(packagesPage.getPackagesPageThemesDropdown());
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while clicking on Theme Filter","FAIL");
		}
	}

	// This method is to calculate the no. of itineraries for each theme

	public void minSeoItineraryCheck(String destination, String theme) {
		try {
			noOfItineraryCards = driver
					.findElements(By.xpath("//section[contains(@class,'package-card tracker-pkg-card')]")).size();
			// System.out.println("Total No of Itineraries : " + noOfItineraryCards);
			if (noOfItineraryCards < 4) {
				// System.out.println("Itineraries are less than 4!!");
				// Reports.//Reportstep("Package Itineraries for "+destination+" with "+theme+"
				// are less than 4","PASS");
			} else {
				// Reports.//Reportstep("Package Itineraries for "+destination+" with "+theme+"
				// is "+noOfItineraryCards, "PASS");
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating the minimum number of
			// itineraries for "+destination,"FAIL");
		}
	}

	public void isImageBroken() {

		invalidImageCount = 0;
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		// System.out.println("Total no. of images are " + imagesList.size());
		for (WebElement imgElement : imagesList) {
			if (imgElement != null) {
				verifyimageActive(imgElement);
			}
		}
		// System.out.println("Total no. of invalid images are " + invalidImageCount);

	}

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			org.apache.http.HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200) {
				// System.out.println(" contains invalid images :");
				if (!imgElement.getAttribute("src").contains("pyt-images.imgix")) {
					// System.out.println(imgElement.getAttribute("src"));
				}
				// System.out.println("broken Image link : " + imgElement.getAttribute("src"));
				invalidImageCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method is collect all the itineraries for Customize and Slug options
	public List<String> individualitineraryValidation(String des, String theme, String opt) {
		List<String> indSeoItinerary = new ArrayList<String>();
		indSeoItinerary.clear();
		scrollTo(2000);
//		scrollToEnd();
		try {
			if (opt == "customize") {
				noOfItineraryCards = driver
						.findElements(By.xpath("//div[@id='packagesContent']/section")).size();
//				System.out.println("noOfItineraryCards size "+noOfItineraryCards);
				for (int i = 1; i <= noOfItineraryCards; i++) {
					// indSeoItinerary.add(
					// driver.findElement(By.xpath("(//section[contains(@class,'package-card
					// tracker-campaign-card')])["
					// + i + "]//a[contains(@class,'custombtn')]")).getAttribute("href"));
					String item = driver.findElement(By.xpath("//div[@id='packagesContent']/section[" +i+ "]//a")).getAttribute("href");
//					 System.out.println("Item-->"+item);
					 scrolltoElement(driver.findElement(By.xpath("//div[@id='packagesContent']/section[" +i+ "]//a")));
					// indSeoItinerary.add("https://pickyourtrail.com/" + item);

					indSeoItinerary.add(item);

				}
			} else if (opt == "slug") {
				scrollToEnd();
				// noOfItineraryCards =
				// driver.findElements(By.xpath("//section[contains(@class,'package-card
				// tracker-pkg-card')]")).size();
				allSlugIntineraries = driver.findElements(By.xpath(
						"//section[contains(@class,'package-card tracker-pkg-card')]//div[@class='middle-col']/div/p/span[@itemprop='name']/a"));
				noOfItineraryCards = allSlugIntineraries.size();
				// System.out.println("No. of itinerary Cards"+noOfItineraryCards);
				// for (int i = 1; i <= noOfItineraryCards; i++)
				for (WebElement eachSlugItinerary : allSlugIntineraries) {
					String item = eachSlugItinerary.getAttribute("href");
					// indSeoItinerary.add(
					// driver.findElement(By.xpath("(//section[contains(@class,'package-card
					// tracker-campaign-card')])["
					// + i + "]//a[contains(@class,'custombtn')]")).getAttribute("href"));

					// String item =
					// driver.findElement(By.xpath("//section[contains(@class,'package-card
					// tracker-pkg-card')]["+i+"]//div[@class='middle-col']/div/p/span[@itemprop='name']/a")).getAttribute("href");
					// System.out.println("Item-->"+item);
					// indSeoItinerary.add("https://pickyourtrail.com/" + item);

					indSeoItinerary.add(item);

				}
			}
			// System.out.println(indSeoItinerary);
			// Reports.//Reportstep("Successfully identified "+noOfItineraryCards+"
			// Itineraries for "+des+" with "+theme, "PASS");
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while consolidating the Itineraries for "+des+"
			// with "+theme, "FAIL");
		}
		return indSeoItinerary;
	}

	// This method is to validate each itineray by costing the same
	public boolean seoItineraryIndvalidation(List<String> seoitinerList, String dest, String theme) throws Exception {
		boolean retVal = false;
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		try {
			int iteration = packageItineraries;
			int run = 0;
			if (iteration == 100) {
				run = seoitinerList.size();
			} else {
				run = iteration;
			}
			for (int i = 1; i <= run; i++) {
				// System.out.println("url is :" + seoitinerList.get(i));
				// clickAction(driver.findElement(By.xpath("(//a[@class='btn btn-primary
				// tracker-campaign-custombtn'])[" + i + "]")));
				driver.navigate().to(seoitinerList.get(i));
				waitForLoad(driver,15);
				Thread.sleep(2000);
				// seoItineraryvalidation();
				if (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					//ReporteraddStepLog("PopUp was clicked Successfully in Itinerary Page");
				}
				try {
					WebDriverWait wait = new WebDriverWait(driver, 15);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fc_widget"));
					pollingWait(cbr.getPackagesChatClose(), 15);
					clickAction(cbr.getPackagesChatClose());
					driver.switchTo().parentFrame();
				} catch (Exception e) {
				}
				if (driver.findElements(By.xpath("//a[@id='calculate-trip-cost-btn']")).size() > 0) {
					// waitForMe(icm.getTripCostButton());
					clickAction(icm.getTripCostButton());
					System.out.println("clicked");
				}
				
				if (driver.findElements(By.xpath("//*[contains(text(),'latest cost')]")).size() > 0) {
					driver.findElement(By.xpath("//*[contains(text(),'latest cost')]")).click();
				}

				if (fillMandatoryInfoInGCM()) {
					waitForMe(pdgtreco.waitForCosting());
					String curUrl = driver.getCurrentUrl();
					if (compareTwoStringsPartially(curUrl, "/inclusions/")) {
						retVal = true;
						// Reports.//Reportstep("Successfully validated "+seoitinerList.get(i)+"
						// Itinerary for "+dest+" with "+theme, "PASS");
					}
					// navigateToDiffUrlPackages(packagesPageEnv);
					navigateToUrl(PackagesPageValidation.destUrl);
					waitForLoad(driver,15);
				}
			}
			// Reports.//Reportstep("Successfully validated "+run+" Itineraries for "+dest+"
			// with "+theme, "PASS");
			// clickAction(driver.findElement(By.xpath("//div[@class='right-content']//i[@class='vehoicon-close']")));

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating the Itineraries for "+dest+"
			// with "+theme, "FAIL");
		}
		return retVal;
	}

	public void enterCBRFields() {
		cbr = PageFactory.initElements(driver, Cbrpage.class);
		typeText(cbr.getUsername(), cbrName);
		typeText(cbr.getPhonenumber(), cbrMobile);
		if (driver.findElements(By.xpath("//input[@name='email']")).size() > 0) {
			typeText(cbr.getEmail(), cbrMail);
			selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");
		}
	}

	public void enterFieldsexceptTime() {
		typeText(cbr.getUsername(), cbrName);
		typeText(cbr.getPhonenumber(), cbrMobile);
		typeText(cbr.getEmail(), cbrMail);
	}

	public boolean cbrValidationHomePage() throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			// scroll();
			scrolltoElement(cbr.getHomePageCbr());
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr());
			enterCBRFields();
			clickAction(cbr.getcBrSubmitButton());
			retVal = packageVacationLogoValidation();

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Home Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	// CBR Validation from Home page after login

	public boolean cbrValidationHomePageAfterLogin() throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			clickAction(cbr.getPytLogo()); // Clicks pyt-logo to go to Home page from Vacations page
			scrolltoElement(cbr.getHomePageCbr());
			scroll();
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr()); // Clicks "Talk to Us"
			// To validate the fields in CBR Popup
			retVal = cbrPopUpValidationAfterLogin();

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Home Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrValidationPackageVacationPage() throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrollToReserveSlot();
			Thread.sleep(1000);
			clickAction(cbr.getPackagesCbr());
			enterCBRFields();
			clickAction(cbr.getcBrSubmitButton());

			if (elementExist(cbr.getSuccessfulCBRPackage())) {
				clickAction(cbr.getKeepBrowsing());
				retVal = packageVacationLogoValidation();
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Packages/Vacations
			// Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrValidationItineraryPage(String page) throws Exception {
		boolean retVal = false;
		try {
			urlNavigation(page);
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			packagesPage = PageFactory.initElements(driver, PackagesPage.class);
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			intpag = PageFactory.initElements(driver, IternaryPage.class);
			icm = PageFactory.initElements(driver, Iternarycostmodel.class);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", packagesPage.getFirstPackage());
			scrolltoElement(packagesPage.getFirstPackage());
			clickAction(packagesPage.getFirstPackage());
			// scrolltoElement(intpag.getLatestCost());
			// clickAction(intpag.getLatestCost());
			Thread.sleep(3000);

			if (fillMandatoryInfoInGCM()) {
				clickAction(gcm.doGetCost());
				waitForMe(pdgtreco.waitForCosting());
				scroll();
				scrolltoElement(cbr.getTravelConsultant());
				clickAction(cbr.getTravelConsultant());
				retVal = cbrPopUpValidationAfterLogin();
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Itinerary page in
			// Packages Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrValidationPackageVacationPageAfterLogin(String page) throws Exception {
		boolean retVal = false;
		try {
			urlNavigation(page);
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrollToReserveSlot();
			Thread.sleep(1000);
			clickAction(cbr.getPackagesCbr());
			Thread.sleep(1000);
			retVal = cbrPopUpValidationAfterLogin();
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Packages/Vacations
			// Page after login", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrValidationFromUrlAfterLogin(String page) throws Exception {
		boolean retVal = false;
		try {
			urlNavigation(page);
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			moveToUrl(driver);
			Thread.sleep(1000);
			retVal = cbrPopUpValidationAfterLogin();
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from URL of
			// Packages/Vacations Page after login", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrEmailValidation() throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrolltoElement(cbr.getHomePageCbr());
			scroll();
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr());
			typeText(cbr.getUsername(), cbrName);
			typeText(cbr.getPhonenumber(), cbrMobile);
			String incorrectEmail = cbrMail.replace(".", ",");
			typeText(cbr.getEmail(), incorrectEmail);
			selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");
			if (!verifyEnabled(cbr.getcBrSubmitButton())) {
				retVal = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Home Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrNameValidation(String testData) throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrolltoElement(cbr.getHomePageCbr());
			scroll();
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr());
			typeText(cbr.getUsername(), testData);
			typeText(cbr.getPhonenumber(), cbrMobile);
			typeText(cbr.getEmail(), cbrMail);
			selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");
			if (!verifyEnabled(cbr.getcBrSubmitButton())) {
				retVal = true;
			} else {
				retVal = false;

			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Packages/Vacations
			// Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrMobileNoValidation(String testMobileNo) throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrolltoElement(cbr.getHomePageCbr());
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr());
			if (testMobileNo.length() != 10) {
				typeText(cbr.getUsername(), cbrName);
				typeText(cbr.getPhonenumber(), testMobileNo);
				typeText(cbr.getEmail(), cbrMail);
				selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");
				if (!verifyEnabled(cbr.getcBrSubmitButton())) {
					retVal = true;
				} else {
					retVal = false;

				}
			} else if (testMobileNo.length() == 10) {

				typeText(cbr.getUsername(), cbrName);
				typeText(cbr.getEmail(), cbrMail);
				selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");
				if (isValidMobile(testMobileNo)) {
					typeText(cbr.getPhonenumber(), testMobileNo);
					if (verifyEnabled(cbr.getcBrSubmitButton())) {
						clickAction(cbr.getcBrSubmitButton());
						if (elementExist(cbr.getPytLogo())) {
							retVal = true;
						}
					} else {
						retVal = false;

					}

				} else {
					typeText(cbr.getPhonenumber(), testMobileNo);
					if (!verifyEnabled(cbr.getcBrSubmitButton())) {
						retVal = true;
					} else {
						retVal = false;
					}

				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Packages/Vacations
			// Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean cbrValidationPreferredTime(String callTime) throws Exception {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			scrolltoElement(cbr.getHomePageCbr());
			scroll();
			Thread.sleep(1000);
			clickAction(cbr.getHomePageCbr());
			enterFieldsexceptTime();
			selectDropDownUsingVisibleText(cbr.getPreferredTime(), callTime);
			clickAction(cbr.getcBrSubmitButton());
			retVal = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR from Home Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;

	}

	public boolean isValidMobile(String s) {
		boolean retVal = false;
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(s);

		if (matcher.matches()) {
			// System.out.println("Phone Number Valid");
			retVal = true;
		} else {
			// System.out.println("Phone Number is not valid");
			retVal = false;
		}
		return retVal;
	}

	public boolean cbrValidationFromUrlPackageVacationPage() {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);
			Thread.sleep(1000);
			moveToUrl(driver);
			enterCBRFields();
			clickAction(cbr.getcBrSubmitButton());
			if (elementExist(cbr.getSuccessfulCBRPackage())) {
				clickAction(cbr.getKeepBrowsing());
				retVal = packageVacationLogoValidation();
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR through Url from
			// Packages/Vacations Page", "FAIL");
			ex.printStackTrace();
		}
		return retVal;
	}

	public boolean noCbrValidationFromUrlPackageVacation() {
		boolean retVal = false;
		try {
			if (cbrValidationFromUrlPackageVacationPage()) {
				moveToUrl(driver);
				List<WebElement> requestCallBack = driver
						.findElements(By.xpath("//button[contains(@class,'rcb-submit')]"));
				if (requestCallBack.size() > 0) {
					retVal = false;
				} else {
					retVal = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating No CBR popup through Url from
			// Packages/Vacations Page", "FAIL");
		}
		return retVal;
	}

	public boolean packageVacationLogoValidation() {
		boolean retVal = false;
		cbr = PageFactory.initElements(driver, Cbrpage.class);

		try {
			packagesLogo = driver.findElements(By.xpath("//a[@class='logo n-tracker-pytlogo']//img"));
			vacationsLogo = driver.findElements(By.xpath("//div[@class='col-md-12 logo-img']//span//img"));

			if (packagesLogo.size() > 0) {
				if (elementExist(cbr.getPackagesPytLogo())) {
					retVal = true;
				}
			} else if (vacationsLogo.size() > 0) {
				if (elementExist(cbr.getVacationsPytLogo())) {
					retVal = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating logos of Packages/Vacations
			// Page", "FAIL");
		}
		return retVal;
	}

	public boolean cbrPopUpValidationAfterLogin() {
		boolean retVal = false;
		try {
			/*
			 * //To Fetch the Email from Popup String givenMail=getAttribute(cbr.getEmail(),
			 * "value"); //Reports.//Reportstep("Entered mobile no: "+givenMail, "INFO");
			 */

			// To Fetch the Mobile No from Popup

			String givenNo = getAttribute(cbr.getPhonenumber(), "value");
			String mobileNoPresentFirst = givenNo.split(" ")[1];
			String mobileNoPresentSecond = givenNo.split(" ")[2];
			String mobileNoPresent = mobileNoPresentFirst + mobileNoPresentSecond;
			// Reports.//Reportstep("Entered mobile no: "+mobileNoPresent, "INFO");
			// Fetches the mobile number from CBR popup
			// Validates whether both the mobile nos are same
			if (compareTwoStrings(mobileNoPresent, username)) {
				clickAction(cbr.getcBrSubmitButton());

				if (driver.findElements(By.xpath("//button[@class='btn btn-link no-padding']")).size() > 0) {
					clickAction(cbr.getKeepBrowsing());
				}
				retVal = packageVacationLogoValidation();
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating the details of CBR Popup",
			// "FAIL");

		}
		return retVal;
	}

	public void urlNavigation(String page) {
		if (page.contentEquals("packages")) {
			packagesUrl = sUrl + "/packages";
			driver.navigate().to(packagesUrl);
		} else if (page.contentEquals("vacations")) {
			vacationsUrl = sUrl + "/vacations/australia";
			driver.navigate().to(vacationsUrl);
		}
	}

	public boolean costPDGItinerary() {
		Boolean actionResult = false;
		try {
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			cp = PageFactory.initElements(driver, CustomizePage.class);
			clickAction(pdgtreco.getCreateItinerary());
			// System.out.println("Clicked create itinerary");
			clickAction(pdgtreco.getPDGLocation());
			clickAction(pdgtreco.getMonth());
			clickAction(pdgtreco.getDuration());
			clickAction(pdgtreco.getPreference());
			// clickAction(pdgtreco.confirmFinalChoices());
			// Thread.sleep(2000);
			// clickAction(pdgtreco.goToCombos());
			// clickAction(pdgtreco.getComboPackage());
			clickAction(pdgtreco.getPYTItn());
			waitForMe(pdgtreco.getPDGGotIt());
			clickAction(pdgtreco.getPDGGotIt());
			clickAction(pdgtreco.getTripCost());
			actionResult = true;
		} catch (Exception ex) {
			System.out.println("Problem while logging");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean fillMandatoryInfoInGCM() {
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		boolean result = false;
		try {

			clickAction(icm.getDepartingCity());
			clickAction(icm.getdepartingOutsideindia());
			Thread.sleep(1000);
			clickAction(icm.getArrivalOn());
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			icm.getArrivalOn().sendKeys(Keys.BACK_SPACE);
			// icm.getArrivalOn().clear();
			Thread.sleep(1000);
			icm.getArrivalOn().sendKeys("28/Oct/2020");
			Thread.sleep(2000);
			icm.getArrivalOn().sendKeys(Keys.TAB);
			// New GCM changes
			// clickAction(icm.getNavigateDatePicker());
			// Thread.sleep(2000);
			// clickAction(icm.getDepartingOnCitydate20());
			// Thread.sleep(1000);
			clickAction(icm.getTravellingPassengersType());
			clickAction(icm.getGetCostContinue());

			/*
			 * gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			 * 
			 * 
			 * clickAction(gcm.goToDepartureSelection());
			 * clickAction(gcm.getdepartureCity()); clickAction(gcm.getDepartureDate());
			 * if(driver.findElements(By.xpath("//div[@class='react-datepicker']/button")).
			 * size()>1) { clickAction(gcm.goToNextMonth()); } else {
			 * clickAction(gcm.goToNextMonth1()); } clickAction(gcm.chooseDepartureDate());
			 */
			result = true;
		} catch (Exception ex) {
			// System.err.println("ERROR : Unable to fill details");
			ex.printStackTrace();
		}
		return result;
	}

	public boolean cbrValidationPDG() {
		boolean retVal = false;
		try {
			cbr = PageFactory.initElements(driver, Cbrpage.class);

			if (costPDGItineraryWithoutLogin()) {
				Thread.sleep(7000);
				scrolltoElement(cbr.getItineraryTravelCons());
				clickAction(cbr.getItineraryTravelCons());
				enterCBRFields();
				clickAction(cbr.getcBrSubmitButton());
				retVal = packageVacationLogoValidation();
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR through PDG flow",
			// "FAIL");

		}
		return retVal;
	}

	public boolean costPDGItineraryWithoutLogin() {
		Boolean actionResult = false;
		try {
			gcm = PageFactory.initElements(driver, GCMSignupPage.class);
			pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
			sp = PageFactory.initElements(driver, SignupPage.class);
			cp = PageFactory.initElements(driver, CustomizePage.class);
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(pdgtreco.getPDGLocation());
			clickAction(pdgtreco.getMonth());
			clickAction(pdgtreco.getDuration());
			clickAction(pdgtreco.getPreference());
			clickAction(pdgtreco.confirmFinalChoices());
			clickAction(pdgtreco.goToCombos());
			clickAction(pdgtreco.getComboPackage());
			Thread.sleep(3000);
			actionResult = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while costing an Itinerary without Login",
			// "FAIL");
			ex.printStackTrace();
		}
		return actionResult;
	}

	public boolean postCardIndia(String city) {
		boolean retVal = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);

		try {
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(ip.getCity());
			typeText(ip.getCity(), city);
			// Reports.//Reportstep("Postcard Page for \""+city+"\" is diplayed
			// correctly","PASS");
			typeText(postCard.getName(), cbrName);
			typeText(postCard.getEmail(), cbrMail);
			clickAction(postCard.getNotified());
			String thankYouText = getText(postCard.getThankYou());
			if (thankYouText.contains("Thank you")) {
				retVal = true;
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Postcard for Indian cities",
			// "FAIL");
		}

		return retVal;
	}

	public boolean noPostCard(String destination) {
		boolean retVal = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);

		try {
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(ip.getCity());
			typeText(ip.getCity(), destination);
			String availableOptions = getText(postCard.getNoPostcard());
			Thread.sleep(3000);
			if (compareTwoStrings(availableOptions, destination)) {
				retVal = true;
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Postcard for Indian cities",
			// "FAIL");
		}

		return retVal;
	}

	public boolean postCardUnsupportedDest(String unsupportedDest) {
		boolean retVal = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);

		try {
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(ip.getCity());
			typeText(ip.getCity(), unsupportedDest);
			clickAction(postCard.getUnwrappedDest());

			selectDropDownUsingVisibleText(postCard.getAdults(), "4 adults");
			selectDropDownUsingValue(postCard.getDepartureCity(), "Mumbai");
			selectDropDownUsingValue(postCard.getDestinationDropdown(), "Others");
			selectDropDownUsingValue(postCard.getDate(), "August");
			selectDropDownUsingVisibleText(postCard.getBudget(), "₹60000 - 75000");

			typeText(postCard.getName(), cbrName);
			typeText(postCard.getEmail(), cbrMail);
			typeText(postCard.getMobile(), cbrMobile);
			clickAction(postCard.getPlanThisTripButton());
			if (elementExist(postCard.getCheers())) {
				retVal = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Postcard for Unsupported
			// Destinations", "FAIL");

		}

		return retVal;
	}

	public boolean cbrValidationAfterGCM(String page) {
		boolean retVal = false;
		cbr = PageFactory.initElements(driver, Cbrpage.class);
		gcm = PageFactory.initElements(driver, GCMSignupPage.class);
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		intpag = PageFactory.initElements(driver, IternaryPage.class);

		try {
			clickAction(cbr.getPytLogo());
			if (costPDGItinerary()) {
				if (fillMandatoryInfoInGCM()) {
					clickAction(gcm.doGetCost());
					Thread.sleep(4000);
					waitForMe(pdgtreco.waitForCosting());

					if (page.equalsIgnoreCase("itinerary")) {
						clickAction(intpag.getItineraryPage());
						scroll();
						scrolltoElement(cbr.getItineraryTravelCons());
						clickAction(cbr.getItineraryTravelCons());
					} else if (page.equalsIgnoreCase("inclusions")) {
						scroll();
						scrolltoElement(cbr.getTravelConsultant());
						clickAction(cbr.getTravelConsultant());
					}
					retVal = cbrPopUpValidationAfterLogin();
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating CBR in Itinerary/Inclusions
			// page", "FAIL");

		}
		return retVal;
	}

	public boolean postCardFieldValidationIndia(String name, String mail) {
		boolean retVal = false;
		String invalidName = "";
		String invalidMail = "";
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);
		String regexName = "^[a-zA-Z0-9]+$";
		Pattern patternName = Pattern.compile(regexName);
		String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern patternEmail = Pattern.compile(regexEmail);
		Matcher matcherName = patternName.matcher(name);
		Matcher matcherEmail = patternEmail.matcher(mail);

		try {
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(ip.getCity());
			typeText(ip.getCity(), "Chennai");
			if (matcherName.matches() && matcherEmail.matches()) {
				clickAction(postCard.getName(), name);
				typeText(postCard.getName(), name);
				clickAction(postCard.getEmail(), mail);
				typeText(postCard.getEmail(), mail);
				clickAction(postCard.getNotified());
				String thankYouText = getText(postCard.getThankYou());
				if (thankYouText.contains("Thank you")) {
					retVal = true;
				}

			} else {
				clickAction(postCard.getName(), name);
				typeText(postCard.getName(), name);
				clickAction(postCard.getEmail(), mail);
				typeText(postCard.getEmail(), mail);
				clickAction(postCard.getNotified());
				if (driver
						.findElements(
								By.xpath("//span[contains(text(),'Name must be at least 3 characters in length')]"))
						.size() > 0) {
					invalidName = getText(postCard.getIncorrectName());
				}
				if (driver.findElements(By.xpath("//span[contains(text(),'Enter a valid email address')]"))
						.size() > 0) {
					invalidMail = getText(postCard.getIncorrectMail());
				}

				if (invalidName != null && invalidMail != null) {
					// Reports.//Reportstep("Error in Name and Mail field:
					// "+invalidName+","+invalidMail, "PASS");
					retVal = true;
				} else if (invalidName != null) {
					// Reports.//Reportstep("Error in Name field: "+invalidName, "PASS");
					retVal = true;
				} else if (invalidMail != null) {
					// Reports.//Reportstep("Error in Mail field: "+invalidMail, "PASS");
					retVal = true;
				}

			}

			/*
			 * 
			 * if(driver.findElements(By.
			 * xpath("//p[@class='mbottom-large color-grey-secondary medium-heading text-center']"
			 * )).size()>0) { String thankYouText= getText(postCard.getThankYou());
			 * if(thankYouText.contains("Thank you")) { retVal=true; } } else {
			 * retVal=false; }
			 */
		} catch (Exception ex) {
			// Reports.//Reportstep("Postcard Fields validation for Indian city \"Chennai\"
			// failed", "FAIL");
		}

		return retVal;
	}

	public boolean postCardFieldsUnsupportedDest(String name, String mail, String mob, String month) {
		boolean retVal = false;
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		ip = PageFactory.initElements(driver, InterestPage.class);
		postCard = PageFactory.initElements(driver, PostcardPage.class);
		try {
			clickAction(pdgtreco.getCreateItinerary());
			clickAction(ip.getCity());
			typeText(ip.getCity(), "Srilanka");
			clickAction(postCard.getUnwrappedDest());

			selectDropDownUsingVisibleText(postCard.getAdults(), "4 adults");
			selectDropDownUsingVisibleText(postCard.getDepartureCity(), "Chennai");
			selectDropDownUsingValue(postCard.getDate(), month);
			selectDropDownUsingVisibleText(postCard.getBudget(), "₹60000 - 75000");

			typeText(postCard.getName(), name);
			typeText(postCard.getEmail(), mail);
			typeText(postCard.getMobile(), mob);
			clickAction(postCard.getPlanThisTripButton());
			if (driver.findElements(By.xpath("//span[@class='postcard_cheers vmargin-large']")).size() > 0) {
				retVal = true;
			} else {
				if (month == null || name == null || mail == null || mob == null || mob.length() != 10) {
					if (driver.findElements(By.xpath("//div[@class='form-group form-group-lg has-error']"))
							.size() > 0) {
						retVal = true;
					}
				}
				/*
				 * else if(mob.length()!=10) { if (driver.findElements(By.
				 * xpath("//div[@class='form-group form-group-lg has-error']")).size()>0) {
				 * retVal=true; } }
				 */
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Postcard Fields validation for Unsupported Destination
			// \"Srilanka\" failed", "FAIL");

		}
		return retVal;
	}

	// Entering Passenger details after costing the itinerary
	public boolean validatePassengerDetails() {
		pdgtreco = PageFactory.initElements(driver, PDGEurTrendingCombos.class);
		psp = PageFactory.initElements(driver, PassengerDetailsPage.class);
		boolean retVal = false;
		try {
			// waitForMe(pdgtreco.waitForCosting());
			// clickAction(pdgtreco.waitForCosting());

			List<WebElement> salutations = driver.findElements(By.xpath("//button[text()='Mr.']"));
			List<WebElement> vegMeals = driver.findElements(By.xpath("//i[@class='veg-icon veg']"));

			for (int i = 0; i < 6; i++) {
				List<WebElement> adults = driver.findElements(
						By.xpath("//form[@id='booking-travellers']//div[contains(@class,'passenger-form-row')]"));
				// System.out.println("No Of Rooms : "+ adults.size());

				for (int j = 0; j < adults.size(); j++) {
					// System.out.println("((//input[@name='salutation_"+i+"_"+j+"'])//following::i)[1]");

					waitForMe(salutations.get(j));

					clickJavaScriptElement(salutations.get(j));

					// Clicking on salutation
					// salutations.get(j).click();

					if (driver.findElements(By.xpath("//input[@name='firstName_" + i + "_" + j + "']")).size() > 0) {
						// WebElement salution= driver.findElement(By.xpath("//button[text()='Mr.']"));
						WebElement firstName = driver
								.findElement(By.xpath("//input[@name='firstName_" + i + "_" + j + "']"));
						WebElement lastName = driver
								.findElement(By.xpath("//input[@name='lastName_" + i + "_" + j + "']"));
						WebElement passportNumber = driver
								.findElement(By.xpath("//input[@name='passportNumber_" + i + "_" + j + "']"));
						WebElement passportExpDate = driver
								.findElement(By.xpath("//input[@name='passportExpirationDate_" + i + "_" + j + "']"));
						WebElement dateOfBirth = driver
								.findElement(By.xpath("//input[@name='birthDay_" + i + "_" + j + "']"));

						typeText(firstName, "Testing");
						Thread.sleep(1000);

						typeText(lastName, "pass");
						Thread.sleep(1000);

						passportTempNum = generateNumber();
						passportNum = Integer.toString(passportTempNum);
						typeText(passportNumber, passportNum);
						Thread.sleep(2000);

						typeText(passportExpDate, "12/12/2021");
						Thread.sleep(1000);

						typeText(dateOfBirth, "12/12/1997");
						Thread.sleep(1000);

						// Extra three fields are added in passenger details page 

						if (driver.findElements(By.xpath("//input[@name='passportIssueDate_" + i + "_" + j + "']")).size() > 0) {

							WebElement passportIssueDate = driver
									.findElement(By.xpath("//input[@name='passportIssueDate_" + i + "_" + j + "']"));

							WebElement passportIssueCity = driver
									.findElement(By.xpath("//input[@name='passportIssueCity_" + i + "_" + j + "']"));

							WebElement passportIssueCountry = driver
									.findElement(By.xpath("//input[@name='passportIssueCountry_" + i + "_" + j + "']"));

							typeText(passportIssueDate, "12/12/2000");
							Thread.sleep(1000);

							typeText(passportIssueCity, "Chennai");
							Thread.sleep(1000);

							clickAction(driver.findElement(By.xpath("(//*[contains(text(),'Country')])["+(i+1)+"]")));
							Thread.sleep(2000);
							(driver.findElement(By.xpath("//*[contains(@id,'option-0')]"))).click();
							Thread.sleep(1000);
						}
						else {
							System.out.println("There are no fields like passportIssueDate, PassportIssueCity,PassportIssueCountry");
						}

						// Clicking on Veg Meal
						vegMeals.get(j).click();

					} else {
						break;
					}
				}
				break;
			}
			clickAction(psp.getreviewLiveCost());
			//			Thread.sleep(6000);


			if (elementDisplayed(booingReview.getReviewCost())) {
				// Reports.//Reportstep("Passenger Details Validated Sucessfully", "PASS");
				retVal = true;
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Unable to Enter passenger details","FAIL");
			ex.printStackTrace();
		}
		return retVal;
	}

	// Generating Random number for Passport
	public int generateNumber() {
		try {
			Random rand = new Random();
			randomNumber = rand.nextInt(90000000) + 1000000;
			int length = String.valueOf(randomNumber).length();
			if (length == 8) {
				return randomNumber;
			} else {
				randomNumber = rand.nextInt(90000000) + 1000000;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while generating Passport Number", "INFO");
		}
		return randomNumber;
	}

	/*
	 * Created Date : 10-09-2019 Author : R.Sharmila Description : Validating the
	 * testimonial cards in landing page,Packages Page and Vacations Page Modified
	 * By : Modified Date: Description on Modification :
	 */

	public boolean TestimonialsOnLandingPage() {
		Boolean retVal = false;
		String testimonialText = "";
		String testimonialUrl = "";
		try {

			Thread.sleep(4000);

			List<WebElement> testimonialList = new ArrayList<WebElement>();
			testimonialList = testimonials.gettestimonialsOfLanding();
			testimonials.gettestimonialsOfLanding();
			System.out.println("Testimonial List :" + testimonialList);
			for (WebElement testimonial : testimonialList) {
				testimonialUrl = testimonial.getAttribute("href");
				Thread.sleep(1000);
				clickAction(testimonial);
				testimonialText = getText(testimonial);

				String window = switchWindows();
				// String currentUrl = getCurrentUrl();
				if (getCurrentUrl().equals(testimonialUrl)) {
					retVal = true;
					// Reports.//Reportstep("Successfully validated the Testimonial:
					// "+testimonialText, "PASS");

				}

				closeSwittchParentWindow(window);

			}
		}

		catch (Exception ex) {
			// Reports.//Reportstep("Problem in validating Testimonials in Landing Page ",
			// "FAIL");
		}

		return retVal;
	}

	public boolean TestimonialsOnVacationsPage() throws Exception {
		Boolean retVal = false;
		String testimonialText = null;
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		driver.navigate().to(currentUrl + "vacations/australia");

		try {
			Thread.sleep(3000);
			// testimonials = PageFactory.initElements(driver, TestimonialsPage.class);
			for (WebElement testimonial : testimonials.gettestimonialsOfVacations()) {

				Thread.sleep(1000);
				scrollToView(testimonial);
				testimonialText = getText(testimonial);
				clickAction(testimonial);
				currentUrl = getCurrentUrl();
				if (currentUrl.contains("get-cost")) {
					retVal = true;
					// Reports.//Reportstep("Successfully validated the Testimonial:
					// "+testimonialText, "PASS");
				}

				clickAction(testimonials.getCostCloseBtn());

			}
		}

		catch (Exception ex) {
			// Reports.//Reportstep("Problem in validating Testimonials in Vacations Page ",
			// "FAIL");
		}

		return retVal;
	}

	public boolean TestimonialsOnPackagesPage() throws Exception {
		Boolean retVal = false;
		String testimonialText = "";
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		driver.navigate().to(currentUrl + "packages");
		try {
			// testimonials = PageFactory.initElements(driver, TestimonialsPage.class);
			for (WebElement testimonial : testimonials.gettestimonialsOfPackages()) {
				Thread.sleep(1000);
				if (elementDisplayed(testimonial)) {
					scrolltoElement(testimonial);
				}
				// Coordinates coordinate = ((Locatable)testimonial).getCoordinates();
				// coordinate.inViewPort();
				testimonialText = getText(testimonial);
				if (elementDisplayed(testimonial)) {
					clickAction(testimonial);
				}
				String testimonialUrl = testimonial.getAttribute("href");
				String window = switchWindows();
				currentUrl = getCurrentUrl();
				if (currentUrl.equals(testimonialUrl)) {
					retVal = true;
					// Reports.//Reportstep("Successfully validated the Testimonial:
					// "+testimonialText, "PASS");
				}

				closeSwittchParentWindow(window);

			}
		}

		catch (Exception ex) {
			// Reports.//Reportstep("Problem in validating Testimonials in Packages Page ",
			// "FAIL");
		}

		return retVal;
	}

	public boolean testimonialFilterValidation(String tripData) {
		boolean retVal = false;
		testimonials = PageFactory.initElements(driver, TestimonialsPage.class);

		try {
			addDestinations();

			clickAction(testimonials.getTestimonial());
			clickAction(testimonials.getTestimonialDropdown());
			clickAction(driver.findElement(By.xpath("//span[contains(text(),'" + tripData + "')]")));
			regionFilter = driver.findElements(By.xpath("//input[@name='regionFilter']/../span"));
			for (WebElement eachRegion : regionFilter) {
				clickAction(testimonials.getTestimonialRegionDropdown());

				regionText = getText(eachRegion);
				// System.out.println("Region Text: "+regionText);

				clickActionFailure(eachRegion);
				Thread.sleep(2000);

				if (!(regionText.contentEquals("All Destinations"))) {
					if (driver.findElements(By.xpath("//h3[@class='color-base dim']")).size() > 0) {
						travellerData = getText(testimonials.getTravelledRegion());
						// System.out.println("Traveller Data: "+travellerData);
						// System.out.println("Trip Data: "+tripData);

						if (travellerData.contains(regionText)) {
							// Reports.//Reportstep("Testimonial for "+tripData+" trip for "+regionText+"
							// was found", "PASS");
							retVal = true;
						} else {
							// System.out.println("Region Text "+regionText);
							if (regionText.equalsIgnoreCase("south east asia")) {
								retVal = travellerValidation(tripData, southEastAsia);

								// retVal=travellerValidation(tripData,"Bali");

							} else if (regionText.equalsIgnoreCase("australia & new zealand")) {
								retVal = travellerValidation(tripData, ausNewzealand);
								// retVal=travellerValidation(tripData,"Australia");
							} else if (regionText.equalsIgnoreCase("africa")) {
								retVal = travellerValidation(tripData, africa);
								// retVal=travellerValidation(tripData,"Africa");

							} else if (regionText.equalsIgnoreCase("island destinations")) {
								retVal = travellerValidation(tripData, islandDestinations);
								// retVal=travellerValidation(tripData,"Maldives");

							}

						}
					} else {
						// Reports.//Reportstep("Testimonial for "+tripData+" trip for "+regionText+"
						// was not found", "PASS");
						retVal = true;
					}

				} else if (regionText.contentEquals("All Destinations")) {
					if (driver.findElements(By.xpath("//h3[@class='color-base dim']")).size() > 1) {
						retVal = travellerValidation(tripData, allDestinations);
					} else {
						// Reports.//Reportstep("Testimonial for "+tripData+" trip for "+regionText+"
						// was not found", "PASS");
						retVal = true;
					}
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Testimonial Filter with
			// different Themes and Regions", "FAIL");
		}

		return retVal;
	}

	public void addDestinations() {
		europe.add("Europe");
		// System.out.println(europe);
		southEastAsia.add("Bali");
		// System.out.println(southEastAsia);
		ausNewzealand.add("Australia");
		ausNewzealand.add("New Zealand");
		// System.out.println(ausNewzealand);
		africa.add("South Africa");
		// System.out.println(africa);
		islandDestinations.add("Maldives");
		islandDestinations.add("Dubai");
		// System.out.println(islandDestinations);
		allDestinations = Stream.of(europe, southEastAsia, ausNewzealand, africa, islandDestinations)
				.flatMap(x -> x.stream()).collect(Collectors.toList());
		// System.out.println(allDestinations);

	}

	public boolean travellerValidation(String tripData, List<String> givenRegion) {
		boolean retVal = false;
		int item = 0;
		try {
			for (String eachRegion : givenRegion) {
				item++;
				if (travellerData.contains(eachRegion)) {
					// System.out.println("each Region:"+eachRegion);
					// System.out.println("traveller:"+travellerData.toLowerCase());
					// Reports.//Reportstep("Testimonial for "+tripData+" trip for "+regionText+"
					// was found", "PASS");
					retVal = true;
					break;
				} else if (!(travellerData.contains(eachRegion))) {
					if (item >= givenRegion.size()) {
						System.out.println("each Region:" + eachRegion);
						System.out.println("traveller:" + travellerData);
						// Reports.//Reportstep("Mismatch in Testimonial for "+tripData+" trip for
						// "+regionText, "FAIL");
						retVal = false;
					}

				}
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Traveller data for
			// "+tripData+" for "+regionText, "FAIL");
		}
		return retVal;
	}

	public boolean testimonialResetFilterValidation(String tripData) {
		boolean retVal = false;
		testimonials = PageFactory.initElements(driver, TestimonialsPage.class);

		try {
			clickAction(testimonials.getTestimonial());
			clickAction(testimonials.getTestimonialDropdown());
			clickAction(driver.findElement(By.xpath("//span[contains(text(),'" + tripData + "')]")));
			regionFilter = driver.findElements(By.xpath("//input[@name='regionFilter']/../span"));
			for (WebElement eachRegion : regionFilter) {
				clickAction(testimonials.getTestimonialRegionDropdown());

				regionText = getText(eachRegion);
				// System.out.println("Region Text: "+regionText);

				clickActionFailure(eachRegion);
				Thread.sleep(2000);

				// Clicking the Reset filter
				clickAction(testimonials.getTestimonialResetFilter());

				if (verifyPartialText(testimonials.getTestimonialDropdown(), "All trips")) {
					retVal = true;
					// Reports.//Reportstep("Successfully validated the Testimonials Reset Filter
					// for: "+tripData, "PASS");
					break;
				}

			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Testimonials Reset Filter for:
			// "+tripData, "FAIL");

		}

		return retVal;
	}

	public boolean testimonialRatingRecentFilterValidation(String tripData) {

		boolean retVal = false;
		testimonials = PageFactory.initElements(driver, TestimonialsPage.class);

		try {
			clickAction(testimonials.getTestimonial());
			clickAction(testimonials.getTestimonialDropdown());
			clickAction(driver.findElement(By.xpath("//span[contains(text(),'" + tripData + "')]")));
			regionFilter = driver.findElements(By.xpath("//input[@name='regionFilter']/../span"));
			for (WebElement eachRegion : regionFilter) {
				clickAction(testimonials.getTestimonialRegionDropdown());

				regionText = getText(eachRegion);

				clickActionFailure(eachRegion);
				Thread.sleep(2000);

				ratingRecentFilter = driver.findElements(By.xpath("//input[@name='sort']/../span"));

				for (WebElement eachSortFilter : ratingRecentFilter) {
					// Clicking the Rating filter
					clickAction(testimonials.getTestimonialRatingRecentFilter());
					sortFilterText = getText(eachSortFilter);
					clickActionFailure(eachSortFilter);
					Thread.sleep(2000);
					// Reports.//Reportstep("Selected the "+sortFilterText+" filter", "PASS");
					retVal = true;
				}
				break;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Testimonials Recent/Rating
			// Filter for: "+tripData, "FAIL");

		}
		return retVal;

	}

	// The below 4 methods are for validation of "Your Vacations" Page

	// This method is to validate the renaming itinerary feature from Saved
	// itineraries under your vacations page
	public boolean validateSavedItinerary() {
		boolean retVal = false;
		yourVacation = PageFactory.initElements(driver, YourVacationsPage.class);
		try {
			scrolltoElement(yourVacation.getSavedItinerary());
			clickAction(yourVacation.getSavedItinerary());
			String beforeRename = getText(yourVacation.getBeforeRename());
			clickAction(yourVacation.getRenameItineraryEditIcon());
			itineraryRandomNumber = generateNumber();
			typeText(yourVacation.getTextBoxRenameItinerary(), "Testing Renaming itinerary " + itineraryRandomNumber);
			clickAction(yourVacation.getSubmitButtonRenameItinerary());
			String afterRename = getText(yourVacation.getBeforeRename());

			if (beforeRename != afterRename) {
				// System.out.println("Renamed successfully");
				// Reports.//Reportstep("Itinerary renamed successfully", "PASS");
				retVal = true;
			} else {
				// System.out.println("Renamed failed");
				// Reports.//Reportstep("Problem with renaming Itinerary ", "FAIL");
			}

		} catch (Exception ex) {
			// Reports.//Reportstep("Problem with renaming the itinerary", "FAIL");
		}
		return retVal;

	}

	// This method will delete an itinerary from saved itineraries under your
	// vacations page
	public boolean validateDeleteItinerary() {
		boolean retVal = false;
		yourVacation = PageFactory.initElements(driver, YourVacationsPage.class);
		try {
			scrolltoElement(yourVacation.getSavedItinerary());
			clickAction(yourVacation.getSavedItinerary());
			clickAction(yourVacation.getDeleteItinerary());
			clickAction(yourVacation.getDeleteItineraryDropDown());
			// Reports.//Reportstep("Itinerary Deleted successfully", "PASS");
			retVal = true;
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem with renaming the itinerary", "FAIL");
		}
		return retVal;
	}

	// Validating an Booked Itinerary under "Your Vacations" Page
	public boolean validateBookedItinerary() {
		boolean retVal = false;
		yourVacation = PageFactory.initElements(driver, YourVacationsPage.class);
		psp = PageFactory.initElements(driver, PassengerDetailsPage.class);
		try {
			clickAction(yourVacation.getBookedItinerary());
			switchWindows();
			clickAction(yourVacation.getViewBookedItinerary());
			if (verifyEnabled(psp.getBookYourTrip())) {
				// Reports.//Reportstep(" In booked itinerary BookThisTrip button is enabled ",
				// "FAIL");
			} else {
				// Reports.//Reportstep(" In booked itinerary BookThisTrip button is Disabled ",
				// "PASS");
				retVal = true;
			}
		} catch (Exception ex) {
			// Reports.//Reportstep(" Problem with validating itinerary", "FAIL");
		}
		return retVal;
	}

	// This method validate the stale costing scenario from saved itinerary under
	// your vacations page
	public boolean validateUpdateCost() {
		boolean retVal = false;
		yourVacation = PageFactory.initElements(driver, YourVacationsPage.class);
		psp = PageFactory.initElements(driver, PassengerDetailsPage.class);
		try {
			scrolltoElement(yourVacation.getSavedItinerary());
			clickAction(yourVacation.getSavedItinerary());
			clickAction(yourVacation.getSavedItineraryCard());
			switchWindows();
			// Open saved itinerary and verify if the itinerary contains "Update cost"
			// button will update the cost or else it will just verify the presents of
			// "BookThisTrip" button
			if (driver.findElements(By.xpath("//button[@id='update-cost-btn']")).size() > 0) {
				clickAction(yourVacation.getUpdateCostButton());
				waitForMe(psp.getBookYourTrip());
				verifyEnabled(psp.getBookYourTrip());
				// Reports.//Reportstep( "Updated the cost of the itinerary in saved itinerary
				// under yourvacation page ", "INFO");
				retVal = true;
			} else {
				if (driver.findElements(By.xpath("//button[contains(@class,'tracker-boookyourtrip btn btn-primary')]"))
						.size() > 0) {
					// Reports.//Reportstep( " Not a stale costed itinerary ", "INFO");
					retVal = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while updating the costing", "FAIL");
		}
		return retVal;

	}

	public boolean yourAccountEditDetailsValidation() {

		boolean retVal = false;

		ac = PageFactory.initElements(driver, YourAccountPage.class);
		lp = PageFactory.initElements(driver, LoginPage.class);

		try {

			clickAction(ac.getUserInitials());

			clickAction(ac.getYourAccount());

			clickAction(ac.getEditDetails());

			clickAction(ac.getNameDetails());

			typeText(ac.getNameDetails(), changeName);

			typeText(ac.getAddressLine1(), address1);

			typeText(ac.getAddressLine2(), address2);

			typeText(ac.getAddressLine3(), address3);

			typeText(ac.getState(), state);

			typeText(ac.getPincode(), pincode);

			clickAction(ac.getUpdate());

			clickAction(ac.getSubmit());

			clickAction(ac.getUserInitials());

			String ChangedName = getText(
					(driver.findElement(By.xpath("//span[contains(text(),'" + changeName + "')]"))));

			if (ChangedName.equalsIgnoreCase(changeName)) {
				retVal = true;
				// Reports.//Reportstep("Successfully validated the name field in youraccount
				// page: ", "PASS");

			}

		} catch (Exception ex) {

			// Reports.//Reportstep("Problem in validating the name field in youraccount
			// Page ", "FAIL");

		}
		return retVal;

	}

	public boolean yourAccountPreferencesValidation() {

		boolean retVal = false;
		ac = PageFactory.initElements(driver, YourAccountPage.class);

		try {

			clickAction(ac.getUserInitials());

			clickAction(ac.getYourAccount());

			clickAction(ac.getPreferences());

			for (WebElement checkbox : ac.getCheckboxList()) {

				clickAction(checkbox);

			}
			clickAction(ac.getSaveButton());
			clickAction(ac.getResetOptions());
			clickAction(ac.getSaveButton());

		}

		catch (Exception ex) {

			// Reports.//Reportstep("Problem in validating the preferences ", "FAIL");

		}

		return retVal;
	}

	public boolean YourAccountChangePassword() {

		boolean retVal = false;
		ac = PageFactory.initElements(driver, YourAccountPage.class);

		try {
			clickAction(ac.getUserInitials());

			clickAction(ac.getYourAccount());

			clickAction(ac.getChangePassword());

		}

		catch (Exception ex) {

			// Reports.//Reportstep("Problem in validating the preferences ", "FAIL");

		}

		return retVal;
	}

	public boolean validateCostPassengerDetails() {
		boolean retVal = false;
		try {
			// forceClick(icm.getDepartingCity());
			clickAction(icm.getDepartingCity());
			Thread.sleep(1000);
			clickAction(icm.getdepartingFromChennai());
			Thread.sleep(1000);
			// clickAction(icm.getArrivalOn());

			clickAction(icm.getDatePicker());
			Thread.sleep(1000);
			clickAction(icm.getDepartingOnCitydate20());
			// if (elementDisplayed(icm.getFirstName()))
			if ((driver.findElements(By.xpath("//input[@placeholder = 'Your name']"))).size() > 0) {
				typeText(icm.getFirstName(), cbrName);
				typeText(icm.getUserEmail(), cbrMail);
				typeText(icm.getPhoneNumber(), cbrMobile);
			}

			clickAction(icm.getcalculateTripCostButton());

			// Validating Account Exists page and entering the password to login
			// if (elementDisplayed(icm.getPasssword()))
			if ((driver.findElements(By.xpath("//input[@placeholder = 'Password']"))).size() > 0) {
				typeText(icm.getPasssword(), pass);
				clickAction(icm.getLogin());
				// Thread.sleep(4000);
				if (driver.findElements(By.xpath("//span[text()='Inclusions']")).size() > 0) {
					// Reports.//Reportstep("Costed the Itinerary successfully", "PASS");
					if (validatePassengerDetails()) {
						retVal = true;
					}
				}
			} else {
				if (waitForMe(icm.getCostingDelay()) != null) {
					// Reports.//Reportstep("Costed the Itinerary successfully", "PASS");
					// if(validatePassengerDetails())
					// {
					// retVal=true;
					// }
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while Costing and Validating the Passenger
			// details", "FAIL");
		}
		return retVal;
	}

	// This method is to validate itineraries by costing and entering passenger
	// details.
	// noOfVacations variable is set in the Configuration file i.e. no. of
	// itineraries to validate in the vacations page

	public boolean validateVacationItineraries(int noOfVacations) {
		boolean retVal = false;
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		int countOnvacations = 0;
		try {
			allVacations = driver.findElements(By.xpath("//div[@class='middle-col']"));
			// System.out.println(noOfVacations);
			for (int i = 0; i < noOfVacations; i++) {
				allVacations = driver.findElements(By.xpath("//div[@class='middle-col']"));
				clickAction(allVacations.get(i));
				// Reports.//Reportstep("Itinerary URL: "+driver.getCurrentUrl(), "PASS");
				Thread.sleep(2000);
				if (validateCostPassengerDetails()) {
					countOnvacations++;
				}
				if (countOnvacations == noOfVacations) {
					retVal = true;
					break;
				} else {
					// navigateToUrl(VacationsPageValidation.vacationsUrl);

				}

			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating Vacation Itineraries","FAIL");
		}
		return retVal;
	}

	public boolean validateCost() {
		boolean retVal = false;
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		packagesPage = PageFactory.initElements(driver, PackagesPage.class);
		try {
			clickAction(icm.getDepartingCity());
			clickAction(icm.getdepartingOutsideindia());
			Thread.sleep(1000);
			clickAction(icm.getArrivalOn());
			Thread.sleep(2000);
			clickAction(icm.getDepartingOnCurrentDate());
			// if (elementDisplayed(icm.getFirstName()))
			if ((driver.findElements(By.xpath("//input[@placeholder = 'Your name']"))).size() > 0) {
				typeText(icm.getFirstName(), cbrName);
				typeText(icm.getUserEmail(), cbrMail);
				typeText(icm.getPhoneNumber(), cbrMobile);
			}

			clickAction(packagesPage.getPackageGetCost());

			// Validating Account Exists page and entering the password to login
			// if (elementDisplayed(icm.getPasssword()))
			if ((driver.findElements(By.xpath("//input[@placeholder = 'Password']"))).size() > 0) {
				typeText(icm.getPasssword(), pass);
				clickAction(icm.getLogin());
				if (waitForMe(icm.getCostingDelay()) != null) {
					// Reports.//Reportstep("Costed the Itinerary successfully", "PASS");
					retVal = true;
				}
			} else {
				if (waitForMe(icm.getCostingDelay()) != null) {
					// Reports.//Reportstep("Costed the Itinerary successfully", "PASS");
					retVal = true;
				}
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while Costing and Validating the Passenger
			// details", "FAIL");
		}
		return retVal;
	}

	public boolean validateSlugItinerary(String dest, String theme) {
		boolean retVal = false;
		icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		try {
			scrollToReserveSlot();
			allSlugIntineraries = driver.findElements(By.xpath("//span[@itemprop='name']"));
			int iteration = packageItineraries;
			int run = 0;
			if (iteration == 100) {
				run = allSlugIntineraries.size();
			} else {
				run = iteration;
			}
			// allSlugIntineraries=driver.findElements(By.xpath("//span[@itemprop='name']"));
			if (allSlugIntineraries.size() > 0) {
				for (WebElement eachSlugIntinerary : allSlugIntineraries) {
					clickAction(eachSlugIntinerary);
					waitForMe(icm.getTripCostButton());
					clickAction(icm.getTripCostButton());
					if (validateCost()) {
						String curUrl = driver.getCurrentUrl();
						if (compareTwoStringsPartially(curUrl, "inclusions")) {
							retVal = true;
							// Reports.//Reportstep("Successfully validated "+eachSlugIntinerary+" Itinerary
							// for "+dest+" with "+theme, "PASS");
						}
						// navigateToDiffUrlPackages(packagesPageEnv);
						// navigateToUrl(PackagesPageValidation.destUrl);

					}

				}
				// Reports.//Reportstep("Successfully validated "+run+" Itineraries for "+dest+"
				// with "+theme, "PASS");
			} else {
				// Reports.//Reportstep("There are No Itineraries for "+dest+" with "+theme,
				// "PASS");
			}
		} catch (Exception ex) {
			// Reports.//Reportstep("Problem while validating the Itineraries for "+dest+"
			// with "+theme, "FAIL");
		}

		return retVal;

	}

	// Pop Up Closure
	public void popupClosure() {
		try {
			clickAction(ip.getgotItPopup(), "closing suggestion popup");
		}

		catch (Exception e) {
			System.out.println("No Popup to close !!");
		}
	}

	// Submitting the card info in payment page
	public void submitcardDetails() throws Exception {
		typeText(razorpaypage.getCardnumber(), "4111111111111111");
		typeText(razorpaypage.getCardExpiryDate(), "0725");
		typeText(razorpaypage.getCardcvv(), "123");
		typeText(razorpaypage.getCardHolderName(), "TestUser");
		clickAction(razorpaypage.getPaynowButton(), "User submits the card details");
	}
	/*
	 * Author : karthick Replacement of : validateCostPassengerDetails()
	 * Functionality : Navigates and complete the GCM Model Date Added : Date Last
	 * Modified : NA Modified By :
	 *
	 *
	 *
	 *
	 *
	 *
	 */

	public void navigateGcmFlow() throws Exception {
		// Thread.sleep(1000);
		scrolltoElement(icm.getcalculateTripCostButton());
		waitForMe(icm.getcalculateTripCostButton());
		clickAction(icm.getcalculateTripCostButton());
		fillMandatoryInfoInGCM();
	}

	public static void sendMail() {

		Properties prop;

		try {
			String systemType = System.getProperty("systemType");
			System.out.println("sys type :" + systemType);
			if (systemType == null) {
				systemType = "local";
				System.out.println("sys type :" + systemType);
			}
			prop = new Properties();
			if(systemType.equalsIgnoreCase("local")) {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configuration/config.properties")));
			}else {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/CucumerBddProject/configuration/config.properties")));
			}

			String env = System.getProperty("configEnv");
			String fromMail = prop.getProperty("fromMail");
			String toMail1 = prop.getProperty("toMail1");
			String toMail2 = prop.getProperty("toMail2");
			String toMail3 = prop.getProperty("toMail3");
			String ccMail1 = prop.getProperty("ccMail1");
			String ccMail2 = prop.getProperty("ccMail2");
			String sendGridKey = prop.getProperty("sendGridKey");

			// System.out.println(fromMail + toMail1);

			// if(!hooks.featureName.equalsIgnoreCase("url-validation")) {
			System.out.println("Sending Mail...");

			Mail mail = new Mail();
			Email fromEmail = new Email();
			fromEmail.setName("QA Team");
			fromEmail.setEmail(fromMail);
			mail.setFrom(fromEmail);
			mail.setSubject("Web Automation Report");
			Personalization personalization = new Personalization();

			// To List for Mail
			Email to = new Email();
			// to.setName("Marketing Team");
			to.setEmail(toMail1);
			personalization.addTo(to);
			to.setEmail(toMail2);
			personalization.addTo(to);
			to.setEmail(toMail3);
			personalization.addTo(to);

			// CC List for Mail
			Email cc = new Email();
			// cc.setName("CC User");
			cc.setEmail(ccMail1);
			personalization.addCc(cc);
			if (!systemType.equalsIgnoreCase("local")) {
				cc.setEmail(ccMail2);
				personalization.addCc(cc);
			}
			mail.addPersonalization(personalization);

			Content content = new Content();
			content.setType("text/html");
			content.setValue(generateUrl(env));
			mail.addContent(content);

			Attachments attachments = new Attachments();
			String attachmentString = "";
			if (systemType.equalsIgnoreCase("local")) {
				attachmentString = getAttachmentData(new File(System.getProperty("user.dir") + "/target/rerun.txt"));
			} else {
				attachmentString = getAttachmentData(
						new File(System.getProperty("user.dir") + "/CucumerBddProject/target/rerun.txt"));
			}
			attachments.setContent(attachmentString);
			attachments.setType("application/txt");// "application/pdf"
			attachments.setFilename("rerun.txt");
			attachments.setDisposition("attachment");
			attachments.setContentId("Banner");
			mail.addAttachments(attachments);

			SendGrid sg = new SendGrid(sendGridKey);
			sg.addRequestHeader("X-Mock", "true");
			Request request = new Request();
			try {
				request.setMethod(Method.POST);
				request.setEndpoint("mail/send");
				request.setBody(mail.build());
				Response response = sg.api(request);
				System.out.println(
						"Script has successfully completed its execution and mailed the report to the required stakeholders");
			} catch (IOException ex) {
				System.out.println("Problem while sending mail to the required stakeholders");
				ex.printStackTrace();
			}
			// }
			// else {
			// System.out.println("Automation Extent Report skipped for URL Validation");
			// }
		} catch (Exception ex) {
			System.out.println("Problem while loading the Properties file ");
			ex.printStackTrace();
		}
	}

	public boolean VisaValidationAdd() throws Exception {

		boolean retVal = false;
		visaPage = PageFactory.initElements(driver, VisaPage.class);

		try {
			clickAction(visaPage.getVisa_viewDetails());
			Thread.sleep(500);
			// clickAction(visaPage.getVisa_RemoveVisa());
			// VisaValidationRemove();
			clickAction(visaPage.getVisa_AddVisa());
			Thread.sleep(500);
			elementExist(visaPage.getVisa_RemoveVisa());
			retVal = true;

		}

		catch (Exception ex) {
			// Reports.//Reportstep("Problem while Costing and Validating the Passenger
			// details", "FAIL");
		}

		return retVal;
	}

	public boolean VisaValidationRemove() throws Exception {

		boolean retVal = false;
		visaPage = PageFactory.initElements(driver, VisaPage.class);

		try {
			Thread.sleep(500);
			clickAction(visaPage.getVisa_viewDetails());
			Thread.sleep(500);
			clickAction(visaPage.getVisa_AddVisa());
			Thread.sleep(500);
			clickAction(visaPage.getVisa_RemoveVisa());
			Thread.sleep(500);
			elementExist(visaPage.getVisa_AddVisa());
			retVal = true;

		}

		catch (Exception ex) {
			// Reports.//Reportstep("Problem while Costing and Validating the Passenger
			// details", "FAIL");
		}

		return retVal;
	}

	private static String getAttachmentData(File attachment) {
		if (attachment != null) {
			byte[] bytesArray = new byte[(int) attachment.length()];
			try {
				FileInputStream fis = new FileInputStream(attachment);
				fis.read(bytesArray);
				fis.close();
				return new Base64().encodeAsString(bytesArray);
			} catch (Exception e) {
				System.out.println("Unable to convert to byte stream " + e.getMessage());
				e.printStackTrace();
			}
		}
		return null;
	}

	public String attachHtml(File attachment) {
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(attachment));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}

		String content = contentBuilder.toString();
		return content;
	}

	public static String getTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH:mm");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	public static void renameFile() {

		try {

			// timeStamp = getTime();
			File oldFile = new File(
					System.getProperty("user.dir") + "/target/cucumber-reports/WebAutomationReport.html");
			File newFile = new File(System.getProperty("user.dir") + "/target/cucumber-reports/WebAutomationReport"
					+ timeStamp + ".html");

			System.out.println("Old File: " + oldFile);
			System.out.println("New File: " + newFile);
			try {
				// FileUtils.moveFile(oldFile, newFile);
				FileUtils.copyFile(oldFile, newFile);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void rentalCarFilterValidation(String expectedText) {
		try {
			getText(rentalCarPage.getRentalCarFilterValidation());
			verifyPartialText(rentalCarPage.getRentalCarFilterValidation(), expectedText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String generateUrl(String env) {
		try {
			//To empty the string builder because it may used in Url validation and Core Web vitals metrice automations
			html.setLength(0);
			timeStamp = getTime();
			String automationReportName = "WebAutomationReport-" + timeStamp;
			html.append("<html>");
			html.append("<body>");
			html.append("Latest Web Automation Report triggered for " + env + " Environment can be accessed here,");
			html.append("<br>");
			html.append("<br>");
			html.append("<a href=\"https://oceanjar-new.s3.ap-south-1.amazonaws.com/qa/testReport" + timeStamp
					+ "/index.html\">" + automationReportName + "</a>");
			html.append("<br>");
			html.append("<br>");

			html.append(
					"Also find attached the failure scenarios for this test run. Kindly copy the same under target directory and re-run using Failed Testcases Runner to execute the failed testcases alone.");

			System.out.println("Automation Report Name: " + automationReportName);
			System.out.println(
					"https://oceanjar-new.s3.ap-south-1.amazonaws.com/qa/testReport" + timeStamp + "/index.html");
			html.append("</body>");
			html.append("</html>");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return html.toString();
	}
	/*
	 * Author : Meenatchi Functionality : Get the text of the filter pills and used
	 * to validate filter applied successfully Date: 28/09/2019 Modified : NA
	 * Modified By :
	 */

	public void validate_the_filter_applied_successfully(String expectedText) throws Throwable {
//		String hotelPill = getText(hotelPage.getFilterPillsHotel());
//		System.out.println(hotelPill);
		validateAssertion(verifyExactText(hotelPage.getFilterPillsHotel(), expectedText));
	}

	public void copyFileUsingStream() throws IOException, InterruptedException {
		InputStream is = null;
		OutputStream os = null;
		try {

			File oldFile = new File(
					System.getProperty("user.dir") + "/target/cucumber-reports/WebAutomationReport.html");
			File newFile = new File(System.getProperty("user.dir") + "/target/cucumber-reports/WebAutomationReport"
					+ timeStamp + ".html");

			System.out.println("Old File: " + oldFile);
			System.out.println("New File: " + newFile);
			is = new FileInputStream(oldFile);
			os = new FileOutputStream(newFile);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			is.close();
			os.close();
			sendMail();
		}
	}

	public boolean fillMandatoryInfoInGCMWithDepartFrom(String departFrom) throws Throwable {
		 SpeedboatGlue spGlue = new SpeedboatGlue();
     icm = PageFactory.initElements(driver, Iternarycostmodel.class);
		boolean result = false;
		try {
			if (elementDisplayed(icm.getDepartingCity())) {
				clickAction(icm.getDepartingCity());
				Thread.sleep(1000);
				clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + departFrom + "')]")));
				Thread.sleep(1000);
				spGlue.enter_speedboat_departure_date();
				clickAction(icm.getTravellingPassengersType());
				clickAction(icm.getGetCostContinue());
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public void navigateGcmFlowWithDepartFrom(String departFrom) throws Throwable {
		waitForMe(icm.getcalculateTripCostButton());
		clickAction(icm.getcalculateTripCostButton());
		fillMandatoryInfoInGCMWithDepartFrom(departFrom);
	}

	public void activityEmptySlot(String slot) throws InterruptedException {
		int slotSize = driver.findElements(By.xpath("//span[text()='" + slot + "']")).size();
		try {
			if (slotSize > 0) {
				try {
					WebElement ele = driver.findElement(By.xpath(
							"//span[(text()='" + slot + "')]/following-sibling::p[@data-full-text='At leisure']"));
					if (elementExist(ele)) {
						clickAction(ele);
						while (elementDisplayed(ip.getgotItPopup())) {
							clickAction(ip.getgotItPopup());
						}
						validate_String_Contains(getCurrentUrl(), "alternate-activities");
					}
				} catch (NoSuchElementException e) {

					driver.findElement(By.xpath("//img[contains(@src,'activity')]/../following-sibling::span[text()='"
							+ slot + "']/following-sibling::p")).click();

					clickAction(activityPage.getActivitySlider_ViewSimilar());
					while (elementDisplayed(ip.getgotItPopup())) {
						clickAction(ip.getgotItPopup());
					}
					validate_String_Contains(getCurrentUrl(), "alternate-activities");

				}
			} else {
				assumeTrue(false);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No empty slot present in the itinerary for the given slot");
			assumeTrue(false);
		}
	}

	public void verifyingTimeSlotActivity(String type) throws Throwable {
		int div = 0;
		switch (type) {
		case "timeslot": {
			div = 2;
			break;
		}
		case "activity duration": {
			div = 3;
			break;
		}
		case "transfer": {
			div = 4;
			break;
		}
		case "group type": {
			div = 5;
			break;
		}
		case "interest": {
			div = 6;
			break;
		}
		case "other": {
			div = 7;
			break;
		}
		}
		List<WebElement> slots = driver
				.findElements(By.xpath("//*[@id='accordion']/section[" + div + "]/div[2]/div/div/a"));
		for (int i = 0; i < slots.size(); i++) {
			String slotNameFromPanel = slots.get(i).getText();
			slots.get(i).click();
			String slotNameFromPill = getText(hotelPage.getFilterPillsHotel());
			validateAssertion(slotNameFromPanel.equalsIgnoreCase(slotNameFromPill));
			slots.get(i).click();
		}
	}

	public boolean iternaryFlowForFerry(String region) throws Exception {
		boolean actualResult = false;
		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		typeText(cp.getlandingSearchBox(), region);
		if (elementDisplayed(cp.getregionSelection())) {
			{
				clickAction(cp.getregionSelection(), "Region selection");
				Thread.sleep(2000);
				clickAction(bdp.getMonth(), "Month Selection");
				try {
					if(bdp.getDate().isDisplayed()) {
						clickAction(bdp.getDate(), "Date Selection");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Date selection not available for this region");
				}
				clickAction(dp.getDurationDur1(), "Duration Selection");
				try {
					if(ip.getTraveelingWith().isDisplayed()) {
						clickAction(ip.getTraveelingWith(), "Couple Selected");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Travelling with selection not available for this region");
				}
				Thread.sleep(2000);
				clickAction(ip.getAbitOfEverything(), "Interest Selected");
				Thread.sleep(2000);
			}
			if (driver
					.findElements(By.xpath("//span[contains(text(),'View your Pickyourtrail personalized')]"))
					.size() > 0) {
				clickAction(ip.getviewPytIternaryButton(), "View only Iternary Button");
			}
		}
		try {
			Thread.sleep(2000);
			waitForMe(ip.getgotItPopup());
			if (elementDisplayed(ip.getgotItPopup())) {
				clickAction(ip.getgotItPopup());
				// ReporteraddStepLog("PopUp was clicked Successfully in Itinerary Page");
			}
			actualResult = true;
		} catch (NoSuchElementException ex) {
			// ReporteraddStepLog("No PopUp displayed in Itinerary Page");
			actualResult = true;
		} catch (Exception e) {
			System.out.println("No Got it popup");
		}
		return actualResult;

	}

	public ArrayList<String> getTextFileNames() {
		ArrayList<String> textFileNames = new ArrayList<String>();

		try {
			File directoryPath = new File(System.getProperty("user.dir") + "/target/cucumber-parallel");

			// List text files only
			System.out.println("\n------------Text files------------");
			File[] files = directoryPath.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".txt");
				}
			});

			for (File file : files) {
				// if(!(file.getName().contains("rerun.txt")))
				// {
				System.out.println(file.getName());
				textFileNames.add(file.getName());
				// }
			}
		} catch (Exception ex) {
			System.out.println("Problem while fetching the Text files " + ex.getMessage());
		}
		return textFileNames;
	}

	public void mergeAllTextFileContents() {
		try {
			File dir = new File(System.getProperty("user.dir") + "/target/cucumber-parallel");

			ArrayList<String> fileNames = new ArrayList<String>();

			// Get list of all the files in form of String Array
			fileNames = getTextFileNames();

			System.out.println("Filenames: " + fileNames);

			// create obejct of PrintWriter for output file
			PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "/target/rerun1.txt");

			// loop for reading the contents of all the files
			for (String fileName : fileNames) {
				System.out.println("Reading from " + fileName);

				// create instance of file from Name of
				// the file stored in string Array
				File f = new File(dir, fileName);

				// create object of BufferedReader
				BufferedReader br = new BufferedReader(new FileReader(f));
				// pw.println("Contents of file " + fileName);
				// pw.println(fileName);

				// Read from current file
				String line = br.readLine();

				while (line != null) {

					// write to the output file
					pw.println(line);
					line = br.readLine();
				}
				pw.flush();
			}
			System.out.println("Reading from all files" + " in directory " + dir.getName() + " Completed");

			greppingRerunFeatures();

		} catch (Exception ex) {
			System.out.println("Problem while merging the contents of text files " + ex.getMessage());
		}
	}

	public void greppingRerunFeatures() {
		try {

			File inputFile = new File(System.getProperty("user.dir") + "/target/rerun1.txt");
			File outputFile = new File(System.getProperty("user.dir") + "/target/rerun.txt");

			Scanner sc = null;
			FileWriter fw = null;

			try {
				sc = new Scanner(inputFile);
				fw = new FileWriter(outputFile);

				while (sc.hasNextLine()) {
					String str = sc.nextLine();
					System.out.println("Original line" + str);
					String str1 = str.replaceAll("^.*CucumerBddProject/", "");
					System.out.println("Grepped file:" + str1);
					fw.write(str1 + " ");
				}

				sc.close();
				fw.close();
			} catch (FileNotFoundException e2) {

				e2.printStackTrace();
			}

		} catch (Exception ex) {
			System.out.println("Problem while grepping the rerun scenarios ");
		}
	}

	public static void main(String args[]) {
		sendMail();
	}
	
	
	public int integerParser(String input) {
		int result = Integer.parseInt(input);
		return result;
	}
	
	
	public void writeToFile(String feature, String scenario, String fileValue) throws IOException 
	{
		try
		{
			String content= feature+","+scenario;

			if (fileValue.equalsIgnoreCase("pass"))
			{
			    FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"/target/PassedTestcases.csv", true);
			    fileWriter.write(content);
			    fileWriter.write("\n");
			    fileWriter.close();	
			}
			else if (fileValue.equalsIgnoreCase("fail"))
			{
				FileWriter fileWriter = new FileWriter(System.getProperty("user.dir")+"/target/FailedTestcases.csv",true);
			    fileWriter.write(content);
			    fileWriter.write("\n");
			    fileWriter.close();	
			}
	    
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Problem while identifying the file");
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Problem while writing the status to the file");
			ex.printStackTrace();
		}
	}
	
	public void closeStaycationModal() {
		try {
		waitForLoad(driver,30);
		driver.findElement(By.xpath("(//div[contains(@class,'PromotionModalstyles')])[10]/p")).click();
		}catch(Exception e) {
			System.out.println("Staycation Modal not displayed");
		}
	}
	
	public void waitForLoad(WebDriver driver,int timeout) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(pageLoadCondition);
    }

}
