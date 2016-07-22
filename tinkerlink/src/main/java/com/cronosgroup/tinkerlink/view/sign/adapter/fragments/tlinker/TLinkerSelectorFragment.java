package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.sign.TLinkerSelectorPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;
import com.cronosgroup.tinkerlink.view.interfaces.IOValidationForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class TLinkerSelectorFragment extends MVPTinkerLinkFragment<TLinkerSelectorPresenter, TLinkerSelectorPresenter.View>
        implements TLinkerSelectorPresenter.View, TLinkerSelectorScreen.Listener, IOValidationForm {

    //Vars
    private IOFormListener mCallback;
    private AppUser appUser;
    private RestCategoria categoria;
    private List<String> skillList = new ArrayList<>();

    //Views
    private TLinkerSelectorScreen tLinkerSelectorScreen;

    //region **************  Fragment **************

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (IOFormListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appUser = mCallback.getFormUser();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        tLinkerSelectorScreen = new TLinkerSelectorScreen(getActivity());
        tLinkerSelectorScreen.setListener(this);
        return tLinkerSelectorScreen;
    }

    @Override
    protected TLinkerSelectorPresenter createPresenter() {
        return new TLinkerSelectorPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected TLinkerSelectorPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getCategories();
    }

    //endregion

    //region **************  TLinkerSelectorPresenter.View **************

    @Override
    public void setCategories(List<RestCategoria> categories) {
        tLinkerSelectorScreen.setItems(categories);
    }

    //endregion

    //region **************  LinkerSelectorScreen.Listener **************

    @Override
    public void setCurrentCategorySelected(RestCategoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public void skillSelectAtPosition(int position) {
        int positionOffset = (position - tLinkerSelectorScreen.getItems().indexOf(categoria)) - 1;
        String skill = categoria.getChildItemList().get(positionOffset);
        if (!skill.contains(skill)) {
            skillList.add(skill);
        }
    }

    //endregion

    @Override
    public boolean validationForm() {
        return true;
    }


}
