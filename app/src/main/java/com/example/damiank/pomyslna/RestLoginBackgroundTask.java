package com.example.damiank.pomyslna;

import com.example.damiank.pomyslna.data.EmailAndPassword;
import com.example.damiank.pomyslna.data.Recipe;
import com.example.damiank.pomyslna.data.User;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;



@EBean
public class RestLoginBackgroundTask {
 public static Integer zmiena = 3;
    int i  = 0;

    @RootContext
    LoginActivity activity;

    @RestService
    PomyslRestClient restClient;



    @Background
    void login(EmailAndPassword emailAndPassword) {

        try {
            restClient.setHeader("X-Dreamfactory-Application-Name", "phonebook");
            User user = restClient.login(emailAndPassword);
            publishResult(user);
        } catch (Exception e) {
            i++;

            if(i<=zmiena){
                login(emailAndPassword);
            }
            else{
                publishError(e);
            }
        }
    }

    @UiThread
    void publishResult(User user) {
        activity.loginSuccess(user);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}
