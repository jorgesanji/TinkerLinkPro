package com.cronosgroup.tinkerlink.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.presenter.messages.MessagesPresenter;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.view.home.HomeActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

/**
 * Created by jorgesanmartin on 2/26/16.
 */
public final class ScreenNavigationHandler implements HomePresenter.Actions, TutorialPresenter.Actions,
        ContactsPresenter.Actions, ProfilePresenter.Actions, MessagesPresenter.Actions,
        StackPresenter.Actions, NewsFeedPresenter.Actions, CardPresenter.Actions {

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

    private static void startActivity(Activity context, Intent intent) {
        context.startActivity(intent);
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private static void startActivityWithResult(Activity context, Intent intent, int code) {
        context.startActivityForResult(intent, code);
        context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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

    private static Intent list(@NonNull Activity context, Bundle bundle) {
        return newTask(context, HomeActivity.class, bundle);
    }

    private static Intent home(@NonNull Activity context, Bundle bundle) {
        return newTask(context, HomeActivity.class, bundle, true);
    }

    private static Intent stack(@NonNull Activity context, Bundle bundle) {
        return newTask(context, StackActivity.class, bundle, false);
    }

    // ******************************
    // ****** ACTIONS DEFINITION ****
    // *************************++***

    // ------------------------ REGISTRATION -----------------------------------

    @Override
    public void onLoginPressed(Activity activity, Bundle bundle) {

    }

    @Override
    public void onSignPressed(Activity activity, Bundle bundle) {

    }

    // ------------------------ TUTORIAL -----------------------------------

    @Override
    public void onLaunchHomeFromTutorial(Activity activity, Bundle bundle) {
        startActivity(activity, home(activity, null));
    }

    // ------------------------ NEWSFEED -----------------------------------

    @Override
    public void onLaunchImTinkerStack(Activity activity, Bundle bundle) {
        startActivity(activity, stack(activity, bundle));
    }

    @Override
    public void onLaunchSearchTinkerStack(Activity activity, Bundle bundle) {
        startActivity(activity, stack(activity, bundle));
    }
}