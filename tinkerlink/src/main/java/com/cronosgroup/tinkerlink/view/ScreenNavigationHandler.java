package com.cronosgroup.tinkerlink.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.cronosgroup.tinkerlink.presenter.account.AccountPresenter;
import com.cronosgroup.tinkerlink.presenter.category.CategoryPresenter;
import com.cronosgroup.tinkerlink.presenter.changepassword.ChangePasswordPresenter;
import com.cronosgroup.tinkerlink.presenter.changephonenumber.ChangePhoneNumberPresenter;
import com.cronosgroup.tinkerlink.presenter.chatuser.ChatUserPresenter;
import com.cronosgroup.tinkerlink.presenter.config.ConfigPresenter;
import com.cronosgroup.tinkerlink.presenter.contacts.ContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.contacts.MyContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.contacts.RequestContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.CategorySelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.CreateCardPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.ExperienceSelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.SkillSelectionPresenter;
import com.cronosgroup.tinkerlink.presenter.createrecommendation.CreateRecommendationPresenter;
import com.cronosgroup.tinkerlink.presenter.detailcard.DetailCardPresenter;
import com.cronosgroup.tinkerlink.presenter.dialog.country.DialogCountryPresenter;
import com.cronosgroup.tinkerlink.presenter.dialog.occupation.DialogOccupationPresenter;
import com.cronosgroup.tinkerlink.presenter.dialog.places.DialogPlacesPresenter;
import com.cronosgroup.tinkerlink.presenter.dragdrop.DrargDropPresenter;
import com.cronosgroup.tinkerlink.presenter.editprofile.ConfigAccountUserPresenter;
import com.cronosgroup.tinkerlink.presenter.editprofile.EditProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.editprofile.UserNotificationsPresenter;
import com.cronosgroup.tinkerlink.presenter.filtercards.FilterCardsPresenter;
import com.cronosgroup.tinkerlink.presenter.frequentlyquestions.FrequentlyQuestionsPresenter;
import com.cronosgroup.tinkerlink.presenter.giverecommendation.GiveRecommendationPresenter;
import com.cronosgroup.tinkerlink.presenter.helptinkerlink.HelpTinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.home.HomePresenter;
import com.cronosgroup.tinkerlink.presenter.importcontacts.ImportContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.login.LoginPresenter;
import com.cronosgroup.tinkerlink.presenter.messages.ChatPresenter;
import com.cronosgroup.tinkerlink.presenter.network.NetworkPresenter;
import com.cronosgroup.tinkerlink.presenter.newsfeed.NewsFeedPresenter;
import com.cronosgroup.tinkerlink.presenter.policyprivacy.PolicyPrivacyPresenter;
import com.cronosgroup.tinkerlink.presenter.privacy.PrivacyPresenter;
import com.cronosgroup.tinkerlink.presenter.profile.ProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.profile.UserActivityPresenter;
import com.cronosgroup.tinkerlink.presenter.profile.UserInformationPresenter;
import com.cronosgroup.tinkerlink.presenter.profile.UserRecommendationsPresenter;
import com.cronosgroup.tinkerlink.presenter.recommendations.RecommendationsPresenter;
import com.cronosgroup.tinkerlink.presenter.recoverypassword.RecoveryPasswordPresenter;
import com.cronosgroup.tinkerlink.presenter.searchcard.SearchCardPresenter;
import com.cronosgroup.tinkerlink.presenter.searchcontacts.SearchContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.searchnewsfeed.SearchNewsFeedPresenter;
import com.cronosgroup.tinkerlink.presenter.share.SharePresenter;
import com.cronosgroup.tinkerlink.presenter.sign.FormUserPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.RegisterSelectorPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.SignPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.SignProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.sign.TLinkerSelectorPresenter;
import com.cronosgroup.tinkerlink.presenter.sign.ValidationPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.CardRecommendationsPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.DetailStackPresenter;
import com.cronosgroup.tinkerlink.presenter.stack.StackPresenter;
import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.presenter.usercontacts.AllUserContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.usercontacts.UserContactsPresenter;
import com.cronosgroup.tinkerlink.presenter.userstatus.UserStatusPresenter;
import com.cronosgroup.tinkerlink.presenter.verify.VerifyPresenter;
import com.cronosgroup.tinkerlink.view.cardfilter.FilterCardsActivity;
import com.cronosgroup.tinkerlink.view.chatuser.ChatUserActivity;
import com.cronosgroup.tinkerlink.view.config.changepassword.ChangePasswordActivity;
import com.cronosgroup.tinkerlink.view.config.changephonenumber.ChangePhoneNumberActivity;
import com.cronosgroup.tinkerlink.view.config.frequentlyquestions.FrequentlyQuestionsActivity;
import com.cronosgroup.tinkerlink.view.config.helptinkerlink.HelpTinkerLinkActivity;
import com.cronosgroup.tinkerlink.view.config.importcontacts.ImportContactsActivity;
import com.cronosgroup.tinkerlink.view.config.main.ConfigActivity;
import com.cronosgroup.tinkerlink.view.config.policyprivacy.PolicyPrivacyActivity;
import com.cronosgroup.tinkerlink.view.config.privacy.PrivacyActivity;
import com.cronosgroup.tinkerlink.view.config.recoverypassword.RecoveryPasswordActivity;
import com.cronosgroup.tinkerlink.view.config.verify.VerificationActivity;
import com.cronosgroup.tinkerlink.view.createcard.CreateCardActivity;
import com.cronosgroup.tinkerlink.view.createrecommendation.CreateRecommendationActivity;
import com.cronosgroup.tinkerlink.view.detailcard.DetailCardActivity;
import com.cronosgroup.tinkerlink.view.editprofile.EditProfileActivity;
import com.cronosgroup.tinkerlink.view.giverecommendation.GiveRecommendationsActivity;
import com.cronosgroup.tinkerlink.view.home.HomeActivity;
import com.cronosgroup.tinkerlink.view.login.LoginActivity;
import com.cronosgroup.tinkerlink.view.profile.ProfileActivity;
import com.cronosgroup.tinkerlink.view.recommendations.RecommendationsActivity;
import com.cronosgroup.tinkerlink.view.searchcard.SearchCardActivity;
import com.cronosgroup.tinkerlink.view.searchcontacts.SearchContactsActivity;
import com.cronosgroup.tinkerlink.view.searchnewsfeed.SearchNewsFeedActivity;
import com.cronosgroup.tinkerlink.view.sign.SignActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;
import com.cronosgroup.tinkerlink.view.status.UserStatusActivity;
import com.cronosgroup.tinkerlink.view.usercontacts.UserContactsActivity;

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
        SkillSelectionPresenter.Actions,
        LoginPresenter.Actions, RegisterSelectorPresenter.Actions, SignProfilePresenter.Actions,
        DetailCardPresenter.Actions, ProfilePresenter.Actions, ConfigAccountUserPresenter.Actions,
        UserNotificationsPresenter.Actions, ChangePasswordPresenter.Actions,
        ChangePhoneNumberPresenter.Actions, ImportContactsPresenter.Actions,
        PolicyPrivacyPresenter.Actions, HelpTinkerLinkPresenter.Actions,
        FrequentlyQuestionsPresenter.Actions, PrivacyPresenter.Actions,
        RecoveryPasswordPresenter.Actions, VerifyPresenter.Actions, UserActivityPresenter.Actions,
        UserInformationPresenter.Actions, UserRecommendationsPresenter.Actions,
        RecommendationsPresenter.Actions, GiveRecommendationPresenter.Actions,
        UserContactsPresenter.Actions, AllUserContactsPresenter.Actions, DrargDropPresenter.Actions,
        DialogOccupationPresenter.Actions, DialogCountryPresenter.Actions,
        DialogPlacesPresenter.Actions, SearchCardPresenter.Actions, FilterCardsPresenter.Actions,
        CardRecommendationsPresenter.Actions, SharePresenter.Actions, MyContactsPresenter.Actions,
        RequestContactsPresenter.Actions, CategoryPresenter.Actions, SearchNewsFeedPresenter.Actions,
        SearchContactsPresenter.Actions, UserStatusPresenter.Actions {

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

    private static Intent sign(Activity context, Bundle bundle) {
        return newTask(context, SignActivity.class, bundle);
    }

    private static Intent login(Activity context, Bundle bundle) {
        return newTask(context, LoginActivity.class, bundle);
    }

    private static Intent home(Activity context, Bundle bundle) {
        return newTask(context, HomeActivity.class, bundle, true);
    }

    private static Intent stack(Activity context, Bundle bundle) {
        return newTask(context, StackActivity.class, bundle);
    }

    private static Intent detailCard(Activity context, Bundle bundle) {
        return newTask(context, DetailCardActivity.class, bundle);
    }

    private static Intent searchCards(Activity context, Bundle bundle) {
        return newTask(context, SearchCardActivity.class, bundle);
    }

    private static Intent filterCards(Activity context, Bundle bundle) {
        return newTask(context, FilterCardsActivity.class, bundle);
    }

    private static Intent profile(Activity context, Bundle bundle) {
        return newTask(context, ProfileActivity.class, bundle);
    }

    private static Intent editProfile(Activity context, Bundle bundle) {
        return newTask(context, EditProfileActivity.class, bundle);
    }

    private static Intent configProfile(Activity context, Bundle bundle) {
        return newTask(context, ConfigActivity.class, bundle);
    }

    private static Intent createRecommendation(Activity context, Bundle bundle) {
        return newTask(context, CreateRecommendationActivity.class, bundle);
    }

    private static Intent createCard(Activity context, Bundle bundle) {
        return newTask(context, CreateCardActivity.class, bundle);
    }

    private static Intent chatUser(Activity context, Bundle bundle) {
        return newTask(context, ChatUserActivity.class, bundle);
    }

    private static Intent changePassword(Activity context, Bundle bundle) {
        return newTask(context, ChangePasswordActivity.class, bundle);
    }

    private static Intent changePhoneNumber(Activity context, Bundle bundle) {
        return newTask(context, ChangePhoneNumberActivity.class, bundle);
    }

    private static Intent importContacts(Activity context, Bundle bundle) {
        return newTask(context, ImportContactsActivity.class, bundle);
    }

    private static Intent privacyPolicy(Activity context, Bundle bundle) {
        return newTask(context, PolicyPrivacyActivity.class, bundle);
    }

    private static Intent privacy(Activity context, Bundle bundle) {
        return newTask(context, PrivacyActivity.class, bundle);
    }

    private static Intent helperTinkerLink(Activity context, Bundle bundle) {
        return newTask(context, HelpTinkerLinkActivity.class, bundle);
    }

    private static Intent frequentlyQuestions(Activity context, Bundle bundle) {
        return newTask(context, FrequentlyQuestionsActivity.class, bundle);
    }

    private static Intent recoveryPassword(Activity context, Bundle bundle) {
        return newTask(context, RecoveryPasswordActivity.class, bundle);
    }

    private static Intent verify(Activity context, Bundle bundle) {
        return newTask(context, VerificationActivity.class, bundle);
    }

    private static Intent recommendations(Activity context, Bundle bundle) {
        return newTask(context, RecommendationsActivity.class, bundle);
    }

    private static Intent giveRecommendations(Activity context, Bundle bundle) {
        return newTask(context, GiveRecommendationsActivity.class, bundle);
    }

    private static Intent userContacts(Activity context, Bundle bundle) {
        return newTask(context, UserContactsActivity.class, bundle);
    }

    private static Intent searchNewsFeed(Activity context, Bundle bundle) {
        return newTask(context, SearchNewsFeedActivity.class, bundle);
    }

    private static Intent userStatus(Activity context, Bundle bundle) {
        return newTask(context, UserStatusActivity.class, bundle);
    }

    private static Intent searchContacts(Activity context, Bundle bundle) {
        return newTask(context, SearchContactsActivity.class, bundle);
    }

    // ******************************
    //      ACTIONS DEFINITION
    // *************************++***

    /**
     * Launch Home activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchHome(Activity activity, Bundle bundle) {
        startActivity(activity, home(activity, bundle));
    }

    /**
     * Launch Login activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchLogin(Activity activity, Bundle bundle) {
        startActivity(activity, login(activity, bundle));
    }

    /**
     * Launch Sign activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchSign(Activity activity, Bundle bundle) {
        startActivity(activity, sign(activity, bundle));
    }

    /**
     * Launch Stack Activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchStack(Activity activity, Bundle bundle) {
        startActivity(activity, stack(activity, bundle));
    }

    /**
     * Launch Detail Stack activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchDetailCard(Activity activity, Bundle bundle) {
        startActivity(activity, detailCard(activity, bundle));
    }

    /**
     * Launch News feed search activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchNewsFeedSearch(Activity activity, Bundle bundle) {
        startActivity(activity, searchNewsFeed(activity, bundle));
    }

    /**
     * Launch User status activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchUserStatus(Activity activity, Bundle bundle) {
        startActivity(activity, userStatus(activity, bundle));
    }

    /**
     * Launch Cards search activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchCardsSearch(Activity activity, Bundle bundle) {
        startActivity(activity, searchCards(activity, bundle));
    }

    /**
     * Launch Filter cards activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchFilterCars(Activity activity, Bundle bundle) {
        startActivity(activity, filterCards(activity, bundle));
    }

    /**
     * Launch Edit user profile activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchEditUserProfile(Activity activity, Bundle bundle) {
        startActivity(activity, editProfile(activity, bundle));
    }

    /**
     * Launch Profile activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchProfile(Activity activity, Bundle bundle) {
        startActivity(activity, profile(activity, bundle));
    }

    /**
     * Launch Config profile activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchConfigProfile(Activity activity, Bundle bundle) {
        startActivity(activity, configProfile(activity, bundle));
    }

    /**
     * Launch Create user recommendations activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchCreateUserRecommendation(Activity activity, Bundle bundle) {
        startActivity(activity, createRecommendation(activity, bundle));
    }

    /**
     * Launch Create card activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchCreateCard(Activity activity, Bundle bundle) {
        startActivity(activity, createCard(activity, bundle));
    }

    /**
     * Launch Change user password activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchChangeUserPassword(Activity activity, Bundle bundle) {
        startActivity(activity, changePassword(activity, bundle));
    }

    /**
     * Launch Change user phone number activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchChangeUserPhoneNumber(Activity activity, Bundle bundle) {
        startActivity(activity, changePhoneNumber(activity, bundle));
    }

    /**
     * Launch Import user contacts activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchImportUserContacts(Activity activity, Bundle bundle) {
        startActivity(activity, importContacts(activity, bundle));
    }

    /**
     * Launch User privacy activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchUserPrivacy(Activity activity, Bundle bundle) {
        startActivity(activity, privacy(activity, bundle));
    }

    /**
     * Launch Recovery user password
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchRecoveryUserPassword(Activity activity, Bundle bundle) {
        startActivity(activity, recoveryPassword(activity, bundle));
    }

    /**
     * Launch User verification activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchUserVerification(Activity activity, Bundle bundle) {
        startActivity(activity, verify(activity, bundle));
    }

    /**
     * Launch TinkerLink help activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchTinkerLinkHelp(Activity activity, Bundle bundle) {
        startActivity(activity, helperTinkerLink(activity, bundle));
    }

    /**
     * Launch Policy privacy
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchPolicyPrivacy(Activity activity, Bundle bundle) {
        startActivity(activity, privacyPolicy(activity, bundle));
    }

    /**
     * Launch Frequently questions activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchFrequentlyQuestions(Activity activity, Bundle bundle) {
        startActivity(activity, frequentlyQuestions(activity, bundle));
    }

    /**
     * Launch User contacts activity
     * @param activity
     * @param bundle
     */
    @Override
    public void onLaunchUserContacts(Activity activity, Bundle bundle) {
        startActivity(activity, userContacts(activity, bundle));
    }

    /**
     * Launch Search Contacts activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchSearchContacts(Activity activity, Bundle bundle) {
        startActivity(activity, searchContacts(activity, bundle));
    }

    /**
     * Launch User recommendations activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchUserRecommendations(Activity activity, Bundle bundle) {
        startActivity(activity, recommendations(activity, bundle));
    }

    /**
     * Launch Give use recommendation activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchGiveUserRecommendation(Activity activity, Bundle bundle) {
        startActivity(activity, giveRecommendations(activity, bundle));
    }

    /**
     * Launch Chat user activity
     * @param activity
     * @param bundle
     */

    @Override
    public void onLaunchChatUser(Activity activity, Bundle bundle) {
        startActivity(activity, chatUser(activity, bundle));
    }
}