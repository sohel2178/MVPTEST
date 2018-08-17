package com.linearbd.mvptest.ui.edit;

import com.linearbd.mvptest.BasePresenter;
import com.linearbd.mvptest.BaseView;
import com.linearbd.mvptest.database.entity.Person;

import java.util.Date;

public interface EditContract {

    interface Presenter extends BasePresenter{

        void save(Person person);

        boolean validate(Person person);

        void showDateDialog();

        void getPersonAndPopulate(long id);

        void update(Person person);

        void onDateClick();

    }

    interface View extends BaseView<Presenter>{

        void showErrorMessage(int field);

        void clearPreErrors();

        void openDateDialog();

        void close();

        void populate(Person person);

        void setSelectedDate(Date date);

    }
}
