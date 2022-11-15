package com.lexass.aaaaaaaaaaaaa;

import android.content.Intent;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import com.lexass.aaaaaaaaaaaaa.databinding.ItemListBinding;

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.MyViewHolder>{

    private List<Beauty> mBeautis =  new ArrayList<>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)  {
        Beauty beauty = mBeautis.get(position);
        holder.bindView(beauty);
    }
    @Override
    public int getItemCount() {
        return mBeautis.size();
    }
    public void setBeauty(List<Beauty> beauty){
        this.mBeautis = beauty;
        notifyDataSetChanged();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding binding;
        TextView nameTxt,beautyTxt,clientTxt,time;

        public MyViewHolder(ItemListBinding binding){
            super(binding.getRoot());
            this.binding = binding;


            itemView.findViewById(R.id.buttony).setOnClickListener(view -> {
                Calendar alarm = new GregorianCalendar(TimeZone.getDefault());
                int hour = alarm.get(Calendar.HOUR_OF_DAY);
                int minutes = alarm.get(Calendar.MINUTE);
                minutes = minutes - 340;
                Toast.makeText(itemView.getContext(), "You ordered the pizza. Wait for 20 minutes", Toast.LENGTH_SHORT).show();
                Date date = new Date();
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String timeText = timeFormat.format(date);
                intent.putExtra(AlarmClock.EXTRA_HOUR,0);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Pizza is done");
                view.getContext().startActivity(intent);

            });

        }
        public void bindView(Beauty beauty){

            binding.nameTxt.setText(beauty.getName());
            binding.beautyTxt.setText(beauty.getBeauty_name());
            binding.clientTxt.setText(beauty.getClient());
        }
    }
}
