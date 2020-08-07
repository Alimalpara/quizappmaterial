package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.avcpln.quizappmaterial.R;

import java.util.ArrayList;

import models.home_list;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
Context context;
ArrayList<home_list> data;

    public HomeAdapter(Context context, ArrayList<home_list> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        home_list home_list=data.get(position);
        holder.name.setText(home_list.getName());

        /*Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        int[] colors = {Color.parseColor("#224abe"),Color.parseColor("#89A2F0")};

        //create a new gradient color
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, colors);


        gd.setCornerRadius(0f);

        //apply the button background to newly created drawable gradient

        //holder.parent.setBackground(gd);*/
        //holder.imagehome.setImageResource(R.drawable.rc_back);

for (int i=0;i<=position;i++){
    if(i==0 ||i%5==0 ){
        holder.imagehome.setImageResource(R.drawable.rc_back);
        holder.parent.setBackgroundResource(R.drawable.gradient_0);
    }else if(i%2==0 && (i%4!=0) ){
        holder.imagehome.setImageResource(R.drawable.ic_store_black_24dp);
        holder.parent.setBackgroundResource(R.drawable.gradient_2);

    }else if(i%3==0 || i%6==0){
        holder.imagehome.setImageResource(R.drawable.ic_wc_black_24dp);
        holder.parent.setBackgroundResource(R.drawable.gradient_3);

    }else {
        holder.imagehome.setImageResource(R.drawable.ic_style_black_24dp);
        holder.parent.setBackgroundResource(R.drawable.gradient_else);

    }
}


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imagehome;
        ConstraintLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvnameListing);
            imagehome=itemView.findViewById(R.id.imageView);
            parent=itemView.findViewById(R.id.parent);

        }
    }
}
