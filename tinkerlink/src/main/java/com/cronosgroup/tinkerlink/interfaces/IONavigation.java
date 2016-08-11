package com.cronosgroup.tinkerlink.interfaces;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by jorgesanmartin on 8/11/16.
 */
public interface IONavigation {

    void onLaunchHome(Activity activity, Bundle bundle);

    void onLaunchLogin(Activity activity, Bundle bundle);

    void onLaunchSign(Activity activity, Bundle bundle);

    void onLaunchStack(Activity activity, Bundle bundle);

    void onLaunchDetailCard(Activity activity, Bundle bundle);

    void onLaunchNewsFeedSearch(Activity activity, Bundle bundle);

    void onLaunchUserStatus(Activity activity, Bundle bundle);

    void onLaunchCardsSearch(Activity activity, Bundle bundle);

    void onLaunchFilterCars(Activity activity, Bundle bundle);

    void onLaunchEditUserProfile(Activity activity, Bundle bundle);

    void onLaunchProfile(Activity activity, Bundle bundle);

    void onLaunchConfigProfile(Activity activity, Bundle bundle);

    void onLaunchCreateUserRecommendation(Activity activity, Bundle bundle);

    void onLaunchCreateCard(Activity activity, Bundle bundle);

    void onLaunchChangeUserPassword(Activity activity, Bundle bundle);

    void onLaunchChangeUserPhoneNumber(Activity activity, Bundle bundle);

    void onLaunchImportUserContacts(Activity activity, Bundle bundle);

    void onLaunchUserPrivacy(Activity activity, Bundle bundle);

    void onLaunchRecoveryUserPassword(Activity activity, Bundle bundle);

    void onLaunchUserVerification(Activity activity, Bundle bundle);

    void onLaunchTinkerLinkHelp(Activity activity, Bundle bundle);

    void onLaunchPolicyPrivacy(Activity activity, Bundle bundle);

    void onLaunchFrequentlyQuestions(Activity activity, Bundle bundle);

    void onLaunchUserContacts(Activity activity, Bundle bundle);

    void onLaunchSearchContacts(Activity activity, Bundle bundle);

    void onLaunchUserRecommendations(Activity activity, Bundle bundle);

    void onLaunchGiveUserRecommendation(Activity activity, Bundle bundle);

    void onLaunchChatUser(Activity activity, Bundle bundle);
}
