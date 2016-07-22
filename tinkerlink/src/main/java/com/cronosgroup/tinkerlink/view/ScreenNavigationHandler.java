package com.cronosgroup.tinkerlink.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.account.AccountPresenter;
import com.cronosgroup.tinkerlink.presenter.chatuser.ChatUserPresenter;
import com.cronosgroup.tinkerlink.presenter.config.ConfigPresenter;
import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.CategorySelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.CreateCardPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.ExperienceSelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.SkillSelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createrecommendation.CreateRecommendationPresenter;
import com.cronosgroup.tinkerlink.presenter.editprofile.EditProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.presenter.login.LoginPresenter;
import com.cronosgroup.tinkerlink.presenter.messages.ChatPresenter;
import com.cronosgroup.tinkerlink.presenter.network.NetworkPresenter;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.presenter.presignuser.PreSignUserPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.FormUserPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.TLinkerSelectorPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.SignPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.ValidationPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.DetailStackPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.view.chatuser.ChatUserActivity;
import com.cronosgroup.tinkerlink.view.config.ConfigActivity;
import com.cronosgroup.tinkerlink.view.createcard.CreateCardActivity;
import com.cronosgroup.tinkerlink.view.createrecommendation.CreateRecommendationActivity;
import com.cronosgroup.tinkerlink.view.editprofile.EditProfileActivity;
import com.cronosgroup.tinkerlink.view.home.HomeActivity;
import com.cronosgroup.tinkerlink.view.login.LoginActivity;
import com.cronosgroup.tinkerlink.view.network.NetworkActivity;
import com.cronosgroup.tinkerlink.view.presignuser.PreSignUserActivity;
import com.cronosgroup.tinkerlink.view.profile.ProfileActivity;
import com.cronosgroup.tinkerlink.view.sign.SignActivity;
import com.cronosgroup.tinkerlink.view.stack.detail.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

/**
 * Created by jorgesanmartin on 2/26/16.
 */
public final class ScreenNavigationHandler implements HomePresenter.Actions,
        TutorialPresenter.Actions, ContactsPresenter.Actions, AccountPresenter.Actions,
        ChatPresenter.Actions, StackPresenter.Actions, NewsFeedPresenter.Actions,
        CardPresenter.Actions, DetailStackPresenter.Actions,
        SignPresenter.Actions, FormUserPresenter.Actions,
        ValidationPresenter.Actions, TLinkerSelectorPresenter.Actions,
        NetworkPresenter.Actions, ConfigPresenter.Actions,
        EditProfilePresenter.Actions, CreateCardPresenter.Actions,
        CreateRecommendationPresenter.Actions, ChatUserPresenter.Actions,
        CategorySelectionPresenter.Actions, ExperienceSelectionPresenter.Actions,
        SkillSelectionPresenter.Actions, PreSignUserPresenter.Actions,
        LoginPresenter.Actions {

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

    private static Intent preSign(@NonNull Activity context, Bundle bundle) {
        return newTask(context, PreSignUserActivity.class, bundle);
    }

    private static Intent sign(@NonNull Activity context, Bundle bundle) {
        return newTask(context, SignActivity.class, bundle);
    }

    private static Intent login(@NonNull Activity context, Bundle bundle) {
        return newTask(context, LoginActivity.class, bundle);
    }

    private static Intent home(@NonNull Activity context, Bundle bundle) {
        return newTask(context, HomeActivity.class, bundle, true);
    }

    private static Intent stack(@NonNull Activity context, Bundle bundle) {
        return newTask(context, StackActivity.class, bundle);
    }

    private static Intent detailStack(@NonNull Activity context, Bundle bundle) {
        return newTask(context, DetailStackActivity.class, bundle);
    }

    private static Intent network(@NonNull Activity context, Bundle bundle) {
        return newTask(context, NetworkActivity.class, bundle);
    }

    private static Intent profile(@NonNull Activity context, Bundle bundle) {
        return newTask(context, ProfileActivity.class, bundle);
    }

    private static Intent editProfile(@NonNull Activity context, Bundle bundle) {
        return newTask(context, EditProfileActivity.class, bundle);
    }

    private static Intent configProfile(@NonNull Activity context, Bundle bundle) {
        return newTask(context, ConfigActivity.class, bundle);
    }

    private static Intent createRecommendation(@NonNull Activity context, Bundle bundle) {
        return newTask(context, CreateRecommendationActivity.class, bundle);
    }

    private static Intent createCard(@NonNull Activity context, Bundle bundle) {
        return newTask(context, CreateCardActivity.class, bundle);
    }

    private static Intent chatUser(@NonNull Activity context, Bundle bundle) {
        return newTask(context, ChatUserActivity.class, bundle);
    }

    // ******************************
    //      ACTIONS DEFINITION
    // *************************++***

    // ------------------------ TUTORIAL -----------------------------------

    @Override
    public void onLaunchStart(Activity activity, Bundle bundle) {
        startActivity(activity, preSign(activity, bundle));
    }


    @Override
    public void onLaunchHome(Activity activity, Bundle bundle) {
        startActivity(activity, home(activity, bundle));
    }

    // ------------------------ PRESIGN -----------------------------------

    @Override
    public void onLaunchLogin(Activity activity, Bundle bundle) {
        startActivity(activity, login(activity, bundle));
    }

    @Override
    public void onLaunchSign(Activity activity, Bundle bundle) {
        startActivity(activity, sign(activity, bundle));
    }

    // ------------------------ REGISTRATION -----------------------------------


    @Override
    public void onLaunchSuccessValidation(Activity activity, Bundle bundle) {

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

    // ------------------------ PROFILE -----------------------------------

    @Override
    public void onLaunchNetWork(Activity activity, Bundle bundle) {
        startActivity(activity, network(activity, bundle));
    }

    // ------------------------ ACCOUNT -----------------------------------

    @Override
    public void onLaunchEditProfile(Activity activity, Bundle bundle) {
        startActivity(activity, editProfile(activity, bundle));
    }

    @Override
    public void onLaunchProfile(Activity activity, Bundle bundle) {
        startActivity(activity, profile(activity, bundle));
    }

    @Override
    public void onLaunchConfigProfile(Activity activity, Bundle bundle) {
        startActivity(activity, configProfile(activity, bundle));
    }

    @Override
    public void onLaunchCreateRecommendation(Activity activity, Bundle bundle) {
        startActivity(activity, createRecommendation(activity, bundle));
    }

    @Override
    public void onLaunchCreateCard(Activity activity, Bundle bundle) {
        startActivity(activity, createCard(activity, bundle));
    }

    // ------------------------ CHAT -----------------------------------

    @Override
    public void onLaunchChatUser(Activity activity, Bundle bundle) {
        startActivity(activity, chatUser(activity, bundle));
    }

}