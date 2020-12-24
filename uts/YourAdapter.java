package com.example.uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class YourAdapter extends RecyclerView.Adapter<YourAdapter.YourViewHolder> {

    String d1[], d2[];
    Context contexts;

    public YourAdapter(Context ct, String s1[], String s2[]) {
        contexts = ct;
        d1 = s1;
        d2 = s2;
    }

    @NonNull
    @Override
    public YourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexts);
        View view = inflater.inflate(R.layout.yourrow, parent, false);
        return new YourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourViewHolder holder, int position) {
        holder.view1.setText(d1[position]);
        holder.view2.setText(d2[position]);
    }

    @Override
    public int getItemCount() {
        return d1.length;
    }

    public class YourViewHolder extends RecyclerView.ViewHolder {
        TextView view1, view2;
        public YourViewHolder(@NonNull View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.nameView);
            view2 = itemView.findViewById(R.id.desView);
        }
    }
}
