package com.leenak0.swurent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.delete;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{

    //Button btn_delete;
    private ArrayList<Data_recyclerview> listData = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_history_item, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(Data_recyclerview data) {
        listData.add(data);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text_reservation_date, text_reservation_time, text_reservation_building, text_reservation_classroom;
        //private Button btn_delete;

        //private ImageView imageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            text_reservation_date = itemView.findViewById(R.id.text_reservation_date);
            text_reservation_time = itemView.findViewById(R.id.text_reservation_time);
            text_reservation_building = itemView.findViewById(R.id.text_reservation_building);
            text_reservation_classroom = itemView.findViewById(R.id.text_reservation_classroom);
            //btn_delete = itemView.findViewById(R.id.btn_delete);

            //imageView = itemView.findViewById(R.id.imageView);
        }

        void onBind(Data_recyclerview data) {
            text_reservation_date.setText(data.getDate());
            text_reservation_time.setText(data.getTime());
            text_reservation_building.setText(data.getBuilding());
            text_reservation_classroom.setText(data.getClassroom());
            //imageView.setImageResource(data.getResId());
        }
    }
}
