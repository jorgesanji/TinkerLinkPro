package com.cronosgroup.tinkerlink.view.searchcard;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.presenter.searchcard.SearchCardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * SearchCard Fragment
 */
public class SearchCardFragment extends MVPTinkerLinkFragment<SearchCardPresenter, SearchCardPresenter.View>
        implements SearchCardPresenter.View, SearchCardScreen.Listener {

    private SearchCardScreen searchCardScreen;
    private StackCard stackType;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView(((SearchCardActivity) getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                      @Override
                                      public boolean onQueryTextSubmit(String query) {
                                          return false;
                                      }

                                      @Override
                                      public boolean onQueryTextChange(String newText) {
                                          return false;
                                      }
                                  }
        );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected View getRootView() {
        searchCardScreen = new SearchCardScreen(getActivity(), this);
        return searchCardScreen;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected SearchCardPresenter createPresenter() {
        return new SearchCardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected SearchCardPresenter.View getPresenterView() {
        return this;
    }

    //region **************  SearchCardScreen.Listener **************

    //endregion

    //region **************  SearchCardPresenter.View **************

    //endregion
}
