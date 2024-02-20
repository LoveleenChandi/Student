package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText editTextStudentID, editTextName, editTextAge, editTextAddress, editTextEmail;
    private Button buttonRegister;
    private DatabaseReference studentsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        studentsRef = database.getReference("students");

        // Initialize views
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);

        buttonRegister = findViewById(R.id.buttonRegister);

        // Set onClickListener for registration button
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });
    }

    private void registerStudent() {
        String studentID = editTextStudentID.getText().toString().trim();
        String studentName = editTextName.getText().toString().trim();
        String studentAge = editTextAge.getText().toString().trim();
        String studentAddress = editTextAddress.getText().toString().trim();
        String studentEmail = editTextEmail.getText().toString().trim();

        if(studentName.isEmpty() || studentName.length()<5){
            showError(editTextName,"Your Name is not valid");
            return;
        }
        else if(studentEmail.isEmpty()||!studentEmail.contains("@")){
            showError(editTextEmail,"Your Email is not valid");
            return;
        }

        Student student = new Student(studentID, studentName, studentAge, studentAddress, studentEmail);
        studentsRef.push().setValue(student);
        Toast.makeText(this,"Student registered successfully",Toast.LENGTH_SHORT).show();
        clearFields();
    }

    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }

    private void clearFields(){
        editTextStudentID.setText("");
        editTextName.setText("");
        editTextAge.setText("");
        editTextAddress.setText("");
        editTextEmail.setText("");
    }
}