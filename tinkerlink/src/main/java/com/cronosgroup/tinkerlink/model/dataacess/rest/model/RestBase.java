package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import java.io.Serializable;

/**
 * Created by jorgesanmartin on 12/4/15.
 */
public class RestBase implements Serializable {
    protected String removeQuoationMarks(String value) {
        return (value != null) ? value.replace("\"", "") : "";
    }

    protected String removeBackSlash(String value) {
        return (value != null) ? value.replace("\\", "") : "";
    }
}
