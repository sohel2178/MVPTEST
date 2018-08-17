package com.linearbd.mvptest.ui.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.linearbd.mvptest.database.dao.PersonDao;
import com.linearbd.mvptest.database.entity.Person;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View mView;
    private final PersonDao personDao;


    public MainPresenter(MainContract.View view, PersonDao personDao) {
        this.personDao = personDao;
        this.mView = view;
    }

    @Override
    public void populatePeople() {
        personDao.findAllPersons().observeForever(new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> peoples) {
                mView.setPersons(peoples);

                if (peoples == null || peoples.size() < 1) {
                    mView.showEmptyMessage();
                }
            }
        });

    }

    @Override
    public void addNewPerson() {

        mView.showAddPerson();

    }

    @Override
    public void start() {

    }
}
