package com.example.clf.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.clf.R;
import com.example.clf.activities.ItemDetailsActivity;
import com.example.clf.models.ItemModel;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context context;
    private List<ItemModel> itemList;

    public ItemAdapter(Context context, List<ItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public void updateList(List<ItemModel> newList) {
        itemList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemStatus.setText(item.getStatus());
        holder.itemLocation.setText(item.getLocation());
        holder.itemDate.setText(item.getDate());

        if (item.getStatus().equalsIgnoreCase("Lost")) {
            holder.itemStatus.setBackgroundColor(Color.parseColor("#E53935")); // Red
        } else {
            holder.itemStatus.setBackgroundColor(Color.parseColor("#43A047")); // Green
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ItemDetailsActivity.class);
            intent.putExtra("item", item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemStatus, itemLocation, itemDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemStatus = itemView.findViewById(R.id.itemStatus);
            itemLocation = itemView.findViewById(R.id.itemLocation);
            itemDate = itemView.findViewById(R.id.itemDate);
        }
    }
}