package Util;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.avcpln.quizappmaterial.R;

import java.util.Calendar;
import java.util.Locale;


public class Helper {
    public static void VolleyErrorMessage(Context context, VolleyError error)
    {
        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
            //This indicates that the reuest has either time out or there is no connection
            Toast.makeText(context, "Connection Timeout , Please try again later. (CODE:)", Toast.LENGTH_SHORT).show();
        } else if (error instanceof AuthFailureError) {
            //Error indicating that there was an Authentication Failure while performing the request
            Toast.makeText(context, "Invalid Mobile No or Password.", Toast.LENGTH_SHORT).show();
        } else if (error instanceof ServerError) {
            //Indicates that the server responded with a error response
            Toast.makeText(context, "Something went wrong, Please try again later.", Toast.LENGTH_SHORT).show();
        } else if (error instanceof NetworkError) {
            //Indicates that there was network error while performing the request
            Toast.makeText(context, "Can't connect , Please check network.", Toast.LENGTH_SHORT).show();
        } else if (error instanceof ParseError) {
            // Indicates that the server response could not be parsed
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show();
        }
    }
    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("dd-MM-yyyy", cal).toString();
        return date;
    }
    public static String getDateTime(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);
        String date = DateFormat.format("yyyy-MM-dd HH:mm:ss", cal).toString();
        return date;
    }
  /*  public  static int getGradiant(int i)
    {
        if(i == 1)
        {
            return R.drawable.gradient_1;
        }
        else if(i == 2)
        {
            return R.drawable.gradient_2;
        }
        else if(i == 3)
        {
            return R.drawable.gradient_3;
        }
        else if(i == 4)
        {
            return R.drawable.gradient_4;
        }
        else if(i == 5)
        {
            return R.drawable.gradient_5;
        }
        else
        {
            return R.drawable.gradient_1;
        }
    }*/
}

