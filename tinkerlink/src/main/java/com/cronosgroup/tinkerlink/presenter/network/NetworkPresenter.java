package com.cronosgroup.tinkerlink.presenter.network;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNetwork;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 6/22/16.
 */
public class NetworkPresenter extends TinkerLinkDialogPresenter<NetworkPresenter.View> {


    // Vars
    private static final int MAX_ITEM = 10;
    private RestNetwork network;
    private final Actions listener;

    /**
     * Network listeners.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        void setNetworkInfo(RestNetwork network);
    }

    /**
     * NetWork actions.
     */
    public interface Actions {
    }

    /**
     * @param navigationListener
     */
    public NetworkPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //Actions

    public void getNetwork() {

        AsyncLoader asyncLoader = new AsyncLoader<RestNetwork>() {
            @Override
            public RestNetwork doInBackground() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                RestNetwork restNetwork = new RestNetwork();

                // set Linker Categories
                List<String> linkcategories = new ArrayList<>();
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");
                linkcategories.add("Reparaciónes");

                // set Linker Categories
                List<String> tinkcategories = new ArrayList<>();
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");
                tinkcategories.add("Reparaciónes");

                // set Contacts
                RestProfile restProfile = new RestProfile();
                restProfile.setProfession("Carpintero");

                RestUser restUser = new RestUser();
                restUser.setName("Jorge Luis");
                restUser.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser.setProfile(restProfile);

                RestUser restUser1 = new RestUser();
                restUser1.setName("Jorge Luis");
                restUser1.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser1.setProfile(restProfile);

                RestUser restUser2 = new RestUser();
                restUser2.setName("Jorge Luis");
                restUser2.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser2.setProfile(restProfile);

                RestUser restUser3 = new RestUser();
                restUser3.setName("Jorge Luis");
                restUser3.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser3.setProfile(restProfile);

                RestUser restUser4 = new RestUser();
                restUser4.setName("Jorge Luis");
                restUser4.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser4.setProfile(restProfile);

                RestUser restUser5 = new RestUser();
                restUser5.setName("Jorge Luis");
                restUser5.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser5.setProfile(restProfile);

                RestUser restUser6 = new RestUser();
                restUser6.setName("Jorge Luis");
                restUser6.setPhoto("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
                restUser6.setProfile(restProfile);

                List<RestUser> contacts = new ArrayList<>();
                contacts.add(restUser);
                contacts.add(restUser1);
                contacts.add(restUser2);
                contacts.add(restUser3);
                contacts.add(restUser4);
                contacts.add(restUser5);
                contacts.add(restUser6);

                restNetwork.setContactsFriend(contacts);
                restNetwork.setLinkerCategories(linkcategories);
                restNetwork.setTinkerCategories(tinkcategories);

                return restNetwork;
            }

            @Override
            public void postProcess(RestNetwork result) {
                network = result;
                getView().setNetworkInfo(result);
            }
        };

        asyncLoader.start();

    }

    private List<String> getCategoriesByPage(int page, List<String> categories) {
        int start = page * MAX_ITEM;
        int end = start + MAX_ITEM;
        int total = categories.size() - end;
        end = (end > categories.size()) ? end - total : end;
        return (end < 0 || end >= categories.size()) ? new ArrayList<String>() : categories.subList(start, end);
    }

    public List<String> getTinkerCategoriesByPage(int page){
        return  getCategoriesByPage(page, network.getTinkerCategories());
    }

    public List<String> getLinkerCategoriesByPage(int page){
        return  getCategoriesByPage(page, network.getLinkerCategories());
    }

}
