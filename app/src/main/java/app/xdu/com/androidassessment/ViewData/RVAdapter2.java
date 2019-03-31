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
import app.xdu.com.androidassessment.data.VideoDetail;


public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter2.VideoViewHolder> {


    List<VideoDetail> detailList;

    public RVAdapter2() {
        detailList = UserDataCache.INSTANCE.getUserData().getVideoDetails();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item, viewGroup, false);
        VideoViewHolder pvh = new VideoViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder personViewHolder, int i) {
        VideoDetailInfo itemInfo = detailList.get(i).getVideoDetailInfo();
        personViewHolder.imageView_VideoImage.setImageBitmap(itemInfo.getVideoImage());
        personViewHolder.textView_Title.setText(itemInfo.getVideoTitle());
        personViewHolder.textView_Duration.setText(String.valueOf(itemInfo.getDuration()));
    }


    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        ImageView imageView_VideoImage;
        TextView textView_Title;
        TextView textView_Duration;
        int id;

        VideoViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv2);
            imageView_VideoImage = itemView.findViewById(R.id.video);
            textView_Title = itemView.findViewById(R.id.video_name);
            textView_Duration = itemView.findViewById(R.id.duration);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
            intent.putExtra("id", id);
           // v.getContext().startActivity(intent);
        }
    }

}
