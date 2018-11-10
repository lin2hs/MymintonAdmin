package bbs.lochv.adminbbs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

//    private ArrayList<> listPromotion;

    @NonNull
    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View promotionView = layoutInflater.inflate(R.layout.layout_promotion_item,
                viewGroup, false);
        return new ViewHolder(promotionView);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPromotionItemsName;
        TextView txtPromotionItemsDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPromotionItemsName = itemView.findViewById(R.id.txtPromotionItemsName);
            txtPromotionItemsDate = itemView.findViewById(R.id.txtPromotionItemsDate);
        }
    }
}
