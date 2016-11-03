package gppmds.wikilegis.view;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.view.WindowManager;
import gppmds.wikilegis.R;
import gppmds.wikilegis.controller.SegmentController;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by thiago on 9/30/16.
 */

public class ViewSegmentFragmentTest extends ActivityInstrumentationTestCase2<LoadingActivity> {
    Activity activityOnTest;
    public ViewSegmentFragmentTest(){
        super(LoadingActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();

        final Activity activityOnTest = getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activityOnTest.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);;
            }
        };

        activityOnTest.runOnUiThread(wakeUpDevice);

        SegmentController segmentController =
                SegmentController.getInstance(getActivity().getBaseContext());

        if(segmentController.isSegmentDatabaseIsEmpty()) {
            onView(withId(R.id.button)).perform(click());
        }

        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    public void tearDown() throws Exception {
        goBackN();

        super.tearDown();
    }

    private void goBackN() {
        final int N = 50; // how many times to hit back button
        try {
            for (int i = 0; i < N; i++)
                Espresso.pressBack();
        } catch (Exception e) {
        }
    }

    public void testImageProposalIsDisplayed(){

        onView(withId(R.id.imageViewProposal)).check(matches(isDisplayed()));
    }


    public void testProposalIsDisplayed(){


        onView(withId(R.id.textViewProposal)).check(matches(isDisplayed()));
    }

    public void testTitleBillIsDisplayed(){

        onView(withId(R.id.titleBill)).check(matches(isDisplayed()));
    }

    public void testConstentSegmentIsDisplayed(){

        onView(withId(R.id.contentSegment)).check(matches(isDisplayed()));
    }

    public void testNumberOfLikeIsDisplayed(){

        onView(withId(R.id.textViewNumberLike)).check(matches(isDisplayed()));
    }

    public void testImageLikeIsDisplayed(){

        onView(withId(R.id.imageViewLike)).check(matches(isDisplayed()));
    }

    public void testNumberOfDislikeIsDisplayed(){

        onView(withId(R.id.textViewNumberLike)).check(matches(isDisplayed()));
    }

    public void testImageDislikeIsDisplayed(){

        onView(withId(R.id.imageViewDislike)).check(matches(isDisplayed()));
    }
    public void testLikeButton(){
        closeSoftKeyboard();

        Boolean isLoggedIn = PreferenceManager.getDefaultSharedPreferences
                (activityOnTest.getBaseContext()).getBoolean("IsLoggedIn", false);

        if(!isLoggedIn){
            onView(withId(R.id.emailLoginField)).perform(typeText("cizabelacristina@gmail.com"));
            closeSoftKeyboard();
            onView(withId(R.id.passwordLoginField)).perform(typeText("iza3bel"));
            closeSoftKeyboard();
            onView(withId(R.id.loginButton)).perform(click());
        }

        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewSegment))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.imageViewLike))
                .perform((click()));
        onView(withText("like")).inRoot(withDecorView(not(is(getActivity()
                .getWindow().getDecorView())))).check(matches(isDisplayed()));

    }
    public void testDesLikeButton(){

        closeSoftKeyboard();

        Boolean isLoggedIn = PreferenceManager.getDefaultSharedPreferences
                (activityOnTest.getBaseContext()).getBoolean("IsLoggedIn", false);

        if(!isLoggedIn){
            onView(withId(R.id.emailLoginField)).perform(typeText("cizabelacristina@gmail.com"));
            closeSoftKeyboard();
            onView(withId(R.id.passwordLoginField)).perform(typeText("iza3bel"));
            closeSoftKeyboard();
            onView(withId(R.id.loginButton)).perform(click());
        }

        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewSegment))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.imageViewDislike))
                .perform((click()));
        onView(withText("deslike")).inRoot(withDecorView(not(is(getActivity()
                .getWindow().getDecorView())))).check(matches(isDisplayed()));

    }
}