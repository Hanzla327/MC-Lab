package com.hanzla.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.hanzla.recycler.Adapter.RecyclerviewAdapter;
import com.hanzla.recycler.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> studentList =new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerviewAdapter recyclerviewAdapter;
    public void removeItem(int position){
        studentList.remove(position);
        recyclerviewAdapter.notifyItemRemoved(position);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList.add(new Student("1","Electrician"));
        studentList.add(new Student("2","Mechanic"));
        studentList.add(new Student("3","Plumber"));
        studentList.add(new Student("4","Carpenter"));
        recyclerviewAdapter=new RecyclerviewAdapter(MainActivity.this,studentList);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerviewAdapter);
        recyclerviewAdapter.setOnItemClickListener(new RecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
                recyclerviewAdapter.notifyDataSetChanged();
            }
        });
    }
}