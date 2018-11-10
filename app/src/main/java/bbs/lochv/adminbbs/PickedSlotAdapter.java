package bbs.lochv.adminbbs;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class PickedSlotAdapter extends RecyclerView.Adapter<PickedSlotAdapter.ViewHolder> {

    public Context mContext;
    public List<String> listPickedSlot;

    public PickedSlotAdapter(Context mContext, List<String> listPickedSlot) {
        this.mContext = mContext;
        this.listPickedSlot = listPickedSlot;
    }

    @NonNull
    @Override
    public PickedSlotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View bookingSlotView = layoutInflater.inflate(R.layout.linearlayout_slots,
                viewGroup, false);
        return new PickedSlotAdapter.ViewHolder(bookingSlotView);
    }

    @Override
    public void onBindViewHolder(@NonNull PickedSlotAdapter.ViewHolder viewHolder, int i) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            viewHolder.slotLayout.setBackground(
                    ResourcesCompat.getDrawable(mContext.getResources(),
                            R.drawable.slots_border_clicked, null));
        }
        viewHolder.txtSlot.setText(listPickedSlot.get(i));
        viewHolder.txtSlot.setTextColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        if (listPickedSlot.size() == 0) {
            return 0;
        } else {
            return listPickedSlot.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSlot;
        LinearLayout slotLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSlot = itemView.findViewById(R.id.txtSlot);
            slotLayout = itemView.findViewById(R.id.ItemSlotsLayout);
        }
    }
}
