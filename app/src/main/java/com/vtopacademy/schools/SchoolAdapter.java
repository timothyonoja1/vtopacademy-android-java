package com.vtopacademy.schools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vtopacademy.OnItemClickListener;
import com.vtopacademy.R;
import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolHolder> {

    private final List<School> schools;
    private final OnItemClickListener<School> onItemClickListener;

    public SchoolAdapter(List<School> categories,
                         OnItemClickListener<School> onItemClickListener) {
        this.schools = categories;
        this.onItemClickListener = onItemClickListener;
    }

    protected static class SchoolHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private School school;
        private OnItemClickListener<School> onItemClickListener;

        public SchoolHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(CLickedView -> onItemClickListener.onItemClick(school));
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(School school, OnItemClickListener<School> onItemClickListener) {
            this.school = school;
            textView.setText(school.getName());
            this.onItemClickListener = onItemClickListener;
        }
    }

    @NonNull
    @Override
    public SchoolHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_school, viewGroup, false);
        return new SchoolHolder(view);
    }

    @Override
    public void onBindViewHolder(SchoolHolder holder, final int position) {
        holder.bind(schools.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }
}

