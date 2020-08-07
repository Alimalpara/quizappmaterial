package com.avcpln.quizappmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.DecimalMin;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Util.Constants;
import Util.Helper;
import Util.PrefManager;

import static com.android.volley.Request.Method.POST;

public class Registration extends AppCompatActivity implements Validator.ValidationListener{
    private TextInputLayout etRegistrationMobile,etRegistrationConfirmPassword,
            etRegistrationEmail,etRegistrationFirstname,
            etRegistrationLastName,etRegistrationPassword,spn_medium;
    Validator validator;

    String email,password,fname,lname,medium,contact;

    Button btn_Registration;
    @Length(min = 3,message = "must be atleast 3 char")
    @NotEmpty
    private TextInputEditText tietFname,tietLname;

    @NotEmpty
    @Email()
    private TextInputEditText tietEmail;

 //anno for mobile no
    @NotEmpty
    @DecimalMin(value = 0000000000,message = "Should be 10 digits")
    // @DecimalMax(value = 10,message = "Should be 10 digits")
    private TextInputEditText tietMobile;

//anno for pass and confirmpass
    @NotEmpty
    @Password(message = "Password must contain Alphanumeric 6 digit",scheme = Password.Scheme.ALPHA)
    private TextInputEditText tietConfirmpass,tietPassword;


    AutoCompleteTextView dropdown;
    TextView login;

    @NotEmpty(message = "Select a medium")
    AutoCompleteTextView actv;
    String confrimpassword;

    PrefManager pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.getSupportActionBar().hide();
//click event on login button
        login=findViewById(R.id.tvLoginscreen);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

        pref= new PrefManager(this.getApplicationContext());
        initViews();
//adapter and init for spinner
        String[] items = new String[]{"English", "Hindi", "Gujarati"};
        //Creating the instance of ArrayAdapter containing list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, items);
        //Getting the instance of AutoCompleteTextView
        actv = (AutoCompleteTextView) findViewById(R.id.dropdown);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView

       /* Spinner dropdown = findViewById(R.id.spn_medium);
//create a list of items for the spinner.
        String[] items = new String[]{"Select medium","English", "Hindi", "Gujarati"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/

       getEditTextData();
//for validation
        validator = new Validator(this);
        validator.setValidationListener((Validator.ValidationListener) this);
//click event on register button
        btn_Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*if(tietLname.getError()==null){
                    etRegistrationMobile.setError(null);
                }if(tietEmail.getError()==null){
                    etRegistrationEmail.setError(null);
                }if(tietFname.getError()==null){
                    etRegistrationFirstname.setError(null);
                }if(tietLname.getError()==null){
                    etRegistrationLastName.setError(null);
                }if(tietConfirmpass.getError()==null){
                    etRegistrationConfirmPassword.setError(null);
                }if(tietPassword.getError()==null){
                    etRegistrationPassword.setError(null);
                }
                if(actv.getError()==null){
                    spn_medium.setError(null);
                }*/

                validator.validate();
            }
        });


//for passsword visibilty toggle
        tietPassword.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( tietPassword.getText().length()>0)
                {
                    etRegistrationPassword.setError(null);
                }
            }


            public void afterTextChanged(Editable edt){
              /*  if( password.getText().length()>0)
                {
                    pass.setError(null);
                }*/
            }

        });
        tietConfirmpass.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( tietConfirmpass.getText().length()>0)
                {
                    tietConfirmpass.setError(null);
                }
            }


            public void afterTextChanged(Editable edt){
              /*  if( password.getText().length()>0)
                {
                    pass.setError(null);
                }*/
            }

        });
    }




    @Override
    public void onValidationSucceeded() {
        getEditTextData();
        if(password.equals(confrimpassword)){
           //
            Registration_method();
        }else {

            etRegistrationConfirmPassword.setError("Password doesnot match");
        }

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)

            if(view instanceof  TextInputEditText|| view instanceof AutoCompleteTextView){
                try {
                    ( (TextInputLayout)view.getParent().getParent()).setError(message);


                }catch (Exception e){
                    ((EditText)view).setError(message);

                }

            }
/*

                    if (password.getText().toString().length() == 0 ) {
                        pass.setError("Password should not be empty");

                    } else if(password.getText().toString().length() < 6) {
                        pass.setError("Password must contain 6 char");

                        String pass = "enter correct password";
                        password.setError(pass);
                    }else {
                        pass.setError(message);
                    }


                if (mobile.getText().toString().length() == 0 ) {
                    mobilee.setError("Mobile should not be empty");

                } else if(mobile.getText().toString().length() < 10) {
                    mobilee.setError("Password must contain 10 char");

                        String pass = "enter correct password";
                        password.setError(pass);
                }else {
                    mobilee.setError(message);
                }


*/







        }

    }

    private void initViews(){
        etRegistrationMobile =  findViewById(R.id.etRegistrationMobile);

        etRegistrationConfirmPassword =  findViewById(R.id.etRegistrationConfirmPassword);
        etRegistrationEmail =  findViewById(R.id.etRegistrationEmail);
        etRegistrationFirstname =  findViewById(R.id.etRegistrationFirstname);
        etRegistrationLastName =  findViewById(R.id.etRegistrationLastName);
        etRegistrationPassword =  findViewById(R.id.etRegistrationPassword);
        spn_medium=  findViewById(R.id.spn_medium);

        tietMobile =  findViewById(R.id.tietMobile);
        tietConfirmpass =  findViewById(R.id.tietConfirmpass);
        tietEmail =  findViewById(R.id.tietEmail);
        tietFname =  findViewById(R.id.tietFname);
        tietLname =  findViewById(R.id.tietLname);
        tietPassword =  findViewById(R.id.tietPassword);

        btn_Registration=findViewById(R.id.btn_Registration);
    }

    public void getEditTextData(){

        contact=tietMobile.getText().toString();
        email=tietEmail.getText().toString();
        fname=tietFname.getText().toString();
        lname=tietLname.getText().toString();
        password=tietPassword.getText().toString();
        confrimpassword=tietConfirmpass.getText().toString();
        medium=actv.getText().toString();
    }


    public void Registration_method(){
        getEditTextData();
        String url= Constants.REGISTER_URL;

        StringRequest request=new StringRequest(POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registration.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Registration.this,Login.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error.networkResponse!=null && error.networkResponse.statusCode==422){
                    try {
                        String response=new String(error.networkResponse.data,"UTF-8");
                        JSONObject object=new JSONObject(response);
                        Iterator<String> keys=object.keys();
                        if(keys.hasNext()){
                            String key=keys.next();
                            String msg=object.getString(key);
                            Toast.makeText(Registration.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Helper.VolleyErrorMessage(getApplicationContext(),error);
                }
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                Map<String,String> res=new HashMap<>();
               String raw_cookie= res.get("Set-Cookie");
               pref.setCookie(raw_cookie);

                return super.parseNetworkResponse(response);
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String,String> headers=new HashMap<>();

                headers.put("contact_no",contact);
                headers.put("password",password);
                headers.put("email",email);
                headers.put("medium",medium);
                headers.put("first_name",fname);
                headers.put("last_name",lname);
                headers.put("class","Class 11th");
                headers.put("fcm_id","xyz");

                return headers;
            }
        };

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);

    }

}


