package com.example.mockitoexampleproject;


import com.example.mockitoexampleproject.data.LoginCredentials;

public interface Contract {

    interface LoginView {

        void onSuccess();

        void onFailed(String message);

    }

    interface Presenter {

        void login(LoginCredentials loginCredentials);

    }

}
