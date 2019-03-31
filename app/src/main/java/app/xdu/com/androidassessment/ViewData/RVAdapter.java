package app.xdu.com.androidassessment.ViewData;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import app.xdu.com.androidassessment.R;
import app.xdu.com.androidassessment.UI.UserDetailsActivity;
import app.xdu.com.androidassessment.data.UserDataCache;
import app.xdu.com.androidassessment.data.UserVideos;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

     List<UserVideos> userVideos;
    public RVAdapter(){
        userVideos = UserDataCache.INSTANCE.getUserData().getUserVideos();

    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        UserInfo userInfo = userVideos.get(i).getUserInfo();
        personViewHolder.imageView_VideoImage.setImageBitmap(userInfo.getVideoImage());
        personViewHolder.imageView_ProfileImage.setImageBitmap(userInfo.getProfileImage());
        personViewHolder.textView_Title.setText(userInfo.getVideoTitle());
        personViewHolder.textView_NumberOfViews.setText(String.valueOf(userInfo.getNumberOfViews()));
        personViewHolder.id = userInfo.getId();
    }


    @Override
    public int getItemCount() {
        return userVideos.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cv;
        ImageView imageView_ProfileImage;
        ImageView imageView_VideoImage;
        TextView textView_Title;
        TextView textView_NumberOfViews;
        int id;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            imageView_ProfileImage = itemView.findViewById(R.id.profile);
            imageView_VideoImage = itemView.findViewById(R.id.video);
            textView_Title = itemView.findViewById(R.id.video_title);
            textView_NumberOfViews = itemView.findViewById(R.id.number_of_views);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
            intent.putExtra("id", id);
            v.getContext().startActivity(intent);
        }
    }

}