package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import com.avcpln.quizappmaterial.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile_fragment extends Fragment  {
    FloatingActionButton floatingActionButton;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        setHasOptionsMenu(true);

        floatingActionButton=view.findViewById(R.id.fabEditProfile);
        /*floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(getActivity(), Edit_Profile.class);
               // startActivity(intent);
            }
        });*/
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.logout_btn:
                Toast.makeText(getActivity(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout1:
                Toast.makeText(getActivity(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            /*case R.id.l:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
