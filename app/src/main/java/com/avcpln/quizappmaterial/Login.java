package com.avcpln.quizappmaterial;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.DecimalMin;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Util.Constants;
import Util.Helper;
import Util.PrefManager;

import static com.android.volley.Request.Method.POST;

public class Login extends AppCompatActivity implements Validator.ValidationListener {
    Button login;
    TextView register;
    TextInputLayout mobilee,pass;
    PrefManager pref;
    String mob,pw;
    @NotEmpty
    @DecimalMin(value = 0000000000,message = "Should be 10 digits")
           // @DecimalMax(value = 10,message = "Should be 10 digits")

    TextInputEditText mobile;

    @NotEmpty
    @Password(message = "Password must contain Alphanumeric 6 gigit",scheme = Password.Scheme.ALPHA)
    TextInputEditText password;
     Validator validator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();
        initview();

        pref=new PrefManager(getApplicationContext());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Registration.class));
            }
        });


        validator = new Validator(this);
        validator.setValidationListener((Validator.ValidationListener) this);


        login=findViewById(R.id.btn_Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getError()==null){
                    pass.setError(null);
                }if(mobile.getError()==null){
                    mobilee.setError(null);
                }
                validator.validate();

            }

        });

        password.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( password.getText().length()>0)
                {
                    pass.setError(null);
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

    private void initview() {
        mobile=findViewById(R.id.tiMobile);
        password=findViewById(R.id.tiPassword);
        mobilee=findViewById(R.id.Mobile);
        pass=findViewById(R.id.etPassword);
        register=findViewById(R.id.tvRegister);
    }
//total logic for login
    private void login() {
  /*JSONObject user_data=new JSONObject();
        try {
            user_data.put("contact_no",mob);
            user_data.put("password",pw);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST,url,user_data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String res=response.getString("Cookie");
                    pref.setCookie(res);
                    //pref=getSharedPreferences(PrefManager);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Cookie " + pref.getCookie());
                return headers;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(request);*/

        /*getEditTextData();
        String url= Constants.LOGIN_URL;

        StringRequest request=new StringRequest(POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                startActivity(new Intent(Login.this,Home.class));


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
                            Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();
                        }

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        Helper.VolleyErrorMessage(getApplicationContext(),error);
                    }
                }

                else {
                    Helper.VolleyErrorMessage(getApplicationContext(),error);

                }

            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                Map<String, String> responseHeader = new HashMap<>();
                String rawcookie=responseHeader.get("Set-Cookie");
                pref.setCookie(rawcookie);

                return super.parseNetworkResponse(response);

            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> headers = new HashMap<String, String>();
                headers.put("contact_no",mob);
                headers.put("password",pw);

                return headers;
            }
        };

MySingleton.getInstance(this).addToRequestQueue(request);*/
        getEditTextData();
        String url=Constants.LOGIN_URL;

        StringRequest request=new StringRequest(POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                startActivity(new Intent(Login.this,Home.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if(error.networkResponse!=null && error.networkResponse.statusCode==422){

                    String res= null;
                    try {
                        res = new String(error.networkResponse.data,"UTF-8");
                        JSONObject object=new JSONObject(res);
                        Iterator<String> keys=object.keys();
                        if(keys.hasNext()){
                            String key=keys.next();
                            String msg=object.getString(key);
                            Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();

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
                String rawcookie=res.get("Set-Cookie");
                pref.setCookie(rawcookie);


                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getParams() {
                Map<String,String> headers=new HashMap<>();
                headers.put("contact_no",mob);
                headers.put("password",pw);
              headers.put("fcm_id","xyz");

                return headers;
            }
        };

        MySingleton.getInstance(this).addToRequestQueue(request);

    }


    private void getEditTextData() {

         mob=mobile.getText().toString();
        pw=password.getText().toString();
    }

    @Override
    public void onValidationSucceeded() {
        //Toast.makeText(this, "Yay! we got it right!", Toast.LENGTH_SHORT).show();

        //startActivity(new Intent(Login.this,Home.class));

        login();
    }



    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view==mobile) {
                mobilee.setError(message);

            }
             if(view==password) {
                pass.setError(message);
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




    }


 class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context ctx;

    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}


