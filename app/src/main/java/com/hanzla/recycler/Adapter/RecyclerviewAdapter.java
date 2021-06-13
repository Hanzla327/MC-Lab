package com.hanzla.recycler.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanzla.recycler.Model.Student;
import com.hanzla.recycler.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
   private Context context;
   private List<Student> studentList;
    private  OnItemClickListener buttonListener;

    public interface  OnItemClickListener{
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        buttonListener = listener;

    }
    public RecyclerviewAdapter() {
    }

    public RecyclerviewAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardd,parent,false);

        return new ViewHolder(view,buttonListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder holder, int position) {
    Student student =studentList.get(position);
    holder.txtName.setText(student.getName());
    holder.txtRollNo.setText(student.getRollNo());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView_dlt;
        TextView txtName,txtRollNo;
        public ViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtRollNo =itemView.findViewById(R.id.txtRollNo);
            imageView_dlt=itemView.findViewById(R.id.img_dlt);
                imageView_dlt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(listener != null) {
                            int position = getAdapterPosition();
                            if(position != RecyclerView.NO_POSITION){
                                listener.onDeleteClick(position);
                            }
                        }
                    }
                });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
