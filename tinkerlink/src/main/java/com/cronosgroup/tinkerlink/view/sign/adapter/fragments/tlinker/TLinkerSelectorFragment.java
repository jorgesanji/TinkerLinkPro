package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker;

import android.app.Activity;
import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.presenter.sign.TLinkerSelectorPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.interfaces.IOFormListener;

import java.util.List;

/**
 * Created by jorgesanmartin on 1/29/16.
 */
public class TLinkerSelectorFragment extends MVPTinkerLinkFragment<TLinkerSelectorPresenter, TLinkerSelectorPresenter.View>
        implements TLinkerSelectorPresenter.View, TLinkerSelectorScreen.Listener {

    public static final String KEY_TYPE = "type";

    //Vars
    private IOFormListener mCallback;
    private RestCategoria categoria;
    private int typeTinker;

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

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        typeTinker = getArguments().getInt(KEY_TYPE);
        tLinkerSelectorScreen = new TLinkerSelectorScreen(getActivity(), typeTinker);
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
            mCallback.getFormUser().getSkills().add(skill);
        } else {
            mCallback.getFormUser().getSkills().remove(skill);
        }
    }

    //endregion

}
