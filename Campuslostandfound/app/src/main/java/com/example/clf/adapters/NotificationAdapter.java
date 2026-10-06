package com.example.clf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.R;
import com.example.clf.models.NotificationModel;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private Context context;
    private List<NotificationModel> notifList;

    public NotificationAdapter(Context context, List<NotificationModel> notifList) {
        this.context = context;
        this.notifList = notifList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationModel notif = notifList.get(position);
        holder.title.setText(notif.getTitle());
        holder.message.setText(notif.getMessage());
        holder.time.setText(notif.getTime());
    }

    @Override
    public int getItemCount() {
        return notifList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, message, time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notifTitle);
            message = itemView.findViewById(R.id.notifMessage);
            time = itemView.findViewById(R.id.notifTime);
        }
    }
}