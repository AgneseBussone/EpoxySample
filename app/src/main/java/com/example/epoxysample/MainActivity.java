package com.example.epoxysample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.airbnb.epoxy.EpoxyVisibilityTracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements Controller.ControllerI {

    private List<Data> dataset1 = new ArrayList<>();
    private List<Data> dataset2 = new ArrayList<>();
    private List<Data> dataset3 = new ArrayList<>();

    private Set<String> ids = new HashSet<>();

    private TextView count;

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = findViewById(R.id.count);
        EpoxyRecyclerView rv = findViewById(R.id.epoxyRecyclerView);

        fetchData();

        controller = new Controller(this);
        rv.setAdapter(controller.getAdapter());

        EpoxyVisibilityTracker visibilityTracker = new EpoxyVisibilityTracker();
        visibilityTracker.attach(rv);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void visible(String id) {
        ids.add(id);
        count.setText(String.format("Fully visible views count = %d", ids.size()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        controller.clearDataset();
        ids.clear();

        switch (id) {
            case R.id.set1:
                controller.setDataset(dataset1);
                break;
            case R.id.set2:
                controller.setDataset(dataset2);
                break;
            case R.id.set3:
                controller.setDataset(dataset3);
                break;
        }

        controller.requestModelBuild();

        return super.onOptionsItemSelected(item);
    }

    // fake data. These comes from the server
    private void fetchData() {
        dataset1.add(new Data("9c1ZnXN", "data with id 9c1ZnXN"));
        dataset1.add(new Data("12cxEGT", "data with id 12cxEGT"));
        dataset1.add(new Data("85e8L1b", "data with id 85e8L1b"));
        dataset1.add(new Data("e5cEI6T", "data with id e5cEI6T"));
        dataset1.add(new Data("c27QurT", "data with id c27QurT"));
        dataset1.add(new Data("30bVurT", "data with id 30bVurT"));
        dataset1.add(new Data("687YI6T", "data with id 687YI6T"));
        dataset1.add(new Data("db1AI6T", "data with id db1AI6T"));
        dataset1.add(new Data("d0cw0oT", "data with id d0cw0oT"));
        dataset1.add(new Data("430NntT", "data with id 430NntT"));
        dataset1.add(new Data("fa5muoT", "data with id fa5muoT"));
        dataset1.add(new Data("e94TjXN", "data with id e94TjXN"));
        dataset1.add(new Data("cd4RjXN", "data with id cd4RjXN"));
        dataset1.add(new Data("cc7Cg1b", "data with id cc7Cg1b"));
        dataset1.add(new Data("e23rerT", "data with id e23rerT"));
        dataset1.add(new Data("07dFqoT", "data with id 07dFqoT"));
        dataset1.add(new Data("e4btDrT", "data with id e4btDrT"));
        dataset1.add(new Data("7e9h9oT", "data with id 7e9h9oT"));
        dataset1.add(new Data("2f6KgST", "data with id 2f6KgST"));
        dataset1.add(new Data("770LVtT", "data with id 770LVtT"));
        dataset1.add(new Data("020yKoT", "data with id 020yKoT"));
        dataset1.add(new Data("9deRzuT", "data with id 9deRzuT"));
        dataset1.add(new Data("94aogoT", "data with id 94aogoT"));
        dataset1.add(new Data("7b4l4rT", "data with id 7b4l4rT"));

        dataset2.add(new Data("c881OKST", "data with id c881OKST"));
        dataset2.add(new Data("183es0oT", "data with id 183es0oT"));

        dataset3.add(new Data("fc1eucoT", "data with id fc1eucoT"));
        dataset3.add(new Data("4d94SFtT", "data with id 4d94SFtT"));
        dataset3.add(new Data("84eaqRyb", "data with id 84eaqRyb"));
        dataset3.add(new Data("b134QDrT", "data with id b134QDrT"));
        dataset3.add(new Data("4339wR6T", "data with id 4339wR6T"));
        dataset3.add(new Data("453dxtoT", "data with id 453dxtoT"));
        dataset3.add(new Data("6e1dPioT", "data with id 6e1dPioT"));
        dataset3.add(new Data("1605OeoT", "data with id 1605OeoT"));
        dataset3.add(new Data("0eebKMyb", "data with id 0eebKMyb"));
        dataset3.add(new Data("35f9vKrT", "data with id 35f9vKrT"));
    }

}
