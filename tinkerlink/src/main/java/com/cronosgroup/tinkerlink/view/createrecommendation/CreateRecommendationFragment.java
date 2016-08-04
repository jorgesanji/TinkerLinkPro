package com.cronosgroup.tinkerlink.view.createrecommendation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.presenter.createrecommendation.CreateRecommendationPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;


/**
 * Create card Fragment
 */
public class CreateRecommendationFragment extends MVPTinkerLinkFragment<CreateRecommendationPresenter, CreateRecommendationPresenter.View>
        implements CreateRecommendationPresenter.View, CreateRecommendationScreen.Listener {

    // Vars

    // Views
    private CreateRecommendationScreen createRecommendationScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.recommendations_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_send_recommendation) {
            getPresenter().sendRecommendation();
        }

        return super.onOptionsItemSelected(item);
    }

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        createRecommendationScreen = new CreateRecommendationScreen(getActivity());
        createRecommendationScreen.setListener(this);
        return createRecommendationScreen;
    }

    @Override
    protected CreateRecommendationPresenter createPresenter() {
        return new CreateRecommendationPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CreateRecommendationPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TLUserView userView = new TLUserView(getContext());
        userView.setLayoutParams(params);
        userView.setUserImageFromUrl("http://www.w3schools.com/css/img_fjords.jpg");
        userView.setTitle("Jorge Sanmartin");
        userView.setSubTitle("Programador");
        createRecommendationScreen.addUser(userView);

        TLUserView userView1 = new TLUserView(getContext());
        userView1.setLayoutParams(params);
        userView1.setUserImageFromUrl("http://www.w3schools.com/css/img_fjords.jpg");
        userView1.setTitle("Jorge Sanmartin");
        userView1.setSubTitle("Programador");
        createRecommendationScreen.addUser(userView1);

        TLUserView userView2 = new TLUserView(getContext());
        userView2.setLayoutParams(params);
        userView2.setUserImageFromUrl("http://www.w3schools.com/css/img_fjords.jpg");
        userView2.setTitle("Jorge Sanmartin");
        userView2.setSubTitle("Programador");
        createRecommendationScreen.addUser(userView2);

        TLUserView userView3 = new TLUserView(getContext());
        userView3.setLayoutParams(params);
        userView3.setUserImageFromUrl("http://www.w3schools.com/css/img_fjords.jpg");
        userView3.setTitle("Jorge Sanmartin");
        userView3.setSubTitle("Programador");
        createRecommendationScreen.addUser(userView3);

        TLUserView userView4 = new TLUserView(getContext());
        userView4.setLayoutParams(params);
        userView4.setUserImageFromUrl("http://www.w3schools.com/css/img_fjords.jpg");
        userView4.setTitle("Jorge Sanmartin");
        userView4.setSubTitle("Programador");
        createRecommendationScreen.addUser(userView4);
    }

    //endregion

    //region ************** CreateRecommendationPresenter.View **************
    //endregion

    //region ************** CreateRecommendationScreen.Listener **************

    @Override
    public void onAllContactsPressed() {

    }

    @Override
    public void onOnlyFriendsPressed() {

    }
    //endregion
}
