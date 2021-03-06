package com.kgcorner.lluvia.data;

import com.kgcorner.lluvia.model.Application;
import com.kgcorner.util.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by admin on 3/28/2018.
 */
public class ApplicationStore {
    private static final ApplicationStore INSTANCE = new ApplicationStore();
    private final Map<String, Application> APPLICATIONS;
    private final Map<String, Application> APPLICATIONS_BEARER;

    private ApplicationStore() {
        APPLICATIONS = new HashMap<>();
        APPLICATIONS_BEARER = new HashMap<>();
    }

    /**
     * Get instance of {@link ApplicationStore}
     * @return
     */
    public static ApplicationStore getInstance() {
        return INSTANCE;
    }

    /**
     * App Application to Application Store
     * @param application
     */
    public void addApplication(Application application) {
        this.APPLICATIONS.put(application.getApplicationId(), application);
    }

    /**
     * Get application by Application Id
     * @param applicationId
     * @return
     */
    public Application getApplication(String applicationId) {
        return APPLICATIONS.get(applicationId);
    }

    /**
     * Set Application's Bearer Token
     * @param bearerToken
     * @param applicationId
     */
    public void setBearer(String bearerToken, String applicationId) {
        if(Strings.isNullOrEmpty(bearerToken)) {
            throw new IllegalArgumentException("Bearer token can't be null or empty");
        }

        if(Strings.isNullOrEmpty(applicationId)) {
            throw new IllegalArgumentException("Application Id can't be null or empty");
        }

        Application app = APPLICATIONS.get(applicationId);
        if(app == null) {
            throw new IllegalArgumentException("Application not found with id:"+applicationId);
        }

        APPLICATIONS_BEARER.put(bearerToken, app);
    }

    /**
     * Get Application by Bearer Token
     * @param bearerToken
     * @return
     */
    public Application getApplicationByBearer(String bearerToken) {
        if(!Strings.isNullOrEmpty(bearerToken)) {
            throw new IllegalArgumentException("Bearer token can't be null or empty");
        }
        return APPLICATIONS_BEARER.get(bearerToken);
    }


}
