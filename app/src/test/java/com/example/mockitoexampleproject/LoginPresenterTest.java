package com.example.mockitoexampleproject;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import com.example.mockitoexampleproject.data.LoginCredentials;
import com.example.mockitoexampleproject.data.LoginRepository;
import com.example.mockitoexampleproject.data.LoginRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoginPresenterTest {

    private LoginPresenter loginPresenter;

    private LoginCredentials loginCredentials = new LoginCredentials(
            "demo@gmail.com",
            "123456");

    @Mock
    private LoginRepositoryImpl loginRepository;

    @Mock
    private Contract.LoginView loginView;

    @Captor
    private ArgumentCaptor<LoginRepository.LoginListener> loginListenerArgumentCaptor;

    @Before
    public void setUpLoginPresenter() {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(loginRepository, loginView);
    }

    @Test
    public void login() {
        loginPresenter.login(loginCredentials);
        verify(loginRepository).login(eq(loginCredentials), loginListenerArgumentCaptor.capture());

        loginListenerArgumentCaptor.getValue().onSuccess();
        verify(loginView).onSuccess();

        loginListenerArgumentCaptor.getValue().onFailure("Invalid Credentials");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(loginView).onFailed(argumentCaptor.capture());

        assertEquals("Invalid Credentials", argumentCaptor.getValue());
    }

}
