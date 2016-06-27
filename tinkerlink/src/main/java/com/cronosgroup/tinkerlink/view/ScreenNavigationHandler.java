package com.cronosgroup.tinkerlink.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.presenter.messages.MessagesPresenter;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.sign.FacebookPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.PhonePresenter;
import com.cronosgroup.tinkerlink.presenter.sign.SignPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.ValidationPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.DetailStackPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.view.home.HomeActivity;
import com.cronosgroup.tinkerlink.view.sign.SignActivity;
import com.cronosgroup.tinkerlink.view.stack.detail.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

/**
 * Created by jorgesanmartin on 2/26/16.
 */
public final class ScreenNavigationHandler implements HomePresenter.Actions, TutorialPresenter.Actions,
        ContactsPresenter.Actions, ProfilePresenter.Actions, MessagesPresenter.Actions,
        StackPresenter.Actions, NewsFeedPresenter.Actions, CardPresenter.Actions,
        DetailStackPresenter.Actions
        , SignPresenter.Actions, FacebookPresenter.Actions,
        ValidationPresenter.Actions, PhonePresenter.Actions
{

    //Instance
    private static ScreenNavigationHandler instance = null;

    private ScreenNavigationHandler() {
    }

    /**
     * @return the instance of ScreenNavigationHandler
     */
    public static ScreenNavigationHandler getInstance() {
        if (instance == null) {
            instance = new ScreenNavigationHandler();
        }
        return instance;
    }

    // ---------------------------- LAUNCH INTENT -------------------------------

    private static void startActivity(Activity context, int enterAnim, int exitAnim, Intent intent) {
        context.startActivity(intent);
        context.overridePendingTransition(enterAnim, exitAnim);
    }

    private static void startActivityForResult(Activity context, int enterAnim, int exitAnim, int code, Intent intent) {
        context.startActivityForResult(intent, code);
        context.overridePendingTransition(enterAnim, exitAnim);
    }

    private static void startActivity(Activity context, Intent intent) {
        startActivity(context, android.R.anim.fade_in, android.R.anim.fade_out, intent);
    }

    private static void startActivityWithResult(Activity context, int code, Intent intent) {
        startActivityForResult(context, android.R.anim.fade_in, android.R.anim.fade_out, code, intent);
    }

    private static Intent newTask(@NonNull Activity context, @NonNull Class clazz, Bundle bundle) {
        Intent intent = newTask(context, clazz, bundle, false);
        return intent;
    }

    private static Intent newTask(@NonNull Activity context, @NonNull Class clazz, Bundle bundle, boolean clearTop) {
        Intent openIntent = new Intent(context, clazz);
        if (bundle != null) {
            openIntent.putExtras(bundle);
        }
        if (clearTop) {
            openIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return openIntent;
    }

    // ------------------------ CREATION INTENTS -----------------------------------

    private static Intent home(@NonNull Activity context, Bundle bundle) {
        return newTask(context, HomeActivity.class, bundle, true);
    }

    private static Intent stack(@NonNull Activity context, Bundle bundle) {
        return newTask(context, StackActivity.class, bundle);
    }

    private static Intent detailStack(@NonNull Activity context, Bundle bundle) {
        return newTask(context, DetailStackActivity.class, bundle, false);
    }

    private static Intent sign(@NonNull Activity context, Bundle bundle) {
        return newTask(context, SignActivity.class, bundle);
    }

    // ******************************
    //      ACTIONS DEFINITION
    // *************************++***


    // ------------------------ TUTORIAL -----------------------------------

    @Override
    public void onLoginPressed(Activity activity, Bundle bundle) {

    }

    @Override
    public void onSignPressed(Activity activity, Bundle bundle) {
        startActivity(activity, sign(activity, bundle));
    }

    // ------------------------ REGISTRATION -----------------------------------

    @Override
    public void onSuccessValidation(Activity activity, Bundle bundle) {
        startActivity(activity, home(activity, null));
    }

    @Override
    public void onGoToLogin(Activity activity, Bundle bundle) {

    }

    @Override
    public void onUsePolicyPressed(Activity activity, Bundle bundle) {

    }

    // ------------------------ TUTORIAL -----------------------------------

    @Override
    public void onLaunchHomeFromTutorial(Activity activity, Bundle bundle) {
        startActivity(activity, home(activity, null));
    }

    // ------------------------ NEWSFEED -----------------------------------

    @Override
    public void onLaunchStack(Activity activity, Bundle bundle) {
        startActivity(activity, stack(activity, bundle));
    }

    // ------------------------ STACK -----------------------------------

    @Override
    public void onLaunchDetailStack(Activity activity, Bundle bundle) {
        startActivity(activity, R.anim.anim_activity_up, R.anim.anim_activity_stay, detailStack(activity, bundle));
    }
}