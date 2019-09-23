package com.example.friends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Friend[] friends = new Friend[4];
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = findViewById(R.id.editLayout);
        v.setVisibility(View.GONE);

        this.friends[0] = new Friend("Jim", "01/01/2000");
        this.friends[1] = new Friend("Bill", "02/02/2000");
        this.friends[2] = new Friend("Kim", "03/03/2000");
        this.friends[3] = new Friend("Bob", "04/04/2000");

        initGrid();
    }

    private void expand(Friend friend){
        Friend[] f = new Friend[this.friends.length + 1];
        for(int i = 0; i < this.friends.length; i++){
            f[i] = this.friends[i];
        }
        f[f.length - 1] = friend;
        this.friends = f;
    }

    public void addFriend(View view){
        EditText etName = findViewById(R.id.nameInput);
        EditText etDate = findViewById(R.id.dateInput);
        String name = etName.getText().toString();
        String birthdate = etDate.getText().toString();

        if(name.equals("") || birthdate.equals("")){
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Friend friend = new Friend(name, birthdate);
            expand(friend);
            Toast.makeText(this, "Friend added", Toast.LENGTH_SHORT).show();
            initGrid();
        }
    }

    private void showFriend(final int i){
        v.setVisibility(View.VISIBLE);
        Friend f = this.friends[i];
        String name = f.getName();
        String birthdate = f.getBirthdate();
        EditText etName = findViewById(R.id.editName);
        EditText etDate = findViewById(R.id.editBirthDate);
        etName.setText(name);
        etDate.setText(birthdate);

        Button editBtn = findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFriend(i);
            }
        });
    }

    private void editFriend(int i){
        Friend f = this.friends[i];
        EditText etName = findViewById(R.id.editName);
        EditText etDate = findViewById(R.id.editBirthDate);
        f.setName(etName.getText().toString());
        f.setBirthdate(etDate.getText().toString());
        v.setVisibility(View.GONE);
        initGrid();
    }

    private void initGrid(){
        GridView grid = findViewById(R.id.gridView);
        grid.setAdapter(new FriendAdapter(this, this.friends));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showFriend(i);
            }
        });
    }
}
