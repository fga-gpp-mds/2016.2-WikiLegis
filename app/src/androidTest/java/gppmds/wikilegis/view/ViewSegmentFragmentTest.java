package gppmds.wikilegis.view;

import android.app.Activity;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.view.WindowManager;

import gppmds.wikilegis.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by thiago on 9/30/16.
 */
public class ViewSegmentFragmentTest extends ActivityInstrumentationTestCase2<LoadingActivity> {

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
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activityOnTest.runOnUiThread(wakeUpDevice);
    }

    public void testTitleBillIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.titleBill)).check(matches(isDisplayed()));
    }

    public void testConstentSegmentIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.contentSegment)).check(matches(isDisplayed()));
    }

    public void testNumberOfLikeIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.textViewNumberLike)).check(matches(isDisplayed()));
    }

    public void testImageLikeIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.imageViewLike)).check(matches(isDisplayed()));
    }

    public void testNumberOfDislikeIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.textViewNumberLike)).check(matches(isDisplayed()));
    }

    public void testImageDislikeIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.imageViewDislike)).check(matches(isDisplayed()));
    }

    public void testProposalIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.textViewProposal)).check(matches(isDisplayed()));
    }

    public void testImageProposalIsDisplayed(){
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.recycler_view_open))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.imageViewProposal)).check(matches(isDisplayed()));
    }

    public void testByClickASegmentThatShouldNotBeClickable() throws InterruptedException {
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.main_content)).perform(swipeLeft());
        Thread.sleep(2000);
        onView(withId(R.id.recycler_view_closed))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.textViewProposal)).check(matches(isDisplayed()));
    }

    public void testByClickASegmentThatShouldBeClickable() throws InterruptedException {
        //Redirecting to ViewSegmentFragment
        closeSoftKeyboard();
        onView(withText("Visitante")).perform(click());
        onView(withId(R.id.main_content)).perform(swipeLeft());
        Thread.sleep(2000);
        onView(withId(R.id.recycler_view_closed))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.recycler_viewBill))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(R.id.imageViewLike)).check(matches(isDisplayed()));
    }
}