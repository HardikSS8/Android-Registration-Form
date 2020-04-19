package com.example.simpleform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private TextView date, first_name, last_name, email, password, date_of_birth;
    private CheckBox policy;
    private RadioGroup gender_group;
    private RadioButton gender_button;
    private Button select_date;

    private Calendar c;
    private DatePickerDialog dpd;

    DatabaseHelper db = new DatabaseHelper(this);

    InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; ++i)
            {
                if (!Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]*").matcher(String.valueOf(source.charAt(i))).matches())
                {
                    return "";
                }
            }

            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gender_group = findViewById(R.id.genderGroup);

        date = findViewById(R.id.date_of_birth);
        select_date = findViewById(R.id.select_dob);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        date_of_birth = findViewById(R.id.date_of_birth);
        password = findViewById(R.id.password);
        policy = findViewById(R.id.policy);
        first_name = findViewById(R.id.first_name);

        first_name.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(15)});
        last_name.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(15)});
        password.setFilters(new InputFilter[]{filter,new InputFilter.LengthFilter(16)});

        select_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                final int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, day, month, year);
                dpd.show();
            }
        });

        Button b = findViewById(R.id.signUpButtonId);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected_gender = gender_group.getCheckedRadioButtonId();
                gender_button = findViewById(selected_gender);

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String datePattern = "^(1[0-2]|0[1-9])/(3[01]" + "|[12][0-9]|0[1-9])/[0-9]{4}$";


                if (first_name.getText().toString().equals("")) {
                    first_name.setError("Empty first name");
                }  else if (last_name.getText().toString().equals("")) {
                    last_name.setError("Empty last name");
                } else if (email.getText().toString().equals("")) {
                    email.setError("Empty email address");
                } else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Invalid email address");
                } else if (date_of_birth.getText().toString().equals("")) {
                    date_of_birth.setError("Select date of birth");
                } else if (!date_of_birth.getText().toString().trim().matches(datePattern)) {
                    date_of_birth.setError("Date format should be 'mm/dd/yyyy'");
                } else if (password.getText().toString().equals("")) {
                    password.setError("Empty password");
                } else if(!policy.isChecked()) {
                    policy.setError("Policy must be accepted");
                } else {

                    if (first_name.getError() == null && last_name.getError() == null && email.getError() == null &&
                            date_of_birth.getError() == null && password.getError() == null && policy.isChecked()) {

                        addUser(new User(first_name.getText().toString(), last_name.getText().toString(),
                                gender_button.getText().toString(), email.getText().toString(), date_of_birth.getText().toString(),
                                password.getText().toString(), Calendar.getInstance().getTime().toString()));

                        Intent myIntent = new Intent(v.getContext(), UserDataShow.class);
                        startActivity(myIntent);
                    }
                    first_name.setText("");
                    last_name.setText("");
                    email.setText("");
                    date_of_birth.setText("");
                    password.setText("");
                    policy.setChecked(false);
                    policy.setError(null);
                }
            }
        });
    }


    public void addUser(User newUser) {
        boolean insertUser = db.addUser(newUser);
        if(insertUser)
            toastMessage("User added successfully");
        else
            toastMessage("Something went wrong");
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

