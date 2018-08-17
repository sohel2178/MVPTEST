package com.linearbd.mvptest.ui.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.linearbd.mvptest.R;
import com.linearbd.mvptest.database.AppDatabase;
import com.linearbd.mvptest.database.entity.Person;
import com.linearbd.mvptest.ui.edit.EditActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private PeopleAdapter mPeopleAdapter;

    private TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmptyTextView = (TextView) findViewById(R.id.emptyTextView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNewPerson();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPeopleAdapter = new PeopleAdapter();
        recyclerView.setAdapter(mPeopleAdapter);

        AppDatabase db = AppDatabase.getDatabase(getApplication());
        mPresenter = new MainPresenter(this, db.personModel());
    }


    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.populatePeople();
    }

    @Override
    public void setPersons(List<Person> persons) {

        mEmptyTextView.setVisibility(View.GONE);
        mPeopleAdapter.setValues(persons);

    }

    @Override
    public void showEmptyMessage() {
        mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddPerson() {

        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
