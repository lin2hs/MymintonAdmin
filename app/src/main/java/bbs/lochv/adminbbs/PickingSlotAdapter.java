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

public class PickingSlotAdapter extends RecyclerView.Adapter<PickingSlotAdapter.ViewHolder> {

    public Context mContext;
    public List<String> listSlotToPick;
    public List<String> listPickedSlot;

    public PickingSlotAdapter(Context mContext, List<String> listSlotToPick, List<String> listPickedSlot) {
        this.mContext = mContext;
        this.listSlotToPick = listSlotToPick;
        this.listPickedSlot = listPickedSlot;
    }

    @NonNull
    @Override
    public PickingSlotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View bookingSlotView = layoutInflater.inflate(R.layout.linearlayout_slots,
                viewGroup, false);
        return new ViewHolder(bookingSlotView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (listPickedSlot.size() == 0) {
            viewHolder.txtSlot.setText(listSlotToPick.get(i));
        } else {
            for (int j = 0; j < listPickedSlot.size(); j++) {
                if (listSlotToPick.get(i).matches(listPickedSlot.get(j))) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        viewHolder.slotLayout.setBackground(
                                ResourcesCompat.getDrawable(mContext.getResources(),
                                        R.drawable.slots_border_clicked, null));
                    }
                    viewHolder.txtSlot.setText(listSlotToPick.get(i));
                    viewHolder.txtSlot.setTextColor(Color.WHITE);
                } else {
                    viewHolder.txtSlot.setText(listSlotToPick.get(i));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (listSlotToPick.size() == 0) {
            return 0;
        } else {
            return listSlotToPick.size();
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
