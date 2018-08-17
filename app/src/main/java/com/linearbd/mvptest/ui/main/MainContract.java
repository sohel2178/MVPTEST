package com.linearbd.mvptest.ui.main;

import com.linearbd.mvptest.BasePresenter;
import com.linearbd.mvptest.BaseView;
import com.linearbd.mvptest.database.entity.Person;

import java.util.List;

public interface MainContract {

    interface Presenter extends BasePresenter{
        void populatePeople();

        void addNewPerson();
    }

    interface View extends BaseView<MainContract.Presenter>{

        void setPersons(List<Person> persons);

        void showEmptyMessage();

        void showAddPerson();

    }
}
