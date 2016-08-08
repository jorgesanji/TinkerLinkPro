package com.cronosgroup.tinkerlink.interfaces;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;

import java.util.List;

/**
 * Created by jorgesanmartin on 2/24/16.
 */
public interface IOLoadRecomendations {
    void onLoadRecommendations(List<RestRecomendacion> list);
}