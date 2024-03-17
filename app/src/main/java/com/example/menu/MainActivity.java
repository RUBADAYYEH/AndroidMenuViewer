package com.example.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.menu.Model.Repository;

public class MainActivity extends AppCompatActivity {
    Spinner spnn;
    Button srchBtn;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setUpViews();
        populateSpinner();
        srchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository repo=new Repository();
               String cat=spnn.getSelectedItem().toString();
               MenuItem[] arr=repo.getByCat(cat).toArray(new MenuItem[0]);
               ArrayAdapter<MenuItem> adapter=new ArrayAdapter<MenuItem>(MainActivity.this, android.R.layout.simple_list_item_1,arr);
               lstView.setAdapter(adapter);
            }
        });

    }

    private void populateSpinner() {
        Repository repo=new Repository();
        String[] cats=repo.getCats();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cats);
        spnn.setAdapter(adapter);
    }

    private void setUpViews() {
        spnn=findViewById(R.id.spnn);
        srchBtn=findViewById(R.id.srchBtn);
        lstView=findViewById(R.id.lstView);
    }
}