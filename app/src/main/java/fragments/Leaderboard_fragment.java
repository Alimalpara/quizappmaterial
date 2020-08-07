package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.avcpln.quizappmaterial.R;


public class Leaderboard_fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.fragment_leaderboard, container, false);

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
