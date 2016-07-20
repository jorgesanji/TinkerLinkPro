package com.cronosgroup.tinkerlink.view;

import com.cronosgroup.core.presenter.BasePresenter;
import com.cronosgroup.core.presenter.StatusMessageManager;

import com.cronosgroup.tinkerlink.R;

/**
 * Created by jorgesanmartin on 11/19/15.
 */
public class AppSnackManager extends StatusMessageManager {

    public AppSnackManager() {
        super(null);
    }

    public AppSnackManager(BasePresenter.View presenter) {
        super(presenter);
    }

    @Override
    public int getErrorColor() {
        return R.color.errorcolor;
    }

    @Override
    public int getSucessColor() {
        return R.color.tinkercolor;
    }

    @Override
    public int getWarningColor() {
        return R.color.warningcolor;
    }

    ////// SHOW SUCCESSFULL MESSAGES

    public void showShareSuccess() {
        showSuccess(R.string.newsFeed_share_success);
    }

    public void showProfileShareSuccess() {
        showSuccess(R.string.profile_share);
    }

    public void showLikeSuccess() {
        showSuccess(R.string.newsFeed_like_success);
    }

    public void showChatSuccess() {
        showSuccess(R.string.newsFeed_chat_success);
    }


    public void showEmptyResponseSuccess() {
        showSuccess(R.string.search_post_no_founded);
    }

    public void showPostReadySharedSuccess() {
        showSuccess(R.string.news_feed_ready_share);
    }

    public void showProfileReadySharedSuccess() {
        showSuccess(R.string.profile_ready_share);
    }

    public void showDeleteContactSuccess() {
        showSuccess(R.string.newsFeed_delete_user_contact);
    }

    public void showRequestAddContactSuccess() {
        showSuccess(R.string.newsFeed_request_user_contact);
    }

    public void showAcceptContactSuccess() {
        showSuccess(R.string.newsFeed_accept_contact);
    }

    public void showCancelContactSuccess() {
        showSuccess(R.string.newsFeed_cancel_user_contact);
    }

    public void showRejectContactSuccess() {
        showSuccess(R.string.newsFeed_reject_user_contact);
    }

    public void showBlockContactSuccess() {
        showSuccess(R.string.newsFeed_block_contact);
    }

    public void showUpdatePhotoSuccess() {
        showSuccess(R.string.profile_update_photo_success);
    }

    public void showDeletePhotoSuccess() {
        showSuccess(R.string.profile_delete_photo_success);
    }

    public void showUpdateProfileSuccess() {
        showSuccess(R.string.profile_update_profile_success);
    }

    public void showRequestRecommendationSuccess(String message) {
        showSuccess(message);
    }

    public void showGiveRecommendationSuccess() {
        showSuccess(R.string.profile_give_recommendation_success);
    }

    public void showDeleteCardSuccess() {
        showSuccess(R.string.card_deleted_success);
    }

    public void showInvalidStatusSuccess() {
        showSuccess(R.string.newsFeed_status_success);
    }

    public void showInviteSuccess() {
        showSuccess(R.string.contacts_invite);
    }


    ////// SHOW ERROR MESSAGES

    public void showLikeError() {
        showError(R.string.newsFeed_like_error);
    }

    public void showChatError() {
        showError(R.string.newsFeed_chat_error);
    }

    public void showShareError() {
        showError(R.string.newsFeed_share_error);
    }

    public void showAddContactError() {
        showError(R.string.newsFeed_contact_error);
    }

    public void showNetworkError() {
        showError(R.string.sign_request_error);
    }

    public void showCategoryError() {
        showError(R.string.create_category_error);
    }

    public void showNumberPhotosError() {
        showError(R.string.create_invalid_number_photos_error);
    }

    public void showDeleteContactError() {
        showError(R.string.newsFeed_delete_contact_error);
    }

    public void showBlockContactError() {
        showError(R.string.newsFeed_block_contact_error);
    }

    public void showUpdatePhotoError() {
        showError(R.string.profile_upload_photo_error);
    }

    public void showDeletePhotoError() {
        showError(R.string.profile_delete_photo_error);
    }

    public void showCodePhoneError() {
        showError(R.string.login_enter_code_error);
    }

    public void showUpdateProfileError() {
        showError(R.string.profile_update_profile_error);
    }

    public void showNoSelectedUserdToRecommendedError() {
        showError(R.string.profile_no_selecte_users_error);
    }

    public void showRequestRecommendationError() {
        showError(R.string.profile_request_recommendation_error);
    }

    public void showGiveRecommendationError() {
        showError(R.string.profile_give_recommendation_error);
    }

    public void showGiveRecommendationNoDescriptionError() {
        showError(R.string.profile_give_recommendation_no_description_error);
    }

    public void showCodeError() {
        showError(R.string.login_code_error);
    }

    public void showLogoutError() {
        showError(R.string.setttings_logout_error);
    }

    public void showInvalidStatusError() {
        showError(R.string.newsFeed_status_error);
    }

    public void showNameError() {
        showError(R.string.sign_name_error);
    }

    public void showEmailError() {
        showError(R.string.sign_email_error);
    }

    public void showProfileEmptyError() {
        showError(R.string.create_use_error_empty_profile);
    }

    public void showRecoveryEmailError() {
        showError(R.string.login_enter_email_error);
    }

    public void showPhoneError() {
        showError(R.string.sign_phone_error);
    }

    public void showBirthDateError() {
        showError(R.string.sign_datebirth_error);
    }

    public void showProfileImageError() {
        showError(R.string.sign_imageProfile_error);
    }

    public void showSexError() {
        showError(R.string.sign_sex_error);
    }

    public void showInviteError() {
        showError(R.string.contacts_invite_error);
    }

    // Form Error

    public void showCategoryFormError() {
        showError(R.string.create_category_form_error);
    }

    public void showProfessionFormError() {
        showError(R.string.create_prefession_form_error);
    }

    public void showCurrencyFormError() {
        showError(R.string.create_currency_form_error);
    }

    public void showExperienceFormError() {
        showError(R.string.create_experience_form_error);
    }

    public void showPayFormError() {
        showError(R.string.create_pay_form_error);
    }

    public void showTimeFormError() {
        showError(R.string.create_time_form_error);
    }

    public void showAddressError() {
        showError(R.string.create_address_form_error);
    }

    public void showPublishFormError() {
        showError(R.string.create_time_publish_form_error);
    }
}
