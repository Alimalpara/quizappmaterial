package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.avcpln.quizapp.Edit_Profile;
import com.avcpln.quizapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile_fragment extends Fragment  {
    FloatingActionButton floatingActionButton;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        floatingActionButton=view.findViewById(R.id.fabEditProfile);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Edit_Profile.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
